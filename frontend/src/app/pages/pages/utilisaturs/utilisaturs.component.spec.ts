import { ComponentFixture, TestBed } from '@angular/core/testing';

import { UtilisatursComponent } from './utilisaturs.component';

import { BrowserModule } from '@angular/platform-browser';
import { AppRoutingModule } from 'src/app/app-routing.module';
import { HttpClientModule } from '@angular/common/http';
import { ConfirmDialog, ConfirmDialogModule } from 'primeng/confirmdialog';
import { DialogModule } from 'primeng/dialog';
import { TableModule } from 'primeng/table';
import { TreeModule } from 'primeng/tree';
import { TreeTableModule } from 'primeng/treetable';
import { ToolbarModule } from 'primeng/toolbar';
import { DepartementService } from 'src/app/services/departement.service';
import { PersonneService } from 'src/app/services/personne.service';
import { ConfirmationService, MessageService } from 'primeng/api';
import { HttpClientTestingModule } from '@angular/common/http/testing';

describe('UtilisatursComponent', () => {
  let component: UtilisatursComponent;
  let fixture: ComponentFixture<UtilisatursComponent>;
  let DepartementServiceStub = jasmine.createSpyObj('DepartementService',['getDepartements']);
  let personServiceStub = jasmine.createSpyObj('PersonneService',['getPersonnes','updatePersonne','createPersonne','deletePersonne']);
  let messageServiceStub = jasmine.createSpyObj('MessageService',['add']);
  let confirmationServiceStub = jasmine.createSpyObj('ConfirmationService',['confirm']);
  let confirmDialog = jasmine.createSpyObj<ConfirmDialog>
  
  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ UtilisatursComponent,],
      imports:[
        HttpClientTestingModule,
        ConfirmDialogModule,
        DialogModule,
        TableModule,
        TreeModule,
        TreeTableModule,
        ToolbarModule,
        HttpClientModule
      ],
      providers:[
        {provide: DepartementService, useValue:DepartementServiceStub},
        {provide: PersonneService, useValue:personServiceStub},
        {provide: MessageService, useValue:messageServiceStub},
        {provide :ConfirmationService, useValue:confirmationServiceStub},
        { provide: ConfirmDialog, useValue: confirmDialog }
       ]

    })
    .compileComponents();
    fixture = TestBed.createComponent(UtilisatursComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
