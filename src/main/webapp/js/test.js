
	let saveOrgButton = document.getElementById('saveOrgButton');
	saveOrgButton.addEventListener('click', setOperationType);

	let saveOrgModalButton = document.getElementById('saveOrgModalButton');
	saveOrgModalButton.addEventListener('click', executeOperation);


	let upDateOrgButtonModal = document.getElementById('saveUpdateOrgButton');
	upDateOrgButtonModal.addEventListener('click', executeOperation);


	let deleteOrgModalButton =  document.getElementById('deleteOrgModalButton');
	deleteOrgModalButton.addEventListener('click', executeOperation);


	let orgTable = document.querySelector('#orgTable');
	orgTable.addEventListener('click',setOrgModalFields);



	function setOperationType(e){
		document.getElementById('operationz').value = e.target.value;
	}




	function getSelectedTableRow(e){
		console.log('getting selected table row');

		if(e.target.classList.contains('btn')){

			if(e.target.closest('tr') == null){
				throw new Error('No row was retrived. row is ' + e.target.closest('tr'));
			}
			return  e.target.closest('tr');
		}
	}



	function setOrgModalFields(e){
		console.log('setting table row to modal fields');
	    
	    setOperationType(e);
		var row =  getSelectedTableRow(e);

		document.querySelector('#updateOrgModal #orgId').value = row.cells.item(1).innerHTML;	
		document.querySelector('#updateOrgModal #orgName').value = row.cells.item(2).innerHTML;
		document.querySelector('#updateOrgModal #orgPhoneNo').value = row.cells.item(4).innerHTML;
	    document.querySelector('#updateOrgModal #orgEmail').value = row.cells.item(5).innerHTML;

	    document.querySelector('#deleteOrgModal #orgId').value = row.cells.item(1).innerHTML;
	}


	function  getXMLHttpRequest(operationModal){

			let xhr = new XMLHttpRequest();
			xhr.open('POST','http://localhost:8080/webpos/OrgServlet',true);
			xhr.setRequestHeader('content-type', 'application/x-www-form-urlencoded');
			xhr.onload =function(){

				document.getElementById('operationStatus').innerHTML = xhr.responseText;
				$(operationModal).modal('hide');
				$('#statusModal').modal('show');
				if(this.status == 200){
				    $('#orgTable').load(' #orgTable');
				}

			}

			return xhr;
	}




	function executeOperation(e){

			e.preventDefault();
		    let operation  = document.getElementById('operationz').value;
		    let xhr = new XMLHttpRequest();

			switch(operation){
				case  'CREATE':
				    xhr = getXMLHttpRequest('#addOrgModal');
					xhr.send('operation='+ document.getElementById('operation').value+'&'+
							 'orgName='+document.getElementById('orgName').value+'&'+
							 'orgEmail='+document.getElementById('orgEmail').value+'&'+
							 'orgPhoneNo='+document.getElementById('orgPhoneNo').value);
					break;


				case   'UPDATE':
				    xhr = getXMLHttpRequest('#updateOrgModal');
					xhr.send(//'operation='+ document.querySelector('#updateOrgModal #operation').value+'&'+
						     'orgId='+ document.querySelector('#updateOrgModal #orgId').value+'&'+
							 'orgName='+document.querySelector('#updateOrgModal #orgName').value+'&'+
							 'orgEmail='+document.querySelector('#updateOrgModal #orgEmail').value+'&'+
							 'orgPhoneNo='+document.querySelector('#updateOrgModal #orgPhoneNo').value+'&'+
					         'operation='+ document.querySelector('#updateOrgModal #operation').value);
					break;


				case 	'DELETE':
				    xhr = getXMLHttpRequest('#deleteOrgModalButton');
					xhr.send('operation='+document.querySelector('#deleteOrgModal #operation').value+'&'+
					 		 'orgId='+document.querySelector('#deleteOrgModal #orgId').value);

					break;


				default:
					console.log('NO OPERATION TO EXECUTE');
			}
	}





















