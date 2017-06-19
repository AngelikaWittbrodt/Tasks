package com.thomson;

import java.util.Locale;

import org.joda.time.LocalDate;

public class DateFormatter  {

	private LocalDate localDate = new LocalDate(2017, 06, 02);
	private Locale local = new Locale("en");

	public DateFormatter(LocalDate localDate) {
		this.localDate = localDate;
	}

	public String getsDay() {
		return localDate.dayOfWeek().getAsShortText(local);
	}

	public String getsMonth() {
		return localDate.monthOfYear().getAsShortText(local);
	}

	public String getsYear() {
		return localDate.year().getAsText();
	}

	public LocalDate nextDay(LocalDate date) {
		return date.plusDays(1);
	}

	public boolean isWeekday(LocalDate localDate) {
		int day = localDate.getDayOfWeek();
		if (day == 6 || day == 7) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return getsDay() + " " + getsMonth() + " " + localDate.getDayOfMonth() + " " + getsYear();
	}


}