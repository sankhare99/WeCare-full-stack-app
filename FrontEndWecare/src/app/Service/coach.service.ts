import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class CoachService {

  constructor( private http: HttpClient) { }
  coachSignup(coachDTO:any):Observable<any>{
    return this.http.post<any>(`${environment.wecare}/coachs/save`, coachDTO);

}
coachLogin(loginDTO:any):Observable<any>{
  return this.http.post<any>(`${environment.wecare}/coachs/login`,loginDTO);
}
getAppointmentsByCoach(coachId:any):Observable<any>{
  return this.http.get<any>(`${environment.wecare}/coachs/booking/${coachId}`);
}
fetchProfile(coachId:any):Observable<any>{
  return this.http.get<any>(`${environment.wecare}/coachs/profile/${coachId}`);
}
}
