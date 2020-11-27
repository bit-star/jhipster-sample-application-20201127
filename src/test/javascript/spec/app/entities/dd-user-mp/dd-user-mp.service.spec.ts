import { TestBed, getTestBed } from '@angular/core/testing';
import { HttpClientTestingModule, HttpTestingController } from '@angular/common/http/testing';
import { DdUserMpService } from 'app/entities/dd-user-mp/dd-user-mp.service';
import { IDdUserMp, DdUserMp } from 'app/shared/model/dd-user-mp.model';

describe('Service Tests', () => {
  describe('DdUserMp Service', () => {
    let injector: TestBed;
    let service: DdUserMpService;
    let httpMock: HttpTestingController;
    let elemDefault: IDdUserMp;
    let expectedResult: IDdUserMp | IDdUserMp[] | boolean | null;

    beforeEach(() => {
      TestBed.configureTestingModule({
        imports: [HttpClientTestingModule],
      });
      expectedResult = null;
      injector = getTestBed();
      service = injector.get(DdUserMpService);
      httpMock = injector.get(HttpTestingController);

      elemDefault = new DdUserMp(
        0,
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        false,
        0,
        false,
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        false,
        'AAAAAAA',
        false,
        false,
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

      it('should create a DdUserMp', () => {
        const returnedFromService = Object.assign(
          {
            id: 0,
          },
          elemDefault
        );

        const expected = Object.assign({}, returnedFromService);

        service.create(new DdUserMp()).subscribe(resp => (expectedResult = resp.body));

        const req = httpMock.expectOne({ method: 'POST' });
        req.flush(returnedFromService);
        expect(expectedResult).toMatchObject(expected);
      });

      it('should update a DdUserMp', () => {
        const returnedFromService = Object.assign(
          {
            unionid: 'BBBBBB',
            remark: 'BBBBBB',
            userid: 'BBBBBB',
            isLeaderInDepts: 'BBBBBB',
            isBoss: true,
            hiredDate: 1,
            isSenior: true,
            tel: 'BBBBBB',
            department: 'BBBBBB',
            workPlace: 'BBBBBB',
            orderInDepts: 'BBBBBB',
            mobile: 'BBBBBB',
            errmsg: 'BBBBBB',
            active: true,
            avatar: 'BBBBBB',
            isAdmin: true,
            isHide: true,
            jobnumber: 'BBBBBB',
            name: 'BBBBBB',
            extattr: 'BBBBBB',
            stateCode: 'BBBBBB',
            position: 'BBBBBB',
            roles: 'BBBBBB',
          },
          elemDefault
        );

        const expected = Object.assign({}, returnedFromService);

        service.update(expected).subscribe(resp => (expectedResult = resp.body));

        const req = httpMock.expectOne({ method: 'PUT' });
        req.flush(returnedFromService);
        expect(expectedResult).toMatchObject(expected);
      });

      it('should return a list of DdUserMp', () => {
        const returnedFromService = Object.assign(
          {
            unionid: 'BBBBBB',
            remark: 'BBBBBB',
            userid: 'BBBBBB',
            isLeaderInDepts: 'BBBBBB',
            isBoss: true,
            hiredDate: 1,
            isSenior: true,
            tel: 'BBBBBB',
            department: 'BBBBBB',
            workPlace: 'BBBBBB',
            orderInDepts: 'BBBBBB',
            mobile: 'BBBBBB',
            errmsg: 'BBBBBB',
            active: true,
            avatar: 'BBBBBB',
            isAdmin: true,
            isHide: true,
            jobnumber: 'BBBBBB',
            name: 'BBBBBB',
            extattr: 'BBBBBB',
            stateCode: 'BBBBBB',
            position: 'BBBBBB',
            roles: 'BBBBBB',
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

      it('should delete a DdUserMp', () => {
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
