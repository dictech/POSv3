<!DOCTYPE html>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>      
<html lang="en">
<head>

  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="">
  <meta name="author" content="">

  <title>Account</title>

  <!-- Bootstrap core CSS -->
  <link href="bootstrap-4.3.1/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
  <link rel="shortcut icon" type="text/x-icon" href="images/posv2Logo3.png">
  <!-- Custom styles for this template -->
  <link href="bootstrap-4.3.1/css/shop-homepage.css" rel="stylesheet">

</head>

<body>
     

  <!-- Navigation -->
  <div id="nav">
    <jsp:include page="/include/common/nav.jsp" />
  </div>

    <!-- Page Content -->
    <div class="container">
    
    <div class="row">

      <div class="col-lg-3">
         <div id="sidebar">
          <jsp:include page="/include/common/sideBar.jsp" />
         </div>
      </div> 

      
      <!-- /.col-lg-3 -->

      <div class="col-lg-9">
        <div id="carouselExampleIndicators" class="carousel slide my-4" data-ride="carousel">

                <ul class="nav nav-tabs" role="tablist">
                   <li class="nav-item"><a href="#workersList" class="nav-link active" data-toggle="tab" role="tab">Current Employees</a></li>
                   <li class="nav-item"><a href="#CreateAttendant" class="nav-link" data-toggle="tab" role="tab">New Employee</a></li>
                   <li class="nav-item"><a href="#AttendantList" class="nav-link" data-toggle="tab" role="tab">Attendance List</a></li>
                   
                </ul>


                   <!--Edit Employee modal -->
                   <div class="modal fade " id="attendantModal" role="dialog">
                    <div class="modal-dialog modal-lg">
                    <div class="modal-content">
                     <div class="modal-header modal-sm">
                       <h1 class="modal-title">Edit Employee</h1>
                     </div><!-- modal header -->
                      
                     <div class="modal-body" id="editAttdt">

                                           
                       <form action="Account" style="width: 500px; margin: auto;">
                         <input type="hidden" id="operation"   value="UPDATE" name="operation" />
                         
                       <div class="row">
                       <div class="col">
                         <div class="form-group">
                         <label for="firstName">First Name</label>
                         <input type="text" class="form-control" placeholder="firstName">
                         </div>
                       </div>
                         
                      
                      <div class="col">
                         <div class="form-group">
                         <label for="lastName">Last Name</label>
                         <input type="text" class="form-control" placeholder="lastName">
                         </div>
                      </div>
                      </div>
                       
                                              
                       <div class="row">
                         <div class="col">
                         <div class="form-group">
                         <label for="middleName">Middle Name</label>
                         <input type="text" class="form-control" placeholder="middleName">
                         </div>
                         </div>
                       
                       
                        <div class="col">
                        <div class="form-group">
                       <label for="dob">Date of birth</label>
                       <input type="date" class="form-control" placeholder="Dob"> 
                       </div>
                      </div>
                      </div>
                       
                        <div class="form-group">
                         <label for="Address">Address</label>
                         <textarea class="form-control" placeholder="Address" cols="8"> 
                         
                         </textarea>
                        </div>
                       
                        <div class="row">
                        <div class="col">
                       <div class="form-group">
                       <label for="phone">Phone</label>
                       <input type="text" class="form-control" placeholder="Phone number">
                       </div>
                       </div>
                       
                        <div class="col">
                        <div class="form-group">
                        <label for="gender">Gender</label>
                         <select name="gender" class="form-control">
                            <option value=""></option>
                            <option value="Male">Male</option>
                            <option value="Memale">Female</option>
                         </select>
                        
                        </div>
                        </div>
                         
                       </div>
                       
                       <div class="row">
                       <div class="col">                        
                       <div class="form-group">
                         <label for="position">Position</label>
                         <select name="gender" class="form-control">
                            <option value=""></option>
                            <option value="Attendant">Attendant</option>
                            <option value="Manager">Manager</option>
                         </select>
                       </div>
                       </div>
                         
                        <div class="col">
                       <div class="form-group">
                       <label for="email">Email</label>
                       <input type="email" class="form-control" placeholder="email Address">
                       </div>
                        </div> 
                       </div>
                       
                  </form>
                  <div class="modal-footer">
                          <input type="submit" class="btn btn-default" value="Update">
                          <button class="btn btn-primary" data-dismiss="modal">Close</button>
                       </div>
                     </div><!-- end modal body -->      
                    </div><!-- end modal content -->
                   </div><!-- end modal-dialog -->
                   </div> <!-- end modal -->



                
                <div class="tab-content">
                  <div role="tabpanel" id="workersList" class="tab-pane fade show active"> 
                  <div class="table-responsive">  
                  <table class="table">

                  <thead>
                    <tr>
                      <th scope="col">#</th>
                      <th scope="col">First Name</th>
                      <th scope="col">Last Name</th>
                      <th scope="col">Phone No.</th>
                      <th scope="col">Gender</th>
                      <th scope="col">Date of Emp.</th>
                      <th scope="col">#Action</th>
                      
                    </tr>
                  </thead>
                   
                 <c:forEach var="displayWorkers" items="${attendants}"> 
                  <tbody>

                    <tr>
                    
                      <th scope="row">
                      </th>
                      <td>${displayWorkers.fName}</td>
                      <td>${displayWorkers.surname}</td>
                      <td>${displayWorkers.phoneNo}</td>
                      <td>${displayWorkers.gender}</td>
                      <td>${displayWorkers.doe}</td>
                      <td><a href="#attendantModal" data-toggle="modal" >Edit</a></td>
                      
                    </tr>
                   
                    <tr>
                  </tbody>
                  </c:forEach>
                  </table>
                  </div>
                  </div>
                    
                    
               <div role="tabpanel" class="tab-pane fade show" id="AttendantList">
                <table class="table">
                  <thead>
                    <tr>
                      <th scope="col">#</th>
                      <th scope="col">First Name</th>
                      <th scope="col">Last Name</th>
                      <th scope="col">Date</th>
                      <th scope="col">SignIn Time</th>
                      <th scope="col">SignOut Time</th>
                    </tr>
                  </thead>
                  <c:forEach var="tempAttendance" items="${attendance}">
                  <tbody>
                    <tr>
                      <th scope="row">#</th>
                      <td>${tempAttendance.attendcFirstName}</td>
                      <td>${tempAttendance.attendcLastName}</td>
                      <td>${tempAttendance.date}</td>
                      <td>${tempAttendance.signInTime}</td>
                      <td>${tempAttendance.signOutTime}</td>
                    </tr>
                  </tbody>
                  </c:forEach>
                </table>
               </div>      
                    
                    
              
                    
            <div role="tabpanel" class="tab-pane fade show" id="CreateAttendant">        
            <div class="form">
      
             <form action="Account" method="GET" style="width: 670px; margin:auto;">
                <input type="hidden" id="operation"   value="CREATE" name="operation" />
                
                <i class="fas fa-user" id="firstNameIcon"></i>
                <i class="fas fa-user" id="lastNameIcon"></i>
                <i class="fas fa-user" id="middleNameIcon"></i>
                <i class="fas fa-address-card" id="addressIcon"></i>
                <i class="fas fa-envelope" id="emailIcon"></i>
                <i class="fas fa-phone" id="phoneIcon"></i>
                <i class="fas fa-mars" id="genderIcon"></i>
                <i class="fas fa-briefcase" id="positionIcon"></i>
                <i class="fas fa-user-circle" id="userNameIcon"></i>
                <i class="fas fa-key" id="passwordIcon"></i>
                
                
               <div class="row">
               <fieldset>
                <legend style="color: #008080; font-weight: bold;">Register An Employee</legend>
               </fieldset> 
               </div> <br/>
            
              <div class="row">
              <div class="col">                 
              <div class="form-group">
               <label for="firstName">FirstName<span class="leb-design">*</span></label>
               <input type="text" name="firstName" class="form-control" style="padding-left: 40px;" required/>
             </div>
             </div>
             
              <div class="col">
               <div class="form-group">
               <label for="lastName">LastName<span class="leb-design">*</span></label>
               <input type="text" name="lastName" class="form-control" style="padding-left: 40px;" required/>
               </div>
              </div>
                
             </div>
             
             <div class="row">
             
              <div class="col">
               <div class="form-group">
               <label for="middleName">MiddleName<span class="leb-design">*</span></label> 
               <input type="text" name="middleName" class="form-control" style="padding-left: 40px;" required>
              </div>
             </div> 
             
              <div class="col">
                <div class="form-group">
                  <label for="phone">Phone<span class="leb-design">*</span></label>
                  <input type="text" name="phone" class="form-control" style="padding-left: 40px;" required/>
                </div>
              </div>
             </div>
             
            <div class="row"> 
             
              <div class="col">
                <div class="form-group">
                  <label for="dob">Date of birth<span class="leb-design">*</span></label>
                  <input type="date" name="dob" class="form-control" required/>
                </div>
              </div>
              
              <div class="col-3">
               <div class="form-group">
               <label for="gender">Gender<span class="leb-design">*</span></label> 
                <select name="gender" class="form-control" style="padding-left: 40px;" required>
                <option selected></option>
                <option value="male">Male</option>
                <option value="female">Female</option>
               </select>
              </div>
             </div>
             </div>
             
              <div class="row">
               <div class="col">
                <div class="form-group">
               <label for="address">Address<span class="leb-design">*</span></label>
               <textarea name="address" class="form-control" rows="4" cols="1" style="padding-left: 40px;" required>
               </textarea>
              </div>
               </div>
               
                <div class="col"></div>
              </div>
              
               <div class="form-group">
               <label for="email">Email<span class="leb-design">*</span></label> 
               <input type="email" name="email" class="form-control"  style="padding-left: 40px;" required/>
               </div>
               
            <div class="row">
             
              <div class="col">
               <div class="form-group">
               <label for="position">Position<span class="leb-design">*</span></label> 
                <select name="position" class="form-control" style="padding-left: 40px;" required>
                <option></option>
                <option>Attendant</option>
                <option>Manager</option>
               </select>
               </div>
             </div> 
             
              <div class="col">
                <div class="form-group">
                  <label for="doe">Date of employment</label>
                  <p class="form-control"><%= new java.util.Date() %></p>
                </div>
              </div>
             </div>
               
                            
            <div class="row">
             
              <div class="col">
               <div class="form-group">
               <label for="username">UserName<span class="leb-design">*</span></label> 
                <input type="text" name="userName" class="form-control" style="padding-left: 40px;" required/>
              </div>
             </div> 
             
              <div class="col">
                <div class="form-group">
                  <label for="password">Password<span class="leb-design">*</span></label>
                  <input type="password" name="password" class="form-control" style="padding-left: 40px;" required/>
                </div>
              </div>
             </div><br>
             
                              
             <div class="form-check">
               <input type="checkbox" name="acceptTerms" class="form-check-input" >
                
                <!-- confirmation modal -->
                   <div class="modal" id="myModal">
                    <div class="modal-dialog">
                    <div class="modal-content">
                     <div class="modal-header">
                       <h1 class="modal-title">Created Successfully</h1>
                     </div><!-- modal header -->
                      
                     <div class="modal-body">
                        
                     </div><!-- end modal body -->      
                    </div><!-- end modal content -->
                   </div><!-- end modal-dialog -->
                   </div> <!-- end modal -->
                  
               <label for="accept terms" class="form-check-label">Accept terms &amp; policy </label>
             </div>
             <br><br>
             <input type="submit" value="Continue" class="btn btn-outline-secondary" >
          </form>
      
      </div>
       </div>  
       
       
        </div>
                
        </div>
        
        </div> <!-- /.row -->

      </div> <!-- /.col-lg-9 -->

    </div> <!-- /.row -->


  <!-- Footer -->
  <div id="footer">
    <jsp:include page="/include/common/footer.jsp" />
  </div>

  <!-- Bootstrap core JavaScript -->
  <script src="bootstrap-4.3.1/vendor/jquery/jquery.min.js"></script>
  <script src="bootstrap-4.3.1/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
</body>

</html>

