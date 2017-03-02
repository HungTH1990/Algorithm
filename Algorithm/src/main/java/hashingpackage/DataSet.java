package hashingpackage;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class DataSet {
	// Read data file text
	public List<ObjectNode> readDataSet(String path) throws FileNotFoundException {
		List<ObjectNode> objectNodeList = new ArrayList<ObjectNode>();
		File file = new File(path);
		Scanner scanner = new Scanner(file);
		while (scanner.hasNextLine()) {
			String line = scanner.nextLine();
			objectNodeList.add(readLineSet(line));
		}
		scanner.close();
		return objectNodeList;
	}
	
	// Read data file excel
	public List<ObjectNode> readDataExcel(String path) {
		List<ObjectNode> objectNodeList = new ArrayList<ObjectNode>();
		Workbook workbook;
		File file = new File(path);
		try {
			workbook = Workbook.getWorkbook(file);
			Sheet sheet = workbook.getSheet(0);
			int rows = sheet.getRows();
			int columns = sheet.getColumns();
			for (int i = 0; i < rows; i++) {
				ObjectNode objectNode = new ObjectNode();
				for (int j = 0; j < columns; j++) {
					Cell cell = sheet.getCell(j, i);
					String s = cell.getContents();
					if (j == 0) {
						objectNode.classCode = converString(s);
					} else if (j == 1) {
						objectNode.index = Integer.parseInt(s);
					} else if (j == 2) {
						objectNode.name = converString(s);
					} else if (j == 3) {
						objectNode.className = converString(s);
					} else if (j == 4) {
						objectNode.department = converString(s);
					} else if (j == 5) {
						objectNode.instructorName = converString(s);
					} else if (j == 6) {
						objectNode.numberPhone = converString(s);
					}
				}
				objectNodeList.add(objectNode);
			}
		} catch (BiffException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		return objectNodeList;
	}

	// Read data file
	public static ObjectNode readLineSet(String line) {
		ObjectNode objectNode = new ObjectNode();
		List<String> tokens = Arrays.asList(line.split("\\s"));
		for (int i = 0; i < tokens.size(); i++) {
			String s = tokens.get(i);
			if (i == 0) {
				objectNode.classCode = converString(s);
			} else if (i == 1) {
				objectNode.index = Integer.parseInt(s);
			} else if (i == 2) {
				objectNode.name = converString(s);
			} else if (i == 3) {
				objectNode.className = converString(s);
			} else if (i == 4) {
				objectNode.department = converString(s);
			} else if (i == 5) {
				objectNode.instructorName = converString(s);
			} else if (i == 0) {
				objectNode.numberPhone = converString(s);
			}
		}
		return objectNode;
	}

	public static Object converString(String s) {
		if (s.equals(""))
			return "null";
		else if (Pattern.matches("[a-zA-Z]{1,}", s))
			return s;
		else if (!Pattern.matches("[a-zA-Z]{1,}", s) || Pattern.matches("[0-9]{1,}", s))
			return s;
		else {
			if (s.contains("."))
				return Float.parseFloat(s);
			else
				return Integer.parseInt(s);
		}
	}

}
