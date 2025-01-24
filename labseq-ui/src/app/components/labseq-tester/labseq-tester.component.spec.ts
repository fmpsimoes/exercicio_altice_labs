import { ComponentFixture, TestBed } from '@angular/core/testing';

import { LabseqTesterComponent } from './labseq-tester.component';

describe('LabseqTesterComponent', () => {
  let component: LabseqTesterComponent;
  let fixture: ComponentFixture<LabseqTesterComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [LabseqTesterComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(LabseqTesterComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
