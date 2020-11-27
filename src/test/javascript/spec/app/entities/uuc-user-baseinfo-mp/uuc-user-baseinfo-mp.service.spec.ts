import { TestBed, getTestBed } from '@angular/core/testing';
import { HttpClientTestingModule, HttpTestingController } from '@angular/common/http/testing';
import * as moment from 'moment';
import { DATE_TIME_FORMAT } from 'app/shared/constants/input.constants';
import { UucUserBaseinfoMpService } from 'app/entities/uuc-user-baseinfo-mp/uuc-user-baseinfo-mp.service';
import { IUucUserBaseinfoMp, UucUserBaseinfoMp } from 'app/shared/model/uuc-user-baseinfo-mp.model';

describe('Service Tests', () => {
  describe('UucUserBaseinfoMp Service', () => {
    let injector: TestBed;
    let service: UucUserBaseinfoMpService;
    let httpMock: HttpTestingController;
    let elemDefault: IUucUserBaseinfoMp;
    let expectedResult: IUucUserBaseinfoMp | IUucUserBaseinfoMp[] | boolean | null;
    let currentDate: moment.Moment;

    beforeEach(() => {
      TestBed.configureTestingModule({
        imports: [HttpClientTestingModule],
      });
      expectedResult = null;
      injector = getTestBed();
      service = injector.get(UucUserBaseinfoMpService);
      httpMock = injector.get(HttpTestingController);
      currentDate = moment();

      elemDefault = new UucUserBaseinfoMp(
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
        0,
        'AAAAAAA',
        'AAAAAAA',
        currentDate,
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        currentDate,
        'AAAAAAA',
        currentDate,
        'AAAAAAA',
        'AAAAAAA',
        currentDate,
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
        const returnedFromService = Object.assign(
          {
            hiredate: currentDate.format(DATE_TIME_FORMAT),
            recCreateTime: currentDate.format(DATE_TIME_FORMAT),
            recReviseTime: currentDate.format(DATE_TIME_FORMAT),
            activationTime: currentDate.format(DATE_TIME_FORMAT),
          },
          elemDefault
        );

        service.find(123).subscribe(resp => (expectedResult = resp.body));

        const req = httpMock.expectOne({ method: 'GET' });
        req.flush(returnedFromService);
        expect(expectedResult).toMatchObject(elemDefault);
      });

      it('should create a UucUserBaseinfoMp', () => {
        const returnedFromService = Object.assign(
          {
            id: 0,
            hiredate: currentDate.format(DATE_TIME_FORMAT),
            recCreateTime: currentDate.format(DATE_TIME_FORMAT),
            recReviseTime: currentDate.format(DATE_TIME_FORMAT),
            activationTime: currentDate.format(DATE_TIME_FORMAT),
          },
          elemDefault
        );

        const expected = Object.assign(
          {
            hiredate: currentDate,
            recCreateTime: currentDate,
            recReviseTime: currentDate,
            activationTime: currentDate,
          },
          returnedFromService
        );

        service.create(new UucUserBaseinfoMp()).subscribe(resp => (expectedResult = resp.body));

        const req = httpMock.expectOne({ method: 'POST' });
        req.flush(returnedFromService);
        expect(expectedResult).toMatchObject(expected);
      });

      it('should update a UucUserBaseinfoMp', () => {
        const returnedFromService = Object.assign(
          {
            jobCode: 'BBBBBB',
            type: 'BBBBBB',
            fullname: 'BBBBBB',
            namePy: 'BBBBBB',
            sex: 'BBBBBB',
            birthday: 'BBBBBB',
            email: 'BBBBBB',
            tel: 'BBBBBB',
            telExt: 'BBBBBB',
            stateCode1: 'BBBBBB',
            mobile1: 'BBBBBB',
            stateCode2: 'BBBBBB',
            mobile2: 'BBBBBB',
            stateCode3: 'BBBBBB',
            mobile3: 'BBBBBB',
            stateCode4: 'BBBBBB',
            mobile4: 'BBBBBB',
            stateCode5: 'BBBBBB',
            mobile5: 'BBBBBB',
            titleDesc: 'BBBBBB',
            titleEn: 'BBBBBB',
            checkNum: 'BBBBBB',
            disporder: 1,
            workPlace: 'BBBBBB',
            userLevel: 'BBBBBB',
            hiredate: currentDate.format(DATE_TIME_FORMAT),
            nickname: 'BBBBBB',
            memo: 'BBBBBB',
            isHidden: 'BBBBBB',
            aliveFlag: 'BBBBBB',
            recCreateTime: currentDate.format(DATE_TIME_FORMAT),
            recCreator: 'BBBBBB',
            recReviseTime: currentDate.format(DATE_TIME_FORMAT),
            recRevisor: 'BBBBBB',
            isActivated: 'BBBBBB',
            activationTime: currentDate.format(DATE_TIME_FORMAT),
            appVersion: 'BBBBBB',
            isOnlyAdminTitle: 'BBBBBB',
            jobnumber: 'BBBBBB',
            avatar: 'BBBBBB',
            enName: 'BBBBBB',
            enWorkplace: 'BBBBBB',
            enTitleDesc: 'BBBBBB',
            onlyCode: 'BBBBBB',
            hrCardId: 'BBBBBB',
            employeeType: 'BBBBBB',
          },
          elemDefault
        );

        const expected = Object.assign(
          {
            hiredate: currentDate,
            recCreateTime: currentDate,
            recReviseTime: currentDate,
            activationTime: currentDate,
          },
          returnedFromService
        );

        service.update(expected).subscribe(resp => (expectedResult = resp.body));

        const req = httpMock.expectOne({ method: 'PUT' });
        req.flush(returnedFromService);
        expect(expectedResult).toMatchObject(expected);
      });

      it('should return a list of UucUserBaseinfoMp', () => {
        const returnedFromService = Object.assign(
          {
            jobCode: 'BBBBBB',
            type: 'BBBBBB',
            fullname: 'BBBBBB',
            namePy: 'BBBBBB',
            sex: 'BBBBBB',
            birthday: 'BBBBBB',
            email: 'BBBBBB',
            tel: 'BBBBBB',
            telExt: 'BBBBBB',
            stateCode1: 'BBBBBB',
            mobile1: 'BBBBBB',
            stateCode2: 'BBBBBB',
            mobile2: 'BBBBBB',
            stateCode3: 'BBBBBB',
            mobile3: 'BBBBBB',
            stateCode4: 'BBBBBB',
            mobile4: 'BBBBBB',
            stateCode5: 'BBBBBB',
            mobile5: 'BBBBBB',
            titleDesc: 'BBBBBB',
            titleEn: 'BBBBBB',
            checkNum: 'BBBBBB',
            disporder: 1,
            workPlace: 'BBBBBB',
            userLevel: 'BBBBBB',
            hiredate: currentDate.format(DATE_TIME_FORMAT),
            nickname: 'BBBBBB',
            memo: 'BBBBBB',
            isHidden: 'BBBBBB',
            aliveFlag: 'BBBBBB',
            recCreateTime: currentDate.format(DATE_TIME_FORMAT),
            recCreator: 'BBBBBB',
            recReviseTime: currentDate.format(DATE_TIME_FORMAT),
            recRevisor: 'BBBBBB',
            isActivated: 'BBBBBB',
            activationTime: currentDate.format(DATE_TIME_FORMAT),
            appVersion: 'BBBBBB',
            isOnlyAdminTitle: 'BBBBBB',
            jobnumber: 'BBBBBB',
            avatar: 'BBBBBB',
            enName: 'BBBBBB',
            enWorkplace: 'BBBBBB',
            enTitleDesc: 'BBBBBB',
            onlyCode: 'BBBBBB',
            hrCardId: 'BBBBBB',
            employeeType: 'BBBBBB',
          },
          elemDefault
        );

        const expected = Object.assign(
          {
            hiredate: currentDate,
            recCreateTime: currentDate,
            recReviseTime: currentDate,
            activationTime: currentDate,
          },
          returnedFromService
        );

        service.query().subscribe(resp => (expectedResult = resp.body));

        const req = httpMock.expectOne({ method: 'GET' });
        req.flush([returnedFromService]);
        httpMock.verify();
        expect(expectedResult).toContainEqual(expected);
      });

      it('should delete a UucUserBaseinfoMp', () => {
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
