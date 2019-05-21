function validateForm(){
	var title= document.forms["student-data"]["title"].value;
	var fname= document.forms["student-data"]["fname"].value;
	var lname= document.forms["student-data"]["lname"].value;
	var sub1= parseFloat(document.forms["student-data"]["mark1"].value);
	var sub2= parseFloat(document.forms["student-data"]["mark2"].value);
	var sub3= parseFloat(document.forms["student-data"]["mark3"].value);
	
	var total = parseFloat(sub1 + sub2 + sub3);
	var average = parseFloat(total/3);
	
	document.getElementById("total").value = total;
	document.getElementById("average").value = average;
	
	var validName = new RegExp("^[a-zA-Z\s]+$");
	if (title=="Title"){
		alert("Please select a correct title!");
	}else if(fname==""){
		alert("First name can not be empty!");
	}else if(lname==""){
		alert("Last name can not be empty!");
	}else if(!fname.match(validName)){
		alert("Please enter a correct first name!");
	}else if(!lname.match(validName)){
		alert("Please enter a correct last name!");
	}else if(sub1<0 || sub1 >100){
		alert("Mark1 should be between 1 and 100!");
	}else if(sub2<0 || sub1 >100){
		alert("Mark2 should be between 1 and 100!!");
	}else if(sub3<0 || sub1 >100){
		alert("Mark3 should be between 1 and 100!!");
	}else{
		alert("Form submitted successfully!!!\nStudent Name :"+title+" "+fname+" "+lname+"\nTotal Mark :"+total+"\nAverage Mark :" + average);	
	}
	
}