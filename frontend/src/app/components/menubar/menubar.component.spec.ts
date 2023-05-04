import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MenubarComponent } from './menubar.component';
import { AppRoutingModule } from 'src/app/app-routing.module';
import { CUSTOM_ELEMENTS_SCHEMA, NO_ERRORS_SCHEMA } from '@angular/core';





describe('MenubarComponent', () => {
  let component: MenubarComponent;
  let fixture: ComponentFixture<MenubarComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
     
      declarations: [ MenubarComponent ],
      schemas:[ CUSTOM_ELEMENTS_SCHEMA ],
    })
    .compileComponents();

    fixture = TestBed.createComponent(MenubarComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
