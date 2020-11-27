import { ComponentFixture, TestBed } from '@angular/core/testing';
import { ActivatedRoute } from '@angular/router';
import { of } from 'rxjs';

import { JhipsterSampleApplication20201127TestModule } from '../../../test.module';
import { FmpMicroAppMpDetailComponent } from 'app/entities/fmp-micro-app-mp/fmp-micro-app-mp-detail.component';
import { FmpMicroAppMp } from 'app/shared/model/fmp-micro-app-mp.model';

describe('Component Tests', () => {
  describe('FmpMicroAppMp Management Detail Component', () => {
    let comp: FmpMicroAppMpDetailComponent;
    let fixture: ComponentFixture<FmpMicroAppMpDetailComponent>;
    const route = ({ data: of({ fmpMicroApp: new FmpMicroAppMp(123) }) } as any) as ActivatedRoute;

    beforeEach(() => {
      TestBed.configureTestingModule({
        imports: [JhipsterSampleApplication20201127TestModule],
        declarations: [FmpMicroAppMpDetailComponent],
        providers: [{ provide: ActivatedRoute, useValue: route }],
      })
        .overrideTemplate(FmpMicroAppMpDetailComponent, '')
        .compileComponents();
      fixture = TestBed.createComponent(FmpMicroAppMpDetailComponent);
      comp = fixture.componentInstance;
    });

    describe('OnInit', () => {
      it('Should load fmpMicroApp on init', () => {
        // WHEN
        comp.ngOnInit();

        // THEN
        expect(comp.fmpMicroApp).toEqual(jasmine.objectContaining({ id: 123 }));
      });
    });
  });
});
