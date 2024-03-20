export interface TipoDocumento {
  idTipoDocumentoIdentidad: number;
  descripcionTipoDocumentoIdentidad: string;
  codigoIeds: string;
  estado: boolean;
}

export interface Paciente {
  idPaciente: number;
  idTipoDocide: number;
  noDocide: string;
  noApepat: string;
  noApemat: string;
  noNombres: string;
  idSexo: number;
  feNacimiento: number;
  noLugarNacimiento: string;
  noDireccion: string;
  coUbigeo: string;
}

export interface Sexo {
  idSexo: number;
  descripcionSexo: string;
  estado: boolean;
}

export interface Ubigeos {
  codigoUbigeo: string;
  descripcionDepartamento: string;
  descripcionProvincia: string;
  descripcionDistrito: string;
  estado: boolean;
  codigoDepartamento: string;
  codigoProvincia: string;
  codigoDistrito: string;
}

export interface Parentesco {
  idParentesco: number;
  nombreParentesco: string;
  activo: boolean;
}
