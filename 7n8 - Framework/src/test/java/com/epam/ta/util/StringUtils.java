package com.epam.ta.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class StringUtils
{
	public static String getYesterdayDate(){
		return DateTimeFormatter.ofPattern("yyyy-0-dd").format(LocalDateTime.now());
	}
}
