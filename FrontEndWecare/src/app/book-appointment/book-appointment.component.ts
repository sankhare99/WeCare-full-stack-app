import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { Location } from '@angular/common'
import { BookingService } from '../Service/booking.service';
import { UserService } from '../Service/user.service';

@Component({
  selector: 'app-book-appointment',
  templateUrl: './book-appointment.component.html',
  styleUrls: ['./book-appointment.component.css'],
  providers:[UserService]
})
export class BookAppointmentComponent implements OnInit {
  bookAppointmentForm!:FormGroup;
  errorMessage:string='';
  //userId:any;
  //coachId:any;
  constructor(private formBuilder: FormBuilder,private router:Router,
    private  location:Location ,private bookingService:BookingService,private activatedRoute:ActivatedRoute) { }

  ngOnInit(): void {
   //this.userId = this.activatedRoute.snapshot.paramMap.get('userId');
   //this.coachId = this.activatedRoute.snapshot.paramMap.get('coachId');


    this.bookAppointmentForm= this.formBuilder.group({
      appointmentDate: ['', {updateOn: 'blur',validators:[Validators.required ,this.within7days]}],
      slot: ['', {updateOn: 'blur',validators:[Validators.required]}]
    });
  }
  within7days(c:FormControl){
    const msDay = 86400000;
    let temp:any= new Date(c.value);
    let today:any = new Date();
    const diff:number = (temp - today );
    if (diff < (7 * msDay) && diff >= 0) {
       return null;
    } else {
        return{
          invalidDate:{
            message:'Invalid date'
          }
        }
    }
}
submitted= false;
bookAppointment(){
  this.submitted=true;
  this.bookingService.makeAppointment(this.bookAppointmentForm.value).subscribe(
      message =>{
     console.log(this.bookAppointmentForm.value)
     this.bookAppointmentForm.reset();
      },
      error=>{
        this.errorMessage = <any>error;
      }
  );
}
goBack(){
  this.location.back();
  }
  userLogout(){
  sessionStorage.clear();
  this.router.navigate(['/home'],{replaceUrl:true});
  }

}
