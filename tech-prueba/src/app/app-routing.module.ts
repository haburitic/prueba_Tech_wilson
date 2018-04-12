import { NgModule, Component } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { HomeComponent } from './forms/home/home.component';
import { GestionCargaCamionComponent } from './gestion-carga-camion/gestion-carga-camion.component';
import { GestionEmpleadosComponent } from './gestion-empleados/gestion-empleados.component';
const routes: Routes = [
  {
    path: '',
    component: HomeComponent
  },
  {
    path: 'Home',
    component: HomeComponent
  },
   {
    path: 'GestionEmpleados',
    component: GestionEmpleadosComponent
  },
  {
    path: 'GestionCargaCamion',
    component: GestionCargaCamionComponent
  },
   {
    path: '**',
    component: HomeComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {}
