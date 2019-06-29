function saveOrg(e) {
	e.preventDefault();

	let xhr = new XMLHttpRequest();
	xhr.open('POST','http://localhost:8080/webpos/OrgServlet', true);
	xhr.setRequestHeader('content-type', 'application/x-www-form-urlencoded');



	xhr.onload = function(test){
		 document.getElementById('operationStatus').innerHTML = xhr.responseText;
		 $('#addOrgModal').modal('hide');
		 $('#statusModal').modal('show');
		 if(this.status == 200){
		    document.getElementById("addOrgForm").reset();
		 }
}



xhr.send('operation='+ document.getElementById('operation').value+'&'+
		 'orgName='+document.getElementById('orgName').value+'&'+
		 'orgEmail='+document.getElementById('orgEmail').value+'&'+
		 'orgPhoneNo='+document.getElementById('orgPhoneNo').value);
}


let saveOrgForm = document.getElementById('saveOrgButton');
saveOrgForm.addEventListener('click', saveOrg);










let orgList = document.querySelector('#orgTable');
orgList.addEventListener('click',getOrgTableRow);

function getOrgTableRow(e){
	console.log('in function getOrgTableRow')

	if(e.target.classList.contains('btn')){

			var row =  e.target.closest('tr')

			// document.querySelectorAll('#updateOrgModal input').item(1).value = row.cells.item(1).innerHTML		
			// document.querySelectorAll('#updateOrgModal input').item(2).value = row.cells.item(2).innerHTML
			// document.querySelectorAll('#updateOrgModal input').item(3).value = row.cells.item(4).innerHTML
			// document.querySelectorAll('#updateOrgModal input').item(4).value = row.cells.item(5).innerHTML
			//document.querySelectorAll('#updateOrgModal input').item(5).value = row.cells.item(6).innerHTML

			document.querySelector('#updateOrgModal #orgId').value = row.cells.item(1).innerHTML;	
			document.querySelector('#updateOrgModal #orgName').value = row.cells.item(2).innerHTML;
			document.querySelector('#updateOrgModal #orgPhoneNo').value = row.cells.item(4).innerHTML;
            document.querySelector('#updateOrgModal #orgEmail').value = row.cells.item(5).innerHTML;
	}

}

let upDateOrgButton = document.getElementById('saveUpdateOrgButton');
upDateOrgButton.addEventListener('click', updateOrg);

function updateOrg(){
	console.log('in function updateOrg')
	event.preventDefault();
    
	let xhr =  new XMLHttpRequest();
	xhr.open('POST', 'OrgServlet', true);
	xhr.setRequestHeader('content-type', 'application/x-www-form-urlencoded');

	xhr.onload = ()=>{
		document.querySelector('#operationStatus').innerHTML = xhr.responseText;
		$('#updateOrgModal').modal('hide');
		$('#statusModal').modal('show');
		if(this.status == 200){
			document.getElementById('updateOrgModal').reset();
		}

	}

	xhr.send(//'operation='+ document.querySelector('#updateOrgModal #operation').value+'&'+
		     'orgId='+ document.querySelector('#updateOrgModal #orgId').value+'&'+
			 'orgName='+document.querySelector('#updateOrgModal #orgName').value+'&'+
			 'orgEmail='+document.querySelector('#updateOrgModal #orgEmail').value+'&'+
			 'orgPhoneNo='+document.querySelector('#updateOrgModal #orgPhoneNo').value+'&'+
	         'operation='+ document.querySelector('#updateOrgModal #operation').value);

}








