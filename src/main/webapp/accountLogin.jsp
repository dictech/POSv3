<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
 pageEncoding="ISO-8859-1"%>
 
 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
 <meta charset="utf-8">
 <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>Login</title>
  <!-- Bootstrap core CSS -->
  <link href="bootstrap-4.3.1/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
  <!-- fontAwsome CDN link -->
  <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.1/css/all.css"
   integrity="sha384-50oBUHEmvpQ+1lW4y57PTFmhCaXp0ML5d60M1M7uH2+nqUivzIebhndOJK28anvf"
   crossorigin="anonymous">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<link rel="stylesheet" type="text/css" href="account.css">
<link rel="shortcut icon" type="text/x-icon" href="images/posv2Logo3.png">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/animate.css/3.7.0/animate.min.css">
</head>

<body class="lg-body">

 <span class="animated zoomIn delay-1s" id="userNameIcon-login"><i class="fas fa-user  fa-1x" ></i></span>
 <span class="animated zoomIn delay-1s" id="passwordIcon-login"><i class="fas fa-key  fa-1x" ></i></span>
 <div style="position: absolute; top: 437px; left: 515px; z-index: 1; width:270px; height:25px; border:none; color:red; font-size:78%;" >

 </div>
 
  <div class="animated zoomIn 5s">
  <div class="titleLogo" align="center">             
  <img alt="title-logo" src="images/posv2SingleLogo.png" width="105" height="102">
  </div>
                 
   <form action="EmployeeLogin" method="GET" class="formContainer">
     
   <div>
   <input type="text" name="loginUserName" class="form-inputs-login" placeholder="Username" required />              
   </div>
  
   <div>
   <input type="password" name="loginPassword" class="form-inputs-login" placeholder="Password" required />               
   </div>    
       
          <div class="modal" id="myModal">
          <div class="modal-dialog">
          <div class="modal-content">
          <div class="modal-header">
          <h2 class="modal-title">Incorrect details </h2>
          </div>
          <div class="modal-body">
           <p>Please check your details and try again</p>
          </div>
          </div>
          </div>
          </div>
             
   <div>
   <input type="submit" class="submit-login" value="submit" />               
   </div>      
  </form>   
  </div>
           

           
           
         
</body>
</html>