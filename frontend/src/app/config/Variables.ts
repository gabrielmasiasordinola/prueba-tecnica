import {environment} from "../../environments/environment";
import {Ubigeos} from "./Intefaces";

export class Variables {
  hostApi: string = '';
  tipoDocumento: string = '';
  pacientes: string = '';
  sexo: string = '';
  departamentos: string = '';
  provincias: string = '';
  distrito: string = '';
  parentesco: string = '';
  acompanante: string = '';

  constructor() {
    this.hostApi = environment.hostApi;
    this.tipoDocumento = 'tipo-documento-identidad';
    this.pacientes = 'pacientes';
    this.sexo = 'sexo';
    this.departamentos = 'ubigeos/departamentos';
    this.provincias = 'ubigeos/provincia';
    this.distrito = 'ubigeos/distrito';
    this.parentesco = 'parentesco';
    this.acompanante = 'pacientes-acompanantes';
  }
}
