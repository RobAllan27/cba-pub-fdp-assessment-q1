package inputDataParsing;

// we will create a Result Class - other elements might be added in future object to what is returned.

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.TreeSet;

public class InputParseResults {

	private static TreeSet<String> datacolumnsNames; 
	private static ArrayDeque<HashMap<String,String>> fullSetFoundData;
	
	/**
	 * @return the datacolumnsNames
	 */
	public static TreeSet<String> getDatacolumnsNames() {
		return datacolumnsNames;
	}
	
	/**
	 * @param datacolumnsNames the datacolumnsNames to set
	 */
	public static void setDatacolumnsNames(TreeSet<String> datacolumnsNames) {
		InputParseResults.datacolumnsNames = datacolumnsNames;
	}
	
	/**
	 * @return the fullSetFoundData
	 */
	public static ArrayDeque<HashMap<String, String>> getFullSetFoundData() {
		return fullSetFoundData;
	}
	
	/**
	 * @param fullSetFoundData the fullSetFoundData to set
	 */
	public static void setFullSetFoundData(ArrayDeque<HashMap<String, String>> fullSetFoundData) {
		InputParseResults.fullSetFoundData = fullSetFoundData;
	}
}
