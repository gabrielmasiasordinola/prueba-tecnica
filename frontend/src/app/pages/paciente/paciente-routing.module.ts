import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';

const routes: Routes = [
    {
      path: '',
      children: [
        {
          path: 'ListarPaciente',
          loadChildren: () => import('./listar-paciente/listar-paciente.module').then(m => m.ListarPacienteModule),
        },
        {
          path: 'CrearPaciente',
          loadChildren: () => import('./crear-paciente/crear-paciente.module').then(m => m.CrearPacienteModule),
        },
        {
          path: '**',
          pathMatch: 'full',
          redirectTo: 'ListarPaciente'
        }
      ],
    }
  ]
;

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class PacienteRoutingModule {
}
