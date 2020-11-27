import { ComponentFixture, TestBed, fakeAsync, tick } from '@angular/core/testing';
import { HttpResponse } from '@angular/common/http';
import { FormBuilder } from '@angular/forms';
import { of } from 'rxjs';

import { JhipsterSampleApplication20201127TestModule } from '../../../test.module';
import { PortalRoutingMpUpdateComponent } from 'app/entities/portal-routing-mp/portal-routing-mp-update.component';
import { PortalRoutingMpService } from 'app/entities/portal-routing-mp/portal-routing-mp.service';
import { PortalRoutingMp } from 'app/shared/model/portal-routing-mp.model';

describe('Component Tests', () => {
  describe('PortalRoutingMp Management Update Component', () => {
    let comp: PortalRoutingMpUpdateComponent;
    let fixture: ComponentFixture<PortalRoutingMpUpdateComponent>;
    let service: PortalRoutingMpService;

    beforeEach(() => {
      TestBed.configureTestingModule({
        imports: [JhipsterSampleApplication20201127TestModule],
        declarations: [PortalRoutingMpUpdateComponent],
        providers: [FormBuilder],
      })
        .overrideTemplate(PortalRoutingMpUpdateComponent, '')
        .compileComponents();

      fixture = TestBed.createComponent(PortalRoutingMpUpdateComponent);
      comp = fixture.componentInstance;
      service = fixture.debugElement.injector.get(PortalRoutingMpService);
    });

    describe('save', () => {
      it('Should call update service on save for existing entity', fakeAsync(() => {
        // GIVEN
        const entity = new PortalRoutingMp(123);
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
        const entity = new PortalRoutingMp();
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
