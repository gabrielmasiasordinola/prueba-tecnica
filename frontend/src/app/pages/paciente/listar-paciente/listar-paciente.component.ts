import {Component, OnInit} from '@angular/core';
import {Router} from "@angular/router";
import {HttpService} from "../../../service/http/http.service";
import {Paciente, TipoDocumento} from "../../../config/Intefaces";
import {FormBuilder, FormGroup, Validators} from "@angular/forms";

@Component({
  selector: 'app-listar-paciente',
  templateUrl: './listar-paciente.component.html',
  styleUrls: ['./listar-paciente.component.scss']
})
export class ListarPacienteComponent implements OnInit {
  listaDocumentos: TipoDocumento[] = [];
  pacientes: Paciente[] = [];
  optinons = {
    onlyDocuments: true,
    onlyFullname: false,
  }
  nCaracteres: number = 8;
  formGroup: FormGroup;

  constructor(
    private router: Router,
    private http: HttpService,
    private formBuilder: FormBuilder
  ) {
    this.formGroup = this.formBuilder.group({
      tipoDocumento: [1, Validators.required],
      numeroDocumento: ['', Validators.required],
      apellidos: [''],
      nombres: [''],
    });
  }

  async ngOnInit() {
    this.listaDocumentos = await this.http.getListaTypoDocumento();
    this.pacientes = await this.http.getPacientes();
  }

  goToRegistar() {
    this.router.navigateByUrl('CrearPaciente');
  }

  editarUsuario(item: Paciente) {
    console.log(item);
  }

  async eliminarUsuario(item: Paciente) {
    const idEliminar = item.idPaciente;
    await this.http.deletePaciente(String(idEliminar));
    await this.reiniciar();
  }

  seleccionarTipoPersona() {
    if (this.optinons.onlyDocuments) {
      this.formGroup.get('apellidos')?.setValidators(Validators.required);
      this.formGroup.get('nombres')?.setValidators(Validators.required);
      this.formGroup.get('tipoDocumento')?.clearValidators();
      this.formGroup.get('numeroDocumento')?.clearValidators();
      return;
    }
    if (this.optinons.onlyFullname) {
      this.formGroup.get('tipoDocumento')?.setValidators(Validators.required);
      this.formGroup.get('numeroDocumento')?.setValidators(Validators.required);
      this.formGroup.get('apellidos')?.clearValidators();
      this.formGroup.get('nombres')?.clearValidators();
      return;
    }
  }

  toggleTypeDocument() {
    this.seleccionarTipoPersona();
    if (this.optinons.onlyDocuments) {
      this.optinons.onlyDocuments = false;
      this.optinons.onlyFullname = true;
    } else {
      this.optinons.onlyDocuments = true;
      this.optinons.onlyFullname = false;
    }
    this.formGroup.reset();
  }

  seleccionarTipoDocumento(selectElement: any) {
    const valorSeleccionado = selectElement.value;
    this.nCaracteres = valorSeleccionado === '1' ? 8 :
      valorSeleccionado === '2' ? 20 :
        valorSeleccionado === '3' ? 20 : 8;
  }

  async buscar() {
    if (!this.formGroup.valid) {
      alert("Rellena todos los campos requeridos")
    }
    if (this.optinons.onlyDocuments)
      this.pacientes = await this.http.searchPaciente(this.formGroup.value.tipoDocumento, this.formGroup.value.numeroDocumento);
    if (this.optinons.onlyFullname) {
      const apellidoPat = this.formGroup.value.apellidos.split(" ").length ? this.formGroup.value.apellidos.split(" ")[0] : this.formGroup.value.apellidos;
      const apellidoMat = this.formGroup.value.apellidos.split(" ").length ? this.formGroup.value.apellidos.split(" ")[1] : "";
      const nombres = this.formGroup.value.nombres;
      this.pacientes = await this.http.searchPacienteByNombres(apellidoPat, apellidoMat, nombres);
    }
  }

  async reiniciar() {
    this.formGroup.reset();
    this.pacientes = await this.http.getPacientes();
  }

}
