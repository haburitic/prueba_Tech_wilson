import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { InformacionTareasComponent } from './informacion-tareas.component';

describe('InformacionTareasComponent', () => {
  let component: InformacionTareasComponent;
  let fixture: ComponentFixture<InformacionTareasComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ InformacionTareasComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(InformacionTareasComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
