import { ComponentFixture, TestBed, fakeAsync, tick } from '@angular/core/testing';
import { HttpResponse } from '@angular/common/http';
import { FormBuilder } from '@angular/forms';
import { of } from 'rxjs';

import { JhipsterSampleApplication20201127TestModule } from '../../../test.module';
import { FmpWidgetInfoMpUpdateComponent } from 'app/entities/fmp-widget-info-mp/fmp-widget-info-mp-update.component';
import { FmpWidgetInfoMpService } from 'app/entities/fmp-widget-info-mp/fmp-widget-info-mp.service';
import { FmpWidgetInfoMp } from 'app/shared/model/fmp-widget-info-mp.model';

describe('Component Tests', () => {
  describe('FmpWidgetInfoMp Management Update Component', () => {
    let comp: FmpWidgetInfoMpUpdateComponent;
    let fixture: ComponentFixture<FmpWidgetInfoMpUpdateComponent>;
    let service: FmpWidgetInfoMpService;

    beforeEach(() => {
      TestBed.configureTestingModule({
        imports: [JhipsterSampleApplication20201127TestModule],
        declarations: [FmpWidgetInfoMpUpdateComponent],
        providers: [FormBuilder],
      })
        .overrideTemplate(FmpWidgetInfoMpUpdateComponent, '')
        .compileComponents();

      fixture = TestBed.createComponent(FmpWidgetInfoMpUpdateComponent);
      comp = fixture.componentInstance;
      service = fixture.debugElement.injector.get(FmpWidgetInfoMpService);
    });

    describe('save', () => {
      it('Should call update service on save for existing entity', fakeAsync(() => {
        // GIVEN
        const entity = new FmpWidgetInfoMp(123);
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
        const entity = new FmpWidgetInfoMp();
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
