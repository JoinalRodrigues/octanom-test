import { Component, OnInit } from '@angular/core';
import { ChartConfiguration, ChartData, ChartDataset, ChartType } from 'chart.js';
import { StudentDataService } from '../student-data.service';

@Component({
  selector: 'app-radar-chart',
  templateUrl: './radar-chart.component.html',
  styleUrls: ['./radar-chart.component.css']
})
export class RadarChartComponent implements OnInit{
  public radarChartLabels: string[] = [ 'm1', 'm2', 'm3', 'm4', 'm5' ];

  public studentChartData:ChartDataset<"radar", (number|null)[]>[] = [];

  public radarChartData: ChartData<'radar'> = {datasets:[]};
  public radarChartType: ChartType = 'radar';

  hide:boolean = false;

  public radarChartOptions: ChartConfiguration['options'] = {
    responsive: true,
    
  };

  constructor(private studentDataService:StudentDataService){
    this.getData();
   }

  ngOnInit(): void {
    
    setInterval(() => this.getData(), 10000);
  }

  getData(){
    this.studentDataService.getStudentData().subscribe(res => {
      this.radarChartData = {datasets:[]};
      this.studentChartData = res.map<ChartDataset<"radar", (number|null)[]>>(i => 
        {
          return {data:[i.m1, i.m2, i.m3, i.m4, i.m5], label:i.name}
        });
        this.radarChartData = {
          labels: this.radarChartLabels,
         datasets:this.studentChartData
        };
    });
  }

}
