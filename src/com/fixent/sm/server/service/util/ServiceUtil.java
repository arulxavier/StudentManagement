package com.fixent.sm.server.service.util;

import java.util.Calendar;
import java.util.Date;

public class ServiceUtil {
	
	public static int getYear(Date date) {
		
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		return calendar.get(Calendar.YEAR);
	}
	
	public static void main(String[] args) {
		getYear(new Date());
	}

}
