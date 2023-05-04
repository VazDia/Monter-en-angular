import { Component } from '@angular/core';
import { MenuItem } from 'primeng/api';

@Component({
  selector: 'app-menubar',
  templateUrl: './menubar.component.html',
  styleUrls: ['./menubar.component.css']
})
export class MenubarComponent {

  items:MenuItem[];
  activeItem:MenuItem;
  

  constructor(){
    this.items = [
      {
        label:'Accueil',
        icon: 'pi pi-home',
        routerLink:'/Accueil'
      },
      {
        label:'utilisateur',
        icon:'pi pi-user',
        routerLink:'/Utilisateurs'

      }
    ];
    this.activeItem = this.items[0];
  }

  
    onActiveItemChange(event: MenuItem){
      this.activeItem =event
    }
}
