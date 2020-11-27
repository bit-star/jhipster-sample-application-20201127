import { ComponentFixture, TestBed } from '@angular/core/testing';
import { of } from 'rxjs';
import { HttpHeaders, HttpResponse } from '@angular/common/http';

import { JhipsterSampleApplication20201127TestModule } from '../../../test.module';
import { FmpWidgetInfoMpComponent } from 'app/entities/fmp-widget-info-mp/fmp-widget-info-mp.component';
import { FmpWidgetInfoMpService } from 'app/entities/fmp-widget-info-mp/fmp-widget-info-mp.service';
import { FmpWidgetInfoMp } from 'app/shared/model/fmp-widget-info-mp.model';

describe('Component Tests', () => {
  describe('FmpWidgetInfoMp Management Component', () => {
    let comp: FmpWidgetInfoMpComponent;
    let fixture: ComponentFixture<FmpWidgetInfoMpComponent>;
    let service: FmpWidgetInfoMpService;

    beforeEach(() => {
      TestBed.configureTestingModule({
        imports: [JhipsterSampleApplication20201127TestModule],
        declarations: [FmpWidgetInfoMpComponent],
      })
        .overrideTemplate(FmpWidgetInfoMpComponent, '')
        .compileComponents();

      fixture = TestBed.createComponent(FmpWidgetInfoMpComponent);
      comp = fixture.componentInstance;
      service = fixture.debugElement.injector.get(FmpWidgetInfoMpService);
    });

    it('Should call load all on init', () => {
      // GIVEN
      const headers = new HttpHeaders().append('link', 'link;link');
      spyOn(service, 'query').and.returnValue(
        of(
          new HttpResponse({
            body: [new FmpWidgetInfoMp(123)],
            headers,
          })
        )
      );

      // WHEN
      comp.ngOnInit();

      // THEN
      expect(service.query).toHaveBeenCalled();
      expect(comp.fmpWidgetInfos && comp.fmpWidgetInfos[0]).toEqual(jasmine.objectContaining({ id: 123 }));
    });
  });
});
