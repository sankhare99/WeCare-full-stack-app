export class UserDTO {
  userId:String;
	name:String;
	password:String;
	gender:String;
	dateOfBirth:Date;
	mobileNumber:Number;
	email:String;
	pincode:Number;
	city:String;
	state:String;
	country:String;

  constructor(userId:String,name:String,password:String,gender:String,dateOfBirth:Date,mobileNumber:Number,
    email:String,pincode:Number,city:String,state:String,country:String ){
  this.userId = userId;
  this.name = name;
  this.password = password;
  this.gender = gender;
  this.dateOfBirth = dateOfBirth;
  this.mobileNumber = mobileNumber;
  this.email= email;
  this.pincode = pincode;
  this.city = city;
  this.state = state;
  this.country = country;
  }
}
