package fileWriters;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.TreeSet;

import com.opencsv.CSVWriter;

//import com.opencsv.CSVWriter;

// to interface

public class CSVFileWriter implements FileWriterContract {

	private static File file;
	
	public void initialiseFile(TreeSet<String> setofColumnStrings, int fileSerialNumber) {

		String pathForCSVFile = "output/parsedresults_" + fileSerialNumber + ".csv" ;
		
		file = new File(pathForCSVFile);
		
		if(file.exists()) {
			System.out.println("******** Sorry Please delete the existing results from the Output folder **********" );
			System.exit(-1);
		}

	
			FileWriter outputFile;
			try {
				outputFile = new FileWriter(file, true);
				CSVWriter writer = new CSVWriter(outputFile);
				
				writer.writeNext(setofColumnStrings.toArray(new String[setofColumnStrings.size()]));
				writer.close();
			} catch (IOException e1) { e1.printStackTrace(); }	
	}

	public void writeLine(TreeSet<String> setofColumnStrings, HashMap<String, String> valuesAndKeyRecord) {

		String[] setofValuesToAdd = new String[setofColumnStrings.size()];
		int entryCountInOutputArray = 0;
		for (String foundColumnsName : setofColumnStrings) {	
			if (valuesAndKeyRecord.containsKey(foundColumnsName)) {
				setofValuesToAdd[entryCountInOutputArray] = valuesAndKeyRecord.get(foundColumnsName);
			} else {
				setofValuesToAdd[entryCountInOutputArray] ="";
			}
			entryCountInOutputArray++;
		}

		FileWriter outputFile;
		try {
			outputFile = new FileWriter(file, true);
			CSVWriter writer = new CSVWriter(outputFile);

			writer.writeNext(setofValuesToAdd);
			writer.close();
		} catch (IOException e1) 
		{
			e1.printStackTrace(); 
		}	
	}	
}
