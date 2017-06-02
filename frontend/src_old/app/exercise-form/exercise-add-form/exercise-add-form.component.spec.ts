import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ExerciseAddFormComponent } from './exercise-add-form.component';

describe('ExerciseAddFormComponent', () => {
  let component: ExerciseAddFormComponent;
  let fixture: ComponentFixture<ExerciseAddFormComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ExerciseAddFormComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ExerciseAddFormComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should be created', () => {
    expect(component).toBeTruthy();
  });
});
