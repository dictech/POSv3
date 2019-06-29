package com.pos.account.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pos.account.model.Attendance;
import com.pos.account.model.AttendanceDAO;
import com.pos.account.model.Attendant;
import com.pos.account.model.AttendantDAO;
import com.pos.enums.AccountOperation;
import com.pos.enums.DBOperation;




public class AttendantServlet extends HttpServlet {
private static final long serialVersionUID = 1L;
  private  AccountOperation operation = null;
  private static List<Attendant> allEmployee = null;
  private static List<Attendance> allAttendance = null;
  
  private RequestDispatcher dispatch;


    public AttendantServlet() throws Exception{
        
    	allEmployee = AttendantDAO.getAllAttendants(); 
    	allAttendance = AttendanceDAO.getAllAttendance();
         
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
 
		    if(request.getParameter("operation") != null) {
		    	
		     operation = AccountOperation.valueOf(request.getParameter("operation"));
		    	
		    }else {
		    	
		    	operation = AccountOperation.READ_ALL;
		    	}
		    	
		    	
			     
		    	 switch(operation) {
		    	 
		    	   
		    	 case CREATE:
		    		   EmployeeCtrl.createEmployee(request);
		    		   request.getRequestDispatcher("/index.jsp").forward(request, response);
		    	       break;

		    		  
		    	 case READ_ALL:
		    		 
						   request.setAttribute("attendants", allEmployee);
					       request.setAttribute("attendance", allAttendance);
			    		   request.getRequestDispatcher("/AttendantDetails.jsp").forward(request, response); 
			    		   break;
			    		       
			     default:
			    	   System.out.println("");
		    		   
		    		  }
		         
		    	
		    	  }




	
	
	         
	
}
