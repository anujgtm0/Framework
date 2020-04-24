package com.tmz.Framework.UIAutomation.Utilities;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class DateTime
{
	  static TimeZone timeZone = TimeZone.getTimeZone("IST");
      String dateFormat = "yyyy-MM-dd"; //MMMM dd,yyyy G
      static String timeFormat = "hh:mm:ss.SSS'Z'";
      String dayFormat = "EEEEEE";
      static String timeFormat1 = "hh_mm_ss";
	 static DateTime obtainDate = new DateTime();
	/*
	 * public static void main(String[]args) {
	 * 
	 * 
	 * 
	 * 
	 * System.out.println("Current Date Time:" + obtainDate.Getcurrentdatetime());
	 * 
	 * }
	 */

  /**
   * Description - Method to Get Today's day
   * @author Chaitanya
   * @param dateFormat
   * @param TimeZone
   */
  public String getTodaysDay(String dayFormat, TimeZone timeZone)
  {
      Date date = new Date();
      /* Specifying the format */
      DateFormat requiredFormat = new SimpleDateFormat(dayFormat);
      /* Setting the Timezone */
      requiredFormat.setTimeZone(timeZone);
      /* Picking the day value in the required Format */
      String strCurrentDay = requiredFormat.format(date).toUpperCase();
      return strCurrentDay;
   }

   /**
    * Description - Method to Get Current time
    * @author Chaitanya
    * @param dateFormat
    * @param TimeZone
    */
   public String getCurrentTime(String timeFormat, TimeZone timeZone)
   {
      /* Specifying the format */ 
      DateFormat dateFormat = new SimpleDateFormat(timeFormat);
      /* Setting the Timezone */
      Calendar cal = Calendar.getInstance(timeZone);
      dateFormat.setTimeZone(cal.getTimeZone());
      /* Picking the time value in the required Format */
      String currentTime = dateFormat.format(cal.getTime());
		/* currentTime=currentTime+"Z"; */
      return currentTime;
   }

   /**
    * Description - Method to Get Today's date
    * @author Chaitanya
    * @param dateFormat
    * @param TimeZone
    */
   public String getTodayDate(String dateFormat, TimeZone timeZone)
   {
       Date todayDate = new Date();
       /* Specifying the format */
       DateFormat todayDateFormat = new SimpleDateFormat(dateFormat);
       /* Setting the Timezone */
       todayDateFormat.setTimeZone(timeZone);
       /* Picking the date value in the required Format */
       String strTodayDate = todayDateFormat.format(todayDate);
       strTodayDate=strTodayDate+"T";
       return strTodayDate;
   }
   public String Getcurrentdatetime() {
	   String Date=obtainDate.getTodayDate(dateFormat,timeZone);
	   String Time= obtainDate.getCurrentTime(timeFormat,timeZone);
	   String dateformat=Date+Time;
	   System.out.println("Current Date Time is "+dateformat);
	return dateformat;
	   
   }
   public String Getcurrentdatetime1() {
	   String Date=obtainDate.getTodayDate(dateFormat,timeZone);
	   String Time= obtainDate.getCurrentTime(timeFormat1,timeZone);
	   String dateformat=Date+Time;
	   System.out.println("Current Date Time is "+dateformat);
	return dateformat;
	   
   }
}