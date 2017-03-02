package hashingpackage;

import java.io.FileNotFoundException;
import java.util.List;

public class HashingJava {
	public static ObjectNode root = new ObjectNode();

	public static void main(String[] args) throws FileNotFoundException {		
		HashingFunction hashingFunction = new HashingFunction();
		DataSet dataSet = new DataSet();
		List<ObjectNode> objectNodeL = dataSet
				.readDataExcel("D:/Project/Algorithm Training/Algorithm/src/main/resources/data_test.xls");

		int count = objectNodeL.size();
		for (int i = 0; i < count; i++) {
			hashingFunction.putToTree(objectNodeL.get(i));
		}
		root = hashingFunction.searchTree(122838);

		if (root != null)
			System.out.println(root.classCode + ", " + root.className+", " + root.name + ", " + root.index + ", " + root.department
					+ ", " + root.instructorName + ", " + root.numberPhone);
		else
			System.out.println("Don't have!");

	}
}
