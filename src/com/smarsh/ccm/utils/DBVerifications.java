package com.smarsh.ccm.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.smarsh.ccm.pages.EmployeeViewPage;

public class DBVerifications {

	ResultSet rs;

	public Statement mgDBConnectivity(String dbUrl, String dbUsername, String dbPassword) {

		Statement mobileguardDBstmt = null;
		Connection MobileguradConn;
		String MobileguardbURL;
		String driverName;

		try {

			driverName = "com.microsoft.sqlserver.jdbc.SQLServerDriver"; // Start
																			// JDBC
			MobileguardbURL = dbUrl + ";user=" + dbUsername + ";password=" + dbPassword;

			System.out.println("Mobilegurad db url now is " + MobileguardbURL);

			Class.forName(driverName);
			MobileguradConn = DriverManager.getConnection(MobileguardbURL);
			mobileguardDBstmt = MobileguradConn.createStatement();

			System.out.println("Connection have been Created ");
		} catch (Exception e) {
			System.out.println("Error in DB Connection");
			e.printStackTrace();
		} finally {
			return mobileguardDBstmt;
		}

	}

	public static int verifyNumOfContacts(String email, Statement stmt) {
		int contactsCount = 0;
		int employeeID = 0;
		String getEmpIDQuery = "SELECT employee_id FROM employee WHERE email = '" + email + "'";

		List<String> phNumList = new ArrayList();
		try {
			ResultSet rs1 = stmt.executeQuery(getEmpIDQuery);
			while (rs1.next()) {
				employeeID = rs1.getInt("employee_id");
				System.out.println("employee id is = " + employeeID);
			}

			String getNumOfCOntacts = "Select count(phone_number) as count from employee_contact where employee_id = '"
					+ employeeID + "'";

			ResultSet rsNumOfContacts = stmt.executeQuery(getNumOfCOntacts);

			while (rsNumOfContacts.next()) {
				contactsCount = rsNumOfContacts.getInt("count");
			}

			/*
			 * ResultSetMetaData rsmd = rsNumOfContacts.getMetaData(); int countOfContacts =
			 * rsmd.getColumnCount();
			 */
			System.out.println("Num of contacts = " + contactsCount);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return contactsCount;

	}

	public static List<String> verifyContactLists(String email, Statement stmt) {
		List<String> phoneNumbersInDB = new ArrayList();
		int contactsCount = 0;
		int employeeID = 0;
		String getEmpIDQuery = "SELECT employee_id FROM employee WHERE email = '" + email + "'";

		List<String> phNumList = new ArrayList();
		try {
			ResultSet rs1 = stmt.executeQuery(getEmpIDQuery);
			while (rs1.next()) {
				employeeID = rs1.getInt("employee_id");
				System.out.println("employee id is = " + employeeID);
			}

			String getContacts = "Select phone_number from employee_contact where employee_id = '" + employeeID + "'";
			ResultSet rsContactNumbers = stmt.executeQuery(getContacts);
			while (rsContactNumbers.next()) {
				String ctcNum = rsContactNumbers.getString("phone_number");
				phoneNumbersInDB.add(ctcNum);

			}
			System.out.println("Observed phone numbers from DB are : " + phoneNumbersInDB);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return phoneNumbersInDB;
	}
	
	public static List<Integer> verifyNumOfMsgs(String email, Statement stmt) {
		int employeeID = 0;
		int totalMsg = 0;
		int monthMsg = 0;
		int dayMsg = 0;
		int hourMsg = 0;
		List<Integer> msgCount = new ArrayList();
		String getEmpIDQuery = "SELECT employee_id FROM employee WHERE email = '" + email + "'";		
		List<String> phNumList = new ArrayList();
		try {
			ResultSet rs1 = stmt.executeQuery(getEmpIDQuery);
			while (rs1.next()) {
				employeeID = rs1.getInt("employee_id");
				System.out.println("employee id is = " + employeeID);
			}
			String queryTotalMsgs = "select count(message_id) as total_msg_count from message where employee_id = " + employeeID;
			String queryNumOfMsgsinCurrMonth = "select count(message_id) as currmonth_msg_count from message where employee_id =" + employeeID + 
				"and datepart(month,utc_timestamp) = month(getdate()) and datepart(year,utc_timestamp) = year(getdate())";
			String queryMsgsToday = "select count(message_id) as msgs_count_today from message where employee_id =" + employeeID + " and\r\n" + 
					"datepart(hour,timestamp) = datepart(hour, getDate()) and\r\n" + 
					"datepart(day,timestamp) = datepart(day, getDate()) \r\n" + 
					"and datepart(month,timestamp) = month(getdate()) \r\n" + 
					"and datepart(year,timestamp) = year(getdate())";
			String queryMsgsinLastHour = "select count(message_id) as msg_count_hour from message where employee_id =" + employeeID + " and\r\n" +  
					"datepart(day,timestamp) = datepart(day, getDate()) \r\n" + 
					"and datepart(month,timestamp) = month(getdate()) \r\n" + 
					"and datepart(year,timestamp) = year(getdate())";
			
			ResultSet rsTotal = stmt.executeQuery(queryTotalMsgs);
			while(rsTotal.next()) {
				totalMsg = rsTotal.getInt("total_msg_count");
				System.out.println("Total msgs = " + totalMsg);
			}
			
			ResultSet rsMonth = stmt.executeQuery(queryNumOfMsgsinCurrMonth);
			while(rsMonth.next()) {
				monthMsg = rsMonth.getInt("currmonth_msg_count");
				System.out.println("Number of messages in this month = " + monthMsg);
			}
			
			ResultSet rsToday = stmt.executeQuery(queryMsgsToday);
			while(rsToday.next()) {
				dayMsg = rsToday.getInt("msgs_count_today");
				System.out.println("Number of messages today = " + dayMsg);
			}
			
			ResultSet rsHour = stmt.executeQuery(queryMsgsinLastHour);
			while(rsHour.next()) {
				hourMsg = rsHour.getInt("msg_count_hour");
				System.out.println("Messages transferred in last hour = " + hourMsg);
			}
			
			
			msgCount.add(0,totalMsg);
			msgCount.add(1,monthMsg);
			msgCount.add(2,dayMsg);
			msgCount.add(3,hourMsg);
			
	} catch(Exception e) {
		e.printStackTrace();
	}
		
		return msgCount;
}
}
