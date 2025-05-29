public class HealthcareFundingEntry extends FundingEntry{
    private String hospitalName;
    
    public HealthcareFundingEntry(String region, String community, boolean isIndigenous, String category, double amount, String hospitalName) {
        super(region, community, isIndigenous, category, amount);
        this.hospitalName = hospitalName;
        
    }
    
    public String getHospitalName()
    {
        return hospitalName;
    }
    
    public String toString(){
        return super.toString() + "," + hospitalName;
    }
}