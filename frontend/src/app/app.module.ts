import { CUSTOM_ELEMENTS_SCHEMA, NO_ERRORS_SCHEMA, NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { MenubarComponent } from './components/menubar/menubar.component';
import {TabMenuModule} from 'primeng/tabmenu';
import {ButtonModule} from 'primeng/button';
import { TableModule } from 'primeng/table';
import { FormsModule } from '@angular/forms';
import {HTTP_INTERCEPTORS, HttpClientModule} from '@angular/common/http';
import { AccueilComponent } from './pages/accueil/accueil.component';
import { UtilisatursComponent } from './pages/pages/utilisaturs/utilisaturs.component';
import { ToolbarModule } from 'primeng/toolbar';
import { SplitButtonModule } from 'primeng/splitbutton';
import { InputTextModule } from 'primeng/inputtext';
import { RippleModule } from 'primeng/ripple';
import { DialogModule } from 'primeng/dialog';
import { CardModule } from 'primeng/card';
import { ConfirmDialogModule } from 'primeng/confirmdialog';
import { ConfirmationService, MessageService } from 'primeng/api';
import { ToastModule } from 'primeng/toast';
import { AutoCompleteModule } from 'primeng/autocomplete';
import { TreeTableModule } from 'primeng/treetable';
import { DropdownModule } from 'primeng/dropdown';
import { TreeSelectModule } from 'primeng/treeselect';
import { ReactiveFormsModule } from '@angular/forms';
import { CorsInterceptor } from './cors.interceptor';
import { TreeModule } from 'primeng/tree';
import { ScrollerModule } from 'primeng/scroller';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { DepartementService } from './services/departement.service';

@NgModule({

  declarations: [
    AppComponent,
    MenubarComponent,
    AccueilComponent,
    UtilisatursComponent,


  ],

  schemas: [CUSTOM_ELEMENTS_SCHEMA],

  imports: [
    BrowserModule,
    BrowserAnimationsModule,
    AppRoutingModule,
    TabMenuModule,
    ButtonModule,
    TableModule,
    FormsModule,
    HttpClientModule,
    BrowserModule,
    AppRoutingModule,
    ToolbarModule,
    ButtonModule,
    SplitButtonModule,
    InputTextModule,
    TableModule,
    FormsModule,
    RippleModule,
    DialogModule,
    ReactiveFormsModule,
    CardModule,
    HttpClientModule,
    ConfirmDialogModule,
    ToastModule,
    AutoCompleteModule,
    TreeTableModule,
    DropdownModule,
    TreeModule,
    TreeSelectModule,
    ScrollerModule
  ],
  providers: [
    { provide: HTTP_INTERCEPTORS, useClass: CorsInterceptor, multi: true },
    ConfirmationService,MessageService, DepartementService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
