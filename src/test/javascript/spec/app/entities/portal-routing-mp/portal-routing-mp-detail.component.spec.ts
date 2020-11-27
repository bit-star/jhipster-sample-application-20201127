import { ComponentFixture, TestBed } from '@angular/core/testing';
import { ActivatedRoute } from '@angular/router';
import { of } from 'rxjs';

import { JhipsterSampleApplication20201127TestModule } from '../../../test.module';
import { PortalRoutingMpDetailComponent } from 'app/entities/portal-routing-mp/portal-routing-mp-detail.component';
import { PortalRoutingMp } from 'app/shared/model/portal-routing-mp.model';

describe('Component Tests', () => {
  describe('PortalRoutingMp Management Detail Component', () => {
    let comp: PortalRoutingMpDetailComponent;
    let fixture: ComponentFixture<PortalRoutingMpDetailComponent>;
    const route = ({ data: of({ portalRouting: new PortalRoutingMp(123) }) } as any) as ActivatedRoute;

    beforeEach(() => {
      TestBed.configureTestingModule({
        imports: [JhipsterSampleApplication20201127TestModule],
        declarations: [PortalRoutingMpDetailComponent],
        providers: [{ provide: ActivatedRoute, useValue: route }],
      })
        .overrideTemplate(PortalRoutingMpDetailComponent, '')
        .compileComponents();
      fixture = TestBed.createComponent(PortalRoutingMpDetailComponent);
      comp = fixture.componentInstance;
    });

    describe('OnInit', () => {
      it('Should load portalRouting on init', () => {
        // WHEN
        comp.ngOnInit();

        // THEN
        expect(comp.portalRouting).toEqual(jasmine.objectContaining({ id: 123 }));
      });
    });
  });
});
