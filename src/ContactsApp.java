import java.io.Console;


/**
 * The ContactsApp class represents a simple console application
 * for managing contacts.
 *
 * It allows users to create, view, update, and remove contacts.
 *
 * @author Leevi Haukijärvi
 */


public class ContactsApp {
    private static Console c = System.console();
    /**
     * The main method of the ContactsApp class.
     * It serves as the entry point for the ContactsApp application.
     *
     * @param args The command-line arguments (not used in this application).
     */
    public static void main(final String[] args) {
        boolean exit = false;
        AlterUser createInstance = new AlterUser();

        System.out.println("Welcome to Contacts App");

        while (!exit) {
            System.out.println("1: Create Contact\n"
            + "2: View Contacts\n3: Update Contact\n4: Remove Contact\n5: Exit");

            System.out.print("What do you want to do (number)?: ");

            try {
                switch (validateUserNumbers(1, 5)) {
                    case 1:
                        createInstance.createUser();
                        FileManager.writeArrayToFile(createInstance.getInformation());
                        System.out.println("\nUser created successfully!\n");
                        break;
                    case 2:
                        System.out.println("\nContacts:\n"
                        + FileManager.readFromFile(0));
                        System.out.print("Press enter to continue \n");
                        c.readLine();
                        break;
                    case 3:
                        int userNumberToUpdate = 0;
                        System.out.println("\nContacts:\n"
                        + FileManager.readFromFile(0));
                        System.out.print("What user do you want to update (number)?: ");
                        userNumberToUpdate = validateUserNumbers(1, 10);
                        createInstance.updateUser(userNumberToUpdate);
                        System.out.println("User updated successfully \n");
                        break;
                    case 4:
                        int userNumberToDelete = 0;
                        System.out.println("\nContacts:\n"
                        + FileManager.readFromFile(0));
                        System.out.print("What user do you want to delete (number)?: ");
                        userNumberToDelete = validateUserNumbers(1, 10);
                        createInstance.deleteUser(userNumberToDelete);
                        System.out.println("User deleted successfully \n");
                        break;
                    case 5:
                        exit = true;
                        break;
                }
            } catch (IllegalArgumentException e) {
                System.out.println("\nInvalid input. Please try again.");
                System.out.println(e.getMessage() + "\n");
            }
        }
    }


    /**
     * Validates user input to ensure it is a number within the specified range.
     *
     * @param min The minimum allowed value.
     * @param max The maximum allowed value.
     * @return The validated user input.
     */
    public static int validateUserNumbers(final int min, final int max) {
        int validatedNumber = 0;
        boolean correctNumber = false;
        while (!correctNumber) {
            try {
                validatedNumber = Integer.parseInt(c.readLine());
                if (!(validatedNumber >= min && validatedNumber <= max)) {
                    throw new IllegalArgumentException();
                } else {
                    correctNumber = true;
                }
            } catch (IllegalArgumentException e) {
                System.out.println("Must be a number between "
                + min + " and " + max + "!");
            }
        }
        return validatedNumber;
    }
}
