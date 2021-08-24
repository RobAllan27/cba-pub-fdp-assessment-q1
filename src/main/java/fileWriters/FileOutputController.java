package fileWriters;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.TreeSet;

import inputDataParsing.InputParseResults;

public class FileOutputController {

		// The following method can be refactored to invoke multiple file writers (not just CSVs) - and perhaps refactor later
		public static void invokeFileWriters() {
			
			TreeSet<String> datacolumnsNames = InputParseResults.getDatacolumnsNames();
			ArrayDeque<HashMap<String,String>> fullSetFoundData = InputParseResults.getFullSetFoundData();
					
			CSVFileWriter csvFileWriter = new CSVFileWriter();
			int transactionFileNumber = 1;
	        while (!fullSetFoundData.isEmpty()) {
	        	csvFileWriter.initialiseFile(datacolumnsNames, transactionFileNumber);
	        	transactionFileNumber++;
	        	HashMap<String,String> foundVal = fullSetFoundData.removeFirst();
	            csvFileWriter.writeLine(datacolumnsNames, foundVal);
	        }
		}
}
