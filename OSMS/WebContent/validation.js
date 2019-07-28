function login(){
	
	var id=document.getElementById("id").value;
	if(id==null || id==""){
		document.getElementById("id_err").innerHTML="Please enter an id";
		return false;
	}
	else
	{
		document.getElementById("id_err").innerHTML="";
	}

	var name=document.getElementById("name").value;
	if(name==null || name==""){
		document.getElementById("name_err").innerHTML="Please enter a password";
		return false;
	}	
	else
	{
		document.getElementById("name_err").innerHTML="";
	}

	return true;
}
function validateadd(){
	var name=document.getElementById("name").value;
	if(name==null || name==""){
		document.getElementById("name_err").innerHTML="Please enter product name";
		return false;
	}
	else
	{
		document.getElementById("name_err").innerHTML="";
	}

	if(!isNaN(name)){
		document.getElementById("name_err").innerHTML="Please enter valid name";
		return false;
	}
	else
	{
		document.getElementById("name_err").innerHTML="";
	}

	if(name.length<5 || name.length>15){
		document.getElementById("name_err").innerHTML="product name length should be in between 5 and 15 characters";
		return false;
	}
	else
	{
		document.getElementById("name_err").innerHTML="";
	}

	var description=document.getElementById("desc").value;
	if(description==null || description==""){
		document.getElementById("desc_err").innerHTML="Please enter Description";
		return false;
	}
	else
	{
		document.getElementById("desc_err").innerHTML="";
	}

	if(description.length<10 || description.length>50){
		document.getElementById("desc_err").innerHTML="product description length should be in between 10 and 50 characters";
		return false;
	}
	else
	{
		document.getElementById("desc_err").innerHTML="";
	}

	var price=document.getElementById("price").value;
	if(price==null || price==""){
		document.getElementById("price_err").innerHTML="Please enter price";
		return false;
	}
	else
	{
		document.getElementById("price_err").innerHTML="";
	}
	if(isNaN(price)){
		document.getElementById("price_err").innerHTML="Please enter valid value";
		return false;
	}
	else
	{
		document.getElementById("price_err").innerHTML="";
	}

	var qty=document.getElementById("qty").value;
	if(qty==null || qty==""){
		document.getElementById("qty_err").innerHTML="Please enter Quantity";
		return false;
	}
	if(isNaN(qty)){
		document.getElementById("qty_err").innerHTML="Please enter valid value";
		return false;
	}
	if(document.addform.status==null){
		document.getElementById("status_err").innerHTML="Please select a status";
		return false;
	}
	else
	{
		document.getElementById("status_err").innerHTML="";
	}
	
	return true;
}

function validateUpdate()
{
	var price=document.getElementById("price").value;
	if(price==null || price==""){
		document.getElementById("price_err").innerHTML="Please enter price";
		return false;
	}
	if(isNaN(price)){
		document.getElementById("price_err").innerHTML="Please enter valid value";
		return false;
	}
	var qty=document.getElementById("qty").value;
	if(qty==null || qty==""){
		document.getElementById("qty_err").innerHTML="Please enter Quantity";
		return false;
	}
	if(isNaN(qty)){
		document.getElementById("qty_err").innerHTML="Please enter valid value";
		return false;
	}
	if(document.addform.status==null){
		document.getElementById("status_err").innerHTML="Please select a status";
		return false;
	}
}
	
	