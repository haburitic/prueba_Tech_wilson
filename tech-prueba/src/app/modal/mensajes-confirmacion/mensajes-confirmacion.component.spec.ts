import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { MensajesConfirmacionComponent } from './mensajes-confirmacion.component';

describe('MensajesConfirmacionComponent', () => {
  let component: MensajesConfirmacionComponent;
  let fixture: ComponentFixture<MensajesConfirmacionComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ MensajesConfirmacionComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(MensajesConfirmacionComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
