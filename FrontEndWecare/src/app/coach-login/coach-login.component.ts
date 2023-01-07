import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup,Validators,FormControl } from '@angular/forms';
import { Router } from '@angular/router';
import { CoachService } from '../Service/coach.service';

@Component({
  selector: 'app-coach-login',
  templateUrl: './coach-login.component.html',
  styleUrls: ['./coach-login.component.css'],
  providers:[],
})
export class CoachLoginComponent implements OnInit {
  coachLoginForm!: FormGroup;
  submitted:Boolean=false;
  loginSuccess:Boolean=false;
  message:string='';
  errorMessage:string="";
  constructor(private formBuilder: FormBuilder,private router:Router,private CoachService:CoachService) { }

  ngOnInit(): void {
    this.coachLoginForm= this.formBuilder.group({
      id: ['', {updateOn: 'blur',validators:[Validators.required]}],
      password: ['', {updateOn: 'blur',validators:[Validators.required,Validators.minLength(5),Validators.maxLength(10)]}],

    });
  }
  coachLogin(){
    console.log("dans coach login")
    console.log("login cs", this.coachLoginForm.value)
      this.CoachService.coachLogin(this.coachLoginForm.value).subscribe(
        message => {
           this.message=message;
           console.log(this.message);
           if(message==true){
          sessionStorage.setItem('coachId',this.coachLoginForm.value.id);
          this.router.navigate(['/coachHome'],{replaceUrl:true});
          this.coachLoginForm.reset();
          console.log(this.coachLoginForm.value.id)
        }else{
          "Invalid Coach Id or Password"
        }
     },
      error => this.errorMessage = <any>error);
      console.log(this.errorMessage);
    }
    }



//}
