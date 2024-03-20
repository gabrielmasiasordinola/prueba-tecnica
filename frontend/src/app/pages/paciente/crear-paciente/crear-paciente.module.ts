import {NgModule} from '@angular/core';
import {CommonModule, DatePipe} from '@angular/common';

import {CrearPacienteRoutingModule} from './crear-paciente-routing.module';
import {CrearPacienteComponent} from "./crear-paciente.component";
import {MaterialModule} from "../../../materia-module";
import {FormsModule, ReactiveFormsModule} from "@angular/forms";


@NgModule({
  declarations: [CrearPacienteComponent],
  imports: [
    CommonModule,
    CrearPacienteRoutingModule,
    MaterialModule,
    FormsModule,
    ReactiveFormsModule
  ],
  providers: [{
    provide: DatePipe
  }]
})
export class CrearPacienteModule {
}
