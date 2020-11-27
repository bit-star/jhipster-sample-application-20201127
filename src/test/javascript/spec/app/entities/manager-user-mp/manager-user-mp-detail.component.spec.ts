import { ComponentFixture, TestBed } from '@angular/core/testing';
import { ActivatedRoute } from '@angular/router';
import { of } from 'rxjs';

import { JhipsterSampleApplication20201127TestModule } from '../../../test.module';
import { ManagerUserMpDetailComponent } from 'app/entities/manager-user-mp/manager-user-mp-detail.component';
import { ManagerUserMp } from 'app/shared/model/manager-user-mp.model';

describe('Component Tests', () => {
  describe('ManagerUserMp Management Detail Component', () => {
    let comp: ManagerUserMpDetailComponent;
    let fixture: ComponentFixture<ManagerUserMpDetailComponent>;
    const route = ({ data: of({ managerUser: new ManagerUserMp(123) }) } as any) as ActivatedRoute;

    beforeEach(() => {
      TestBed.configureTestingModule({
        imports: [JhipsterSampleApplication20201127TestModule],
        declarations: [ManagerUserMpDetailComponent],
        providers: [{ provide: ActivatedRoute, useValue: route }],
      })
        .overrideTemplate(ManagerUserMpDetailComponent, '')
        .compileComponents();
      fixture = TestBed.createComponent(ManagerUserMpDetailComponent);
      comp = fixture.componentInstance;
    });

    describe('OnInit', () => {
      it('Should load managerUser on init', () => {
        // WHEN
        comp.ngOnInit();

        // THEN
        expect(comp.managerUser).toEqual(jasmine.objectContaining({ id: 123 }));
      });
    });
  });
});
