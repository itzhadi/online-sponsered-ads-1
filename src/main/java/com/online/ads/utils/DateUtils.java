package com.online.ads.utils;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

public class DateUtils {
	
	public static Date parseDate(long date_long) {
		Date date = null;
		try {
			String startDate = String.valueOf(date_long);
			String year = startDate.substring(0, 4);
			String month = startDate.substring(6, 8);
			String day = startDate.substring(4, 6);
			String strFormatDate = year + "-" + month + "-" + day;
			LocalDate localDateParsed = LocalDate.parse(strFormatDate);
			ZoneId defaultZoneId = ZoneId.systemDefault();
			date = Date.from(localDateParsed.atStartOfDay(defaultZoneId).toInstant());
		} catch (Exception e) {
			e.printStackTrace();
		}

		return date;
	}

	public static LocalDate convertToLocalDateViaInstant(Date dateToConvert) {
		return dateToConvert.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
	}

}
