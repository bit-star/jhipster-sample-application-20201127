import { ComponentFixture, TestBed } from '@angular/core/testing';
import { ActivatedRoute } from '@angular/router';
import { of } from 'rxjs';

import { JhipsterSampleApplication20201127TestModule } from '../../../test.module';
import { FmpWidgetInfoMpDetailComponent } from 'app/entities/fmp-widget-info-mp/fmp-widget-info-mp-detail.component';
import { FmpWidgetInfoMp } from 'app/shared/model/fmp-widget-info-mp.model';

describe('Component Tests', () => {
  describe('FmpWidgetInfoMp Management Detail Component', () => {
    let comp: FmpWidgetInfoMpDetailComponent;
    let fixture: ComponentFixture<FmpWidgetInfoMpDetailComponent>;
    const route = ({ data: of({ fmpWidgetInfo: new FmpWidgetInfoMp(123) }) } as any) as ActivatedRoute;

    beforeEach(() => {
      TestBed.configureTestingModule({
        imports: [JhipsterSampleApplication20201127TestModule],
        declarations: [FmpWidgetInfoMpDetailComponent],
        providers: [{ provide: ActivatedRoute, useValue: route }],
      })
        .overrideTemplate(FmpWidgetInfoMpDetailComponent, '')
        .compileComponents();
      fixture = TestBed.createComponent(FmpWidgetInfoMpDetailComponent);
      comp = fixture.componentInstance;
    });

    describe('OnInit', () => {
      it('Should load fmpWidgetInfo on init', () => {
        // WHEN
        comp.ngOnInit();

        // THEN
        expect(comp.fmpWidgetInfo).toEqual(jasmine.objectContaining({ id: 123 }));
      });
    });
  });
});
