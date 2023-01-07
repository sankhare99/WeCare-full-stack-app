import { Component, OnInit } from '@angular/core';
import {  Router } from '@angular/router';
import { UserService } from '../Service/user.service';


@Component({
  selector: 'app-user-home',
  templateUrl: './user-home.component.html',
  styleUrls: ['./user-home.component.css'],
  providers: []
})
export class UserHomeComponent implements OnInit {
  coaches:any[]=[];
  errorMessage:string='';
  constructor( private router:Router,private userService:UserService) { }

  ngOnInit(): void {
    if(!sessionStorage.getItem('userId'))
    {
      this.router.navigate(['/userLogin'],{replaceUrl:true});
    }
    this.userService.fetchAllCoaches().subscribe(
      message => {
        this.coaches=message;
    },
    error => this.errorMessage = <any>error);
  }


  bookAppointment(coachId:any,){
    sessionStorage.setItem('bookCoachId',coachId);
    this.router.navigate(['/bookAppointment'],{ skipLocationChange: true })
  }
  userLogout(){
    sessionStorage.clear();
    this.router.navigate(['/home'],{replaceUrl:true});

  }


}
