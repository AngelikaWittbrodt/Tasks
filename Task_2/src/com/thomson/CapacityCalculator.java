package com.thomson;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class CapacityCalculator {

	private List<Integer> valueList;
	private List<String> keyList;

	public int calcForecastCapacity(Integer column, String path) {
		valueList = new ArrayList<>();
		keyList = new ArrayList<>();
		Document doc;
		try {
			doc = Jsoup.connect(path).get();

			for (Element table : doc.select("table.gridALL")) {
				for (Element row : table.select("tr")) {
					Elements tds = row.select("td");

					if (tds.size() >= 16) {
						String key = tds.get(column).attr("class");
						String record = tds.get(column).text();
						int intRecord = Integer.parseInt(record);
						valueList.add(intRecord);
						keyList.add(key);
					}
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		int dayForecastCapacitySum = 0;

		for (int i = 0; i < 24; i++) {
			if (keyList.get(i).equals("txtrPREV")) {
				int one = valueList.get(i);
				dayForecastCapacitySum += one;
			}
		}
		return dayForecastCapacitySum;
	}
	
	public int calcActualCapacity(Integer column, String path) {
		valueList = new ArrayList<>();
		keyList = new ArrayList<>();
		Document doc;
		try {
			doc = Jsoup.connect(path).get();

			for (Element table : doc.select("table.gridALL")) {
				for (Element row : table.select("tr")) {
					Elements tds = row.select("td");

					if (tds.size() >= 16) {
						String key = tds.get(column).attr("class");
						String record = tds.get(column).text();
						int intRecord = Integer.parseInt(record);
						valueList.add(intRecord);
						keyList.add(key);
					}
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		int dayActualCapacitySum = 0;
		for (int i = 0; i < 24; i++) {
			if (keyList.get(i).equals("txtrVERIF")) {
				int one = valueList.get(i);
				dayActualCapacitySum += one;
			}
		}
		return dayActualCapacitySum;
	}
}
