import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { CoachService } from '../Service/coach.service';

@Component({
  selector: 'app-coach-signup',
  templateUrl: './coach-signup.component.html',
  styleUrls: ['./coach-signup.component.css']
})
export class CoachSignupComponent implements OnInit {

  coachSignupForm!: FormGroup;
  signupSuccess:Boolean=false;
  coachId:String='';
  CoachId:any;
  //formDisplay:Boolean=true;
  errorMessage:string='';
  constructor(private formBuilder: FormBuilder,private router:Router,private CoachService:CoachService) { }

  ngOnInit(): void {
    this.coachSignupForm= this.formBuilder.group({
      name: ['', {updateOn: 'blur',validators:[Validators.required,Validators.minLength(3),Validators.maxLength(50)]}],
      password: ['', {updateOn: 'blur',validators:[Validators.required,Validators.minLength(5),Validators.maxLength(10)]}],
      mobileNumber: ['', {updateOn: 'blur',validators:[Validators.required,Validators.minLength(10),Validators.maxLength(10),Validators.pattern('[123456789][0-9]{9}')]}],
      dateOfBirth: ['', {updateOn: 'blur',validators:[Validators.required,this.dobValid]}],
      gender: ['', {updateOn: 'blur',validators:[Validators.required]}],
      speciality: ['', {updateOn: 'blur',validators:[Validators.required,Validators.minLength(10),Validators.maxLength(50)]}],
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
    submitted =false;
    coachSignup(){
      //if(!this.coachSignupForm.invalid)
      //{
        this.submitted = true;
        this.CoachService.coachSignup(this.coachSignupForm.value).subscribe(
          id => {
            this.CoachId=id.message;
            this.coachSignupForm.reset();
            //this.signupSuccess=true;

        },
        error => this.CoachId = error.error.text);
        console.log(this.CoachId);
      }
    }




