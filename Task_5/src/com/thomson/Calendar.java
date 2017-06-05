package com.thomson;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.joda.time.Days;
import org.joda.time.LocalDate;

public class Calendar {

	public static void main(String[] args) {
		LocalDate date;
		DateFormatter md;

		Scanner sc = new Scanner(System.in);

		System.out.println("Choose method to get calendar :" + "\n1 - from one period for specified number of days"
				+ "\n2 - from one period of time to other ");

		switch (sc.nextInt()) {
		case 1:
			System.out.println("year: ");
			int year = sc.nextInt();
			System.out.println("month: ");
			int month = sc.nextInt();
			System.out.println("day: ");
			int day = sc.nextInt();

			System.out.println("Number of days: ");
			int period = sc.nextInt();

			System.out.println("\nThis is your calendar for " + period + " next days: \n");

			date = new LocalDate(year, month, day);

			md = new DateFormatter(date);

			// Print a list of data from one period for specified number of days
			printList(addDateToList(md, date, period));
			break;
		case 2:
			// Print a list of data from one period of time to other
			System.out.println("year: ");
			year = sc.nextInt();
			System.out.println("month: ");
			month = sc.nextInt();
			System.out.println("day: ");
			day = sc.nextInt();

			System.out.println("other year: ");
			int year2 = sc.nextInt();
			System.out.println("other month: ");
			int month2 = sc.nextInt();
			System.out.println("other day: ");
			int day2 = sc.nextInt();

			date = new LocalDate(year, month, day);
			LocalDate date2 = new LocalDate(year2, month2, day2);
			Days days = Days.daysBetween(date, date2);
			int limitDays = days.getDays();
			md = new DateFormatter(date);
			System.out.println(
					"\nThis is your calendar from " + date.toString() + " to " + date2.toString() + " next days: \n");
			printList(addDateToList(md, date, limitDays));
			break;
		default:
			sc.close();
		}
	}

	public static List<DateFormatter> addDateToList(DateFormatter sc, LocalDate date, int limit) {
		List<DateFormatter> list = new ArrayList<>();
		for (int i = 0; i < limit; i++) {
			date = sc.nextDay(date);
			sc = new DateFormatter(date);
			if (sc.isWeekday(date) == true) {
				list.add(sc);
			}
		}
		return list;
	}

	public static void printList(List<DateFormatter> list) {
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
	}
}
