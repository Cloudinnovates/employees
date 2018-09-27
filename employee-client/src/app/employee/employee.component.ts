import { Component, OnInit } from '@angular/core';
import { EmployeeService } from './employee.service';
import { Employee } from './employee.dto';

@Component({
  selector: 'app-employee',
  templateUrl: './employee.component.html',
  styleUrls: ['./employee.component.scss']
})
export class EmployeeComponent implements OnInit {

  employees: Employee[];
  employeeId: '';

  constructor(
    private employeeService: EmployeeService
  ) { }

  ngOnInit() {
  }

  searchEmployee(employeeId): void {
    this.employeeService.getEmployee(employeeId).then(response => {
      this.employees = response;
    });
  }

  clearSearch(): void {
    this.employees = undefined;
  }

  preventCharacter($event: KeyboardEvent): void {
    const e = $event.keyCode || $event.charCode;
        if (($event.shiftKey || (e < 48 || e > 57)) && (e < 96 || e > 105) && e !== 8) {
            $event.preventDefault();
        }
  }

}
