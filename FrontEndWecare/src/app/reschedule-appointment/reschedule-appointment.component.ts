
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';

import { Location } from '@angular/common'
import { BookingService } from '../Service/booking.service';
import { UserService } from '../Service/user.service';

@Component({
  selector: 'app-reschedule-appointment',
  templateUrl: './reschedule-appointment.component.html',
  styleUrls: ['./reschedule-appointment.component.css'],
  providers:[UserService]
})
export class RescheduleAppointmentComponent implements OnInit {

  rescheduleAppointmentForm!:FormGroup;

  errorMessage:string='';
  constructor(private formBuilder: FormBuilder,private router:Router,
    private location:Location,private BookingService:BookingService) { }

  ngOnInit(): void {

    this.rescheduleAppointmentForm= this.formBuilder.group({
      appointmentDate: ['', {updateOn: 'blur',validators:[Validators.required,this.within7days]}],
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
      rescheduleAppointment(){
        this.submitted=true;

          this.BookingService.rescheduleAppointment(this.rescheduleAppointmentForm.value).subscribe(
            message=>{
              //this.rescheduleSuccess=true;
              console.log(message);
              this.rescheduleAppointmentForm.reset();
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

