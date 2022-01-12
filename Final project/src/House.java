public class House extends Home
{
    private String type;
    private int numFloors;
    private double utilityFees;

    public House(double price, int numParkingSpace, int numBedrooms, int numBathrooms, Address address, double floorArea, double monthlyPropertyTax, String listId, String type, int numFloors, double utilityFees)
    {
        super(price, numParkingSpace, numBedrooms, numBathrooms, address, floorArea, monthlyPropertyTax, listId);
        this.type = type;
        this.numFloors = numFloors;
        this.utilityFees = utilityFees;
    }

    public String getType()
    {
        return type;
    }

    public int getNumFloors()
    {
        return numFloors;
    }

    public double getUtilityFees()
    {
        return utilityFees;
    }

    public void setUtilityFees(double utilityFees)
    {
        this.utilityFees = utilityFees;
    }

    @Override
    public double calculateExpectedCost()
    {
        return NUM_MONTHS_IN_YEAR * (monthlyPropertyTax + utilityFees);
    }

    public String toString()
    {
        return super.toString() + String.format("\nType of house: %s\nNumber of floors: %d\nMonthly utility fees: %.2f\n-------------------------------\n", type, numFloors, utilityFees);
    }
}
