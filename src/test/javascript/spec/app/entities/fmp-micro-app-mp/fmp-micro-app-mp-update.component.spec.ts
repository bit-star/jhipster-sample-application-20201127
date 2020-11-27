import { ComponentFixture, TestBed, fakeAsync, tick } from '@angular/core/testing';
import { HttpResponse } from '@angular/common/http';
import { FormBuilder } from '@angular/forms';
import { of } from 'rxjs';

import { JhipsterSampleApplication20201127TestModule } from '../../../test.module';
import { FmpMicroAppMpUpdateComponent } from 'app/entities/fmp-micro-app-mp/fmp-micro-app-mp-update.component';
import { FmpMicroAppMpService } from 'app/entities/fmp-micro-app-mp/fmp-micro-app-mp.service';
import { FmpMicroAppMp } from 'app/shared/model/fmp-micro-app-mp.model';

describe('Component Tests', () => {
  describe('FmpMicroAppMp Management Update Component', () => {
    let comp: FmpMicroAppMpUpdateComponent;
    let fixture: ComponentFixture<FmpMicroAppMpUpdateComponent>;
    let service: FmpMicroAppMpService;

    beforeEach(() => {
      TestBed.configureTestingModule({
        imports: [JhipsterSampleApplication20201127TestModule],
        declarations: [FmpMicroAppMpUpdateComponent],
        providers: [FormBuilder],
      })
        .overrideTemplate(FmpMicroAppMpUpdateComponent, '')
        .compileComponents();

      fixture = TestBed.createComponent(FmpMicroAppMpUpdateComponent);
      comp = fixture.componentInstance;
      service = fixture.debugElement.injector.get(FmpMicroAppMpService);
    });

    describe('save', () => {
      it('Should call update service on save for existing entity', fakeAsync(() => {
        // GIVEN
        const entity = new FmpMicroAppMp(123);
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
        const entity = new FmpMicroAppMp();
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
