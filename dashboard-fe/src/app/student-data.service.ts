import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';


@Injectable({
  providedIn: 'root'
})
export class StudentDataService {

  private baseUrl = 'http://localhost:8080';

  constructor(private httpClient:HttpClient) { }

  public getStudentData():Observable<Student[]>{
    return this.httpClient.get<Student[]>(this.baseUrl + '/students');
  }
}


export class Student{
  name:string = '';
  m1:number = 0;
  m2:number = 0;
  m3:number = 0;
  m4:number = 0;
  m5:number = 0;
}
