package pl.com.simbit.utility.file;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.IOUtils;

public class FileReader {

	public static final String TAB_SPLIT_REGEX = "\t";

	public static List<Integer> fileAsDigits(InputStream fileStream) {
		try {
			String file = IOUtils.toString(fileStream);
			List<Integer> numbers = new ArrayList<Integer>();
			for (int i = 0; i < file.length(); i++) {
				numbers.add(Integer.parseInt(file.substring(i, i + 1)));
			}
			return numbers;
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}

	public static List<String> readLines(InputStream fileStream) {
		try {
			List<String> file = IOUtils.readLines(fileStream);
			return file;
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}

	public static String firstLine(InputStream fileStream) {
		return readLines(fileStream).get(0);
	}

	public static List<Integer> readLinesAsNumbers(InputStream fileStream) {
		List<Integer> numbers = new ArrayList<Integer>();
		for (String line : readLines(fileStream)) {
			numbers.add(Integer.parseInt(line));
		}
		return numbers;
	}

	public static List<List<Integer>> readNumberMatrix(InputStream fileStream) {
		return readNumberMatrixForSeparator(fileStream, TAB_SPLIT_REGEX);
	}

	public static List<List<Integer>> readNumberMatrixForSeparator(InputStream fileStream, String separator) {
		List<List<Integer>> matrix = new ArrayList<List<Integer>>();
		for (List<String> singleLine : readMatrix(fileStream, separator)) {
			List<Integer> singleLineNumbers = new ArrayList<Integer>();
			for (String stringNumber : singleLine) {
				singleLineNumbers.add(Integer.parseInt(stringNumber));
			}
			matrix.add(singleLineNumbers);
		}
		return matrix;
	}

	public static List<List<String>> readMatrix(InputStream fileStream, String separator) {
		List<List<String>> matrix = new ArrayList<List<String>>();
		List<String> fileLines = FileReader.readLines(fileStream);
		for (String singleLine : fileLines) {
			List<String> singleLineNumbers = new ArrayList<String>();
			for (String stringNumber : singleLine.split(separator)) {
				singleLineNumbers.add(stringNumber);
			}
			matrix.add(singleLineNumbers);
		}
		return matrix;
	}
}
