import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Variables} from "../../config/Variables";
import {Paciente, Parentesco, Sexo, TipoDocumento, Ubigeos} from "../../config/Intefaces";

@Injectable({
  providedIn: 'root'
})
export class HttpService {

  private env = new Variables();

  constructor(
    private httpClient: HttpClient
  ) {
  }

  async getListaTypoDocumento(): Promise<TipoDocumento[]> {
    const url = `${this.env.hostApi}${this.env.tipoDocumento}`;
    const response = await this.httpClient.get<TipoDocumento[]>(url).toPromise();
    return response || [];
  }

  async getPacientes(): Promise<Paciente[]> {
    const url = `${this.env.hostApi}${this.env.pacientes}`;
    const response = await this.httpClient.get<Paciente[]>(url).toPromise();
    return response || [];
  }

  async getListaSexo(): Promise<Sexo[]> {
    const url = `${this.env.hostApi}${this.env.sexo}`;
    const response = await this.httpClient.get<Sexo[]>(url).toPromise();
    return response || [];
  }

  async getListaDepartamentos(): Promise<Ubigeos[]> {
    const url = `${this.env.hostApi}${this.env.departamentos}`;
    const response = await this.httpClient.get<Ubigeos[]>(url).toPromise();
    return response || [];
  }

  async getListaProvincias(codigoDepartamento: string): Promise<Ubigeos[]> {
    const url = `${this.env.hostApi}${this.env.provincias}/${codigoDepartamento}`;
    const response = await this.httpClient.get<Ubigeos[]>(url).toPromise();
    return response || [];
  }

  async getListaDistritos(codigoDepartamento: string, codigoProvincia: string): Promise<Ubigeos[]> {
    const url = `${this.env.hostApi}${this.env.distrito}/${codigoDepartamento}/${codigoProvincia}`;
    const response = await this.httpClient.get<Ubigeos[]>(url).toPromise();
    return response || [];
  }

  async getListParentesco(): Promise<Parentesco[]> {
    const url = `${this.env.hostApi}${this.env.parentesco}`;
    const response = await this.httpClient.get<Parentesco[]>(url).toPromise();
    return response || [];
  }

  async searchPaciente(tipoDocumento: string, numeroDocumento: string): Promise<Paciente[]> {
    const url = `${this.env.hostApi}${this.env.pacientes}/${tipoDocumento}/${numeroDocumento}`;
    const response = await this.httpClient.get<Paciente[]>(url).toPromise();
    return response || [];
  }

  async searchPacienteByNombres(apellidoPat: string, apellidoMat: string, nombres: string): Promise<Paciente[]> {
    const url = `${this.env.hostApi}${this.env.pacientes}/${apellidoPat}/${apellidoMat}/${nombres}`;
    const response = await this.httpClient.get<Paciente[]>(url).toPromise();
    return response || [];
  }

  async deletePaciente(id: string) {
    const url = `${this.env.hostApi}${this.env.pacientes}/${id}`;
    const response = await this.httpClient.delete<Paciente[]>(url).toPromise();
    return response || [];
  }

  async savePaciente(body: Paciente) {
    const url = `${this.env.hostApi}${this.env.pacientes}`;
    const response = await this.httpClient.post<Paciente>(url, body).toPromise();
    return response || [];
  }

  async saveAcompanante(body: any) {
    const url = `${this.env.hostApi}${this.env.acompanante}`;
    const response = await this.httpClient.post<any>(url, body).toPromise();
    return response || [];
  }

}
