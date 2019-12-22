import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { JavaapiComponent } from './javaapi.component';

describe('JavaapiComponent', () => {
  let component: JavaapiComponent;
  let fixture: ComponentFixture<JavaapiComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ JavaapiComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(JavaapiComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
