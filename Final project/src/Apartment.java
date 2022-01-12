public class Apartment extends Home
{
    private int unitNum;
    private double maintenanceFee;

    public Apartment(double price, int numParkingSpace, int numBedrooms, int numBathrooms, Address address, double floorArea, double monthlyPropertyTax, String listId, int unitNum, double maintenanceFee)
    {
        super(price, numParkingSpace, numBedrooms, numBathrooms, address, floorArea, monthlyPropertyTax, listId);
        this.unitNum = unitNum;
        this.maintenanceFee = maintenanceFee;
    }

    public int getUnitNum()
    {
        return unitNum;
    }

    public double getMaintenanceFee()
    {
        return maintenanceFee;
    }

    public void setMaintenanceFee(double maintenanceFee)
    {
        this.maintenanceFee = maintenanceFee;
    }

    @Override
    double calculateExpectedCost()
    {
        return NUM_MONTHS_IN_YEAR * (monthlyPropertyTax + maintenanceFee);
    }

    public String toString()
    {
        return super.toString() + String.format( "\nUnit Number: %d\nMonthly maintenance fees: %.2f\n-------------------------------\n", unitNum, maintenanceFee);
    }
}
