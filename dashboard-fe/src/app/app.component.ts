import { Component, OnInit } from '@angular/core';
import { ChartConfiguration, ChartData, ChartDataset, ChartType } from 'chart.js';
import { StudentDataService, Student } from './student-data.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent{
  title = 'dashboard-fe';
  constructor(){

  }

}
