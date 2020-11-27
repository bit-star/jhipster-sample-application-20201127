import { TestBed, getTestBed } from '@angular/core/testing';
import { HttpClientTestingModule, HttpTestingController } from '@angular/common/http/testing';
import * as moment from 'moment';
import { DATE_TIME_FORMAT } from 'app/shared/constants/input.constants';
import { UucDepartmentTreeMpService } from 'app/entities/uuc-department-tree-mp/uuc-department-tree-mp.service';
import { IUucDepartmentTreeMp, UucDepartmentTreeMp } from 'app/shared/model/uuc-department-tree-mp.model';

describe('Service Tests', () => {
  describe('UucDepartmentTreeMp Service', () => {
    let injector: TestBed;
    let service: UucDepartmentTreeMpService;
    let httpMock: HttpTestingController;
    let elemDefault: IUucDepartmentTreeMp;
    let expectedResult: IUucDepartmentTreeMp | IUucDepartmentTreeMp[] | boolean | null;
    let currentDate: moment.Moment;

    beforeEach(() => {
      TestBed.configureTestingModule({
        imports: [HttpClientTestingModule],
      });
      expectedResult = null;
      injector = getTestBed();
      service = injector.get(UucDepartmentTreeMpService);
      httpMock = injector.get(HttpTestingController);
      currentDate = moment();

      elemDefault = new UucDepartmentTreeMp(
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
        currentDate,
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
        'AAAAAAA'
      );
    });

    describe('Service methods', () => {
      it('should find an element', () => {
        const returnedFromService = Object.assign(
          {
            recCreateTime: currentDate.format(DATE_TIME_FORMAT),
            recReviseTime: currentDate.format(DATE_TIME_FORMAT),
          },
          elemDefault
        );

        service.find(123).subscribe(resp => (expectedResult = resp.body));

        const req = httpMock.expectOne({ method: 'GET' });
        req.flush(returnedFromService);
        expect(expectedResult).toMatchObject(elemDefault);
      });

      it('should create a UucDepartmentTreeMp', () => {
        const returnedFromService = Object.assign(
          {
            id: 0,
            recCreateTime: currentDate.format(DATE_TIME_FORMAT),
            recReviseTime: currentDate.format(DATE_TIME_FORMAT),
          },
          elemDefault
        );

        const expected = Object.assign(
          {
            recCreateTime: currentDate,
            recReviseTime: currentDate,
          },
          returnedFromService
        );

        service.create(new UucDepartmentTreeMp()).subscribe(resp => (expectedResult = resp.body));

        const req = httpMock.expectOne({ method: 'POST' });
        req.flush(returnedFromService);
        expect(expectedResult).toMatchObject(expected);
      });

      it('should update a UucDepartmentTreeMp', () => {
        const returnedFromService = Object.assign(
          {
            name: 'BBBBBB',
            namePy: 'BBBBBB',
            code: 'BBBBBB',
            parentDepId: 'BBBBBB',
            parentDepName: 'BBBBBB',
            status: 'BBBBBB',
            disporder: 'BBBBBB',
            namePath: 'BBBBBB',
            codePath: 'BBBBBB',
            depIdPath: 'BBBBBB',
            depLevel: 'BBBBBB',
            aliveFlag: 'BBBBBB',
            recCreateTime: currentDate.format(DATE_TIME_FORMAT),
            recCreator: 'BBBBBB',
            recReviseTime: currentDate.format(DATE_TIME_FORMAT),
            recRevisor: 'BBBBBB',
            deptUserCount: 'BBBBBB',
            microappId: 'BBBBBB',
            enName: 'BBBBBB',
            onlyCode: 'BBBBBB',
            srcDeptId: 'BBBBBB',
            srcDeptType: 'BBBBBB',
            srcType: 'BBBBBB',
            srcDeptUcode: 'BBBBBB',
          },
          elemDefault
        );

        const expected = Object.assign(
          {
            recCreateTime: currentDate,
            recReviseTime: currentDate,
          },
          returnedFromService
        );

        service.update(expected).subscribe(resp => (expectedResult = resp.body));

        const req = httpMock.expectOne({ method: 'PUT' });
        req.flush(returnedFromService);
        expect(expectedResult).toMatchObject(expected);
      });

      it('should return a list of UucDepartmentTreeMp', () => {
        const returnedFromService = Object.assign(
          {
            name: 'BBBBBB',
            namePy: 'BBBBBB',
            code: 'BBBBBB',
            parentDepId: 'BBBBBB',
            parentDepName: 'BBBBBB',
            status: 'BBBBBB',
            disporder: 'BBBBBB',
            namePath: 'BBBBBB',
            codePath: 'BBBBBB',
            depIdPath: 'BBBBBB',
            depLevel: 'BBBBBB',
            aliveFlag: 'BBBBBB',
            recCreateTime: currentDate.format(DATE_TIME_FORMAT),
            recCreator: 'BBBBBB',
            recReviseTime: currentDate.format(DATE_TIME_FORMAT),
            recRevisor: 'BBBBBB',
            deptUserCount: 'BBBBBB',
            microappId: 'BBBBBB',
            enName: 'BBBBBB',
            onlyCode: 'BBBBBB',
            srcDeptId: 'BBBBBB',
            srcDeptType: 'BBBBBB',
            srcType: 'BBBBBB',
            srcDeptUcode: 'BBBBBB',
          },
          elemDefault
        );

        const expected = Object.assign(
          {
            recCreateTime: currentDate,
            recReviseTime: currentDate,
          },
          returnedFromService
        );

        service.query().subscribe(resp => (expectedResult = resp.body));

        const req = httpMock.expectOne({ method: 'GET' });
        req.flush([returnedFromService]);
        httpMock.verify();
        expect(expectedResult).toContainEqual(expected);
      });

      it('should delete a UucDepartmentTreeMp', () => {
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
