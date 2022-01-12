public class Townhouse extends Home
{
    private int unitNum;
    private double maintenanceFee;
    private int numSharedWalls;

    public Townhouse(double price, int numParkingSpace, int numBedrooms, int numBathrooms, Address address, double floorArea, double monthlyPropertyTax, String listId, int unitNum, double maintenanceFee, int numSharedWalls)
    {
        super(price, numParkingSpace, numBedrooms, numBathrooms, address, floorArea, monthlyPropertyTax, listId);
        this.unitNum = unitNum;
        this.maintenanceFee = maintenanceFee;
        this.numSharedWalls = numSharedWalls;
    }

    public int getUnitNum()
    {
        return unitNum;
    }

    public double getMaintenanceFee()
    {
        return maintenanceFee;
    }

    public int getNumSharedWalls()
    {
        return numSharedWalls;
    }

    public void setMaintenanceFee(double maintenanceFee)
    {
        this.maintenanceFee = maintenanceFee;
    }

    public void setNumSharedWalls(int numSharedWalls)
    {
        this.numSharedWalls = numSharedWalls;
    }

    @Override
    double calculateExpectedCost()
    {
        return NUM_MONTHS_IN_YEAR * (monthlyPropertyTax + maintenanceFee);
    }

    public String toString()
    {
        return super.toString() + String.format( "\nUnit Number: %d\nMonthly maintenance fees: %.2f\nNumber of Shared Walls: %d\n-------------------------------\n", unitNum, maintenanceFee, numSharedWalls);
    }
}
