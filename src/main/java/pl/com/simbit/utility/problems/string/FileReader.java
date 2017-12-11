package pl.com.simbit.utility.problems.string;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import pl.com.simbit.utility.problems.classes.MapDoubleKey;

public class FileReader {

	private static Logger logger = LoggerFactory.getLogger(FileReader.class);

	public static String readProblemFile(String fileName) {
		try {
			StringBuilder sb = new StringBuilder();
			BufferedReader bufferedReader = getReader(fileName);
			String s;
			while ((s = bufferedReader.readLine()) != null) {
				sb.append(s);
				sb.append("\n");
			}
			return sb.toString();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	private static BufferedReader getReader(String fileName) throws FileNotFoundException {
		File file = new File("src/main/resources/files/" + fileName);
		try {
			logger.info("FILE " + file.getCanonicalPath());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		FileInputStream fileInputStream = new FileInputStream(file);
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream));
		return bufferedReader;
	}

	public static String readProblemFileInOneLine(String fileName) {
		return readProblemFile(fileName).replaceAll("\n", "");
	}

	public static String[] readProblemFileLines(String fileName) {

		List<String> list = new ArrayList<String>();
		try {
			BufferedReader bufferedReader = getReader(fileName);
			String s;
			while ((s = bufferedReader.readLine()) != null) {
				s = s.trim();
				if (!s.isEmpty()) {
					list.add(s);
				}
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return list.toArray(new String[] {});
	}

	public static MapDoubleKey<Integer, Integer, Integer> getLinesWithNumbersSeparatedWithSpaceForFileName(
			String fileName) {
		String[] fileLines = readProblemFileLines(fileName);
		return FileReader.getLinesWithNumbersSeparatedWithSpace(fileLines);
	}

	public static MapDoubleKey<Integer, Integer, Integer> getLinesWithNumbersSeparatedWithSpace(String[] arr) {
		MapDoubleKey<Integer, Integer, Integer> numbers = new MapDoubleKey<Integer, Integer, Integer>();

		int colNumber = 0;
		for (int rowNumber = 0; rowNumber < arr.length; rowNumber++) {
			String line = arr[rowNumber];
			StringBuilder sb = new StringBuilder();
			for (int j = 0; j < line.length(); j++) {
				char c = line.charAt(j);
				if (Character.isDigit(c) || c == '-') {
					sb.append(Character.toString(c));
				} else if (!sb.toString().trim().isEmpty()) {
					numbers.put(rowNumber, colNumber++, Integer.parseInt(sb.toString()));
					sb = new StringBuilder();
				}
			}
			if (!sb.toString().trim().isEmpty()) {
				numbers.put(rowNumber, colNumber++, Integer.parseInt(sb.toString()));
				sb = new StringBuilder();
			}
			colNumber = 0;
		}
		return numbers;
	}

	public static Set<String> getWordsSeparatedWithCommasWithoutQuotations(String file) {
		String[] words = file.replaceAll("\\\"", "").split(",");
		Set<String> set = new HashSet<String>();
		for (String word : words) {
			set.add(word.trim());
		}
		return set;
	}

	public static String[] getWordsSeparatedWithCommas(String file) {
		return file.split(",");
	}
}
