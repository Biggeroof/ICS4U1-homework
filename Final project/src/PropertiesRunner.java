import java.util.Scanner;

public class PropertiesRunner
{
    //WRITE JAVADOCS
    //TEST THE CATCHES BY TYPING STUFF IN WRONG
    //ONCE DONE CHECKING REMOVE ALL THE LETTERS IN THE CATCHES
    static final String FILE_PATH = "src/";
    static Scanner input = new Scanner(System.in);
    static Properties propertyDatabase = null;
    static String menu = "PROPERTY MANAGER\n----------------------------\nChoose an option from the menu:\n  " +
            "1. Load property list from file\n  2. Save property list to file\n  3. Add a property\n" +
            "  4. Remove a property\n  5. Edit information for one property\n  6. List all properties\n" +
            "  7. List one property\n  8. Filter properties by attribute\n  9. Sort properties by attribute\n" +
            "  10. Calculate average price of all of the homes\n  11. Calculate average floor area of all of the homes\n  " +
            "12. Calculate expected cost to own home for a year (excluding mortgage)\n  To choose an option, type in the number next to the option.";

    public static void main(String[] args)
    {
        String path = "";
        String option;
        String listID = null;
        boolean success;

        boolean on = true;

        while (on)
        {

            if (propertyDatabase != null)
            {
                do
                {
                    option = Properties.takeInt(input, menu);
                    if(Integer.parseInt(option) < 0 || Integer.parseInt(option) > 12)
                    {
                        System.out.println("\nInvalid option. Please try again.\n");
                    }
                } while (Integer.parseInt(option) < 0 || Integer.parseInt(option) > 12);
            }
            else
            {
                System.out.println("There is no file loaded!");
                option = "1";
            }

            switch (option)
            {
                case "0":
                {
                    System.out.println("Exiting...");
                    on = false;
                    break;
                }

                case "1":
                {
                    boolean loaded;
                    propertyDatabase = new Properties();
                    do
                    {
                        System.out.printf("Enter a filename to load (default location: %s): ", FILE_PATH);
                        path = input.nextLine();
                        loaded = propertyDatabase.loadPropertyList(FILE_PATH + path);
                        if (loaded)
                        {
                            System.out.println("Staff list in file '" + path + "' loaded.");
                        }
                        else
                        {
                            System.out.println("Staff list not loaded!\n");
                        }
                    }
                    while (!loaded);
                    break;
                }

                case "2":
                {
                    String saveName;
                    System.out.print("Do you want to use the same filename ("
                            + path + ")? (y/n) ");
                    saveName = input.nextLine();
                    if (!saveName.equals("y"))
                    {
                        System.out.print("Enter a filename to save: ");
                        path = input.nextLine();
                    }
                    System.out.println("Saving file...");
                    propertyDatabase.savePropertyList(FILE_PATH + path);
                    System.out.println();
                    break;
                }

                case "3":
                {
                    propertyDatabase.addProperty(input);
                    break;
                }

                case "4":
                {
                    success = false;
                    do
                    {
                        System.out.print("Listing ID of property to change: ");
                        listID = input.nextLine();
                        if (propertyDatabase.getHomeIndex(listID) >= 0)
                        {
                            success = true;
                        }
                        else
                        {
                            System.out.println("\nInvalid listing ID. Please try again.\n");
                        }
                    } while (!success);
                    propertyDatabase.removeProperty(listID);
                    System.out.println("Property successfully removed.");
                    break;
                }

                case "5":
                {
                    success = false;
                    do
                    {
                        System.out.print("Listing ID of property to change: ");
                        listID = input.nextLine();
                        if (propertyDatabase.getHomeIndex(listID) >= 0)
                        {
                            success = true;
                        }
                        else
                        {
                            System.out.println("\nInvalid listing ID. Please try again.\n");
                        }
                    } while (!success);
                    propertyDatabase.changeInfo(listID, input);
                    break;
                }

                case "6":
                {
                    propertyDatabase.printAllInfo();
                    break;
                }

                case "7":
                {
                    success = false;
                    do
                    {
                        System.out.print("Listing ID of property: ");
                        listID = input.nextLine();
                        if (propertyDatabase.getHomeIndex(listID) >= 0)
                        {
                            success = true;
                        }
                        else
                        {
                            System.out.println("\nInvalid listing ID. Please try again.\n");
                        }
                    } while (!success);
                    propertyDatabase.printHomeInfo(listID);
                    break;
                }

                case "8":
                {
                    //option = propertyDatabase.takeInt(input, "What would you like to filter by? \n  1. Street\n  2. Postal Code\n  3. Price\n  To choose an option, type in the number next to the option.");
                    do
                    {
                        option = propertyDatabase.takeInt(input, "What would you like to filter by? \n  1. Street\n  2. Postal Code\n  3. Price\n  To choose an option, type in the number next to the option.");
                        if (Integer.parseInt(option) < 1 || Integer.parseInt(option) > 3)
                        {
                            System.out.println("\nInvalid option. Please try again.\n");
                        }
                    } while (Integer.parseInt(option) < 1 || Integer.parseInt(option) > 3);

                    switch (option)
                    {
                        case "1":
                        {
                            System.out.println("What is the street name you would like to filter by? ");
                            System.out.print("> ");
                            String name = input.nextLine();
                            System.out.println("Search results: ");
                            propertyDatabase.searchByStreet(name);
                            break;
                        }
                        case "2":
                        {
                            System.out.println("What are the first 3 letters of the postal " +
                                    "code you would like to filter by? ");
                            System.out.print("> ");
                            String code = input.nextLine();
                            if (code.length() != 3)
                            {
                                System.out.println("\nInvalid length. Please try again.\n");
                                break;
                            }
                            System.out.println("Search results: ");
                            propertyDatabase.searchByCode(code);
                            break;
                        }
                        case "3":
                        {
                            propertyDatabase.searchByPrice(input);
                            break;
                        }
                        default:
                        {
                            System.out.println("\nInvalid option. Please try again.\n");
                        }
                    }
                    break;
                }

                case "9":
                {
                    do
                    {
                        option = propertyDatabase.takeInt(input, "What would you like to sort by?\n  1. Price\n  2. Number of bedrooms\n  To choose an option, type in the number next to the option.");
                        if (Integer.parseInt(option) < 1 || Integer.parseInt(option) > 2)
                        {
                            System.out.println("\nInvalid option. Please try again.\n");
                        }
                    } while (Integer.parseInt(option) < 1 || Integer.parseInt(option) > 2);
                    switch (option)
                    {
                        case "1":
                        {
                            propertyDatabase.sortByPrice();
                            break;
                        }
                        case "2":
                        {
                            propertyDatabase.sortByNumberOfBedrooms();
                            break;
                        }
                    }
                    System.out.println("Sorted.");
                    break;
                }

                case "10":
                {
                    System.out.printf("Average price of all homes: %.2f\n", propertyDatabase.calculateAvgPrice());
                    break;
                }

                case "11":
                {
                    System.out.printf("Average price of all homes: %.2f\n", propertyDatabase.calculateAvgArea());
                    break;
                }

                case "12":
                {
                    success = false;
                    do
                    {
                        System.out.print("Listing ID of property: ");
                        listID = input.nextLine();
                        if (propertyDatabase.getHomeIndex(listID) >= 0)
                        {
                            success = true;
                        }
                        else
                        {
                            System.out.println("\nInvalid listing ID. Please try again.\n");
                        }
                    } while (!success);
                    propertyDatabase.calculateExpectedCost(listID);
                    break;
                }

                default:
                {
                    System.out.println("\nInvalid option. Please try again.\n");
                }
            }
            System.out.print("Press Enter to continue...");
            input.nextLine();
            System.out.println();
        }
    }
}
