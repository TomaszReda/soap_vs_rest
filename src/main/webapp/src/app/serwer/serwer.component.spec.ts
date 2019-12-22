import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { SerwerComponent } from './serwer.component';

describe('SerwerComponent', () => {
  let component: SerwerComponent;
  let fixture: ComponentFixture<SerwerComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ SerwerComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(SerwerComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
