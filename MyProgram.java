import java.io.*;
/*
 * Begins the funding analysis application. Loads the input file, sorts data, and writes the output file. It also catches and reports any issues with the file.
*/
public class MyProgram
{
    
/*
 * Main method used to run the program. Includes loading input file, sorting data, writing output and handling I/O errors.
 * @param args
 */
    public static void main(String[] args)
    {
        FundingAnalyzer analyzer = new FundingAnalyzer();
        try {
            analyzer.loadFromFile("/Users/sophiachow/Desktop/funding_data.txt");
            analyzer.sort("/Users/sophiachow/Desktop/sorted_output.txt");
            System.out.println("Funding data sorted and saved to file.");
        }
        catch (IOException e) {
            System.out.println("Error");
        }
    }
}
