<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
	<link href="http://code.jquery.com/ui/1.10.4/themes/ui-lightness/jquery-ui.css" rel="stylesheet"> 
	<script src="http://code.jquery.com/jquery-1.10.2.js"></script>
	<script src="http://code.jquery.com/ui/1.10.4/jquery-ui.js"></script>
	<!-- CSS -->
	<style>
	Table.GridOne 
		{
		 padding: 3px;
		 margin: 0;
		 background: lightyellow;
		 border-collapse: collapse; 
		 width:35%;
		}
	Table.GridOne Td 
		{ 
		 padding:2px;
		 border: 1px solid #ff9900;
		 border-collapse: collapse;
		} 
	</style>
	<script type="text/javascript">
	
	jQuery(document).ready(function() {
		//$('#insertBut').hide();
		//$('#updateBut').hide();
		
		//showAll();
		
	    jQuery("#confirmationDialog").dialog({
	        autoOpen: false,
	        modal: true,
	        title:'insert Data',
	        width:600,
	        height:600,
	        open: function() {
	        	var id = $("#id").val();
	        	if(id == '' ){
	        		$('#insertBut').show();
	        		$('#updateBut').hide();
	        	}else{
	        		$('#insertBut').hide();
	        		$('#updateBut').show();
	        	}
	        },
	        close :function() {
	        	$("#id").val('');
    	    	$("#fname").val('');
    	    	$("#lname").val('');
    	    	$("#gen").val('');
    	    	$("#address").val('');
    	    	
	        	//showAll();
	        } 
	    });
	});
	
	function insert(){
		$("#confirmationDialog").dialog("open");
	}
	
	
	
	function insertAjaxData(){
    	var firstName = $("#fname").val();
  		var lastName = $("#lname").val();
  		var email = $("#email").val();
  		var phoneNumber = $("#phoneNumber").val();
		 var supervisor = $("#selectsupervisor option:selected").index()
  		console.log("fn ::: "+firstName+" ln ::: "+lastName+" gn ::: "+email+" phoneNumber ::: "+phoneNumber+" supervisor ::::: "+supervisor);
    	$.ajax({
	    	   type: "post",
	    	   url: "/api/submit",///MANGER-SERVICE
	    	   dataType: "json",  
			   contentType: 'application/json',
			   data:{firstName: firstName , lastName: lastName , email: email , phoneNumber: phoneNumber,supervisor :supervisor},
	    	   success: function(data){
	    		  alert('success :::: '+data);
	    	    if(data == 1){
	    	    	
	    	    	alert('inserted');
	    	    	$('#confirmationDialog').dialog('close');
	    	    	//showAll();
	    	    }else{
	    	    	alert('inserting fail');
	    	    	$('#confirmationDialog').dialog('close');
	    	    	//showAll();
	    	    }
	    	   },
	    	   error: function(){      
	    	    alert('Error while request..');
	    	   }
	    });
    }
	</script>
</head>
<body>
	<button id="click" onclick="insert();"> Add New</button>
	
	
	<!-- <input id="search" type="type" name="search"  value=""/>
	<button id="click" onclick="searchName();"> SEARCH</button> -->
				
	<table>
	  <!-- <thead>
	  	<tr>
		  <th> Id </th>
		  <th> FirstName </th>
		  <th> Lastname </th>
		  <th> Gender </th>
		  <th> address </th>
		  <th>Action</th>
		</tr>
	  </thead>
	  <tbody id="tblProducts">
	  
	  </tbody>-->
	</table>
	<div id="confirmationDialog">
        <table class="GridOne">
	        <tr>
				<td>
					<input id="id" type="hidden" name="id"  value=""/>
					<label>First Name</label>
				</td> 
				<td>
					<input id="fname" type="text" name="fname"  value=""/>
				</td>         
			</tr>
			 <tr>
				<td>
					<label>Last Name</label>
				</td> 
				<td>
					<input id="lname" type="text" name="lname"  value=""/>
				</td>         
			</tr>
			 <tr>
				<td>
					<label>Email</label>
				</td> 
				<td>
					<input id="email" type="text" name="email"  value=""/>
				</td>         
			</tr>
			 <tr>
				<td>
					<label>Phone Number</label>
				</td> 
				<td>
					<input id="phoneNumber" type="text" name="phoneNumber"  value=""/>

				</td>         
			</tr>

			<tr>
				<td>
					<label>Supervisor</label>
				</td> 
				<td>

					<select id="selectsupervisor">
						<option value="Sam">Sam</option>
						<option value="josh">josh</option>
						<option value="butler">butler</option>
						<option value="Sachin">Sachin</option>
					  </select>
				</td>         
			</tr>
			<tr>
				<td>
					<input type="button" id="insertBut" name="submit" onclick="insertAjaxData();" value="submit">
					<!-- <input type="button" id="updateBut" name="submit" onclick="updateAjaxData();"  value="update"> -->
				</td>         
			</tr>
			
        </table>
</div>

</body>
</html>