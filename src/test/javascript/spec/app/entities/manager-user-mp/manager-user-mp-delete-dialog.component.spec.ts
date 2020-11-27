import { ComponentFixture, TestBed, inject, fakeAsync, tick } from '@angular/core/testing';
import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';
import { of } from 'rxjs';
import { JhiEventManager } from 'ng-jhipster';

import { JhipsterSampleApplication20201127TestModule } from '../../../test.module';
import { MockEventManager } from '../../../helpers/mock-event-manager.service';
import { MockActiveModal } from '../../../helpers/mock-active-modal.service';
import { ManagerUserMpDeleteDialogComponent } from 'app/entities/manager-user-mp/manager-user-mp-delete-dialog.component';
import { ManagerUserMpService } from 'app/entities/manager-user-mp/manager-user-mp.service';

describe('Component Tests', () => {
  describe('ManagerUserMp Management Delete Component', () => {
    let comp: ManagerUserMpDeleteDialogComponent;
    let fixture: ComponentFixture<ManagerUserMpDeleteDialogComponent>;
    let service: ManagerUserMpService;
    let mockEventManager: MockEventManager;
    let mockActiveModal: MockActiveModal;

    beforeEach(() => {
      TestBed.configureTestingModule({
        imports: [JhipsterSampleApplication20201127TestModule],
        declarations: [ManagerUserMpDeleteDialogComponent],
      })
        .overrideTemplate(ManagerUserMpDeleteDialogComponent, '')
        .compileComponents();
      fixture = TestBed.createComponent(ManagerUserMpDeleteDialogComponent);
      comp = fixture.componentInstance;
      service = fixture.debugElement.injector.get(ManagerUserMpService);
      mockEventManager = TestBed.get(JhiEventManager);
      mockActiveModal = TestBed.get(NgbActiveModal);
    });

    describe('confirmDelete', () => {
      it('Should call delete service on confirmDelete', inject(
        [],
        fakeAsync(() => {
          // GIVEN
          spyOn(service, 'delete').and.returnValue(of({}));

          // WHEN
          comp.confirmDelete(123);
          tick();

          // THEN
          expect(service.delete).toHaveBeenCalledWith(123);
          expect(mockActiveModal.closeSpy).toHaveBeenCalled();
          expect(mockEventManager.broadcastSpy).toHaveBeenCalled();
        })
      ));

      it('Should not call delete service on clear', () => {
        // GIVEN
        spyOn(service, 'delete');

        // WHEN
        comp.cancel();

        // THEN
        expect(service.delete).not.toHaveBeenCalled();
        expect(mockActiveModal.dismissSpy).toHaveBeenCalled();
      });
    });
  });
});
