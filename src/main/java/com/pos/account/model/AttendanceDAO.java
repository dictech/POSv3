package com.pos.account.model;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import com.pos.database.Database;

public class AttendanceDAO {
	
	private static PreparedStatement ps;
	private static ResultSet rs;
	private static Attendance attendance;
	private static Date date = Date.valueOf(LocalDate.now());
	private static Time time = Time.valueOf(LocalTime.now());
	

	public static void CreateAttendance(Attendant attendant) throws Exception{
		      attendance  = new Attendance();
	          String query = " INSERT INTO posv2.attendance "
	   		               + " value(?,?,?,?,?,?,?) ";
	   
	          ps = Database.getConnectedPreparedStatement(query);
			  ps.setBigDecimal(1, attendance.getAttenc_ID());
			  ps.setBigDecimal(2, attendant.getId());
			  ps.setString(3, attendant.getfName());
			  ps.setString(4, attendant.getSurname());
			  ps.setTime(5, AttendanceDAO.time);
			  ps.setTime(6, attendance.getSignOutTime());
			  ps.setDate(7, AttendanceDAO.date);
			  ps.execute();
			  ps.close();
			        
	     }


	
	
	public static Attendance getAttendance(Date date, Attendant attendant) throws Exception{
		   
		           
		           String query = " SELECT * FROM posv2.attendance "
		   		                + " where attdnc_date = ? "
		   		                + " and attdnc_attdnt_id = ? ";
                  	
		           ps = Database.getConnectedPreparedStatement(query);
		           ps.setDate(1, date);
		           ps.setBigDecimal(2, attendant.getId());
		           ps.execute();
		           rs = ps.executeQuery();
		         
		           if(rs.next())
		           {
                       System.out.println("Attendance already exist! and will not be created again");
                       
  
		           }
		           else
		           {
		        	   attendance  = new Attendance();
		        	   attendance.setAttenc_ID(attendance.getAttenc_ID());
                       attendance.setAttenc_attendt_Id(attendant.getId());
                       attendance.setAttendcFirstName(attendant.getfName());
                       attendance.setAttendcLastName(attendant.getSurname());
                       attendance.setDate(date);
                       attendance.setSignInTime(time);
                       attendance.setSignOutTime(attendance.getSignOutTime());
                       CreateAttendance(attendant);
                       System.out.println("your attendance for today is not present");
                       System.out.println("Your attendance will be created now, \n please wait...");
                       System.out.println("your attendance for today has been created ! thank you");
		             }
		           
		           ps.close();
		           rs.close();           
		           return attendance;
	            }
	
		   
	
	
	          public static List<Attendance> getAllAttendance()throws Exception{
	        	      
	        	        List<Attendance>getAllAttdc = new ArrayList<Attendance>();
	        	        String query = "SELECT * FROM posv2.attendance";
	        	        Statement stmt = Database.getDatabaseConnection().createStatement();
	        	        ResultSet rs = stmt.executeQuery(query);
	        	        while(rs.next())
	        	          {
	        	        	
	        	        	attendance  = new Attendance();
	        	        	attendance.setAttenc_ID(rs.getBigDecimal(1));
	        	        	attendance.setAttenc_attendt_Id(rs.getBigDecimal(2));
	        	        	attendance.setAttendcFirstName(rs.getString(3));
	        	        	attendance.setAttendcLastName(rs.getString(4));
	        	        	attendance.setSignInTime(rs.getTime(5));
	        	        	attendance.setSignOutTime(rs.getTime(6));
	        	        	attendance.setDate(rs.getDate(7));
	        	        	getAllAttdc.add(attendance);
	        	        	
	        	          }
	        	        
	        	      return getAllAttdc;
	          } 
	
	
	          
	          
	}

	    

