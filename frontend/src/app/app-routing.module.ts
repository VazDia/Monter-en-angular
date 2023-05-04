import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AccueilComponent } from './pages/accueil/accueil.component';
import { MenubarComponent } from './components/menubar/menubar.component';
import { UtilisatursComponent } from './pages/pages/utilisaturs/utilisaturs.component';

const routes: Routes = [
  {
    path:'Accueil',
    component: AccueilComponent
  },
  {
    path:'Utilisateurs',
    component: UtilisatursComponent
  },
  {
    path : '',
    redirectTo : 'Accueil',
    pathMatch : 'full'
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
