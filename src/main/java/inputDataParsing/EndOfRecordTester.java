package inputDataParsing;

import java.util.HashMap;

public class EndOfRecordTester {

	/* This single responsibility class is used to check if the end of record has occurred - 
	 * allows for future delimiters etc.
	 */
	public static boolean determineIfEndOfTransactionOccured(String lineOfData) {
		if(lineOfData.indexOf("SZ") > 0 && lineOfData.indexOf("[record") > 0) {
			return true;
		}
		return false;
	}

}
