package com.pos.account.controller;

import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pos.account.model.Attendant;
import com.pos.account.model.AttendantDAO;
import com.pos.account.model.SystemAccount;
import com.pos.account.model.SystemAccountDAO;



public class CreateAttendantCtrl extends HttpServlet {
private static final long serialVersionUID = 1L;
   
    String fName;
    String mName;
    String surname;
    String gender;
    Date dob;
    String address;
    String phoneNo;
    String email;
    Date doe;
    String pos;
    String image;
    String userName;
    String password;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	  
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		  
		  fName = request.getParameter("firstName");
		  mName = request.getParameter("middleName");
		  surname = request.getParameter("lastName");
		  gender = request.getParameter("gender");
		  dob = Date.valueOf(request.getParameter("dob"));
		  address = request.getParameter("address");
		  phoneNo = request.getParameter("phone");
		  email = request.getParameter("email");
		  doe = Date.valueOf(LocalDate.now());
		  pos = request.getParameter("position");
		  userName = request.getParameter("userName");
		  password = request.getParameter("password");
		  
		  try {
		  
		  Attendant attendant = new Attendant()
	      .setfName(fName)
		  .setmName(mName)
		  .setSurname(surname)
		  .setAddress(address)
		  .setEmail(email)
		  .setGender(gender)
		  .setDob(dob)
		  .setDoe(doe)
		  .setPhoneNo(phoneNo)
		  .setPosition(pos)
		  .BuildAttendant();
		  AttendantDAO.createNewAttendant(attendant);
		  
		  SystemAccount systemAccount = new SystemAccount();
		  systemAccount.setActAttendantID(attendant.getId());
		  systemAccount.setPassword(password);
		  systemAccount.setUserName(userName);
		  SystemAccountDAO.createSystemAccount(systemAccount);
		  
		  RequestDispatcher dispatch = request.getRequestDispatcher("/homePage.jsp");
		  dispatch.forward(request, response);
		  
		  }catch(Exception e) {
			  
			  e.printStackTrace();
		  }
		    		 
		
	}

}

