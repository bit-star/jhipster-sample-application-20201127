import { ComponentFixture, TestBed } from '@angular/core/testing';
import { ActivatedRoute } from '@angular/router';
import { of } from 'rxjs';

import { JhipsterSampleApplication20201127TestModule } from '../../../test.module';
import { DdUserMpDetailComponent } from 'app/entities/dd-user-mp/dd-user-mp-detail.component';
import { DdUserMp } from 'app/shared/model/dd-user-mp.model';

describe('Component Tests', () => {
  describe('DdUserMp Management Detail Component', () => {
    let comp: DdUserMpDetailComponent;
    let fixture: ComponentFixture<DdUserMpDetailComponent>;
    const route = ({ data: of({ ddUser: new DdUserMp(123) }) } as any) as ActivatedRoute;

    beforeEach(() => {
      TestBed.configureTestingModule({
        imports: [JhipsterSampleApplication20201127TestModule],
        declarations: [DdUserMpDetailComponent],
        providers: [{ provide: ActivatedRoute, useValue: route }],
      })
        .overrideTemplate(DdUserMpDetailComponent, '')
        .compileComponents();
      fixture = TestBed.createComponent(DdUserMpDetailComponent);
      comp = fixture.componentInstance;
    });

    describe('OnInit', () => {
      it('Should load ddUser on init', () => {
        // WHEN
        comp.ngOnInit();

        // THEN
        expect(comp.ddUser).toEqual(jasmine.objectContaining({ id: 123 }));
      });
    });
  });
});
