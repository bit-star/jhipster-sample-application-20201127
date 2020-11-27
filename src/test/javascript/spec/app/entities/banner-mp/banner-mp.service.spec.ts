import { TestBed, getTestBed } from '@angular/core/testing';
import { HttpClientTestingModule, HttpTestingController } from '@angular/common/http/testing';
import { BannerMpService } from 'app/entities/banner-mp/banner-mp.service';
import { IBannerMp, BannerMp } from 'app/shared/model/banner-mp.model';
import { BannerType } from 'app/shared/model/enumerations/banner-type.model';
import { Status } from 'app/shared/model/enumerations/status.model';

describe('Service Tests', () => {
  describe('BannerMp Service', () => {
    let injector: TestBed;
    let service: BannerMpService;
    let httpMock: HttpTestingController;
    let elemDefault: IBannerMp;
    let expectedResult: IBannerMp | IBannerMp[] | boolean | null;

    beforeEach(() => {
      TestBed.configureTestingModule({
        imports: [HttpClientTestingModule],
      });
      expectedResult = null;
      injector = getTestBed();
      service = injector.get(BannerMpService);
      httpMock = injector.get(HttpTestingController);

      elemDefault = new BannerMp(0, 0, BannerType.Global, Status.Available, 'AAAAAAA', 'AAAAAAA', 'AAAAAAA');
    });

    describe('Service methods', () => {
      it('should find an element', () => {
        const returnedFromService = Object.assign({}, elemDefault);

        service.find(123).subscribe(resp => (expectedResult = resp.body));

        const req = httpMock.expectOne({ method: 'GET' });
        req.flush(returnedFromService);
        expect(expectedResult).toMatchObject(elemDefault);
      });

      it('should create a BannerMp', () => {
        const returnedFromService = Object.assign(
          {
            id: 0,
          },
          elemDefault
        );

        const expected = Object.assign({}, returnedFromService);

        service.create(new BannerMp()).subscribe(resp => (expectedResult = resp.body));

        const req = httpMock.expectOne({ method: 'POST' });
        req.flush(returnedFromService);
        expect(expectedResult).toMatchObject(expected);
      });

      it('should update a BannerMp', () => {
        const returnedFromService = Object.assign(
          {
            rank: 1,
            type: 'BBBBBB',
            status: 'BBBBBB',
            pathUrl: 'BBBBBB',
            bannerUrl: 'BBBBBB',
            remark: 'BBBBBB',
          },
          elemDefault
        );

        const expected = Object.assign({}, returnedFromService);

        service.update(expected).subscribe(resp => (expectedResult = resp.body));

        const req = httpMock.expectOne({ method: 'PUT' });
        req.flush(returnedFromService);
        expect(expectedResult).toMatchObject(expected);
      });

      it('should return a list of BannerMp', () => {
        const returnedFromService = Object.assign(
          {
            rank: 1,
            type: 'BBBBBB',
            status: 'BBBBBB',
            pathUrl: 'BBBBBB',
            bannerUrl: 'BBBBBB',
            remark: 'BBBBBB',
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

      it('should delete a BannerMp', () => {
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
