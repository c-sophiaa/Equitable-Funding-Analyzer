/*
 * Represents a generic funding record with the main/core attributes like region, community, category, amount, and if this funding applies to an Indigenous community.
 * This abstract base class encapsulates common properties and behaviours shared by all specific funding categories.
 */
public class FundingEntry {
    
    private String region;
    private String community;
    private String category;
    private boolean isIndigenous;
    private double amount;
    
    /*
     * Constructs a FundingEntry with the provided attributes
     * @param region the province or territory the funding is being allocated
     * @param community the specific city, town or Indigenous community receiving the funding
     * @param category the funding category
     * @param isIndigenous true if the community is Indigenous false if not
     * @param amount the allocated funding amount in CAD, must be non negative
     */
    public FundingEntry (String region, String community, boolean isIndigenous, String category, double amount) {
        this.region = region;
        this.community = community;
        this.category = category;
        this.isIndigenous = isIndigenous;
        this.amount = amount;
    }
    
    /*
     * Returns the region name.
     * @return the name of the region
     */
    public String getRegion() {
        return region;
    }
    
    /*
     * Returns the community name.
     * @return the name of the community
     */
    public String getCommunity() {
        return community;
    }
    
    /*
     * Returns the category.
     * @return the name of the category
     */
    public String getCategory() {
        return category;
    }
    
    /*
     * Indicates if this entry applies to an Indigenous community.
     * @return true if Indigenous, false if not
     */
    public boolean isIndigenous(){
        return isIndigenous;
    }
    
    /*
     * Returns the funding amount.
     * @return the amount of funding in CAD
     */
    public double getAmount(){
        return amount;
    }
    /*
     * Formats the entry as a String separated by commas.
     * @return a representation of the funding entry
     */
    public String toString (){
        return region + "," + community + "," + category + "," + isIndigenous + "," + amount;
    }
}