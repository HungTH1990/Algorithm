package objectpackage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Quartile {

	public float quartileOfArray(float p, List<String> litString) {
		int n = litString.size();
		List<Float> litStringFloat = new ArrayList<Float>();
		if (n <= 6) {
			return -1;
		}

		for (int i = 0; i < n; i++) {
			try {
				if (litString.get(i) == null)
					continue;
				Float StringFloat = Float.parseFloat(litString.get(i));
				litStringFloat.add(StringFloat);
			} catch (NumberFormatException e) {
				continue;
			}
		}

		Collections.sort(litStringFloat);

		float quar, y;
		y = (n + 1) * p;
		if (y == (int) y) {
			quar = litStringFloat.get((int) y);
		} else {
			int y1 = (int) y;
			int y2 = (int) (y + 1);
			float oy1 = litStringFloat.get(y1);
			float oy2 = litStringFloat.get(y2);
			quar = (float) ((oy2 + oy1) * 0.5);
		}
		return quar;
	}

	public String quartileOfColumn(List<String> listString) {
		float quar1 = quartileOfArray((float) 0.25, listString);
		float quar2 = quartileOfArray((float) 0.5, listString);
		float quar3 = quartileOfArray((float) 0.75, listString);
		return "; Quartile 1: " + quar1 + "; Quartile 2: " + quar2 + "; Quartile 3: " + quar3;
	}
}
