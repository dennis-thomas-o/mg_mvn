package com.smarsh.ccm.utils;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class ReadEmpFromCSV {

	public List<EmployeesGetSet> readCSVAndMapIt(String path) {

		/*
		 * System.setProperty("id", id); System.setProperty("assDevID", assDevID);
		 * System.setProperty("name", name); System.setProperty("email", email);
		 * System.setProperty("department", department); System.setProperty("regStatus",
		 * regStatus); System.setProperty("netGuardDev", netGuardDev);
		 * System.setProperty("verizonSet", verizonSet);
		 */

		List<EmployeesGetSet> csvList = new ArrayList();
		String line;
		int lineNumber = 0;
		BufferedReader br = null;

		try {
			br = new BufferedReader(new InputStreamReader(new FileInputStream(path), "utf-8"));
			while ((line = br.readLine()) != null) {
				if (lineNumber == 0) {
					Thread.sleep(1000);
					lineNumber++;

				} else {
					//lineNumber++;
					EmployeesGetSet emp = new EmployeesGetSet();
					String[] values = line.split(",");

					emp.setId(values[0]);
					emp.setAssDevID(values[1]);
					emp.setName(values[2]);
					emp.setEmail(values[3]);
					emp.setDepartment(values[4]);
					emp.setRegStatus(values[5]);
					emp.setNetGuardDev(values[6]);
					emp.setVerizonSet(values[7]);

					csvList.add(emp);

					
				}
				//lineNumber++;
			}

		} catch (Exception e) {
			System.out.println("Error while reading CSV File");
			e.printStackTrace();
		}

		return csvList;
	}

}
