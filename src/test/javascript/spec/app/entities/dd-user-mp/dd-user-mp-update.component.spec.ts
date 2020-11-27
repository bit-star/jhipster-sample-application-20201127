import { ComponentFixture, TestBed, fakeAsync, tick } from '@angular/core/testing';
import { HttpResponse } from '@angular/common/http';
import { FormBuilder } from '@angular/forms';
import { of } from 'rxjs';

import { JhipsterSampleApplication20201127TestModule } from '../../../test.module';
import { DdUserMpUpdateComponent } from 'app/entities/dd-user-mp/dd-user-mp-update.component';
import { DdUserMpService } from 'app/entities/dd-user-mp/dd-user-mp.service';
import { DdUserMp } from 'app/shared/model/dd-user-mp.model';

describe('Component Tests', () => {
  describe('DdUserMp Management Update Component', () => {
    let comp: DdUserMpUpdateComponent;
    let fixture: ComponentFixture<DdUserMpUpdateComponent>;
    let service: DdUserMpService;

    beforeEach(() => {
      TestBed.configureTestingModule({
        imports: [JhipsterSampleApplication20201127TestModule],
        declarations: [DdUserMpUpdateComponent],
        providers: [FormBuilder],
      })
        .overrideTemplate(DdUserMpUpdateComponent, '')
        .compileComponents();

      fixture = TestBed.createComponent(DdUserMpUpdateComponent);
      comp = fixture.componentInstance;
      service = fixture.debugElement.injector.get(DdUserMpService);
    });

    describe('save', () => {
      it('Should call update service on save for existing entity', fakeAsync(() => {
        // GIVEN
        const entity = new DdUserMp(123);
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
        const entity = new DdUserMp();
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
