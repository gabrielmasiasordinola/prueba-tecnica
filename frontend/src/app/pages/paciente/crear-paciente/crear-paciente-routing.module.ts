import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {CrearPacienteComponent} from "./crear-paciente.component";

const routes: Routes = [
  {
    path: '',
    component: CrearPacienteComponent
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class CrearPacienteRoutingModule { }
