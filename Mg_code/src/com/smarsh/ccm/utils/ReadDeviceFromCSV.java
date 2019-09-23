package com.smarsh.ccm.utils;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.yaml.snakeyaml.reader.StreamReader;

public class ReadDeviceFromCSV {
	
	
	
	public List<DeviceGetSet> readDeviceCSVAndMap(String path) {
		
		List<DeviceGetSet> devList = new ArrayList();
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
					DeviceGetSet dev = new DeviceGetSet();
					String[] values = line.split(",");

					dev.setCountryCode(values[0]);
					dev.setPhoneNumber(values[1]);
					dev.setImeiNumber(values[2]);
					dev.setMeid(values[3]);
					dev.setPin(values[4]);
					dev.setManufacturer(values[5]);
					dev.setModel(values[6]);
					dev.setPlatform(values[7]);
					dev.setPlatformVersion(values[8]);
					dev.setAppVersion(values[9]);
					dev.setGetOldMsgs(values[10]);
					dev.setToken(values[11]);
					dev.setActive(values[12]);

					devList.add(dev);

					
				}
				//lineNumber++;
			}

		} catch (Exception e) {
			System.out.println("Error while reading CSV File");
			e.printStackTrace();
		}

		return devList;
	}
}	


