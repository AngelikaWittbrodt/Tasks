package com.thomson;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputStreamReader {

	private static final String path = "http://www.nhc.noaa.gov/data/hurdat/hurdat2-nepac-1949-2016-041317.txt";
	private static String currentLine = "";
	private static List<String> list;

	public static void main(String[] args) throws IOException {

		System.out.println(printMaxWind("2009"));
	}

	public static List<String> printMaxWind(String prefix) {
		list = new ArrayList<>();
		URL url;
		try {
			url = new URL(path);
			Scanner sc = new Scanner(url.openStream());
			while (sc.hasNextLine()) {
				currentLine = sc.nextLine();
				String[] array = currentLine.split(",");
				if (array[0].endsWith(prefix) & array.length == 3) {
					list.add(array[1].trim());
				}
				if (array[0].startsWith(prefix)) {
					if (array.length > 3) {
						list.add(array[6].trim());
					}
				}
			}
			sc.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return list;
	}
}
