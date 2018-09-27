import { Injectable } from '@angular/core';
import { Http } from '@angular/http';
import { ToastrService } from 'ngx-toastr';

@Injectable()
export class EmployeeService {

  constructor(
    private http: Http,
    private toastr: ToastrService
  ) { }

  getEmployee(employeeId): Promise<any> {
    return this.http.get(`/employees`, { params: { employeeId: employeeId } })
      .toPromise()
      .then((r) => {
        return r.json();
      })
      .catch((error) => {
        if (error.status === 404) {
          this.toastr.warning(`There is no employees with id: ${employeeId}`);
        } else {
          this.toastr.warning('The service for employees is down, please try later');
        }
      });
  }

}
