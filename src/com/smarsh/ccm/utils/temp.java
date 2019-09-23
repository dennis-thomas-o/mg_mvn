package com.smarsh.ccm.utils;

public class temp {

	public static void main(String[] args) {
		
		String st = "Test Emp sagar.ranjan@smarsh.com  ";
		
		st = st.trim();
		
		String st1 = st.substring(0, st.lastIndexOf(" "));
		
		String st2 = st.substring(st.lastIndexOf(" ")+1);
		
		System.out.println(st1);
		System.out.println(st2);
	}
	
}
