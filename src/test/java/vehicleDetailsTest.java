import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import helper.searchRegistrationNumber;
import fileProcessor.FileReader;
import fileProcessor.FileReaderFactory;
import pages.detailsPage;
import pages.homePage;


import java.io.IOException;
import java.util.List;


public class vehicleDetailsTest{

	protected WebDriver _driver;
	public homePage hpage;
	public detailsPage dpage;

	private FileReader textFileReader;
	private searchRegistrationNumber searchRegistrationNumber;
	
	
	 @Before
	 public void setup() {
		 	hpage = new homePage(_driver);
			hpage.acceptCookies();
	        textFileReader = FileReaderFactory.provideFileReader("text");
	        searchRegistrationNumber = new searchRegistrationNumber();
	    }

	 
    @Test
    public void searchVehilceDetails() throws IOException
    {
    	
    	
    	textFileReader = FileReaderFactory.provideFileReader("text");
    	/***** Reading from single file *****************************************/
        //List<String> inputRegList = searchRegistrationNumber.find(textFileReader.getInputFileContent());
        //List<String> outputLines = textFileReader.getOutputFileContent();
    	
    	/************* Reading from multiple file *******************************/
    	 List<String> inputRegList = searchRegistrationNumber.find(textFileReader.getInputFileContentfromMutiplefiles(FileReader.inputFileResourcePath));
         List<String> outputLines = textFileReader.getOutputFileContentfromMutiplefiles(FileReader.outputFileResourcePath);
         inputRegList
                .forEach(
                        reg -> {
                        	
                        	
                        	//Search Vehicle
                        	hpage.searchVehicle(reg);
                        	_driver = hpage.getDriver();
                        	
                        	 dpage =  new detailsPage(_driver);
                        	 
                        	//Extract Actial Vehicle Details
                            String actual = dpage.getCarDetails(reg);
                            
                            //Compare with output file
                            verifyInEachOutputLine(outputLines, reg, actual);
                            //_driver = dpage.getDriver();
                            
                        	//Go Back
                            dpage.goBack();
                            
                        });
        			dpage.disposeDriver();
    }
    
    @After
    public void AfterTest() {
    	dpage.disposeDriver();
    }
    
    private void verifyInEachOutputLine(List<String> outputLines, String reg, String actual) {
        outputLines
                .stream()
                .filter(expectedLine -> expectedLine.split(",")[0].equals(reg))
                .forEach(expectedLine -> printStatus(reg, actual, expectedLine));
    }
    
    private void printStatus(String reg, String actual, String expectedLine) {
        System.out.println(actual);
        System.out.println(expectedLine);
        String actualString = actual;
        String expectedString = expectedLine;
        
        //Comment/Uncomment below as necessary
        Assert.assertTrue("Vehicle MATCH",actualString.equals(expectedString));    	//Assert.(actual.toString(), expectedLine.toString(), reg + ": " + (expectedLine.equals(actual) ? "MATCHED" : "NOT MATCHED"));
     
        System.out.println("=====================================================================");
        System.out.println(reg + ": " + (expectedLine.equals(actual) ? "MATCHED" : "NOT MATCHED"));
        System.out.println("=====================================================================");
    }
    

}
