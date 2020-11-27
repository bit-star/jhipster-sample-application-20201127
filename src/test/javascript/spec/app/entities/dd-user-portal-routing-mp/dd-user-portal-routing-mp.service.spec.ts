import { TestBed, getTestBed } from '@angular/core/testing';
import { HttpClientTestingModule, HttpTestingController } from '@angular/common/http/testing';
import { DdUserPortalRoutingMpService } from 'app/entities/dd-user-portal-routing-mp/dd-user-portal-routing-mp.service';
import { IDdUserPortalRoutingMp, DdUserPortalRoutingMp } from 'app/shared/model/dd-user-portal-routing-mp.model';

describe('Service Tests', () => {
  describe('DdUserPortalRoutingMp Service', () => {
    let injector: TestBed;
    let service: DdUserPortalRoutingMpService;
    let httpMock: HttpTestingController;
    let elemDefault: IDdUserPortalRoutingMp;
    let expectedResult: IDdUserPortalRoutingMp | IDdUserPortalRoutingMp[] | boolean | null;

    beforeEach(() => {
      TestBed.configureTestingModule({
        imports: [HttpClientTestingModule],
      });
      expectedResult = null;
      injector = getTestBed();
      service = injector.get(DdUserPortalRoutingMpService);
      httpMock = injector.get(HttpTestingController);

      elemDefault = new DdUserPortalRoutingMp(0, 'AAAAAAA', 'AAAAAAA', 'AAAAAAA', 'AAAAAAA', 'AAAAAAA', 'AAAAAAA');
    });

    describe('Service methods', () => {
      it('should find an element', () => {
        const returnedFromService = Object.assign({}, elemDefault);

        service.find(123).subscribe(resp => (expectedResult = resp.body));

        const req = httpMock.expectOne({ method: 'GET' });
        req.flush(returnedFromService);
        expect(expectedResult).toMatchObject(elemDefault);
      });

      it('should create a DdUserPortalRoutingMp', () => {
        const returnedFromService = Object.assign(
          {
            id: 0,
          },
          elemDefault
        );

        const expected = Object.assign({}, returnedFromService);

        service.create(new DdUserPortalRoutingMp()).subscribe(resp => (expectedResult = resp.body));

        const req = httpMock.expectOne({ method: 'POST' });
        req.flush(returnedFromService);
        expect(expectedResult).toMatchObject(expected);
      });

      it('should update a DdUserPortalRoutingMp', () => {
        const returnedFromService = Object.assign(
          {
            jobCode: 'BBBBBB',
            mobile: 'BBBBBB',
            microappUrl: 'BBBBBB',
            injectionFlag: 'BBBBBB',
            injectionApiUri: 'BBBBBB',
            mucAppId: 'BBBBBB',
          },
          elemDefault
        );

        const expected = Object.assign({}, returnedFromService);

        service.update(expected).subscribe(resp => (expectedResult = resp.body));

        const req = httpMock.expectOne({ method: 'PUT' });
        req.flush(returnedFromService);
        expect(expectedResult).toMatchObject(expected);
      });

      it('should return a list of DdUserPortalRoutingMp', () => {
        const returnedFromService = Object.assign(
          {
            jobCode: 'BBBBBB',
            mobile: 'BBBBBB',
            microappUrl: 'BBBBBB',
            injectionFlag: 'BBBBBB',
            injectionApiUri: 'BBBBBB',
            mucAppId: 'BBBBBB',
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

      it('should delete a DdUserPortalRoutingMp', () => {
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
