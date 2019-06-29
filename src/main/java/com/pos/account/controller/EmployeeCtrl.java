package com.pos.account.controller;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

import com.pos.account.model.Attendance;
import com.pos.account.model.AttendanceDAO;
import com.pos.account.model.Attendant;
import com.pos.account.model.AttendantDAO;
import com.pos.account.model.SystemAccount;
import com.pos.account.model.SystemAccountDAO;

public class EmployeeCtrl {
	
	 
	public static void createEmployee( HttpServletRequest request) {
		
		
		  
		  try {
		  
		  Attendant attendant = new Attendant()
	      .setfName(request.getParameter("firstName"))
		  .setmName(request.getParameter("middleName"))
		  .setSurname(request.getParameter("lastName"))
		  .setAddress(request.getParameter("address"))
		  .setEmail(request.getParameter("email"))
		  .setGender(request.getParameter("gender"))
		  .setDob(Date.valueOf(request.getParameter("dob")))
		  .setDoe(Date.valueOf(LocalDate.now()))
		  .setPhoneNo(request.getParameter("phone"))
		  .setPosition(request.getParameter("position"))
		  .BuildAttendant();
		  AttendantDAO.createNewAttendant(attendant);
		  
		  SystemAccount systemAccount = new SystemAccount();
		  systemAccount.setActAttendantID(attendant.getId());
		  systemAccount.setPassword(request.getParameter("password"));
		  systemAccount.setUserName(request.getParameter("userName"));
		  SystemAccountDAO.createSystemAccount(systemAccount);
		  		  
		  }catch(Exception e) {
			  
			  e.printStackTrace();
		  }
	}
	
	

	  public static List<Attendant> getAllEmployee() throws Exception{
		  return AttendantDAO.getAllAttendants();  
	     }
	  
	 
	  
	  public static List<Attendance> getAllAttendance() throws Exception{
		  return AttendanceDAO.getAllAttendance();  
	     }
	  
}
