import { ComponentFixture, TestBed } from '@angular/core/testing';
import { of } from 'rxjs';
import { HttpHeaders, HttpResponse } from '@angular/common/http';

import { JhipsterSampleApplication20201127TestModule } from '../../../test.module';
import { DdUserMpComponent } from 'app/entities/dd-user-mp/dd-user-mp.component';
import { DdUserMpService } from 'app/entities/dd-user-mp/dd-user-mp.service';
import { DdUserMp } from 'app/shared/model/dd-user-mp.model';

describe('Component Tests', () => {
  describe('DdUserMp Management Component', () => {
    let comp: DdUserMpComponent;
    let fixture: ComponentFixture<DdUserMpComponent>;
    let service: DdUserMpService;

    beforeEach(() => {
      TestBed.configureTestingModule({
        imports: [JhipsterSampleApplication20201127TestModule],
        declarations: [DdUserMpComponent],
      })
        .overrideTemplate(DdUserMpComponent, '')
        .compileComponents();

      fixture = TestBed.createComponent(DdUserMpComponent);
      comp = fixture.componentInstance;
      service = fixture.debugElement.injector.get(DdUserMpService);
    });

    it('Should call load all on init', () => {
      // GIVEN
      const headers = new HttpHeaders().append('link', 'link;link');
      spyOn(service, 'query').and.returnValue(
        of(
          new HttpResponse({
            body: [new DdUserMp(123)],
            headers,
          })
        )
      );

      // WHEN
      comp.ngOnInit();

      // THEN
      expect(service.query).toHaveBeenCalled();
      expect(comp.ddUsers && comp.ddUsers[0]).toEqual(jasmine.objectContaining({ id: 123 }));
    });
  });
});
