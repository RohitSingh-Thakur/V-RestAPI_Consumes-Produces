package com.v.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TimeStampUtil {

	public static String getTimeStamp() {
		
		 LocalDateTime now = LocalDateTime.now();
	        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
	        return now.format(formatter);
	}
	
}
