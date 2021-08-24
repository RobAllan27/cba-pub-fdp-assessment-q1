package inputDataParsing;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.TreeSet;

/** The purpose of this class is for lines that have been selected, to parse the lines and add values to the hashset
 * There is a fullset of data and we add to the last hashmapObject
 * We also proactively keep a list of All the found column names in a Sorted TreeSet. 
 * @author robma
 *
 */
public class LineParser {

	//We assume that data is held in the quoted section
	public static void parseLineWithQuotes(String stringLineOfData, TreeSet<String> datacolumnsNames, 
			ArrayDeque<HashMap<String,String>> fullSetFoundData) {
		String[] partsOfData=stringLineOfData.split("\"");  
		//Now lets get the token at the start of the string.		
		//String cleanedString = stringLineOfData.replaceAll("[\\n\\t ]", "");
		addDataToResultsSets(partsOfData[0],partsOfData[1],datacolumnsNames, fullSetFoundData);
	}
	
	public static void parseLineWithVoid(String stringLineOfData, TreeSet<String> datacolumnsNames, 
			ArrayDeque<HashMap<String,String>> fullSetFoundData) {
		String dataValue = stringLineOfData.substring(stringLineOfData.indexOf('['),stringLineOfData.indexOf(']'));
		String dataTypeWithTabsandSpaces = stringLineOfData.substring(0,stringLineOfData.indexOf('['));
		addDataToResultsSets(dataTypeWithTabsandSpaces,dataValue,datacolumnsNames, fullSetFoundData);
	}
	
	private static void addDataToResultsSets(String dataTypeWithTabsSpaces, String dataValue, TreeSet<String> datacolumnsNames, ArrayDeque<HashMap<String,String>> fullSetFoundData) {
		String dataTypeCleanedString = dataTypeWithTabsSpaces.replaceAll("[\\n\\t ]", "");
		datacolumnsNames.add(dataTypeCleanedString);
		fullSetFoundData.getLast().put(dataTypeCleanedString, dataValue);
		datacolumnsNames.add(dataTypeCleanedString);
	}
}
