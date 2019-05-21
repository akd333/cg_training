package com.cg.lab3;

import java.time.LocalTime;
import java.time.ZoneId;
public class TimeZone {
  public static void main(String... args) {
    ZoneId zone1 = ZoneId.of("Europe/Berlin");
    ZoneId zone2 = ZoneId.of("Brazil/East");
    ZoneId zone3 = ZoneId.of("America/New_York");
    ZoneId zone4 = ZoneId.of("Europe/London");
    ZoneId zone5 = ZoneId.of("Asia/Tokyo");
    ZoneId zone6 = ZoneId.of("US/Pacific");
    ZoneId zone7 = ZoneId.of("Africa/Cairo");
    ZoneId zone8 = ZoneId.of("Australia/Sydney");
    

    System.out.println("Local time of Europe/Berlin is : "+LocalTime.now(zone1));
    System.out.println("Local time of Brazil/East is : "+LocalTime.now(zone2));
    System.out.println("Local time of America/New_York is : "+LocalTime.now(zone3));
    System.out.println("Local time of Europe/London is : "+LocalTime.now(zone4));
    System.out.println("Local time of Asia/Tokyo is : "+LocalTime.now(zone5));
    System.out.println("Local time of US/Pacific is : "+LocalTime.now(zone6));
    System.out.println("Local time of Africa/Cairo is : "+LocalTime.now(zone7));
    System.out.println("Local time of Australia/Sydney is : "+LocalTime.now(zone8));

  }
}
