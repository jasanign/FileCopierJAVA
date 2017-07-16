import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;
/**
 * The purpose of this class is to copy content of one file to another
 * @author Gajjan Jasani
 * @version 2/11/2017
 */
public class FileCopier {
	
	/** Scanner for taking user input */
	private Scanner userInput;
	/** Constant for exiting program with error */
	private static final int EXIT_WITH_ERROR = 1;
	
	/**
	 * Constructor for FileCopier class
	 */
	public FileCopier() {
		userInput = new Scanner(System.in);
	}
	
	public void copyFile() {
	
		System.out.println("Please enter path for the input file:");
		String inputFile = userInput.nextLine();
		
		
		try (FileInputStream inputFileReader = 
								new FileInputStream(inputFile)){
			System.out.println("Please enter path for the output file:");
			String outputFile = userInput.nextLine();
			try(FileOutputStream outputFileWriter = 
					new FileOutputStream(outputFile, true)){
				byte[] buf = new byte[1024];
		        int length;
		        while((length = inputFileReader.read(buf))>0){
		        	outputFileWriter.write(buf,0,length);
		        }
			}
		}catch (FileNotFoundException fnfe) {
			System.out.println(fnfe.getLocalizedMessage());
	        System.exit(EXIT_WITH_ERROR);
		}catch (IOException ioe){
			System.out.println(ioe.getMessage());
	        System.exit(EXIT_WITH_ERROR);
		}
	}
	
	/**
	 * Main method for entry in the program
	 * @param args array of command line arguments (not being used)
	 */
	public static void main(String[] args) {
		
		FileCopier copyMaker = new FileCopier();
		copyMaker.copyFile();
		System.out.println("File copied successfully!");
	}
}