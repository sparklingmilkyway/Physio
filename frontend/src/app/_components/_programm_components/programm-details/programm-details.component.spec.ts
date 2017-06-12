import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ProgrammDetailsComponent } from './programm-details.component';

describe('ProgrammDetailsComponent', () => {
  let component: ProgrammDetailsComponent;
  let fixture: ComponentFixture<ProgrammDetailsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ProgrammDetailsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ProgrammDetailsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should be created', () => {
    expect(component).toBeTruthy();
  });
});
