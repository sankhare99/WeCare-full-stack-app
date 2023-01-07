import { HttpClient, HttpErrorResponse, HttpParams, HttpResponse } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
//import { catchError } from 'rxjs/internal/operators/catchError';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class BookingService {
  cachedUserId:any=sessionStorage.getItem('userId');
  cachedCoachId:any=sessionStorage.getItem('bookCoachId') ;
  cachedBookingId:any=sessionStorage.getItem('rescheduleBookingId');

  constructor(private http:HttpClient) { }

  rescheduleAppointment(BookingDTO:any):Observable<any>{
    let param = new HttpParams();
    param = param.set('slot',BookingDTO.slot);
    param = param.set('appointmentDate',BookingDTO.appointmentDate);
    return this.http.put<any>(`${environment.wecare}/book/reschedule/${this.cachedBookingId}`,param,{responseType:'json'} );//.pipe(
      //catchError(this.handleError));
}

makeAppointment(BookingDTO:any):Observable<any>{
  let param = new HttpParams();
    param = param.set('slot',BookingDTO.slot);
    param = param.set('appointmentDate',BookingDTO.appointmentDate);
  return this.http.post<any>(`${environment.wecare}/book/BookingId/`+this.cachedUserId+'/'+this.cachedCoachId,param,{responseType:'json'});//.pipe(
    //catchError(this.handleError));

}
//private handleError(err: HttpErrorResponse) {
  //console.log(err);
 // return Observable.throw(err.error() || 'Server error');
//}
}
