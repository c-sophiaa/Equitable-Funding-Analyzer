public class FundingEntry {
    
    private String region;
    private String community;
    private String category;
    private boolean isIndigenous;
    private double amount;
    
    public FundingEntry (String region, String community, boolean isIndigenous, String category, double amount) {
        this.region = region;
        this.community = community;
        this.category = category;
        this.isIndigenous = isIndigenous;
        this.amount = amount;
    }
    
    public String getRegion() {
        return region;
    }
    
    public String getCommunity() {
        return community;
    }
    
    public String getCategory() {
        return category;
    }
    
    public boolean isIndigenous(){
        return isIndigenous;
    }
    
    public double getAmount(){
        return amount;
    }
    
    public String toString (){
        return region + "," + community + "," + category + "," + isIndigenous + "," + amount;
    }
}