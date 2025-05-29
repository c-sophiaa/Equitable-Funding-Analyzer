public class EducationFundingEntry extends FundingEntry{
    
    private String schoolBoard;
    
    public EducationFundingEntry(String region, String community, boolean isIndigenous, String category, double amount, String schoolBoard) {
        super(region, community, isIndigenous, category, amount);
        this.schoolBoard = schoolBoard;
        
    }
    
    public String getSchoolBoard()
    {
        return schoolBoard;
    }
    
    public String toString() {
        return super.toString() + "," + schoolBoard;
    }
}
