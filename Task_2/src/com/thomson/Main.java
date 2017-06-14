package com.thomson;

import java.util.Map;
import java.util.Scanner;

public class Main {
	private static final String PATH = "http://www.mercado.ren.pt/EN/Electr/MarketInfo/Interconnections/CapForecast/Pages/Daily.aspx";
	private static String[] strMonths = { "Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov",
			"Dec" };

	public static void main(String[] args) {
		DataProvider data = new DataProvider();
		CapacityCalculator etc = new CapacityCalculator();

		// Creating a map of months and days from URL address and printing to console

		Map<Integer, String> dayAndMonthMap = data.getMonthsAndDays();
		data.printDayAndMonth(dayAndMonthMap);

		System.out.println("\nType number to calculate daily capacity: \n");

		Scanner sc = new Scanner(System.in);
		Integer number = sc.nextInt();

		int forecastCapacity = etc.calcForecastCapacity(number, PATH);
		int actualCapacity = etc.calcActualCapacity(number, PATH);

		Map<String, Integer> mapMonths = data.createMonthsMap(strMonths);

		String monthStr = data.getNewMonth(dayAndMonthMap, number);
		String month = data.printActualCapacity(mapMonths, monthStr);
		String day = data.getNewDay(dayAndMonthMap, number);

		System.out.println("Actual: 2017" + "-" + month + "-" + day + ": " + "<" + actualCapacity + ">");
		System.out.println("Forecast: 2017"+ "-" + month + "-" + day + ": " + "<" + forecastCapacity + ">");

		sc.close();
	}

}
