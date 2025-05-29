import java.io.*;
public class MyProgram
{
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
