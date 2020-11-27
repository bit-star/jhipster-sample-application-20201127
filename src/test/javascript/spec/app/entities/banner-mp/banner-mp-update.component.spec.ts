import { ComponentFixture, TestBed, fakeAsync, tick } from '@angular/core/testing';
import { HttpResponse } from '@angular/common/http';
import { FormBuilder } from '@angular/forms';
import { of } from 'rxjs';

import { JhipsterSampleApplication20201127TestModule } from '../../../test.module';
import { BannerMpUpdateComponent } from 'app/entities/banner-mp/banner-mp-update.component';
import { BannerMpService } from 'app/entities/banner-mp/banner-mp.service';
import { BannerMp } from 'app/shared/model/banner-mp.model';

describe('Component Tests', () => {
  describe('BannerMp Management Update Component', () => {
    let comp: BannerMpUpdateComponent;
    let fixture: ComponentFixture<BannerMpUpdateComponent>;
    let service: BannerMpService;

    beforeEach(() => {
      TestBed.configureTestingModule({
        imports: [JhipsterSampleApplication20201127TestModule],
        declarations: [BannerMpUpdateComponent],
        providers: [FormBuilder],
      })
        .overrideTemplate(BannerMpUpdateComponent, '')
        .compileComponents();

      fixture = TestBed.createComponent(BannerMpUpdateComponent);
      comp = fixture.componentInstance;
      service = fixture.debugElement.injector.get(BannerMpService);
    });

    describe('save', () => {
      it('Should call update service on save for existing entity', fakeAsync(() => {
        // GIVEN
        const entity = new BannerMp(123);
        spyOn(service, 'update').and.returnValue(of(new HttpResponse({ body: entity })));
        comp.updateForm(entity);
        // WHEN
        comp.save();
        tick(); // simulate async

        // THEN
        expect(service.update).toHaveBeenCalledWith(entity);
        expect(comp.isSaving).toEqual(false);
      }));

      it('Should call create service on save for new entity', fakeAsync(() => {
        // GIVEN
        const entity = new BannerMp();
        spyOn(service, 'create').and.returnValue(of(new HttpResponse({ body: entity })));
        comp.updateForm(entity);
        // WHEN
        comp.save();
        tick(); // simulate async

        // THEN
        expect(service.create).toHaveBeenCalledWith(entity);
        expect(comp.isSaving).toEqual(false);
      }));
    });
  });
});
