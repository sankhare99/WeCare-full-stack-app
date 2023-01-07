import { NgModule, Component } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { CoachLoginComponent } from './coach-login/coach-login.component';
import { CoachSignupComponent } from './coach-signup/coach-signup.component';
import { HomeComponent } from './home/home.component';
import { UserLoginComponent } from './user-login/user-login.component';
import { UserSignupComponent } from './user-signup/user-signup.component';
import { CoachHomeComponent } from './coach-home/coach-home.component';
import { UserHomeComponent } from './user-home/user-home.component';
import { CoachProfileComponent } from './coach-profile/coach-profile.component';
import { UserProfileComponent } from './user-profile/user-profile.component';
import { UserAppointmentComponent } from './user-appointment/user-appointment.component';
import { RescheduleAppointmentComponent } from './reschedule-appointment/reschedule-appointment.component';
import { BookAppointmentComponent } from './book-appointment/book-appointment.component';

const routes: Routes = [
{path: 'home',component:HomeComponent},
{path: '',redirectTo:'/home',pathMatch:'full'},
{path:'coachLogin',component:CoachLoginComponent},
{path:'coachSignup',component:CoachSignupComponent},
{path:'userLogin',component:UserLoginComponent},
{path:'userSignup',component:UserSignupComponent},
{path:'coachHome',component:CoachHomeComponent},
{path:'userHome',component:UserHomeComponent},
{path:'coachProfile',component:CoachProfileComponent},
{path:'userProfile',component:UserProfileComponent},
{path:'userAppointments',component:UserAppointmentComponent},
{path:'rescheduleAppointment',component:RescheduleAppointmentComponent},
{path:'bookAppointment',component:BookAppointmentComponent},
{path:'**',component:HomeComponent}

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
