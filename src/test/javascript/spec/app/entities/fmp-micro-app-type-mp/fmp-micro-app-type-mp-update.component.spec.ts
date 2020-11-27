import { ComponentFixture, TestBed, fakeAsync, tick } from '@angular/core/testing';
import { HttpResponse } from '@angular/common/http';
import { FormBuilder } from '@angular/forms';
import { of } from 'rxjs';

import { JhipsterSampleApplication20201127TestModule } from '../../../test.module';
import { FmpMicroAppTypeMpUpdateComponent } from 'app/entities/fmp-micro-app-type-mp/fmp-micro-app-type-mp-update.component';
import { FmpMicroAppTypeMpService } from 'app/entities/fmp-micro-app-type-mp/fmp-micro-app-type-mp.service';
import { FmpMicroAppTypeMp } from 'app/shared/model/fmp-micro-app-type-mp.model';

describe('Component Tests', () => {
  describe('FmpMicroAppTypeMp Management Update Component', () => {
    let comp: FmpMicroAppTypeMpUpdateComponent;
    let fixture: ComponentFixture<FmpMicroAppTypeMpUpdateComponent>;
    let service: FmpMicroAppTypeMpService;

    beforeEach(() => {
      TestBed.configureTestingModule({
        imports: [JhipsterSampleApplication20201127TestModule],
        declarations: [FmpMicroAppTypeMpUpdateComponent],
        providers: [FormBuilder],
      })
        .overrideTemplate(FmpMicroAppTypeMpUpdateComponent, '')
        .compileComponents();

      fixture = TestBed.createComponent(FmpMicroAppTypeMpUpdateComponent);
      comp = fixture.componentInstance;
      service = fixture.debugElement.injector.get(FmpMicroAppTypeMpService);
    });

    describe('save', () => {
      it('Should call update service on save for existing entity', fakeAsync(() => {
        // GIVEN
        const entity = new FmpMicroAppTypeMp(123);
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
        const entity = new FmpMicroAppTypeMp();
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
