export class CoachDTO {
     coachId:String;
		 password:String;
		 name:String;
		 dateOfBirth:Date;
		 gender:String;
     mobileNumber:Number;
		 speciality:String;

     constructor(coachId:String,password:String,name:String, dateOfBirth:Date,gender:String,
      mobileNumber:Number,speciality:String){
        this.coachId = coachId;
        this.password = password;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.mobileNumber = mobileNumber;
        this.speciality = speciality;

     }
	}

