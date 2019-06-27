<h1 class="my-4">Shop Name</h1>
<div class="list-group">

  <a href="homePage.jsp" class="list-group-item" >HOME</a>

  <a href="#" class="list-group-item" >SALES</a>
         

  <a href="#" 
     class="list-group-item" 
  	 data-toggle="collapse" 
  	 data-target="#salesSubSystemList" 
  	 aria-expanded="false" 
  	 aria-controls="salesSubSystemList">PAYMENT</a>
	  <div class="list-group list-group-flush collapse" id="paymentSubSystemList">
		  <a href="#" class="list-group-item">Debit Payment</a>
		  <a href="#" class="list-group-item">Crebit Payment</a>
	  </div>


  <a href="#" 
     class="list-group-item"
     data-toggle="collapse"
     data-target="#inventorySubSystemList"
     aria-expanded="false"
     aria-controls="inventorySubSystemList">INVENTORY</a>
  	  <div class="list-group list-group-flush collapse" id="inventorySubSystemList">
		  <a href="#" class="list-group-item">Inventory details</a>
		  <a href="#" class="list-group-item">inventory Inquiry</a>
	  </div>
  
  <a href="#" class="list-group-item">ACCOUNT</a>

  <a href="#" 
     class="list-group-item"
     data-toggle="collapse"
     data-target="#setupSubSystemList"
     aria-expanded="false"
     aria-controls="setupSubSystemList">SYSTEM SETUPS</a>
  	  <div class="list-group list-group-flush collapse" id="setupSubSystemList">
		  <a href="OrgServlet" class="list-group-item">Organization setup</a>
		  <a href="Account" class="list-group-item">Account</a>
	  </div>

</div>
