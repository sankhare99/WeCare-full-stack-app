import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { UserService } from '../Service/user.service';

@Component({
  selector: 'app-user-login',
  templateUrl: './user-login.component.html',
  styleUrls: ['./user-login.component.css'],
  providers:[]
})
export class UserLoginComponent implements OnInit {
  userLoginForm!: FormGroup;
  submitted:Boolean=false;
  loginSuccess:Boolean=false;
  message!: string;
  errorMessage!:string;
  constructor(private formBuilder: FormBuilder,private router:Router,private UserService:UserService) { }

  ngOnInit(): void {
    this.userLoginForm= this.formBuilder.group({
      id: ['', {updateOn: 'blur',validators:[Validators.required]}],
      password: ['', {updateOn: 'blur',validators:[Validators.required,Validators.minLength(5),Validators.maxLength(10)]}],
    });
  }
  userLogin(){
    //if(!this.userLoginForm.invalid){
      this.submitted=true;
      this.UserService.userLogin(this.userLoginForm.value).subscribe(
        message => {
          this.message=message;
          if(message==true){
          sessionStorage.setItem('userId',this.userLoginForm.value.id);
          console.log(this.userLoginForm.value)
          this.router.navigate(['/userHome'],{replaceUrl:true});

        }else{
          "Invalid Coach Id or Password"
        }
      },
      error => this.errorMessage = <any>error);
      console.log(this.errorMessage);
    }
    }



//}
