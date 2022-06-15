import { ComponentFixture, TestBed } from '@angular/core/testing';

import { LoginsuccesslandingComponent } from './loginsuccesslanding.component';

describe('LoginsuccesslandingComponent', () => {
  let component: LoginsuccesslandingComponent;
  let fixture: ComponentFixture<LoginsuccesslandingComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ LoginsuccesslandingComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(LoginsuccesslandingComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
