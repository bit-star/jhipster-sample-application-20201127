import { TestBed, getTestBed } from '@angular/core/testing';
import { HttpClientTestingModule, HttpTestingController } from '@angular/common/http/testing';
import { FmpWidgetInfoMpService } from 'app/entities/fmp-widget-info-mp/fmp-widget-info-mp.service';
import { IFmpWidgetInfoMp, FmpWidgetInfoMp } from 'app/shared/model/fmp-widget-info-mp.model';
import { PassingForm } from 'app/shared/model/enumerations/passing-form.model';
import { TopOption } from 'app/shared/model/enumerations/top-option.model';
import { WidgetContentType } from 'app/shared/model/enumerations/widget-content-type.model';
import { WidgeType } from 'app/shared/model/enumerations/widge-type.model';

describe('Service Tests', () => {
  describe('FmpWidgetInfoMp Service', () => {
    let injector: TestBed;
    let service: FmpWidgetInfoMpService;
    let httpMock: HttpTestingController;
    let elemDefault: IFmpWidgetInfoMp;
    let expectedResult: IFmpWidgetInfoMp | IFmpWidgetInfoMp[] | boolean | null;

    beforeEach(() => {
      TestBed.configureTestingModule({
        imports: [HttpClientTestingModule],
      });
      expectedResult = null;
      injector = getTestBed();
      service = injector.get(FmpWidgetInfoMpService);
      httpMock = injector.get(HttpTestingController);

      elemDefault = new FmpWidgetInfoMp(
        0,
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        PassingForm.JobCode,
        TopOption.Top,
        WidgetContentType.List,
        WidgeType.OA,
        false
      );
    });

    describe('Service methods', () => {
      it('should find an element', () => {
        const returnedFromService = Object.assign({}, elemDefault);

        service.find(123).subscribe(resp => (expectedResult = resp.body));

        const req = httpMock.expectOne({ method: 'GET' });
        req.flush(returnedFromService);
        expect(expectedResult).toMatchObject(elemDefault);
      });

      it('should create a FmpWidgetInfoMp', () => {
        const returnedFromService = Object.assign(
          {
            id: 0,
          },
          elemDefault
        );

        const expected = Object.assign({}, returnedFromService);

        service.create(new FmpWidgetInfoMp()).subscribe(resp => (expectedResult = resp.body));

        const req = httpMock.expectOne({ method: 'POST' });
        req.flush(returnedFromService);
        expect(expectedResult).toMatchObject(expected);
      });

      it('should update a FmpWidgetInfoMp', () => {
        const returnedFromService = Object.assign(
          {
            code: 'BBBBBB',
            portalId: 'BBBBBB',
            title: 'BBBBBB',
            catId: 'BBBBBB',
            dataUrl: 'BBBBBB',
            sort: 'BBBBBB',
            dataUrlParam: 'BBBBBB',
            isTop: 'BBBBBB',
            contentType: 'BBBBBB',
            type: 'BBBBBB',
            isDeleted: true,
          },
          elemDefault
        );

        const expected = Object.assign({}, returnedFromService);

        service.update(expected).subscribe(resp => (expectedResult = resp.body));

        const req = httpMock.expectOne({ method: 'PUT' });
        req.flush(returnedFromService);
        expect(expectedResult).toMatchObject(expected);
      });

      it('should return a list of FmpWidgetInfoMp', () => {
        const returnedFromService = Object.assign(
          {
            code: 'BBBBBB',
            portalId: 'BBBBBB',
            title: 'BBBBBB',
            catId: 'BBBBBB',
            dataUrl: 'BBBBBB',
            sort: 'BBBBBB',
            dataUrlParam: 'BBBBBB',
            isTop: 'BBBBBB',
            contentType: 'BBBBBB',
            type: 'BBBBBB',
            isDeleted: true,
          },
          elemDefault
        );

        const expected = Object.assign({}, returnedFromService);

        service.query().subscribe(resp => (expectedResult = resp.body));

        const req = httpMock.expectOne({ method: 'GET' });
        req.flush([returnedFromService]);
        httpMock.verify();
        expect(expectedResult).toContainEqual(expected);
      });

      it('should delete a FmpWidgetInfoMp', () => {
        service.delete(123).subscribe(resp => (expectedResult = resp.ok));

        const req = httpMock.expectOne({ method: 'DELETE' });
        req.flush({ status: 200 });
        expect(expectedResult);
      });
    });

    afterEach(() => {
      httpMock.verify();
    });
  });
});
