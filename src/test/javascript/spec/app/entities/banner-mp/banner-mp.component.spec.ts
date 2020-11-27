import { ComponentFixture, TestBed } from '@angular/core/testing';
import { of } from 'rxjs';
import { HttpHeaders, HttpResponse } from '@angular/common/http';

import { JhipsterSampleApplication20201127TestModule } from '../../../test.module';
import { BannerMpComponent } from 'app/entities/banner-mp/banner-mp.component';
import { BannerMpService } from 'app/entities/banner-mp/banner-mp.service';
import { BannerMp } from 'app/shared/model/banner-mp.model';

describe('Component Tests', () => {
  describe('BannerMp Management Component', () => {
    let comp: BannerMpComponent;
    let fixture: ComponentFixture<BannerMpComponent>;
    let service: BannerMpService;

    beforeEach(() => {
      TestBed.configureTestingModule({
        imports: [JhipsterSampleApplication20201127TestModule],
        declarations: [BannerMpComponent],
      })
        .overrideTemplate(BannerMpComponent, '')
        .compileComponents();

      fixture = TestBed.createComponent(BannerMpComponent);
      comp = fixture.componentInstance;
      service = fixture.debugElement.injector.get(BannerMpService);
    });

    it('Should call load all on init', () => {
      // GIVEN
      const headers = new HttpHeaders().append('link', 'link;link');
      spyOn(service, 'query').and.returnValue(
        of(
          new HttpResponse({
            body: [new BannerMp(123)],
            headers,
          })
        )
      );

      // WHEN
      comp.ngOnInit();

      // THEN
      expect(service.query).toHaveBeenCalled();
      expect(comp.banners && comp.banners[0]).toEqual(jasmine.objectContaining({ id: 123 }));
    });
  });
});
