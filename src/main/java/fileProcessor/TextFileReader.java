package fileProcessor;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;




public class TextFileReader implements FileReader {

    @Override
    public String getInputFileContent() throws IOException {
        return Files.readString(Paths.get(INPUT_PATH));
    }

    @Override
    public List<String> getOutputFileContent() throws IOException {
        List<String> lines =  Files.readAllLines(Paths.get(OUTPUT_PATH), StandardCharsets.US_ASCII);
        lines.remove(0);
        return lines;
    }

	@Override
	public String getInputFileContent(String inputFileName) throws IOException {
		// TODO Auto-generated method stub
		return Files.readString(Paths.get(inputFileResourcePath + inputFileName));
	}

	@Override
	public List<String> getOutputFileContent(String outputFileName) throws IOException {
		// TODO Auto-generated method stub
		List<String> lines =  Files.readAllLines(Paths.get(outputFileResourcePath + outputFileName), StandardCharsets.US_ASCII);
        lines.remove(0);
        return lines;	}

	@Override
	public String getInputFileContentfromMutiplefiles(String inputDir) throws IOException {
		File dir = new File(inputDir);
        File[] files = dir.listFiles();
        String textBuffer = null ;
        // Fetching all the files
        for (File file : files) {
            if(file.isFile()) {
            	System.out.println(file.getAbsolutePath());
            	textBuffer = textBuffer +  Files.readString(Paths.get(file.getAbsolutePath()));
            }
        }
        System.out.println(textBuffer);
        return textBuffer; 
	   }
	

	@Override
	public List<String> getOutputFileContentfromMutiplefiles(String outputDir) throws IOException {
		File dir = new File(outputDir);
        File[] files = dir.listFiles();
        List<String> lines = null;
        String textBuffer = null ;
        for (File file : files) {
            if(file.isFile()) {
            	System.out.println(file.getAbsolutePath());
            	textBuffer = textBuffer +  Files.readString(Paths.get(file.getAbsolutePath()));
            }
        }
		lines = new ArrayList <String>(Arrays.asList(textBuffer.split("\\r?\\n")));
        return lines; 
	   }
    
}