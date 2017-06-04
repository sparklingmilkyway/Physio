import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ExerciseSearchComponent } from './exercise-search.component';

describe('ExerciseSearchComponent', () => {
  let component: ExerciseSearchComponent;
  let fixture: ComponentFixture<ExerciseSearchComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ExerciseSearchComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ExerciseSearchComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should be created', () => {
    expect(component).toBeTruthy();
  });
});
