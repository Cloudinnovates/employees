import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpModule, Http, XHRBackend, RequestOptions } from '@angular/http';
import { ToastrModule } from 'ngx-toastr';
import { FormsModule } from '@angular/forms';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';

import { AppComponent } from './app.component';
import { EmployeeComponent } from './employee/employee.component';
import { EmployeeService } from './employee/employee.service';


@NgModule({
  declarations: [
    AppComponent,
    EmployeeComponent
  ],
  imports: [
    BrowserModule,
    HttpModule,
    ToastrModule.forRoot(),
    FormsModule,
    BrowserAnimationsModule
  ],
  providers: [EmployeeService],
  bootstrap: [AppComponent]
})
export class AppModule { }
