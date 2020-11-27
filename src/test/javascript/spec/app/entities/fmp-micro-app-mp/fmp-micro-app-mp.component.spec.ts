import { ComponentFixture, TestBed } from '@angular/core/testing';
import { of } from 'rxjs';
import { HttpHeaders, HttpResponse } from '@angular/common/http';

import { JhipsterSampleApplication20201127TestModule } from '../../../test.module';
import { FmpMicroAppMpComponent } from 'app/entities/fmp-micro-app-mp/fmp-micro-app-mp.component';
import { FmpMicroAppMpService } from 'app/entities/fmp-micro-app-mp/fmp-micro-app-mp.service';
import { FmpMicroAppMp } from 'app/shared/model/fmp-micro-app-mp.model';

describe('Component Tests', () => {
  describe('FmpMicroAppMp Management Component', () => {
    let comp: FmpMicroAppMpComponent;
    let fixture: ComponentFixture<FmpMicroAppMpComponent>;
    let service: FmpMicroAppMpService;

    beforeEach(() => {
      TestBed.configureTestingModule({
        imports: [JhipsterSampleApplication20201127TestModule],
        declarations: [FmpMicroAppMpComponent],
      })
        .overrideTemplate(FmpMicroAppMpComponent, '')
        .compileComponents();

      fixture = TestBed.createComponent(FmpMicroAppMpComponent);
      comp = fixture.componentInstance;
      service = fixture.debugElement.injector.get(FmpMicroAppMpService);
    });

    it('Should call load all on init', () => {
      // GIVEN
      const headers = new HttpHeaders().append('link', 'link;link');
      spyOn(service, 'query').and.returnValue(
        of(
          new HttpResponse({
            body: [new FmpMicroAppMp(123)],
            headers,
          })
        )
      );

      // WHEN
      comp.ngOnInit();

      // THEN
      expect(service.query).toHaveBeenCalled();
      expect(comp.fmpMicroApps && comp.fmpMicroApps[0]).toEqual(jasmine.objectContaining({ id: 123 }));
    });
  });
});
