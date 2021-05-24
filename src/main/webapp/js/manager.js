window.onload = function(){
	getReim();
}

function getReim() {
	let xhttp = new XMLHttpRequest();
	
	xhttp.onreadystatechange = function(){
		
		
		if(xhttp.readyState == 4 && xhttp.status==200){
			let userReimbs = JSON.parse(xhttp.responseText);
			console.log(userReimbs);
			let result="";
			let filterByStatus = 0;
			filterByStatus = document.getElementById("statusFilter").value;
			console.log(filterByStatus);
			for (let j = 0; j < userReimbs.length; j++) {
			
			let submitDate = new Date(userReimbs[j].reimbusermentSubmitted);
			let submittedDate = submitDate.getFullYear() + "/" + (submitDate.getMonth()+1) + "/" + submitDate.getDate() + " " + submitDate.getHours() + ":" + submitDate.getMinutes() + ":" + submitDate.getSeconds();
			let resolveDate;
			let resolvedDate = new Date(userReimbs[j].reimbusermentResolved);
			if(userReimbs[j].reimbusermentResolved != null){
				resolveDate = resolvedDate.getFullYear() + "/" + (resolvedDate.getMonth()+1) + "/" + resolvedDate.getDate() + " " + resolvedDate.getHours() + ":" + resolvedDate.getMinutes() + ":" + resolvedDate.getSeconds();
			}
			
			let statusId = userReimbs[j].reimbursementStatusId;
			let status;
			if(statusId == 1) {  status = "Pending" }
			else if(statusId == 2) {  status = "Approved" }
			else if(statusId == 3) {  status = "Denied" }
			else { status = "unknown" }
			
			let typeId = userReimbs[j].reimbursementTypeId;
			let type;
			if(typeId == 1) {  type = "Lodging" }
			else if(typeId == 2) {  type = "Travel" }
			else if(typeId == 3) {  type = "Food" }
			else {  type = "Others" }
			
			if(filterByStatus == 0){
				result += "<tr>";
			  result += "<td>" + userReimbs[j].reimbursmentID + "</td>"
					  + "<td>" + userReimbs[j].amount + "</td>"
					  + "<td>" + submittedDate + "</td>"
					  + "<td>" + resolveDate + "</td>"
					  + "<td>" + userReimbs[j].reimbursementDescription + "</td>"
					  + "<td>" + userReimbs[j].author + "</td>"
					  + "<td>" + userReimbs[j].resolver + "</td>"
					  + "<td>" + status+ "</td>"
					  + "<td>" + type + "</td>";
				if(statusId == 1){ 
					result += "<td><form method=\"post\" action=\"/ProjectOne/approveReimbursement.change\">"
					+ "<input type=\"text\" style=\"display:none\" name=\"reimbId\" value=\""+ userReimbs[j].reimbursmentID +"\" />"
					+ "<button type=\"submit\" class=\"btn btn-dark\">Approve</button>"
					+ "</form>"
					+ "<form method=\"post\" action=\"/ProjectOne/denyReimbursement.change\">"
					+ "<input type=\"text\" style=\"display:none\" name=\"reimbId\" value=\""+ userReimbs[j].reimbursmentID +"\" />"
					+ "<button type=\"submit\" class=\"btn btn-dark\" >Deny</button>"
					+ "</form></td>";
				}							
			  result += "</tr>";
			}
			else if(filterByStatus == statusId){
				result += "<tr>";
			  result += "<td>" + userReimbs[j].reimbursmentID + "</td>"
					  + "<td>" + userReimbs[j].amount + "</td>"
					  + "<td>" + submittedDate + "</td>"
					  + "<td>" + resolveDate + "</td>"
					  + "<td>" + userReimbs[j].reimbursementDescription + "</td>"
					  + "<td>" + userReimbs[j].author + "</td>"
					  + "<td>" + userReimbs[j].resolver + "</td>"
					  + "<td>" + status+ "</td>"
					  + "<td>" + type + "</td>";
						if(statusId == 1){ 
					result += "<td><form method=\"post\" action=\"/ProjectOne/approveReimbursement.change\">"
					+ "<input type=\"text\" style=\"display:none\" name=\"reimbId\" value=\""+ userReimbs[j].reimbursmentID +"\" />"
					+ "<button type=\"submit\" class=\"btn btn-dark\">Approve</button>"
					+ "</form>"
					+ "<form method=\"post\" action=\"/ProjectOne/denyReimbursement.change\">"
					+ "<input type=\"text\" style=\"display:none\" name=\"reimbId\" value=\""+ userReimbs[j].reimbursmentID +"\" />"
					+ "<button type=\"submit\" class=\"btn btn-dark\" >Deny</button>"
					+ "</form></td>";
				}		
			  result += "</tr>";
			}
			  			 
			}
			document.getElementById("reimInfo").innerHTML = result;
		}
	}
	
	xhttp.open("GET", "http://localhost:8080/ProjectOne/getSessionReim.json");

	xhttp.send();
}
