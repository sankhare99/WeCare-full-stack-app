import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  cachedUserId:any=sessionStorage.getItem('userId') || null;
   cachedBookingId:any=sessionStorage.getItem('bookingId');



  constructor(private http:HttpClient) { }
  userLogin(userDto:any):Observable<any>{
    return this.http.post<any>(`${environment.wecare}/users/login`, userDto);
}
userSignup(userDto:any):Observable<any>{
  return this.http.post<any>(`${environment.wecare}/users/save`,userDto);
}
fetchAllCoaches():Observable<any>{
  return this.http.get<any>(`${environment.wecare}/coachs/showAll`);
}
fetchProfile(userId:any):Observable<any>{
  return this.http.get<any>(`${environment.wecare}/users/user/${userId}`);
}
fetchApppointmentsUser():Observable<any>{
  return this.http.get<any>(`${environment.wecare}/users/booking/`+this.cachedUserId);
}
deleteAppointment(bookingId:any):Observable<any>{
  return this.http.delete<any>(`${environment.wecare}/book/delete/${bookingId}`);
}
}
