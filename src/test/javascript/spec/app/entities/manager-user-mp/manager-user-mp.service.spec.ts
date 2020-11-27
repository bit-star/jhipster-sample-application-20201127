import { TestBed, getTestBed } from '@angular/core/testing';
import { HttpClientTestingModule, HttpTestingController } from '@angular/common/http/testing';
import { ManagerUserMpService } from 'app/entities/manager-user-mp/manager-user-mp.service';
import { IManagerUserMp, ManagerUserMp } from 'app/shared/model/manager-user-mp.model';
import { ManagerUserType } from 'app/shared/model/enumerations/manager-user-type.model';

describe('Service Tests', () => {
  describe('ManagerUserMp Service', () => {
    let injector: TestBed;
    let service: ManagerUserMpService;
    let httpMock: HttpTestingController;
    let elemDefault: IManagerUserMp;
    let expectedResult: IManagerUserMp | IManagerUserMp[] | boolean | null;

    beforeEach(() => {
      TestBed.configureTestingModule({
        imports: [HttpClientTestingModule],
      });
      expectedResult = null;
      injector = getTestBed();
      service = injector.get(ManagerUserMpService);
      httpMock = injector.get(HttpTestingController);

      elemDefault = new ManagerUserMp(0, 0, ManagerUserType.SuperAdministrator);
    });

    describe('Service methods', () => {
      it('should find an element', () => {
        const returnedFromService = Object.assign({}, elemDefault);

        service.find(123).subscribe(resp => (expectedResult = resp.body));

        const req = httpMock.expectOne({ method: 'GET' });
        req.flush(returnedFromService);
        expect(expectedResult).toMatchObject(elemDefault);
      });

      it('should create a ManagerUserMp', () => {
        const returnedFromService = Object.assign(
          {
            id: 0,
          },
          elemDefault
        );

        const expected = Object.assign({}, returnedFromService);

        service.create(new ManagerUserMp()).subscribe(resp => (expectedResult = resp.body));

        const req = httpMock.expectOne({ method: 'POST' });
        req.flush(returnedFromService);
        expect(expectedResult).toMatchObject(expected);
      });

      it('should update a ManagerUserMp', () => {
        const returnedFromService = Object.assign(
          {
            parentId: 1,
            type: 'BBBBBB',
          },
          elemDefault
        );

        const expected = Object.assign({}, returnedFromService);

        service.update(expected).subscribe(resp => (expectedResult = resp.body));

        const req = httpMock.expectOne({ method: 'PUT' });
        req.flush(returnedFromService);
        expect(expectedResult).toMatchObject(expected);
      });

      it('should return a list of ManagerUserMp', () => {
        const returnedFromService = Object.assign(
          {
            parentId: 1,
            type: 'BBBBBB',
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

      it('should delete a ManagerUserMp', () => {
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
