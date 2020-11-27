import { ComponentFixture, TestBed } from '@angular/core/testing';
import { of } from 'rxjs';
import { HttpHeaders, HttpResponse } from '@angular/common/http';

import { JhipsterSampleApplication20201127TestModule } from '../../../test.module';
import { FmpMicroAppTypeMpComponent } from 'app/entities/fmp-micro-app-type-mp/fmp-micro-app-type-mp.component';
import { FmpMicroAppTypeMpService } from 'app/entities/fmp-micro-app-type-mp/fmp-micro-app-type-mp.service';
import { FmpMicroAppTypeMp } from 'app/shared/model/fmp-micro-app-type-mp.model';

describe('Component Tests', () => {
  describe('FmpMicroAppTypeMp Management Component', () => {
    let comp: FmpMicroAppTypeMpComponent;
    let fixture: ComponentFixture<FmpMicroAppTypeMpComponent>;
    let service: FmpMicroAppTypeMpService;

    beforeEach(() => {
      TestBed.configureTestingModule({
        imports: [JhipsterSampleApplication20201127TestModule],
        declarations: [FmpMicroAppTypeMpComponent],
      })
        .overrideTemplate(FmpMicroAppTypeMpComponent, '')
        .compileComponents();

      fixture = TestBed.createComponent(FmpMicroAppTypeMpComponent);
      comp = fixture.componentInstance;
      service = fixture.debugElement.injector.get(FmpMicroAppTypeMpService);
    });

    it('Should call load all on init', () => {
      // GIVEN
      const headers = new HttpHeaders().append('link', 'link;link');
      spyOn(service, 'query').and.returnValue(
        of(
          new HttpResponse({
            body: [new FmpMicroAppTypeMp(123)],
            headers,
          })
        )
      );

      // WHEN
      comp.ngOnInit();

      // THEN
      expect(service.query).toHaveBeenCalled();
      expect(comp.fmpMicroAppTypes && comp.fmpMicroAppTypes[0]).toEqual(jasmine.objectContaining({ id: 123 }));
    });
  });
});
