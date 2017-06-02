import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ProgramCreateFormComponent } from './program-create-form.component';

describe('ProgramCreateFormComponent', () => {
  let component: ProgramCreateFormComponent;
  let fixture: ComponentFixture<ProgramCreateFormComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ProgramCreateFormComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ProgramCreateFormComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should be created', () => {
    expect(component).toBeTruthy();
  });
});
