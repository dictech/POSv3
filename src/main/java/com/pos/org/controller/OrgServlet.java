package com.pos.org.controller;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.pos.enums.DBOperation;
import com.pos.org.model.Organization;

public class OrgServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private static DBOperation operation;
	private static String operationStatus = "NULL_STATUS";
	private static Organization org= null;
	private static List<Organization> listOfOrgs = null;
       
  
    public OrgServlet() {
    	listOfOrgs =  OrganizationCtrl.viewAllOrganization();	
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		

		if (request.getParameter("operation") != null) {
			operation = DBOperation.valueOf(request.getParameter("operation"));
		}else {
			operation = DBOperation.READ_ALL;
		}
		

		switch (operation) {
			case CREATE:
				operationStatus = OrganizationCtrl.createOrganization(request);
				response.getWriter().write(operationStatus);
				request.setAttribute("operationStatus", operationStatus);
				break;
			case READ:
				org = OrganizationCtrl.viewOrganization(request);
				break;
			case UPDATE:
				operationStatus = OrganizationCtrl.updateOrganization(request);
				response.getWriter().write(operationStatus);
				break;
			case DELETE:
				operationStatus = OrganizationCtrl.deleteOrganization(request);
				response.getWriter().write(operationStatus);
				break;
			case READ_ALL:
				request.setAttribute("orgs", OrganizationCtrl.viewAllOrganization());
				request.getRequestDispatcher("createShop.jsp").forward(request, response);
				response.getWriter().write(Arrays.toString(OrganizationCtrl.viewAllOrganization().toArray()));  //OrganizationCtrl.viewAllOrganization().toArray()
				break;
		}
		
	}
	
	
	
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		doGet(request, response);
	}
}
