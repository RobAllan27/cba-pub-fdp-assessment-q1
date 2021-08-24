package inputDataParsing;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.TreeSet;

/**
 * Purpose of this class is simple - 
 *  - To determine if a line is valid data to be selected or not - 
 *  Its Single responsibility is to check form a set of rules if this is relevant data.
 *  - It does not determine how to select the data from any line -  defers that to a parse class.
 *  - Tests if line has either 2 quoets or instead is a hex piece of data
 * @author robma
 *
 */


public class LineSelector {

	public LineSelector() {
		// TODO Auto-generated constructor stub
	}

	public static void manipulateLineOfData(String stringLine, TreeSet<String> datacolumnsNames, 
			ArrayDeque<HashMap<String,String>> fullSetFoundData) {
			if (testLineIsDataLineWithQuotes(stringLine)) {
				LineParser.parseLineWithQuotes(stringLine, datacolumnsNames, fullSetFoundData);
			}
			if (testLineIsDataLineWithVoidString(stringLine)) {
				LineParser.parseLineWithVoid(stringLine, datacolumnsNames, fullSetFoundData);
			}		
	}
	
	//this row checks if the data line holds data or a structural line - data held in between quotes
	private static boolean testLineIsDataLineWithQuotes(String stringLine) {
		if(stringLine.chars().filter(ch -> ch == '"').count() == 2) {
			return true;
		}
		else return false;
	}
	
	//this row checks if the data line holds data or a structural line - data is hex data.
	//check if the line contains the string '[void '
	private static boolean testLineIsDataLineWithVoidString(String stringLine) {
		if(stringLine.indexOf("[void ") > 0) {
			return true;
		}
		else return false;
	}
	
}
