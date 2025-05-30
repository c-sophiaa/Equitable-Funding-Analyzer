/*
 * Represents a funding entry specifically related to healthcare by creating a subclass of FundingEntry.
 */
public class HealthcareFundingEntry extends FundingEntry{
    private String hospitalName;
    
    /*
     * Constructs a HealthcareFundingEntry with healthcare specific attributes.
     * @param region the region receiving the funding
     * @param community the community receiving education funding
     * @param isIndigenous whether the community is Indigenous
     * @param category must be "Healthcare"
     * @param amount the funding amount in CAD
     * @param hospitalName the name of the hospital
     * @throws NullPointerException if hospitalName is null
     */
    public HealthcareFundingEntry(String region, String community, boolean isIndigenous, String category, double amount, String hospitalName) {
        super(region, community, isIndigenous, category, amount);
        this.hospitalName = hospitalName;
        
    }
    
    /*
     * Returns the hospital name.
     * @return the name of the hospital
     */
    public String getHospitalName()
    {
        return hospitalName;
    }
    
    /*
     * Formats the entry as a String.
     * @return String of the funding entry
     */
    @Override
    public String toString(){
        return super.toString() + "," + hospitalName;
    }
}