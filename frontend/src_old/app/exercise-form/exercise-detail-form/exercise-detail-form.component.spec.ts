import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ExerciseDetailFormComponent } from './exercise-detail-form.component';

describe('ExerciseDetailFormComponent', () => {
  let component: ExerciseDetailFormComponent;
  let fixture: ComponentFixture<ExerciseDetailFormComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ExerciseDetailFormComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ExerciseDetailFormComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should be created', () => {
    expect(component).toBeTruthy();
  });
});
