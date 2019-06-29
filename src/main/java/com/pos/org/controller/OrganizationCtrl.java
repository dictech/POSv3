package com.pos.org.controller;

import java.math.BigDecimal;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import com.pos.org.model.Organization;
import com.pos.org.model.OrganizationDAO;

public class OrganizationCtrl {
	   
		static String msg = null;
		static Boolean isSuccessful = null;
	
	
	public static String createOrganization(HttpServletRequest request) {

		Organization org =  new Organization();
		org.setName(request.getParameter("orgName").toString());
		org.setPhoneNo(request.getParameter("orgPhoneNo").toString());
		org.setEmail(request.getParameter("orgEmail").toString());
		
	    isSuccessful = OrganizationDAO.create(org);
		if(isSuccessful) {
	    	msg = "Organization successfully created";
	    }else {
	    	msg = "Failed to create organization. Please check log for details.";
	    }
	    
	    return msg;
	}
	
	public static List<Organization> viewAllOrganization(){
		return OrganizationDAO.viewAllOrganization();
	}
	
	public static Organization viewOrganization(HttpServletRequest request) {
		return OrganizationDAO.viewOrganization((BigDecimal)request.getAttribute("id"));
	}
	
	public static String updateOrganization(HttpServletRequest request) {
		Organization org =  new Organization();
		org.setId(new BigDecimal(request.getParameter("orgId")));
		org.setName(request.getParameter("orgName").toString());
		org.setPhoneNo(request.getParameter("orgPhoneNo").toString());
		org.setEmail(request.getParameter("orgEmail").toString());
		
		isSuccessful = OrganizationDAO.updateOrganization(org);
		if(isSuccessful) {
	    	msg = "Organization successfully updated";
	    }else {
	    	msg = "Failed to update organization. Please check log for details.";
	    }
		
		return msg;
	}
	
	public static String deleteOrganization(HttpServletRequest request) {
		
		return "true";
	}


}
