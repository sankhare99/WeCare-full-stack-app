import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { CoachService } from '../Service/coach.service';

@Component({
  selector: 'app-coach-profile',
  templateUrl: './coach-profile.component.html',
  styleUrls: ['./coach-profile.component.css']
})
export class CoachProfileComponent implements OnInit {
  profile!:any;
  errorMessage:string='';
  constructor(private router:Router,private CoachService:CoachService) { }

  ngOnInit(): void {
    let idcoach = sessionStorage.getItem('coachId');
    if(!sessionStorage.getItem('coachId'))
    {
      this.router.navigate(['/coachLogin'],{replaceUrl:true});
    }
    this.CoachService.fetchProfile(idcoach).subscribe(
      message => {
        const arr:any[]=message;
        this.profile=arr;
        console.log(arr)
    },
    error => this.errorMessage = <any>error);
  }
  coachLogout(){
    sessionStorage.removeItem('coachId');
    this.router.navigate(['/home'],{replaceUrl:true});
  }


}
