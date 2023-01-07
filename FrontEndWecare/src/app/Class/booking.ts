import { Data } from "@angular/router";

export class BookingDTO {
   bookingId:Number;
	 userId:String;
	 coachId:String;
	 slot:String;
	 appointmentDate:Date;
   constructor(bookingId:Number,userId:String,coachId:String,appointmentDate:Date){

    this.bookingId = bookingId;
    this.userId = userId;
    this.coachId = coachId;
    this.appointmentDate = appointmentDate
   }
}
