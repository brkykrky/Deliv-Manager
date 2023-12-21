import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ToureditorComponent } from './toureditor.component';

describe('ToureditorComponent', () => {
  let component: ToureditorComponent;
  let fixture: ComponentFixture<ToureditorComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ToureditorComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(ToureditorComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
