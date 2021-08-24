package fileWriters;

import java.util.HashMap;
import java.util.TreeSet;

/**
 * @author robma
 *
 */
public interface FileWriterContract {

	public void initialiseFile(TreeSet<String> setofColumStrings, int fileSerialNumber);
	
	public void writeLine(TreeSet<String> setofColumnStrings, HashMap<String, String> valuesAndKey);

}
