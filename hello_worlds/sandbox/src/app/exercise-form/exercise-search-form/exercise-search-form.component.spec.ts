import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ExerciseSearchFormComponent } from './exercise-search-form.component';

describe('ExerciseSearchFormComponent', () => {
  let component: ExerciseSearchFormComponent;
  let fixture: ComponentFixture<ExerciseSearchFormComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ExerciseSearchFormComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ExerciseSearchFormComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should be created', () => {
    expect(component).toBeTruthy();
  });
});
