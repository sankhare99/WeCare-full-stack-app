import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { UserService } from '../Service/user.service';


@Component({
  selector: 'app-user-signup',
  templateUrl: './user-signup.component.html',
  styleUrls: ['./user-signup.component.css'],
  providers:[UserService]
})
export class UserSignupComponent implements OnInit {
  userSignupForm!: FormGroup;
  UserId:any;
  message:string='';
  errorMessage:string="";
  constructor(private formBuilder: FormBuilder,private router:Router,private UserService:UserService) { }

  ngOnInit(): void {
    this.userSignupForm= this.formBuilder.group({
      name: ['', {updateOn: 'blur',validators:[Validators.required,Validators.minLength(3),Validators.maxLength(50)]}],
      password: ['', {updateOn: 'blur',validators:[Validators.required,Validators.minLength(5),Validators.maxLength(10)]}],
      mobileNumber: ['', {updateOn: 'blur',validators:[Validators.required,Validators.minLength(10),Validators.maxLength(10),Validators.pattern('[123456789][0-9]{9}')]}],
      email: ['', {updateOn: 'blur',validators:[Validators.required,Validators.pattern("^[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,4}$")]}],
      dateOfBirth: ['', {updateOn: 'blur',validators:[Validators.required,this.dobValid]}],
      gender: ['', {updateOn: 'blur',validators:[Validators.required]}],
      pincode: ['', {updateOn: 'blur',validators:[Validators.required,Validators.minLength(6),Validators.maxLength(6)]}],
      city: ['', {updateOn: 'blur',validators:[Validators.required,Validators.minLength(6),Validators.maxLength(20)]}],
      state: ['', {updateOn: 'blur',validators:[Validators.required,Validators.minLength(6),Validators.maxLength(20)]}],
      country: ['', {updateOn: 'blur',validators:[Validators.required,Validators.minLength(6),Validators.maxLength(20)]}],
    });
  }
    dobValid(c: FormControl) {
      const temp = new Date(c.value).getFullYear()
      const today = new Date().getFullYear()
      const Age = today - temp
      if (Age > 20 && Age < 100) {
         return null
      }
      else{
         return {
           dobInvalid:{
             message:'Invalid Dob',
           }
         }
      }
    }
    submitted= false;
    userSignup(){
      this.submitted = true;
        this.UserService.userSignup(this.userSignupForm.value).subscribe(
          res => {
            alert("SignUp Successfully...");
           this.userSignupForm.reset();
        },
        error => this.UserId =error.error.text);
        console.log(this.UserId);
      }
      
    }





