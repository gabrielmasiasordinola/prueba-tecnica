import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';

import {ListarPacienteRoutingModule} from './listar-paciente-routing.module';
import {ListarPacienteComponent} from "./listar-paciente.component";
import {MaterialModule} from "../../../materia-module";
import {FormsModule, ReactiveFormsModule} from "@angular/forms";


@NgModule({
  declarations: [ListarPacienteComponent],
  imports: [
    CommonModule,
    ListarPacienteRoutingModule,
    MaterialModule,
    FormsModule,
    ReactiveFormsModule
  ]
})
export class ListarPacienteModule {
}
