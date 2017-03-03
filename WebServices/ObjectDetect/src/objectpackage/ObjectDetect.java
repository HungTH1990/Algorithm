package objectpackage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Pattern;

public class ObjectDetect {

	static Quartile quartile = new Quartile();

	public static String[][] allObjectDetect(String hostName, String userName, String password, String tableName) {
		int i = 0;
		DataSet dataSet = new DataSet(hostName, userName, password);
		HashMap<String, List<String>> allObject = dataSet
				.readDataFromPostgreSQL("SELECT * FROM " + tableName + " LIMIT 100;");

		String[][] ObjectStyles = new String[allObject.size()][2];

		for (String key : allObject.keySet()) {
			ObjectStyles[i][0] = key;
			List<String> listString = allObject.get(key);
			ObjectStyles[i][1] = objectDetect(listString, key);
			i++;
		}

		return ObjectStyles;
	}

	public static String objectDetect(List<String> listString, String label) {
		int count = listString.size();
		List<String> listStringNew = new ArrayList<String>();
		String allString = "";
		int matcherCount = 0;

		for (int i = 0; i < count; i++) {
			if (listString.get(i) == null) {
				continue;
			}
			listStringNew.add(listString.get(i));
			allString += listString.get(i);
			matcherCount++;
		}
		if (matcherCount <= 2) {
			return "Can't bbject detect!";
		}
		matcherCount = (int) (matcherCount * 0.9) - 1;

		Pattern patternString = Pattern.compile(".*[a-zA-Z].*");
		if (patternString.matcher(allString).matches()) {// co ky tu
			for (int i = 0; i < count - 1; i++) {
				if (listString.get(i) == null || listString.get(i + 1) == null) {
					continue;
				}
				if (listString.get(i).length() != listString.get(i + 1).length()) {
					return "Free tex";
				}
				if (!(listString.get(i).equals("t") || listString.get(i).equals("f"))) {
					return "String";
				}
			}
			return "Boolean";
		} else {// So,toa do
			Pattern patternInteger = Pattern.compile("[0-9\\s]{0,}");
			if (patternInteger.matcher(allString).matches()) {// So nguyen
				Pattern patternBit = Pattern.compile(".*[2-9].*");
				String quar = "";
				if (patternBit.matcher(allString).matches()) {
					return "Integer " + quar;
				}
				for (int i = 0; i < count - 1; i++) {
					if (listString.get(i) == null || listString.get(i + 1) == null) {
						continue;
					}
					if (listString.get(i).length() != listString.get(i + 1).length()) {
						return "Integer " + quar;
					}
				}
				return "Bit";
			} else {// So thuc, toa do
				Pattern patternDouble = Pattern.compile(".*[0-9][\\.][0-9].*");
				Pattern patternPoint = Pattern.compile(
						".*[\\(][\\-]{0,1}[0-9]{0,}[\\.]{0,1}[0-9]{0,}[\\,][\\s]{0,}[\\-]{0,1}[0-9]{0,}[\\.]{0,1}[0-9]{0,}[\\)].*");
				Pattern patternCoordinates = Pattern.compile(
						".*[\\(][\\-]{0,1}[0-9]{1,2}[\\.][0-9]{0,}[\\,][\\s]{0,}[0-9]{0,}[\\.][0-9]{0,}[\\)].*");
				if (patternPoint.matcher(allString).matches()) {// So thuc
					return "Point";
				} else if (patternCoordinates.matcher(allString).matches()) {// Kieu
																				// diem
					return "Coordinates";
				} else if (patternDouble.matcher(allString).matches()) {// Kieu
																		// toa
																		// do
					String quar = "";
					quar = quartile.quartileOfColumn(listStringNew);
					return "Double" + quar;
				} else {
					return "Other Styles";
				}
			}

		}
	}
}
