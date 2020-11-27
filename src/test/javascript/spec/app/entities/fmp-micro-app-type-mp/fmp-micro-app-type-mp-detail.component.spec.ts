import { ComponentFixture, TestBed } from '@angular/core/testing';
import { ActivatedRoute } from '@angular/router';
import { of } from 'rxjs';

import { JhipsterSampleApplication20201127TestModule } from '../../../test.module';
import { FmpMicroAppTypeMpDetailComponent } from 'app/entities/fmp-micro-app-type-mp/fmp-micro-app-type-mp-detail.component';
import { FmpMicroAppTypeMp } from 'app/shared/model/fmp-micro-app-type-mp.model';

describe('Component Tests', () => {
  describe('FmpMicroAppTypeMp Management Detail Component', () => {
    let comp: FmpMicroAppTypeMpDetailComponent;
    let fixture: ComponentFixture<FmpMicroAppTypeMpDetailComponent>;
    const route = ({ data: of({ fmpMicroAppType: new FmpMicroAppTypeMp(123) }) } as any) as ActivatedRoute;

    beforeEach(() => {
      TestBed.configureTestingModule({
        imports: [JhipsterSampleApplication20201127TestModule],
        declarations: [FmpMicroAppTypeMpDetailComponent],
        providers: [{ provide: ActivatedRoute, useValue: route }],
      })
        .overrideTemplate(FmpMicroAppTypeMpDetailComponent, '')
        .compileComponents();
      fixture = TestBed.createComponent(FmpMicroAppTypeMpDetailComponent);
      comp = fixture.componentInstance;
    });

    describe('OnInit', () => {
      it('Should load fmpMicroAppType on init', () => {
        // WHEN
        comp.ngOnInit();

        // THEN
        expect(comp.fmpMicroAppType).toEqual(jasmine.objectContaining({ id: 123 }));
      });
    });
  });
});
