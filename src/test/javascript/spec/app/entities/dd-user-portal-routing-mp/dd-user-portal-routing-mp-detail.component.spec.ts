import { ComponentFixture, TestBed } from '@angular/core/testing';
import { ActivatedRoute } from '@angular/router';
import { of } from 'rxjs';

import { JhipsterSampleApplication20201127TestModule } from '../../../test.module';
import { DdUserPortalRoutingMpDetailComponent } from 'app/entities/dd-user-portal-routing-mp/dd-user-portal-routing-mp-detail.component';
import { DdUserPortalRoutingMp } from 'app/shared/model/dd-user-portal-routing-mp.model';

describe('Component Tests', () => {
  describe('DdUserPortalRoutingMp Management Detail Component', () => {
    let comp: DdUserPortalRoutingMpDetailComponent;
    let fixture: ComponentFixture<DdUserPortalRoutingMpDetailComponent>;
    const route = ({ data: of({ ddUserPortalRouting: new DdUserPortalRoutingMp(123) }) } as any) as ActivatedRoute;

    beforeEach(() => {
      TestBed.configureTestingModule({
        imports: [JhipsterSampleApplication20201127TestModule],
        declarations: [DdUserPortalRoutingMpDetailComponent],
        providers: [{ provide: ActivatedRoute, useValue: route }],
      })
        .overrideTemplate(DdUserPortalRoutingMpDetailComponent, '')
        .compileComponents();
      fixture = TestBed.createComponent(DdUserPortalRoutingMpDetailComponent);
      comp = fixture.componentInstance;
    });

    describe('OnInit', () => {
      it('Should load ddUserPortalRouting on init', () => {
        // WHEN
        comp.ngOnInit();

        // THEN
        expect(comp.ddUserPortalRouting).toEqual(jasmine.objectContaining({ id: 123 }));
      });
    });
  });
});
