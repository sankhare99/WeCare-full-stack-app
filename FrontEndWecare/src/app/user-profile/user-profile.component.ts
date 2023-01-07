import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { UserService } from '../Service/user.service';


@Component({
  selector: 'app-user-profile',
  templateUrl: './user-profile.component.html',
  styleUrls: ['./user-profile.component.css'],
  providers:[]
})
export class UserProfileComponent implements OnInit {
  profile!:any;
  errorMessage:string='';
  constructor(private router:Router,private UserService:UserService) { }

  ngOnInit(): void {
    let iduser = sessionStorage.getItem('userId');
    console.log(iduser)
    if(!sessionStorage.getItem('userId'))
    {
      this.router.navigate(['/userLogin'],{replaceUrl:true});
    }
    this.UserService.fetchProfile(iduser).subscribe(
      message => {
        console.log(message);

        this.profile=message;
    },
    error => this.errorMessage = <any>error);
  }
  userLogout(){
    sessionStorage.clear();
    this.router.navigate(['/home'],{replaceUrl:true});
  }

}
