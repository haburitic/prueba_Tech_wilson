import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { MenuDerechoComponent } from './menu-derecho.component';

describe('MenuDerechoComponent', () => {
  let component: MenuDerechoComponent;
  let fixture: ComponentFixture<MenuDerechoComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ MenuDerechoComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(MenuDerechoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
