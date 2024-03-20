import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {ListarPacienteComponent} from "./listar-paciente.component";

const routes: Routes = [
  {
    path: '',
    component: ListarPacienteComponent
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class ListarPacienteRoutingModule {
}
