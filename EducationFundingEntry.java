/*
 * Represents a funding entry specifically for education by creating a subclass of FundingEntry.
 */
public class EducationFundingEntry extends FundingEntry{
    
    private String schoolBoard;
    
    /*
     * Constructs an EducationFundingEntry with education specific attributes.
     * @param region the region receiving funding
     * @param community the community receiving education funding
     * @param isIndigenous true if the community is Indigenous
     * @param category must be "Education"
     * @param amount the funding amount
     * @param schoolBoard the name of the school board
     * @throws NullPointerException if the schoolBoard is null
     */
    public EducationFundingEntry(String region, String community, boolean isIndigenous, String category, double amount, String schoolBoard) {
        super(region, community, isIndigenous, category, amount);
        this.schoolBoard = schoolBoard;
        
    }
    
    /*
     * Returns the school board name.
     * @return the name of the school board
     */
    public String getSchoolBoard()
    {
        return schoolBoard;
    }
    
    /*
     * Formats the entry as a String.
     * @return String of the funding entry
     */
    @Override
    public String toString() {
        return super.toString() + "," + schoolBoard;
    }
}
