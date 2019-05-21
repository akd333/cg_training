function validateForm(){
	var title= document.forms["emp-data"]["title"].value;
	var fname= document.forms["emp-data"]["fname"].value;
	var lname= document.forms["emp-data"]["lname"].value;
	var sal= document.forms["emp-data"]["sal"].value;
	var addr= document.forms["emp-data"]["address"].value;
	
	var tax = (sal*0.15);
	
	var validName = new RegExp("^[a-zA-Z\s]+$");
	if (title=="Select Title"){
		alert("Please select a correct title!");
	}else if(fname==""){
		alert("First name can not be empty!");
	}else if(lname==""){
		alert("Last name can not be empty!");
	}else if(sal==""){
		alert("Gross salary can not be empty!");
	}else if(addr==""){
		alert("Address can't be empty!");
	}else if(!fname.match(validName)){
		alert("Please enter a correct first name!");
	}else if(!lname.match(validName)){
		alert("Please enter a correct last name!");
	}else if(sal<0){
		alert("Gross salary can't be negative!");
	}else{
		alert("All data for "+fname+" "+lname+ " "+"entered successfully\n"+"The income tax paid is Rs."+" "+tax);	
	}
	
}