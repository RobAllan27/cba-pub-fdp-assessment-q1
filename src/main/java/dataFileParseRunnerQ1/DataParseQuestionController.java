package dataFileParseRunnerQ1;

import fileWriters.FileOutputController;
import inputDataParsing.TransactionFileParser;

public class DataParseQuestionController {

		public static void executeAnalysis() {
			TransactionFileParser transactionFileParser = new TransactionFileParser();
			transactionFileParser.parseInputData();
			FileOutputController.invokeFileWriters();
		}

}
