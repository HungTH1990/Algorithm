package objectpackage;

import java.io.FileNotFoundException;

public class Test {
	public static void main(String... args) throws FileNotFoundException {
		String[][] objectStyles = ObjectDetect.allObjectDetect("jdbc:postgresql://localhost:5432/mydb", "postgres",
				"123456", "my_table");
		for (int i = 0; i < objectStyles.length; i++)
			for (int j = 0; j < objectStyles[i].length; j++)
				System.out.println(objectStyles[i][j]);
	}
}
