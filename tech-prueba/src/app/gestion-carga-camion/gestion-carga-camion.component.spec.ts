import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { GestionCargaCamionComponent } from './gestion-carga-camion.component';

describe('GestionCargaCamionComponent', () => {
  let component: GestionCargaCamionComponent;
  let fixture: ComponentFixture<GestionCargaCamionComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ GestionCargaCamionComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(GestionCargaCamionComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
