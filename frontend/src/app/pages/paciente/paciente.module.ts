import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';

import {PacienteRoutingModule} from './paciente-routing.module';
import {FormsModule, ReactiveFormsModule} from "@angular/forms";


@NgModule({
  declarations: [],
  imports: [
    CommonModule,
    PacienteRoutingModule,
    FormsModule,
    ReactiveFormsModule
  ]
})
export class PacienteModule {
}
