import { ComponentFixture, TestBed } from '@angular/core/testing';
import { of } from 'rxjs';
import { HttpHeaders, HttpResponse } from '@angular/common/http';

import { JhipsterSampleApplication20201127TestModule } from '../../../test.module';
import { PortalRoutingMpComponent } from 'app/entities/portal-routing-mp/portal-routing-mp.component';
import { PortalRoutingMpService } from 'app/entities/portal-routing-mp/portal-routing-mp.service';
import { PortalRoutingMp } from 'app/shared/model/portal-routing-mp.model';

describe('Component Tests', () => {
  describe('PortalRoutingMp Management Component', () => {
    let comp: PortalRoutingMpComponent;
    let fixture: ComponentFixture<PortalRoutingMpComponent>;
    let service: PortalRoutingMpService;

    beforeEach(() => {
      TestBed.configureTestingModule({
        imports: [JhipsterSampleApplication20201127TestModule],
        declarations: [PortalRoutingMpComponent],
      })
        .overrideTemplate(PortalRoutingMpComponent, '')
        .compileComponents();

      fixture = TestBed.createComponent(PortalRoutingMpComponent);
      comp = fixture.componentInstance;
      service = fixture.debugElement.injector.get(PortalRoutingMpService);
    });

    it('Should call load all on init', () => {
      // GIVEN
      const headers = new HttpHeaders().append('link', 'link;link');
      spyOn(service, 'query').and.returnValue(
        of(
          new HttpResponse({
            body: [new PortalRoutingMp(123)],
            headers,
          })
        )
      );

      // WHEN
      comp.ngOnInit();

      // THEN
      expect(service.query).toHaveBeenCalled();
      expect(comp.portalRoutings && comp.portalRoutings[0]).toEqual(jasmine.objectContaining({ id: 123 }));
    });
  });
});
