import { ComponentFixture, TestBed, fakeAsync, tick } from '@angular/core/testing';
import { HttpResponse } from '@angular/common/http';
import { FormBuilder } from '@angular/forms';
import { of } from 'rxjs';

import { JhipsterSampleApplication20201127TestModule } from '../../../test.module';
import { ManagerUserMpUpdateComponent } from 'app/entities/manager-user-mp/manager-user-mp-update.component';
import { ManagerUserMpService } from 'app/entities/manager-user-mp/manager-user-mp.service';
import { ManagerUserMp } from 'app/shared/model/manager-user-mp.model';

describe('Component Tests', () => {
  describe('ManagerUserMp Management Update Component', () => {
    let comp: ManagerUserMpUpdateComponent;
    let fixture: ComponentFixture<ManagerUserMpUpdateComponent>;
    let service: ManagerUserMpService;

    beforeEach(() => {
      TestBed.configureTestingModule({
        imports: [JhipsterSampleApplication20201127TestModule],
        declarations: [ManagerUserMpUpdateComponent],
        providers: [FormBuilder],
      })
        .overrideTemplate(ManagerUserMpUpdateComponent, '')
        .compileComponents();

      fixture = TestBed.createComponent(ManagerUserMpUpdateComponent);
      comp = fixture.componentInstance;
      service = fixture.debugElement.injector.get(ManagerUserMpService);
    });

    describe('save', () => {
      it('Should call update service on save for existing entity', fakeAsync(() => {
        // GIVEN
        const entity = new ManagerUserMp(123);
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
        const entity = new ManagerUserMp();
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
