import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Properties
{

    private final ArrayList<Home> propertyList;

    public Properties()
    {
        propertyList = new ArrayList<>();
    }

    public boolean loadPropertyList(String filename)
    {
        String row;
        try
        {
            BufferedReader reader = new BufferedReader(new FileReader(filename));
            while ((row = reader.readLine()) != null)
            {
                String[] text = row.split(",");

                if (text[0].equals("House"))
                {
                    propertyList.add(new House(Double.parseDouble(text[1]), Integer.parseInt(text[2]), Integer.parseInt(text[3]),
                            Integer.parseInt(text[4]), new Address(Integer.parseInt(text[5]), text[6], text[7], text[8]),
                            Double.parseDouble(text[9]), Double.parseDouble(text[10]), text[11], text[12], Integer.parseInt(text[13]),
                            Double.parseDouble(text[14])));
                }
                else if (text[0].equals("Apartment"))
                {
                    propertyList.add(new Apartment(Double.parseDouble(text[1]), Integer.parseInt(text[2]), Integer.parseInt(text[3]),
                            Integer.parseInt(text[4]), new Address(Integer.parseInt(text[5]), text[6], text[7], text[8]),
                            Double.parseDouble(text[9]), Double.parseDouble(text[10]), text[11], Integer.parseInt(text[12]),
                            Double.parseDouble(text[13])));
                }
                else if (text[0].equals("Townhouse"))
                {
                    propertyList.add(new Townhouse(Double.parseDouble(text[1]), Integer.parseInt(text[2]), Integer.parseInt(text[3]),
                            Integer.parseInt(text[4]), new Address(Integer.parseInt(text[5]), text[6], text[7], text[8]),
                            Double.parseDouble(text[9]), Double.parseDouble(text[10]), text[11], Integer.parseInt(text[12]),
                            Double.parseDouble(text[13]), Integer.parseInt(text[14])));
                }
                else
                {
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

    public void savePropertyList(String filename)
    {
        try
        {
            BufferedWriter writer = new BufferedWriter(new FileWriter(filename));
            for (Home temp : propertyList)
            {
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

    public void changeInfo(String listId, Scanner input)
    {
        int index = getHomeIndex(listId);
        String option = "0";
        String menuDef = "  1. Price\n  2. Number of parking spaces\n  3. Number of bedrooms\n  4. Number of bathrooms\n" +
                "  5. Floor area\n  6. Monthly property tax\n";
        String phr;
        //keep asking for options while option is not valid (less than 1 greater than 7) or for townhouses less than 1 greater than 8
        do
        {
            if(propertyList.get(index) instanceof Townhouse && Integer.parseInt(option) == 8)
            {
                break;
            }
            if (propertyList.get(index) instanceof House)
            {
                phr = "What would you like to change?\n" + menuDef + "  7. Monthly utility fees\n  To choose an option, type in the number next to the option.";
                option = takeInt(input, phr);
            }
            else if (propertyList.get(index) instanceof Apartment)
            {
                phr = "What would you like to change?\n" + menuDef + "  7. Monthly maintenance fees\n  To choose an option, type in the number next to the option.";
                option = takeInt(input, phr);
            }
            else
            {
                phr = "What would you like to change?\n" + menuDef + "  7. Monthly maintenance fees\n  8. Number of shared walls\n  To choose an option, type in the number next to the option.";
                option = takeInt(input, phr);
            }
            if(Integer.parseInt(option) < 1 || (Integer.parseInt(option) > 7) && !(propertyList.get(index) instanceof Townhouse))
            {
                System.out.println("\nInvalid option. Please try again.\n");
            }
        } while (Integer.parseInt(option) < 1 || (Integer.parseInt(option) > 7));

            switch (option)
            {
                case "1":
                {
                    propertyList.get(index).price = Double.parseDouble(takeDouble(input, "What would you like to change the price to?"));
                    System.out.println("The value has been changed.");
                    break;
                }

                case "2":
                {
                    propertyList.get(index).numParkingSpace = Integer.parseInt(takeInt(input, "What would you like to change the number of parking spaces to?"));
                    System.out.println("The value has been changed.");
                    break;
                }

                case "3":
                {
                    propertyList.get(index).numBedrooms = Integer.parseInt(takeInt(input, "What would you like to change the number of bedrooms to?"));
                    System.out.println("The value has been changed.");
                    break;
                }

                case "4":
                {
                    propertyList.get(index).numBathrooms = Integer.parseInt(takeInt(input, "What would you like to change the number of bathrooms to?"));
                    System.out.println("The value has been changed.");
                    break;
                }

                case "5":
                {
                    propertyList.get(index).floorArea = Double.parseDouble(takeDouble(input, "What would you like to change the floor area to?"));
                    System.out.println("The value has been changed.");
                    break;
                }

                case "6":
                {
                    propertyList.get(index).monthlyPropertyTax = Double.parseDouble(takeDouble(input, "What would you like to change the monthly property tax to?"));
                    System.out.println("The value has been changed.");
                    break;
                }

                case "7":
                {
                    if (propertyList.get(index) instanceof House)
                    {
                        ((House) propertyList.get(index)).setUtilityFees(Double.parseDouble(takeDouble(input, "What would you like to change the monthly utility fees to?")));
                        System.out.println("The value has been changed.");
                        break;
                    }
                    else if (propertyList.get(index) instanceof Apartment)
                    {
                        ((Apartment) propertyList.get(index)).setMaintenanceFee(Double.parseDouble(takeDouble(input, "What would you like to change the monthly maintenance fees to?")));
                        System.out.println("The value has been changed.");
                        break;
                    }
                    else
                    {
                        ((Townhouse) propertyList.get(index)).setMaintenanceFee(Double.parseDouble(takeDouble(input, "What would you like to change the monthly maintenance fees to?")));
                        System.out.println("The value has been changed.");
                        break;
                    }
                }

                case "8":
                {
                    ((Townhouse) propertyList.get(index)).setNumSharedWalls(Integer.parseInt(takeInt(input, "What would you like to change the number of shared walls to?")));
                    System.out.println("The value has been changed.");
                    break;
                }
            }
    }

    public void addProperty(Scanner input)
    {
        String option;
        String phr;
        String[] details = new String[14];
        boolean equal;

        //this try catch is so that it displays a different error message saying incorrect option
        //instead of incorrect input
        phr = "What kind of home would you like to add?\n  1. House\n  2. Apartment\n  3. Townhouse\n  To choose an option, type in the number next to the option.";
        do
        {
            option = takeInt(input, phr);
            if(Integer.parseInt(option) < 1 || Integer.parseInt(option) > 3)
            {
                System.out.println("\nInvalid option. Please try again.\n");
            }
        } while (Integer.parseInt(option) < 1 || Integer.parseInt(option) > 3);

            //input error only shows after all things are inputted because all strings
            //add
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
            //postal codes can have different formats so I can't verify these
            System.out.println("  Postal code: ");
            System.out.print("> ");
            details[7] = input.nextLine();
            details[8] = takeDouble(input, "  Floor area: ");
            details[9] = takeDouble(input, "  Monthly property tax: ");
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

    public void removeProperty(String listId)
    {
        Home temp = getHome(listId);

        if (temp != null)
        {
            propertyList.remove(temp);
        }
    }

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

    public int getHomeIndex(String listId)
    {
        for (int i = 0; i < propertyList.size(); i++)
        {
            if (propertyList.get(i).listId.equals(listId))
            {
                return i;
            }
        }
        return -1;
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

    public String takeInt(Scanner input, String phrase)
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

    public String takeDouble(Scanner input, String phrase)
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
