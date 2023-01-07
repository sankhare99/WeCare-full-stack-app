import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BookAppointmentComponent } from './book-appointment/book-appointment.component';
import { CoachHomeComponent } from './coach-home/coach-home.component';
import { CoachLoginComponent } from './coach-login/coach-login.component';
import { CoachProfileComponent } from './coach-profile/coach-profile.component';
import { CoachSignupComponent } from './coach-signup/coach-signup.component';
import { HomeComponent } from './home/home.component';
import { RescheduleAppointmentComponent } from './reschedule-appointment/reschedule-appointment.component';
import { UserAppointmentComponent } from './user-appointment/user-appointment.component';
import { UserHomeComponent } from './user-home/user-home.component';
import { UserLoginComponent } from './user-login/user-login.component';
import { UserProfileComponent } from './user-profile/user-profile.component';
import { UserSignupComponent } from './user-signup/user-signup.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { RouterModule } from '@angular/router';
import { HttpClientModule } from '@angular/common/http';

@NgModule({
  declarations: [
    AppComponent,
    BookAppointmentComponent,
    CoachHomeComponent,
    CoachLoginComponent,
    CoachProfileComponent,
    CoachSignupComponent,
    HomeComponent,
    RescheduleAppointmentComponent,
    UserAppointmentComponent,
    UserHomeComponent,
    UserLoginComponent,
    UserProfileComponent,
    UserSignupComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    RouterModule,
    ReactiveFormsModule,
    HttpClientModule,
   //NgModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
