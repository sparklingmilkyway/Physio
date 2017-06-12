import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ProgrammComponent } from './programm.component';

describe('ProgrammComponent', () => {
  let component: ProgrammComponent;
  let fixture: ComponentFixture<ProgrammComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ProgrammComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ProgrammComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should be created', () => {
    expect(component).toBeTruthy();
  });
});
