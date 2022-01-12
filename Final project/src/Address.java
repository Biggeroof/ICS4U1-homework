public class Address
{
    //these are all final because you can't change the address once the home object is created
    private int streetNum;
    private String streetName;
    private String city;
    private String postalCode;

    public Address(int streetNum, String streetName, String city, String postalCode)
    {
        this.streetNum = streetNum;
        this.streetName = streetName;
        this.city = city;
        this.postalCode = postalCode;
    }

    public int getStreetNum()
    {
        return streetNum;
    }

    public String getStreetName()
    {
        return streetName;
    }

    public String getCity()
    {
        return city;
    }

    public String getPostalCode()
    {
        return postalCode;
    }

    public String toString()
    {
        return streetNum + " " + streetName + ", " + city + ", " + postalCode;
    }
}
