import {Component, OnInit} from '@angular/core';
import {FormBuilder, FormGroup, isFormGroup, Validators} from "@angular/forms";
import {Paciente, Parentesco, Sexo, TipoDocumento, Ubigeos} from "../../../config/Intefaces";
import {HttpService} from "../../../service/http/http.service";
import {DatePipe} from "@angular/common";
import {subscribeOn} from "rxjs";
import {Router} from "@angular/router";

@Component({
  selector: 'app-crear-paciente',
  templateUrl: './crear-paciente.component.html',
  styleUrls: ['./crear-paciente.component.scss']
})
export class CrearPacienteComponent implements OnInit {

  pacienteForm: FormGroup;
  listaDocumentos: TipoDocumento[] = [];
  listaSexo: Sexo[] = [];
  listaDepartamentos: Ubigeos[] = [];
  listaProvincias: Ubigeos[] = [];
  listaDistritos: Ubigeos[] = [];
  listaParentescos: Parentesco[] = [];
  acompapante = false;

  constructor(
    private formBuilder: FormBuilder,
    private http: HttpService,
    private datePipe: DatePipe,
    private route: Router,
  ) {
    this.pacienteForm = this.formBuilder.group({
      datosPaciente: this.formBuilder.group({
        tipoDocumento: ['', Validators.required],
        numeroDocumento: ['', Validators.required],
        apellidoPaterno: ['', Validators.required],
        apellidoMaterno: ['', Validators.required],
        nombres: ['', Validators.required],
        sexo: ['', Validators.required],
        fechaNacimiento: ['', Validators.required],
        edad: ['', Validators.required],
        lugarNacimiento: ['', Validators.required],
        direccion: ['', Validators.required],
        departamento: ['', Validators.required],
        provincia: ['', Validators.required],
        distrito: ['', Validators.required]
      }),
      datosAcompanante: this.formBuilder.group({
        idPaciente: [''],
        tipoDocumento: [''],
        numeroDocumento: [''],
        apellidoPaterno: [''],
        apellidoMaterno: [''],
        nombres: [''],
        fechaNacimiento: [''],
        edad: [''],
        parentesco: [''],
        telefonoContacto: [''],
        direccion: [''],
        departamento: [''],
        provincia: [''],
        distrito: ['']
      })
    });
  }

  async ngOnInit() {
    this.listaDocumentos = await this.http.getListaTypoDocumento();
    this.listaSexo = await this.http.getListaSexo();
    this.listaDepartamentos = await this.http.getListaDepartamentos();
    this.listaParentescos = await this.http.getListParentesco();
  }

  async fetchProvincias() {
    const id = this.pacienteForm.value.datosPaciente.departamento;
    this.listaProvincias = await this.http.getListaProvincias(id);
  }

  async fetchDistritos() {
    if (!this.pacienteForm.value.datosPaciente.provincia)
      return;
    const idDepartamento = this.pacienteForm.value.datosPaciente.departamento;
    const idProvincia = this.pacienteForm.value.datosPaciente.provincia;
    this.listaDistritos = await this.http.getListaDistritos(idDepartamento, idProvincia);
  }

  toggleAcompanante() {
    this.acompapante = !this.acompapante;
    if (this.acompapante) {
      this.pacienteForm.get('idPaciente')?.setValidators(Validators.required);
      this.pacienteForm.get('tipoDocumento')?.setValidators(Validators.required);
      this.pacienteForm.get('numeroDocumento')?.setValidators(Validators.required);
      this.pacienteForm.get('apellidoPaterno')?.setValidators(Validators.required);
      this.pacienteForm.get('apellidoMaterno')?.setValidators(Validators.required);
      this.pacienteForm.get('nombres')?.setValidators(Validators.required);
      this.pacienteForm.get('fechaNacimiento')?.setValidators(Validators.required);
      this.pacienteForm.get('edad')?.setValidators(Validators.required);
      this.pacienteForm.get('parentesco')?.setValidators(Validators.required);
      this.pacienteForm.get('telefonoContacto')?.setValidators(Validators.required);
      this.pacienteForm.get('provincia')?.setValidators(Validators.required);
      this.pacienteForm.get('distrito')?.setValidators(Validators.required);
    } else {
      this.pacienteForm.get('idPaciente')?.clearValidators()
      this.pacienteForm.get('tipoDocumento')?.clearValidators()
      this.pacienteForm.get('numeroDocumento')?.clearValidators()
      this.pacienteForm.get('apellidoPaterno')?.clearValidators()
      this.pacienteForm.get('apellidoMaterno')?.clearValidators()
      this.pacienteForm.get('nombres')?.clearValidators()
      this.pacienteForm.get('fechaNacimiento')?.clearValidators()
      this.pacienteForm.get('edad')?.clearValidators()
      this.pacienteForm.get('parentesco')?.clearValidators()
      this.pacienteForm.get('telefonoContacto')?.clearValidators()
      this.pacienteForm.get('provincia')?.clearValidators()
      this.pacienteForm.get('distrito')?.clearValidators()
    }
  }

  async onSubmit() {
    console.log(this.pacienteForm.valid)
    //if (!this.pacienteForm.valid)
    //return;
    console.log('Datos del paciente y acompañante enviados:', this.pacienteForm.value);
    const dataPaciente = this.pacienteForm.value.datosPaciente;
    dataPaciente["fechaNacimiento"] = this.datePipe.transform(new Date(dataPaciente.fechaNacimiento), 'yyyy-MM-dd');
    const newDataPaciente: Paciente = {
      idPaciente: 0,
      idTipoDocide: dataPaciente.tipoDocumento,
      noDocide: dataPaciente.numeroDocumento,
      noApepat: dataPaciente.apellidoPaterno,
      noApemat: dataPaciente.apellidoMaterno,
      noNombres: dataPaciente.nombres,
      idSexo: dataPaciente.sexo,
      feNacimiento: dataPaciente.fechaNacimiento,
      noLugarNacimiento: dataPaciente.lugarNacimiento,
      noDireccion: dataPaciente.direccion,
      coUbigeo: `${dataPaciente.departamento}${dataPaciente.provincia}${dataPaciente.distrito}`,
    }
    const data: any = await this.http.savePaciente(newDataPaciente);
    if (this.acompapante) {
      const newDataAcompanante = {
        idPaciente: data.idPaciente,
        idTipoDocide: dataPaciente.tipoDocumento,
        noDocide: dataPaciente.numeroDocumento,
        noApepat: dataPaciente.apellidoPaterno,
        noApemat: dataPaciente.apellidoMaterno,
        noNombres: dataPaciente.nombres,
        idSexo: dataPaciente.sexo,
        feNacimiento: dataPaciente.fechaNacimiento,
        noLugarNacimiento: dataPaciente.lugarNacimiento,
        noDireccion: dataPaciente.direccion,
        coUbigeo: `${dataPaciente.departamento}${dataPaciente.provincia}${dataPaciente.distrito}`,
      }
      await this.http.saveAcompanante(newDataAcompanante);
    }
    if (data) {
      await this.route.navigateByUrl("ListarPaciente");
    }
  }

  onCancel() {
    this.pacienteForm.reset();
  }

  dismiss() {

  }

}
