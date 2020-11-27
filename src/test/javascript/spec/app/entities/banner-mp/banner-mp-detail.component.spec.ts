import { ComponentFixture, TestBed } from '@angular/core/testing';
import { ActivatedRoute } from '@angular/router';
import { of } from 'rxjs';

import { JhipsterSampleApplication20201127TestModule } from '../../../test.module';
import { BannerMpDetailComponent } from 'app/entities/banner-mp/banner-mp-detail.component';
import { BannerMp } from 'app/shared/model/banner-mp.model';

describe('Component Tests', () => {
  describe('BannerMp Management Detail Component', () => {
    let comp: BannerMpDetailComponent;
    let fixture: ComponentFixture<BannerMpDetailComponent>;
    const route = ({ data: of({ banner: new BannerMp(123) }) } as any) as ActivatedRoute;

    beforeEach(() => {
      TestBed.configureTestingModule({
        imports: [JhipsterSampleApplication20201127TestModule],
        declarations: [BannerMpDetailComponent],
        providers: [{ provide: ActivatedRoute, useValue: route }],
      })
        .overrideTemplate(BannerMpDetailComponent, '')
        .compileComponents();
      fixture = TestBed.createComponent(BannerMpDetailComponent);
      comp = fixture.componentInstance;
    });

    describe('OnInit', () => {
      it('Should load banner on init', () => {
        // WHEN
        comp.ngOnInit();

        // THEN
        expect(comp.banner).toEqual(jasmine.objectContaining({ id: 123 }));
      });
    });
  });
});
