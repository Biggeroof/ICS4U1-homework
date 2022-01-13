import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Properties
{

    private final ArrayList<Home> propertyList;

    /**
     * Initializes the propertyList arraylist
     */
    public Properties()
    {
        propertyList = new ArrayList<>();
    }

    /**
     * Loads a property list from a file
     *
     * @param filename The name of the file to load from
     * @return Whether the loading is successful or not
     */
    public boolean loadPropertyList(String filename)
    {
        String row;
        try
        {
            //reads the file row by row
            BufferedReader reader = new BufferedReader(new FileReader(filename));
            while ((row = reader.readLine()) != null)
            {
                //split the row into a string array at the commas
                String[] text = row.split(",");

                //if the home is a house, add a house to the property list
                if (text[0].equals("House"))
                {
                    propertyList.add(new House(Double.parseDouble(text[1]), Integer.parseInt(text[2]), Integer.parseInt(text[3]),
                            Integer.parseInt(text[4]), new Address(Integer.parseInt(text[5]), text[6], text[7], text[8]),
                            Double.parseDouble(text[9]), Double.parseDouble(text[10]), text[11], text[12], Integer.parseInt(text[13]),
                            Double.parseDouble(text[14])));
                }
                //if the home is an apartment, add an apartment to the property list
                else if (text[0].equals("Apartment"))
                {
                    propertyList.add(new Apartment(Double.parseDouble(text[1]), Integer.parseInt(text[2]), Integer.parseInt(text[3]),
                            Integer.parseInt(text[4]), new Address(Integer.parseInt(text[5]), text[6], text[7], text[8]),
                            Double.parseDouble(text[9]), Double.parseDouble(text[10]), text[11], Integer.parseInt(text[12]),
                            Double.parseDouble(text[13])));
                }
                //if the home is a townhouse, add a townhouse to the property list
                else if (text[0].equals("Townhouse"))
                {
                    propertyList.add(new Townhouse(Double.parseDouble(text[1]), Integer.parseInt(text[2]), Integer.parseInt(text[3]),
                            Integer.parseInt(text[4]), new Address(Integer.parseInt(text[5]), text[6], text[7], text[8]),
                            Double.parseDouble(text[9]), Double.parseDouble(text[10]), text[11], Integer.parseInt(text[12]),
                            Double.parseDouble(text[13]), Integer.parseInt(text[14])));
                }
                else
                {
                    //if the type of home is invalid, throw an error that is then caught by the catch
                    throw new IOException();
                }
            }
            reader.close();
            return true;
        }
        catch (IOException e)
        {
            System.out.println("Problem reading file.");
            return false;
        }
    }

    /**
     * Saves a property list into a file
     *
     * @param filename The name of the file to save into
     */
    public void savePropertyList(String filename)
    {
        try
        {
            BufferedWriter writer = new BufferedWriter(new FileWriter(filename));
            //iterate through all the homes currently on the property list
            for (Home temp : propertyList)
            {
                //check what type the object is and writes it into the file in their respective formats so the file can be read again
                if (temp instanceof House)
                {
                    writer.write("House," + temp.price + "," + temp.numParkingSpace + "," + temp.numBedrooms + "," +
                            temp.numBathrooms + "," + temp.address.getStreetNum() + "," + temp.address.getStreetName() + "," +
                            temp.address.getCity() + "," + temp.address.getPostalCode() + "," + temp.floorArea + "," +
                            temp.monthlyPropertyTax + "," + temp.listId + "," + ((House) temp).getType() + "," +
                            ((House) temp).getNumFloors() + "," + ((House) temp).getUtilityFees() + "\n");
                }
                else if (temp instanceof Apartment)
                {
                    writer.write("Apartment," + temp.price + "," + temp.numParkingSpace + "," + temp.numBedrooms + "," +
                            temp.numBathrooms + "," + temp.address.getStreetNum() + "," + temp.address.getStreetName() + "," +
                            temp.address.getCity() + "," + temp.address.getPostalCode() + "," + temp.floorArea + "," +
                            temp.monthlyPropertyTax + "," + temp.listId + "," + ((Apartment) temp).getUnitNum() + "," +
                            ((Apartment) temp).getMaintenanceFee() + "\n");
                }
                else
                {
                    writer.write("Townhouse," + temp.price + "," + temp.numParkingSpace + "," + temp.numBedrooms + "," +
                            temp.numBathrooms + "," + temp.address.getStreetNum() + "," + temp.address.getStreetName() + "," +
                            temp.address.getCity() + "," + temp.address.getPostalCode() + "," + temp.floorArea + "," +
                            temp.monthlyPropertyTax + "," + temp.listId + "," + ((Townhouse) temp).getUnitNum() + "," +
                            ((Townhouse) temp).getMaintenanceFee() + "," + ((Townhouse) temp).getNumSharedWalls() + "\n");
                }
            }
            writer.close();
        }
        catch (IOException e)
        {
            System.out.println("Problem writing to file");
        }
    }

    /**
     * Changes the info for a home given its listing ID
     *
     * @param listId The listing ID of the home
     * @param input
     */
    public void changeInfo(String listId, Scanner input)
    {
        String option = "0";
        String menuDef = "  1. Price\n  2. Number of parking spaces\n  3. Number of bedrooms\n  4. Number of bathrooms\n" +
                "  5. Floor area\n  6. Monthly property tax\n";
        String phr;
        Home temp = getHome(listId);
        //prints the menu and asks the user for an option
        //repeats until it gets a valid option (1-8 for townhouses and 1-7 for houses and apartments)
        do
        {
            if(temp instanceof Townhouse && Integer.parseInt(option) == 8)
            {
                break;
            }
            if (temp instanceof House)
            {
                phr = "What would you like to change?\n" + menuDef + "  7. Monthly utility fees\n  To choose an option, type in the number next to the option.";
                option = takeInt(input, phr);
            }
            else if (temp instanceof Apartment)
            {
                phr = "What would you like to change?\n" + menuDef + "  7. Monthly maintenance fees\n  To choose an option, type in the number next to the option.";
                option = takeInt(input, phr);
            }
            else
            {
                phr = "What would you like to change?\n" + menuDef + "  7. Monthly maintenance fees\n  8. Number of shared walls\n  To choose an option, type in the number next to the option.";
                option = takeInt(input, phr);
            }
            if(Integer.parseInt(option) < 1 || (Integer.parseInt(option) > 7) && !(temp instanceof Townhouse))
            {
                System.out.println("\nInvalid option. Please try again.\n");
            }
        } while (Integer.parseInt(option) < 1 || (Integer.parseInt(option) > 7));

        //Changes the printing and what is to be changed based on the option the user chose
        switch (option)
        {
            case "1":
            {
                temp.price = Double.parseDouble(takeDouble(input, "What would you like to change the price to?"));
                System.out.println("The value has been changed.");
                break;
            }

            case "2":
            {
                temp.numParkingSpace = Integer.parseInt(takeInt(input, "What would you like to change the number of parking spaces to?"));
                System.out.println("The value has been changed.");
                break;
            }

            case "3":
            {
                temp.numBedrooms = Integer.parseInt(takeInt(input, "What would you like to change the number of bedrooms to?"));
                System.out.println("The value has been changed.");
                break;
            }

            case "4":
            {
                temp.numBathrooms = Integer.parseInt(takeInt(input, "What would you like to change the number of bathrooms to?"));
                System.out.println("The value has been changed.");
                break;
            }

            case "5":
            {
                temp.floorArea = Double.parseDouble(takeDouble(input, "What would you like to change the floor area to?"));
                System.out.println("The value has been changed.");
                break;
            }

            case "6":
            {
                temp.monthlyPropertyTax = Double.parseDouble(takeDouble(input, "What would you like to change the monthly property tax to?"));
                System.out.println("The value has been changed.");
                break;
            }

            case "7":
            {
                if (temp instanceof House)
                {
                    ((House)temp).setUtilityFees(Double.parseDouble(takeDouble(input, "What would you like to change the monthly utility fees to?")));
                    System.out.println("The value has been changed.");
                    break;
                }
                else if (temp instanceof Apartment)
                {
                    ((Apartment)temp).setMaintenanceFee(Double.parseDouble(takeDouble(input, "What would you like to change the monthly maintenance fees to?")));
                    System.out.println("The value has been changed.");
                    break;
                }
                else
                {
                    ((Townhouse)temp).setMaintenanceFee(Double.parseDouble(takeDouble(input, "What would you like to change the monthly maintenance fees to?")));
                    System.out.println("The value has been changed.");
                    break;
                }
            }

            case "8":
            {
                ((Townhouse)temp).setNumSharedWalls(Integer.parseInt(takeInt(input, "What would you like to change the number of shared walls to?")));
                System.out.println("The value has been changed.");
                break;
            }
        }
    }

    /**
     * Adds a home to the property list
     *
     * @param input
     */
    public void addHome(Scanner input)
    {
        String option;
        String phr;
        String[] details = new String[14];
        boolean equal;

        phr = "What kind of home would you like to add?\n  1. House\n  2. Apartment\n  3. Townhouse\n  To choose an option, type in the number next to the option.";
        //prints the menu and asks for an option until the user inputs a valid option
        do
        {
            option = takeInt(input, phr);
            if(Integer.parseInt(option) < 1 || Integer.parseInt(option) > 3)
            {
                System.out.println("\nInvalid option. Please try again.\n");
            }
        } while (Integer.parseInt(option) < 1 || Integer.parseInt(option) > 3);

        //takes input from the user about the information of the new home
            System.out.println("Please enter the following details:");
            details[0] = takeDouble(input, "  Price: ");
            details[1] = takeInt(input, "  Number of parking spaces: ");
            details[2] = takeInt(input, "  Number of bedrooms: ");
            details[3] = takeInt(input, "  Number of bathrooms: ");
            details[4] = takeInt(input, "  Street number: ");
            System.out.println("  Street name: ");
            System.out.print("> ");
            details[5] = input.nextLine();
            System.out.println("  City: ");
            System.out.print("> ");
            details[6] = input.nextLine();
            System.out.println("  Postal code: ");
            System.out.print("> ");
            details[7] = input.nextLine();
            details[8] = takeDouble(input, "  Floor area: ");
            details[9] = takeDouble(input, "  Monthly property tax: ");
            //asks the user for a listing ID until the user inputs an ID that doesn't match the other homes
            do
            {
                equal = false;
                System.out.println("  Listing id: ");
                System.out.print("> ");
                details[10] = input.nextLine();
                for (Home i : propertyList)
                {
                    if(i.listId.equals(details[10]))
                    {
                        equal = true;
                        System.out.println("There is another home with the same Listing ID. Please try again.");
                    }
                }

            } while(equal);
            //asks the user for the specific parameters for each home type
            switch (option)
            {
                case "1":
                {
                    do
                    {
                        System.out.println("  Type of house (detached, semi-detached, terraced): ");
                        System.out.print("> ");
                        details[11] = input.nextLine();

                        if(!details[11].equalsIgnoreCase("detached") && !details[11].equalsIgnoreCase("semi-detached") && !details[11].equalsIgnoreCase("terraced"))
                        {
                            System.out.println("Invalid type. Please try again.");
                        }
                    }
                    while(!details[11].equalsIgnoreCase("detached") && !details[11].equalsIgnoreCase("semi-detached") && !details[11].equalsIgnoreCase("terraced"));
                    details[12] = takeInt(input, "  Number of floors: ");
                    details[13] = takeDouble(input, "  Monthly utility fees: ");

                    propertyList.add(new House(Double.parseDouble(details[0]), Integer.parseInt(details[1]), Integer.parseInt(details[2]),
                            Integer.parseInt(details[3]), new Address(Integer.parseInt(details[4]), details[5], details[6], details[7]),
                            Double.parseDouble(details[8]), Double.parseDouble(details[9]), details[10], details[11], Integer.parseInt(details[12]),
                            Double.parseDouble(details[13])));
                    break;
                }

                case "2":
                {
                    details[11] = takeInt(input, "  Unit number: ");
                    details[12] = takeDouble(input, "  Monthly maintenance fees: ");
                    propertyList.add(new Apartment(Double.parseDouble(details[0]), Integer.parseInt(details[1]), Integer.parseInt(details[2]),
                            Integer.parseInt(details[3]), new Address(Integer.parseInt(details[4]), details[5], details[6], details[7]),
                            Double.parseDouble(details[8]), Double.parseDouble(details[9]), details[10], Integer.parseInt(details[11]),
                            Double.parseDouble(details[12])));
                    break;
                }

                case "3":
                {
                    details[11] = takeInt(input, "  Unit number: ");
                    details[12] = takeDouble(input, "  Monthly maintenance fees: ");
                    details[13] = takeInt(input, "  Number of shared walls: ");
                    propertyList.add(new Townhouse(Double.parseDouble(details[0]), Integer.parseInt(details[1]), Integer.parseInt(details[2]),
                            Integer.parseInt(details[3]), new Address(Integer.parseInt(details[4]), details[5], details[6], details[7]),
                            Double.parseDouble(details[8]), Double.parseDouble(details[9]), details[10], Integer.parseInt(details[11]),
                            Double.parseDouble(details[12]), Integer.parseInt(details[13])));
                    break;
                }
            }
            System.out.println("Added.");
    }

    /**
     * Removes a home from the property list given its listing ID
     *
     * @param listId The listing ID of the home to be removed
     */
    public void removeHome(String listId)
    {
        Home temp = getHome(listId);

        if (temp != null)
        {
            propertyList.remove(temp);
        }
    }

    /**
     * Returns a home given its listing ID
     *
     * @param listId the ID of the home to look for
     * @return The home if it is found
     */
    public Home getHome(String listId)
    {
        for (Home i : propertyList)
        {
            if (i.listId.equals(listId))
            {
                return i;
            }
        }
        return null;
    }

    public void searchByStreet(String streetName)
    {
        for (Home i : propertyList)
        {
            if (i.address.getStreetName().equalsIgnoreCase(streetName))
            {
                System.out.println(i);
            }
        }
    }

    public void searchByCode(String postalCode)
    {
        for (Home i : propertyList)
        {
            if (i.address.getPostalCode().substring(0, 3).equalsIgnoreCase(postalCode))
            {
                System.out.println(i);
            }
        }
    }

    public void searchByPrice(Scanner input)
    {
        String option;
        double lowest, highest;
        String phr;

        phr = "What price range would you like to search in?\n  1. Lower than\n  2. In between two prices\n  3. Higher than\n  To choose an option, type in the number next to the option.\n";
        //just have the case default here instead of this (for anything else)
        do
        {
            option = takeInt(input, phr);
            if(Integer.parseInt(option) < 1 || Integer.parseInt(option) > 3)
            {
                System.out.println("\nInvalid option. Please try again.\n");
            }
        } while (Integer.parseInt(option) < 1 || Integer.parseInt(option) > 3);

        switch (option)
        {
            case "1":
            {
                highest = Double.parseDouble(takeDouble(input, "Enter the highest price you want: "));
                System.out.println("Search results: ");
                for (Home i : propertyList)
                {
                    if (i.price <= highest)
                    {
                        System.out.println(i);
                    }
                }
                break;
            }

            case "2":
            {
                lowest = Double.parseDouble(takeDouble(input, "Enter the lowest price you want: "));
                highest = Double.parseDouble(takeDouble(input, "Enter the highest price you want: "));
                System.out.println("Search results: ");
                for (Home i : propertyList)
                {
                    if (i.price >= lowest && i.price <= highest)
                    {
                        System.out.println(i);
                    }
                }
                break;
            }

            case "3":
            {
                lowest = Double.parseDouble(takeDouble(input, "Enter the lowest price you want: "));
                System.out.println("Search results: ");
                for (Home i : propertyList)
                {
                    if (i.price >= lowest)
                    {
                        System.out.println(i);
                    }
                }
                break;
            }
        }
    }

    public void sortByPrice()
    {
        //insertion sort
        for (int i = 1; i < propertyList.size(); i++)
        {
            Home key = propertyList.get(i);
            int j = i - 1;
            while (j >= 0 && key.price < propertyList.get(j).price)
            {
                propertyList.set(j + 1, propertyList.get(j));
                j--;
            }
            propertyList.set(j + 1, key);
        }
    }

    public void sortByNumberOfBedrooms()
    {
        Collections.sort(propertyList);
    }

    public double calculateAvgPrice()
    {
        double total = 0;
        for (Home home : propertyList)
        {
            total += home.price;
        }
        return total / propertyList.size();
    }

    public double calculateAvgArea()
    {
        double total = 0;
        for (Home home : propertyList) {
            total += home.floorArea;
        }
        return total / propertyList.size();
    }

    //in main if the returned value is less than zero print not found
    public void calculateExpectedCost(String listId)
    {
        Home temp = getHome(listId);
        if (temp != null)
        {
            System.out.println("\nThe details of the home: ");
            System.out.println(temp);
            System.out.printf("Expected price to own this home for one year: %.2f\n", temp.calculateExpectedCost());
        }
        else
        {
            System.out.println("Property not found.");
        }
    }

    public void printAllInfo()
    {
        System.out.println("\nAll home information: ");
        for (Home i : propertyList)
        {
            System.out.println(i);
        }
    }

    public void printHomeInfo(String listId)
    {
        Home temp = getHome(listId);

        if (temp != null)
        {
            System.out.println(temp);
        }
        else
        {
            System.out.println("Property not found.");
        }
    }

    public static String takeInt(Scanner input, String phrase)
    {
        boolean notValid = true;
        int number = 0;

        do
        {
            try
            {
                System.out.println(phrase);
                System.out.print("> ");
                number = Integer.parseInt(input.nextLine());
                notValid = false;
            }
            catch (NumberFormatException e)
            {
                System.out.println("\nInvalid input. Please try again.\n");
            }
        } while (notValid);
        return Integer.toString(number);
    }

    public static String takeDouble(Scanner input, String phrase)
    {
        boolean notValid = true;
        double number = 0;

        do
        {
            try
            {
                System.out.println(phrase);
                System.out.print("> ");
                number = Double.parseDouble(input.nextLine());
                notValid = false;
            }
            catch (NumberFormatException e)
            {
                System.out.println("\nInvalid input. Please try again.\n");
            }
        } while (notValid);
        return Double.toString(number);
    }
}
