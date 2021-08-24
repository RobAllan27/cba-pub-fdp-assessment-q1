package inputDataParsing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.TreeSet;


// the purpose of this class is to choreograph the handling of a file.
//  - It opens a file and then parses to each row - and keeps a record of the results. 
//  - It defers the handling of the each row to a class that determines if the data is valid.

public class TransactionFileParser {

	private TreeSet<String> datacolumnsNames; 
	private ArrayDeque<HashMap<String,String>> fullSetFoundData;

	/* Design choice to use ArrayDeque to hold record data 
	 - we need to add new sets of transaction records
	 - we need to take the records off the front when we write them out tot he CSV
	No need to access the middle of the array..
	
	Design choice to use a TreetSet for the Column names as it is auto-sorted and avoids duplicates - as it is a set.
	*/


	public TransactionFileParser() {
		// TODO Auto-generated constructor stub


		fullSetFoundData = new ArrayDeque<HashMap<String,String>>();
		datacolumnsNames = new TreeSet<String>();
		HashMap<String,String> firstTransactionRecord = new HashMap<String,String>();
		fullSetFoundData.add(firstTransactionRecord);
	}


	public void parseInputData() {

		String fileName = "dataParseInputFile/q1.test_data";

		InputStream is = getFileFromResourceAsStream(fileName);

		try (InputStreamReader streamReader =
				new InputStreamReader(is, StandardCharsets.UTF_8);
				BufferedReader reader = new BufferedReader(streamReader)) {

			String line;
			while ((line = reader.readLine()) != null) {
				LineSelector.manipulateLineOfData(line,datacolumnsNames, fullSetFoundData);
				boolean temp1 = EndOfRecordTester.determineIfEndOfTransactionOccured(line);
				if(EndOfRecordTester.determineIfEndOfTransactionOccured(line))
				{
						HashMap<String,String> transactionRecord = new HashMap<String,String>();
						fullSetFoundData.add(transactionRecord);
				}
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

		InputParseResults.setDatacolumnsNames(datacolumnsNames);
		InputParseResults.setFullSetFoundData(fullSetFoundData);
	}

	private InputStream getFileFromResourceAsStream(String fileName) {

		ClassLoader classLoader = getClass().getClassLoader();
		InputStream inputStream = classLoader.getResourceAsStream(fileName);

		if (inputStream == null) {
			throw new IllegalArgumentException("Sorry Input file not found! " + fileName);
		} else {
			return inputStream;
		}
	}
}
