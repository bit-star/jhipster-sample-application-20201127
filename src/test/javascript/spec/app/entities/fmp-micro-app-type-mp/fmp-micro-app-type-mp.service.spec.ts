import { TestBed, getTestBed } from '@angular/core/testing';
import { HttpClientTestingModule, HttpTestingController } from '@angular/common/http/testing';
import { FmpMicroAppTypeMpService } from 'app/entities/fmp-micro-app-type-mp/fmp-micro-app-type-mp.service';
import { IFmpMicroAppTypeMp, FmpMicroAppTypeMp } from 'app/shared/model/fmp-micro-app-type-mp.model';

describe('Service Tests', () => {
  describe('FmpMicroAppTypeMp Service', () => {
    let injector: TestBed;
    let service: FmpMicroAppTypeMpService;
    let httpMock: HttpTestingController;
    let elemDefault: IFmpMicroAppTypeMp;
    let expectedResult: IFmpMicroAppTypeMp | IFmpMicroAppTypeMp[] | boolean | null;

    beforeEach(() => {
      TestBed.configureTestingModule({
        imports: [HttpClientTestingModule],
      });
      expectedResult = null;
      injector = getTestBed();
      service = injector.get(FmpMicroAppTypeMpService);
      httpMock = injector.get(HttpTestingController);

      elemDefault = new FmpMicroAppTypeMp(0, 'AAAAAAA', 'AAAAAAA', 'AAAAAAA', 'AAAAAAA', false);
    });

    describe('Service methods', () => {
      it('should find an element', () => {
        const returnedFromService = Object.assign({}, elemDefault);

        service.find(123).subscribe(resp => (expectedResult = resp.body));

        const req = httpMock.expectOne({ method: 'GET' });
        req.flush(returnedFromService);
        expect(expectedResult).toMatchObject(elemDefault);
      });

      it('should create a FmpMicroAppTypeMp', () => {
        const returnedFromService = Object.assign(
          {
            id: 0,
          },
          elemDefault
        );

        const expected = Object.assign({}, returnedFromService);

        service.create(new FmpMicroAppTypeMp()).subscribe(resp => (expectedResult = resp.body));

        const req = httpMock.expectOne({ method: 'POST' });
        req.flush(returnedFromService);
        expect(expectedResult).toMatchObject(expected);
      });

      it('should update a FmpMicroAppTypeMp', () => {
        const returnedFromService = Object.assign(
          {
            code: 'BBBBBB',
            name: 'BBBBBB',
            language: 'BBBBBB',
            portalId: 'BBBBBB',
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

      it('should return a list of FmpMicroAppTypeMp', () => {
        const returnedFromService = Object.assign(
          {
            code: 'BBBBBB',
            name: 'BBBBBB',
            language: 'BBBBBB',
            portalId: 'BBBBBB',
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

      it('should delete a FmpMicroAppTypeMp', () => {
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
