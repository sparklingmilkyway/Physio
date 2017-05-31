import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PatientManipulateFormComponent } from './patient-manipulate-form.component';

describe('PatientManipulateFormComponent', () => {
  let component: PatientManipulateFormComponent;
  let fixture: ComponentFixture<PatientManipulateFormComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PatientManipulateFormComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PatientManipulateFormComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should be created', () => {
    expect(component).toBeTruthy();
  });
});
