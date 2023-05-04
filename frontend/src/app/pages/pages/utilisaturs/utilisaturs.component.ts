import { Component } from '@angular/core';
import { DepartementService } from 'src/app/services/departement.service';
import { PersonneService } from 'src/app/services/personne.service';
import {
  ConfirmEventType,
  ConfirmationService,
  FilterMatchMode,
  MessageService,
  PrimeNGConfig,
} from 'primeng/api';

@Component({
  selector: 'app-utilisaturs',
  templateUrl: './utilisaturs.component.html',
  styleUrls: ['./utilisaturs.component.css']
})
export class UtilisatursComponent {
  value!:string
  ListeDepartement= <any>[];
  listePersonne = <any>[];
  first = 0;
  rows = 10;
  visible!: boolean;
  submitted!: boolean;
  btnText!: any;
  personne!: any;
  departement!: any;
  cols: any[] = [];


  constructor(private departementService: DepartementService, private personneService: PersonneService,private messageService: MessageService,private confirmationService: ConfirmationService, private config:PrimeNGConfig){}

  ngOnInit(): void {
      this.getListeDepartement();
      this.getListePersonne();
      this.cols = [
        {
          field: 'nom',
          header: 'Nom',
        },
        {
          field: 'age',
          header: 'Age',
        },
        this.config.filterMatchModeOptions = {
          text: [],
          numeric: [
              FilterMatchMode.LESS_THAN,
              FilterMatchMode.GREATER_THAN,
          ],
          date: []
      }
      ];
  }

  getListeDepartement() {
    this.departementService.getDepartements().subscribe({
      next: (reponse: any) => {
        this.ListeDepartement = reponse;
        console.log(this.ListeDepartement);
      },
      error: (error: any) => {
        console.log(error);
      },
    });
  }

  getListePersonne() {
    this.personneService.getPersonnes().subscribe({
      next: (reponse: any) => {
        this.listePersonne = reponse;
      
        console.log(this.listePersonne)
      },
      error: (error: any) => {
        console.log(error);
      },
    });
  }

  editPersonne(personne: any) {
    this.personne = { ...personne };
    this.visible = true;
    this.btnText = 'Modifier';
  }

  deletePersonne(id: number) {
    this.confirmationService.confirm({
      message: 'Etes vous sûr de supprimer la personne selectionnée ?',
      header: 'Confirmer',
      icon: 'pi pi-exclamation-triangle',
      accept: () => {
        this.personneService.deletePersonne(id).subscribe({
          complete: () => {
            this.getListePersonne();
            this.messageService.add({
              severity: 'error',
              summary: 'success',
              detail: 'personne supprimée.',
              life: 5000,
            });
          },
          error: (error: any) => {
            console.log(error);
          },
        });
      },
      reject: (type: any) => {
        switch (type) {
          case ConfirmEventType.REJECT:
            this.messageService.add({
              severity: 'error',
              summary: 'Rejet',
              detail: 'vous avez rejecté la suppression',
            });
            break;
          case ConfirmEventType.CANCEL:
            this.messageService.add({
              severity: 'warn',
              summary: 'Annulation',
              detail: 'vous avez annulé la suppression',
            });
            break;
        }
      },
    });
  }

  // Cette fonction permet d'ajouter ou de modifier une personne
  savePersonne(id: any, personne: any) {
    this.submitted = true;
    // Vérification des champs du formulaire
    if (
      !personne.nom ||
      !personne.prenoms ||
      !personne.age ||
      !personne.departement
    ) {
      this.messageService.add({
        severity: 'error',
        summary: 'Erreur',
        detail: 'Veuillez remplir tous les champs.',
        life: 5000,
      });
      return;
    }

    if (this.btnText === 'Ajouter') {
      this.personneService.createPersonne(personne).subscribe({
        complete: () => {
          this.getListePersonne();
          this.messageService.add({
            severity: 'success',
            summary: 'Success',
            detail: 'Personne Ajoutée',
            life: 5000,
          });
        },
        error: (error: any) => {
          console.log(error);
        },
      });
    } else {
      const index = this.listePersonne.findIndex((p:any) => p.id === id);
      this.personneService.updatePersonne(id, personne).subscribe({
        complete: () => {
          this.listePersonne[index] = personne;
          this.messageService.add({
            severity: 'success',
            summary: 'Success',
            detail: 'Personne modifiée',
            life: 5000,
          });
        },
        error: (error: any) => {
          console.log(error);
        },
      });
    }

    this.visible = false;
  }

  showDialog() {
    this.visible = true;
    this.submitted = false;
    this.personne = {};
    this.btnText = 'Ajouter';
  }
}
