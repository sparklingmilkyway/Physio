import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PatientAddFormComponent } from './patient-add-form.component';

describe('PatientAddFormComponent', () => {
  let component: PatientAddFormComponent;
  let fixture: ComponentFixture<PatientAddFormComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PatientAddFormComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PatientAddFormComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should be created', () => {
    expect(component).toBeTruthy();
  });
});
