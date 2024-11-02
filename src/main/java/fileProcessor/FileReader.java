package fileProcessor;

import java.io.IOException;
import java.util.List;

public interface FileReader {
	
	public String inputFileResourcePath = System.getProperty("user.dir") + "/src/main/resources/testdata/input/";
	public String outputFileResourcePath = System.getProperty("user.dir") + "/src/main/resources/testdata/output/";

	public String DEFAULT_INPUT_FILE_PATH = inputFileResourcePath + "car_input.txt";
	public String INPUT_PATH = System.getProperty("input_file_path", DEFAULT_INPUT_FILE_PATH);

	public String DEFAULT_OUTPUT_FILE_PATH = outputFileResourcePath + "car_output.txt";
	public String OUTPUT_PATH = System.getProperty("output_file_path", DEFAULT_OUTPUT_FILE_PATH);

    String getInputFileContent() throws IOException;
    List<String> getOutputFileContent() throws IOException;
    
    //Get Input/output by supplying fileName
    String getInputFileContent(String inputFilePath) throws IOException;
    List<String> getOutputFileContent(String outputFilePath) throws IOException;
    
    //Read from Mutiple files
    String getInputFileContentfromMutiplefiles(String inputDir) throws IOException;
    List<String> getOutputFileContentfromMutiplefiles(String outputDir) throws IOException;    
    
    
}