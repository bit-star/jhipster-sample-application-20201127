import { ComponentFixture, TestBed } from '@angular/core/testing';
import { of } from 'rxjs';
import { HttpHeaders, HttpResponse } from '@angular/common/http';
import { ActivatedRoute, convertToParamMap } from '@angular/router';

import { JhipsterSampleApplication20201127TestModule } from '../../../test.module';
import { UucUserBaseinfoMpComponent } from 'app/entities/uuc-user-baseinfo-mp/uuc-user-baseinfo-mp.component';
import { UucUserBaseinfoMpService } from 'app/entities/uuc-user-baseinfo-mp/uuc-user-baseinfo-mp.service';
import { UucUserBaseinfoMp } from 'app/shared/model/uuc-user-baseinfo-mp.model';

describe('Component Tests', () => {
  describe('UucUserBaseinfoMp Management Component', () => {
    let comp: UucUserBaseinfoMpComponent;
    let fixture: ComponentFixture<UucUserBaseinfoMpComponent>;
    let service: UucUserBaseinfoMpService;

    beforeEach(() => {
      TestBed.configureTestingModule({
        imports: [JhipsterSampleApplication20201127TestModule],
        declarations: [UucUserBaseinfoMpComponent],
        providers: [
          {
            provide: ActivatedRoute,
            useValue: {
              data: of({
                defaultSort: 'id,asc',
              }),
              queryParamMap: of(
                convertToParamMap({
                  page: '1',
                  size: '1',
                  sort: 'id,desc',
                })
              ),
            },
          },
        ],
      })
        .overrideTemplate(UucUserBaseinfoMpComponent, '')
        .compileComponents();

      fixture = TestBed.createComponent(UucUserBaseinfoMpComponent);
      comp = fixture.componentInstance;
      service = fixture.debugElement.injector.get(UucUserBaseinfoMpService);
    });

    it('Should call load all on init', () => {
      // GIVEN
      const headers = new HttpHeaders().append('link', 'link;link');
      spyOn(service, 'query').and.returnValue(
        of(
          new HttpResponse({
            body: [new UucUserBaseinfoMp(123)],
            headers,
          })
        )
      );

      // WHEN
      comp.ngOnInit();

      // THEN
      expect(service.query).toHaveBeenCalled();
      expect(comp.uucUserBaseinfos && comp.uucUserBaseinfos[0]).toEqual(jasmine.objectContaining({ id: 123 }));
    });

    it('should load a page', () => {
      // GIVEN
      const headers = new HttpHeaders().append('link', 'link;link');
      spyOn(service, 'query').and.returnValue(
        of(
          new HttpResponse({
            body: [new UucUserBaseinfoMp(123)],
            headers,
          })
        )
      );

      // WHEN
      comp.loadPage(1);

      // THEN
      expect(service.query).toHaveBeenCalled();
      expect(comp.uucUserBaseinfos && comp.uucUserBaseinfos[0]).toEqual(jasmine.objectContaining({ id: 123 }));
    });

    it('should calculate the sort attribute for an id', () => {
      // WHEN
      comp.ngOnInit();
      const result = comp.sort();

      // THEN
      expect(result).toEqual(['id,desc']);
    });

    it('should calculate the sort attribute for a non-id attribute', () => {
      // INIT
      comp.ngOnInit();

      // GIVEN
      comp.predicate = 'name';

      // WHEN
      const result = comp.sort();

      // THEN
      expect(result).toEqual(['name,desc', 'id']);
    });
  });
});
