import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { CoachService } from '../Service/coach.service';


@Component({
  selector: 'app-coach-home',
  templateUrl: './coach-home.component.html',
  styleUrls: ['./coach-home.component.css']
})
export class CoachHomeComponent implements OnInit {
  schedules: any[] = [];
  errorMessage:string='';
  errorFetch: boolean=false;
  constructor(private router:Router,private CoachService:CoachService ) { }

  ngOnInit(): void {
    let idcoach = sessionStorage.getItem('coachId');
    if(!sessionStorage.getItem('coachId'))
    {
      this.router.navigate(['/coachLogin'],{replaceUrl:true});
    }
    this.CoachService.getAppointmentsByCoach(idcoach).subscribe(
      message =>{
        this.schedules=message;
      },
      error=>{
        this.errorFetch=true;
        this.errorMessage = <any>error;
      }
    );

  }
  coachLogout(){
    sessionStorage.removeItem('CoachId');
    this.router.navigate(['/home'],{replaceUrl:true});
  }


}
