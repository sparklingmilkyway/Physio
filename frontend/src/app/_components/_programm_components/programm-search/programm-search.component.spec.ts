import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ProgrammSearchComponent } from './programm-search.component';

describe('ProgrammSearchComponent', () => {
  let component: ProgrammSearchComponent;
  let fixture: ComponentFixture<ProgrammSearchComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ProgrammSearchComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ProgrammSearchComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should be created', () => {
    expect(component).toBeTruthy();
  });
});
