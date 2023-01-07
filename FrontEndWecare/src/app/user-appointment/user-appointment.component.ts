import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { BookingService } from '../Service/booking.service';
import { UserService } from '../Service/user.service';



@Component({
  selector: 'app-user-appointment',
  templateUrl: './user-appointment.component.html',
  styleUrls: ['./user-appointment.component.css'],
  providers:[BookingService]
})
export class UserAppointmentComponent implements OnInit {
  appointments:any[]=[];
  errorMessage: any;
  errorMessageFetch: any;
  constructor(private router:Router,private UserService:UserService) { }

  ngOnInit(): void {

    this.UserService.fetchApppointmentsUser().subscribe(
      message=>{
        const arr:any[]=message;
        this.appointments=arr;
       console.log(this.appointments);



      },
      error=>{
        this.errorMessageFetch = <any>error;
      }
    )
  }
  rescheduleAppointment(bookingId:any){
    sessionStorage.setItem('rescheduleBookingId',bookingId);
    this.router.navigate(['/rescheduleAppointment'],{ skipLocationChange: true })
  }

  deleteAppointment(bookingId:any){
    const val=confirm('Are you Sure');
    console.warn(val);
    if(val){
      this.UserService.deleteAppointment(bookingId).subscribe(
          message=>{
            window.location.reload();
            console.log(message);
          },
          error=>{
            this.errorMessage = <any>error;
          }
      );
    }
  }
    userLogout(){
    sessionStorage.removeItem('userId');
    this.router.navigate(['/home'],{replaceUrl:true});

  }

}
