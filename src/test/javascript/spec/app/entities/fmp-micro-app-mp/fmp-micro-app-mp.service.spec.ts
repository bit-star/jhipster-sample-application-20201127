import { TestBed, getTestBed } from '@angular/core/testing';
import { HttpClientTestingModule, HttpTestingController } from '@angular/common/http/testing';
import { FmpMicroAppMpService } from 'app/entities/fmp-micro-app-mp/fmp-micro-app-mp.service';
import { IFmpMicroAppMp, FmpMicroAppMp } from 'app/shared/model/fmp-micro-app-mp.model';
import { IsNew } from 'app/shared/model/enumerations/is-new.model';
import { MicroAppStatus } from 'app/shared/model/enumerations/micro-app-status.model';
import { OpenMethod } from 'app/shared/model/enumerations/open-method.model';
import { Language } from 'app/shared/model/enumerations/language.model';
import { IsFixed } from 'app/shared/model/enumerations/is-fixed.model';

describe('Service Tests', () => {
  describe('FmpMicroAppMp Service', () => {
    let injector: TestBed;
    let service: FmpMicroAppMpService;
    let httpMock: HttpTestingController;
    let elemDefault: IFmpMicroAppMp;
    let expectedResult: IFmpMicroAppMp | IFmpMicroAppMp[] | boolean | null;

    beforeEach(() => {
      TestBed.configureTestingModule({
        imports: [HttpClientTestingModule],
      });
      expectedResult = null;
      injector = getTestBed();
      service = injector.get(FmpMicroAppMpService);
      httpMock = injector.get(HttpTestingController);

      elemDefault = new FmpMicroAppMp(
        0,
        'AAAAAAA',
        'AAAAAAA',
        0,
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        IsNew.New,
        MicroAppStatus.OffLine,
        OpenMethod.Nesting,
        Language.ZH,
        IsFixed.Fixed,
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA'
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

      it('should create a FmpMicroAppMp', () => {
        const returnedFromService = Object.assign(
          {
            id: 0,
          },
          elemDefault
        );

        const expected = Object.assign({}, returnedFromService);

        service.create(new FmpMicroAppMp()).subscribe(resp => (expectedResult = resp.body));

        const req = httpMock.expectOne({ method: 'POST' });
        req.flush(returnedFromService);
        expect(expectedResult).toMatchObject(expected);
      });

      it('should update a FmpMicroAppMp', () => {
        const returnedFromService = Object.assign(
          {
            catCode: 'BBBBBB',
            parentCatId: 'BBBBBB',
            levelNumber: 1,
            isLeaf: 'BBBBBB',
            businessCode: 'BBBBBB',
            endpointUrl: 'BBBBBB',
            iconImg: 'BBBBBB',
            bannerImg: 'BBBBBB',
            thumbnail: 'BBBBBB',
            sortCode: 'BBBBBB',
            systemType: 'BBBBBB',
            contentOwnerCode: 'BBBBBB',
            lable: 'BBBBBB',
            isNew: 'BBBBBB',
            status: 'BBBBBB',
            openMethod: 'BBBBBB',
            language: 'BBBBBB',
            isFixed: 'BBBBBB',
            tagKey01: 'BBBBBB',
            tagVal01: 'BBBBBB',
            tagKey02: 'BBBBBB',
            tagVal02: 'BBBBBB',
            tagKey03: 'BBBBBB',
            tagVal03: 'BBBBBB',
            catName: 'BBBBBB',
            filterSql: 'BBBBBB',
            sharingFlag: 'BBBBBB',
            category: 'BBBBBB',
            imgClass: 'BBBBBB',
            isInternal: 'BBBBBB',
            customFlag: 'BBBBBB',
            portal: 'BBBBBB',
            description: 'BBBBBB',
            businessUnit: 'BBBBBB',
            businessOwners: 'BBBBBB',
            businessOwnersMobile: 'BBBBBB',
          },
          elemDefault
        );

        const expected = Object.assign({}, returnedFromService);

        service.update(expected).subscribe(resp => (expectedResult = resp.body));

        const req = httpMock.expectOne({ method: 'PUT' });
        req.flush(returnedFromService);
        expect(expectedResult).toMatchObject(expected);
      });

      it('should return a list of FmpMicroAppMp', () => {
        const returnedFromService = Object.assign(
          {
            catCode: 'BBBBBB',
            parentCatId: 'BBBBBB',
            levelNumber: 1,
            isLeaf: 'BBBBBB',
            businessCode: 'BBBBBB',
            endpointUrl: 'BBBBBB',
            iconImg: 'BBBBBB',
            bannerImg: 'BBBBBB',
            thumbnail: 'BBBBBB',
            sortCode: 'BBBBBB',
            systemType: 'BBBBBB',
            contentOwnerCode: 'BBBBBB',
            lable: 'BBBBBB',
            isNew: 'BBBBBB',
            status: 'BBBBBB',
            openMethod: 'BBBBBB',
            language: 'BBBBBB',
            isFixed: 'BBBBBB',
            tagKey01: 'BBBBBB',
            tagVal01: 'BBBBBB',
            tagKey02: 'BBBBBB',
            tagVal02: 'BBBBBB',
            tagKey03: 'BBBBBB',
            tagVal03: 'BBBBBB',
            catName: 'BBBBBB',
            filterSql: 'BBBBBB',
            sharingFlag: 'BBBBBB',
            category: 'BBBBBB',
            imgClass: 'BBBBBB',
            isInternal: 'BBBBBB',
            customFlag: 'BBBBBB',
            portal: 'BBBBBB',
            description: 'BBBBBB',
            businessUnit: 'BBBBBB',
            businessOwners: 'BBBBBB',
            businessOwnersMobile: 'BBBBBB',
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

      it('should delete a FmpMicroAppMp', () => {
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
