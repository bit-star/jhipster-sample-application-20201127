import { ComponentFixture, TestBed, fakeAsync, tick } from '@angular/core/testing';
import { HttpResponse } from '@angular/common/http';
import { FormBuilder } from '@angular/forms';
import { of } from 'rxjs';

import { JhipsterSampleApplication20201127TestModule } from '../../../test.module';
import { DdUserPortalRoutingMpUpdateComponent } from 'app/entities/dd-user-portal-routing-mp/dd-user-portal-routing-mp-update.component';
import { DdUserPortalRoutingMpService } from 'app/entities/dd-user-portal-routing-mp/dd-user-portal-routing-mp.service';
import { DdUserPortalRoutingMp } from 'app/shared/model/dd-user-portal-routing-mp.model';

describe('Component Tests', () => {
  describe('DdUserPortalRoutingMp Management Update Component', () => {
    let comp: DdUserPortalRoutingMpUpdateComponent;
    let fixture: ComponentFixture<DdUserPortalRoutingMpUpdateComponent>;
    let service: DdUserPortalRoutingMpService;

    beforeEach(() => {
      TestBed.configureTestingModule({
        imports: [JhipsterSampleApplication20201127TestModule],
        declarations: [DdUserPortalRoutingMpUpdateComponent],
        providers: [FormBuilder],
      })
        .overrideTemplate(DdUserPortalRoutingMpUpdateComponent, '')
        .compileComponents();

      fixture = TestBed.createComponent(DdUserPortalRoutingMpUpdateComponent);
      comp = fixture.componentInstance;
      service = fixture.debugElement.injector.get(DdUserPortalRoutingMpService);
    });

    describe('save', () => {
      it('Should call update service on save for existing entity', fakeAsync(() => {
        // GIVEN
        const entity = new DdUserPortalRoutingMp(123);
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
        const entity = new DdUserPortalRoutingMp();
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
