import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ProgrammAddComponent } from './programm-add.component';

describe('ProgrammAddComponent', () => {
  let component: ProgrammAddComponent;
  let fixture: ComponentFixture<ProgrammAddComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ProgrammAddComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ProgrammAddComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should be created', () => {
    expect(component).toBeTruthy();
  });
});
