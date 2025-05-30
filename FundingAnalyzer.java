import java.io.*;
import java.util.*;

/*
 * Handles loading, sorting and analyzing funding data. Applies recursive merge sort, writes sorted data in an output text file, and provides an equity analysis for Indigenous communities.
 */
public class FundingAnalyzer{
    
    private List<FundingEntry> entries;
    
    /*
     *  Constructs an empty FundingAnalyzer
     */
    public FundingAnalyzer(){
        entries = new ArrayList<>();
    }
    
 /*
     * Loads funding entries from a text file and creates objects based on the text file meta data.
     * @param filename path to the input file
     * @throws IOException if the file access does not work
 */    
public void loadFromFile (String filename) throws IOException {
    Scanner sc = new Scanner (new File(filename));
    while(sc.hasNextLine()){
        String [] parts = sc.nextLine().split(",");
        String region = parts[0];
        String community = parts[1];
        String category = parts[2];
        boolean isIndigenous = Boolean.parseBoolean(parts[3]);
        double amount = Double.parseDouble(parts[4]);
    
        
        if(category.equalsIgnoreCase("Education") && parts.length == 6)
        {
            String schoolBoard = parts[5];
            entries.add(new EducationFundingEntry(region, community, isIndigenous, category, amount, schoolBoard));
        }
        
        else if (category.equalsIgnoreCase("Healthcare") && parts.length == 6)
        {
            String hospital = parts[5];
            entries.add(new HealthcareFundingEntry(region, community, isIndigenous, category, amount, hospital));
        }
        
        else
        {
            entries.add(new FundingEntry(region, community, isIndigenous, category, amount));
        }
    }
    
    sc.close();
}

/*
 * Recursively performs merge sort on the list of entries.
 * @param list the list needed to be sorted
 * @return a sorted list of funding entries
 */
private List<FundingEntry> mergeSort (List<FundingEntry> list) {
   if (list.size() <= 1)
   {
       return list;
   }
   
   int mid = list.size()/2;
    List <FundingEntry> left = mergeSort(list.subList(0, mid));
    List <FundingEntry> right = mergeSort(list.subList(mid, list.size()));
    
    return merge(left, right);
}

/*
 * Merges two halves of a sorted list.
 */
private List<FundingEntry> merge (List<FundingEntry> left, List<FundingEntry> right) {
    return mergeRecursive (left, right, 0, 0, new ArrayList<>());
}

/*
 * Recursively merges entries by comparing amounts of funding in descending order.
 */
private List<FundingEntry> mergeRecursive(List<FundingEntry> left, List<FundingEntry> right, int i, int j, List<FundingEntry> merged) {
    if (i >= left.size() && j>= right.size()) {
        return merged;
    }
    
    if (i < left.size() && (j>= right.size() || left.get(i).getAmount() >= right.get(j).getAmount())) {
        merged.add(left.get(i));
        return mergeRecursive (left, right, i+1, j, merged);
    }
    
    else
    {
        merged.add(right.get(j));
        return mergeRecursive (left, right, i, j+1, merged);
    }
}
    
/*
 * Writes all funding entries to a file and generates an equity analysis summary.
 * @param filename the file to write
 * @throws IOExcpetion if writing the file does not work
 */
public void writeNew (String filename) throws IOException {
    int indigenousCount = 0;
    int totalEntries = 0;
    double indigenousTotal = 0;
    double nonIndigenousTotal = 0;
    
    PrintWriter p = new PrintWriter (new FileWriter(filename));
    for (FundingEntry e:entries)
    {
        p.println(e.toString());
        if (e.isIndigenous()) {
            indigenousCount++;
            indigenousTotal += e.getAmount();
        }
        else {
            nonIndigenousTotal += e.getAmount();
        }
        totalEntries++;
    }
    
    p.println("");
    p.println("Equity Summary:");
    p.println("");
    p.println("Total Entries: " + totalEntries);
    p.println("Total Funding: $" + (indigenousTotal + nonIndigenousTotal));
    p.println("Indigenous Entries: " + indigenousCount);
    p.println("Indigenous Funding Total: $" + indigenousTotal);
    
    double indigenous = 100.0*indigenousTotal/(indigenousTotal+nonIndigenousTotal);
    p.println(String.format("Indigenous Funding: %.2f%%", indigenous));
    p.println(String.format("Non-Indigenous Funding: %.2f%%", 100-indigenous));
    
    if (indigenous < 25.0)
    {
        p.println("Conclusion: Indigenous Communities received disproportionately low funding.");
    }
    
    else
    {
        p.println("Conclusion: Indigenous Communities received equitable funding.");
    }
    p.close();
}

/*
 * Sorts the entries based on amount and writes the sorted entries in the output file.
 * @param outputFile file where the sorted entries are written
 * @throws IOException if writing the file does not work
 */
public void sort (String outputFile) throws IOException {
    entries = mergeSort(entries);
    writeNew(outputFile);
}
}