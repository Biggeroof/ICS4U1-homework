public abstract class Home implements Comparable<Home>
{

    protected final int NUM_MONTHS_IN_YEAR = 12;
    protected double price;
    protected int numParkingSpace;
    protected int numBedrooms;
    protected int numBathrooms;
    protected Address address;
    protected double floorArea;
    protected double monthlyPropertyTax;
    protected String listId;

    public Home(double price, int numParkingSpace, int numBedrooms, int numBathrooms, Address address, double floorArea, double monthlyPropertyTax, String listId)
    {
        this.price = price;
        this.numParkingSpace = numParkingSpace;
        this.numBedrooms = numBedrooms;
        this.numBathrooms = numBathrooms;
        this.address = address;
        this.floorArea = floorArea;
        this.monthlyPropertyTax = monthlyPropertyTax;
        this.listId = listId;
    }

    public double getPrice()
    {
        return price;
    }

    public int getNumParkingSpace()
    {
        return numParkingSpace;
    }

    public int getNumBedrooms()
    {
        return numBedrooms;
    }

    public int getNumBathrooms()
    {
        return numBathrooms;
    }

    public Address getAddress()
    {
        return address;
    }

    public double getFloorArea()
    {
        return floorArea;
    }

    public double getMonthlyPropertyTax()
    {
        return monthlyPropertyTax;
    }

    public String getListId()
    {
        return listId;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setNumParkingSpace(int numParkingSpace)
    {
        this.numParkingSpace = numParkingSpace;
    }

    public void setNumBedrooms(int numBedrooms)
    {
        this.numBedrooms = numBedrooms;
    }

    public void setNumBathrooms(int numBathrooms)
    {
        this.numBathrooms = numBathrooms;
    }

    public void setFloorArea(double floorArea)
    {
        this.floorArea = floorArea;
    }

    public void setMonthlyPropertyTax(double monthlyPropertyTax)
    {
        this.monthlyPropertyTax = monthlyPropertyTax;
    }

    abstract double calculateExpectedCost();

    @Override
    public int compareTo(Home o)
    {
        return this.numBedrooms - o.numBedrooms;
    }

    public String toString()
    {
        return this.getClass().getName() + String.format("\n-------------------------------\nListingID: %s\nPrice: %.2f\nAddress: %s\nFloor Area: %.2f\nNumber of bedrooms: %d\nNumber of bathrooms: %d" +
                "\nNumber of parking spaces: %d\nMonthly property tax: %.2f", listId, price, address, floorArea, numBedrooms, numBathrooms, numParkingSpace, monthlyPropertyTax);
    }
}
