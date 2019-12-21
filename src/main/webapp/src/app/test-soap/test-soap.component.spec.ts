import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { TestSoapComponent } from './test-soap.component';

describe('TestSoapComponent', () => {
  let component: TestSoapComponent;
  let fixture: ComponentFixture<TestSoapComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ TestSoapComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(TestSoapComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
