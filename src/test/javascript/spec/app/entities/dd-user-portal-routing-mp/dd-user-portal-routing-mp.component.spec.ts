import { ComponentFixture, TestBed } from '@angular/core/testing';
import { of } from 'rxjs';
import { HttpHeaders, HttpResponse } from '@angular/common/http';

import { JhipsterSampleApplication20201127TestModule } from '../../../test.module';
import { DdUserPortalRoutingMpComponent } from 'app/entities/dd-user-portal-routing-mp/dd-user-portal-routing-mp.component';
import { DdUserPortalRoutingMpService } from 'app/entities/dd-user-portal-routing-mp/dd-user-portal-routing-mp.service';
import { DdUserPortalRoutingMp } from 'app/shared/model/dd-user-portal-routing-mp.model';

describe('Component Tests', () => {
  describe('DdUserPortalRoutingMp Management Component', () => {
    let comp: DdUserPortalRoutingMpComponent;
    let fixture: ComponentFixture<DdUserPortalRoutingMpComponent>;
    let service: DdUserPortalRoutingMpService;

    beforeEach(() => {
      TestBed.configureTestingModule({
        imports: [JhipsterSampleApplication20201127TestModule],
        declarations: [DdUserPortalRoutingMpComponent],
      })
        .overrideTemplate(DdUserPortalRoutingMpComponent, '')
        .compileComponents();

      fixture = TestBed.createComponent(DdUserPortalRoutingMpComponent);
      comp = fixture.componentInstance;
      service = fixture.debugElement.injector.get(DdUserPortalRoutingMpService);
    });

    it('Should call load all on init', () => {
      // GIVEN
      const headers = new HttpHeaders().append('link', 'link;link');
      spyOn(service, 'query').and.returnValue(
        of(
          new HttpResponse({
            body: [new DdUserPortalRoutingMp(123)],
            headers,
          })
        )
      );

      // WHEN
      comp.ngOnInit();

      // THEN
      expect(service.query).toHaveBeenCalled();
      expect(comp.ddUserPortalRoutings && comp.ddUserPortalRoutings[0]).toEqual(jasmine.objectContaining({ id: 123 }));
    });
  });
});
