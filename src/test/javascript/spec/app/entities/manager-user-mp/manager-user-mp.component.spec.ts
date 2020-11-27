import { ComponentFixture, TestBed } from '@angular/core/testing';
import { of } from 'rxjs';
import { HttpHeaders, HttpResponse } from '@angular/common/http';

import { JhipsterSampleApplication20201127TestModule } from '../../../test.module';
import { ManagerUserMpComponent } from 'app/entities/manager-user-mp/manager-user-mp.component';
import { ManagerUserMpService } from 'app/entities/manager-user-mp/manager-user-mp.service';
import { ManagerUserMp } from 'app/shared/model/manager-user-mp.model';

describe('Component Tests', () => {
  describe('ManagerUserMp Management Component', () => {
    let comp: ManagerUserMpComponent;
    let fixture: ComponentFixture<ManagerUserMpComponent>;
    let service: ManagerUserMpService;

    beforeEach(() => {
      TestBed.configureTestingModule({
        imports: [JhipsterSampleApplication20201127TestModule],
        declarations: [ManagerUserMpComponent],
      })
        .overrideTemplate(ManagerUserMpComponent, '')
        .compileComponents();

      fixture = TestBed.createComponent(ManagerUserMpComponent);
      comp = fixture.componentInstance;
      service = fixture.debugElement.injector.get(ManagerUserMpService);
    });

    it('Should call load all on init', () => {
      // GIVEN
      const headers = new HttpHeaders().append('link', 'link;link');
      spyOn(service, 'query').and.returnValue(
        of(
          new HttpResponse({
            body: [new ManagerUserMp(123)],
            headers,
          })
        )
      );

      // WHEN
      comp.ngOnInit();

      // THEN
      expect(service.query).toHaveBeenCalled();
      expect(comp.managerUsers && comp.managerUsers[0]).toEqual(jasmine.objectContaining({ id: 123 }));
    });
  });
});
