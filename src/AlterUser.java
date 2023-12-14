import java.io.Console;
/**
 * The AlterUser class has the creation, updating, and deletion of user information.
 */
class AlterUser {
    private UserData user = new UserData();
    private String[] information = new String[6];


    /**
     * Creates a new user by asking for user information.
     */
    public void createUser() {
        Console c = System.console();

        for (int i = 0; i < information.length; i++) {
            boolean validInput = false;
            while (!validInput) {
                try {
                    switch (i) {
                        // Cases for different user information fields
                        // Handle address and email cases for skipping input
                        case 0:
                            System.out.print("Enter first name: ");
                            user.setFirstName(c.readLine());
                            information[i] = user.getFirstName();
                            break;
                        case 1:
                            System.out.print("Enter last name: ");
                            user.setLastName(c.readLine());
                            information[i] = user.getLastName();
                            break;
                        case 2:
                            System.out.print("Enter id: ");
                            user.setId(c.readLine());
                            information[i] = user.getId();
                            break;
                        case 3:
                            System.out.print("Enter phone number (without "+"): ");
                            user.setPhoneNumber(c.readLine());
                            information[i] = user.getPhoneNumber();
                            break;
                        case 4:
                            System.out.print("Enter address (Press Enter to skip): ");
                            String addressInput = c.readLine();
                            if (addressInput.isEmpty()) {
                                information[i] = "null";
                            } else {
                                user.setAddress(addressInput);
                                information[i] = user.getAddress();
                            }
                            break;
                        case 5:
                            System.out.print("Enter email (Press Enter to skip): ");
                            String emailInput = c.readLine();
                            if (emailInput.isEmpty()) {
                                information[i] = "null";
                            } else {
                                user.setEmail(emailInput);
                                information[i] = user.getEmail();
                            }
                            break;
                    }
                    validInput = true;
                } catch (IllegalArgumentException e) {
                    System.out.println("\n" + "Invalid input. Please try again.");
                    System.out.println(e.getMessage() + "\n");
                    validInput = false;
                }
            }
        }
    }
    /**
     * Retrieves the user information.
     *
     * @return An array containing user information.
     */
    public String[] getInformation() {
        return this.information;
    }
    /**
     * Updates an existing user's information.
     *
     * @param lineNumber The line number represents what user to update.
     */
    public void updateUser(int lineNumber) {
        AlterUser user = new AlterUser();
        user.createUser();
        FileManager.updateLine(false, lineNumber, user.getInformation());
    }
    /**
     * Deletes an existing user's information.
     *
     * @param lineNumber The line number represents the user to delete.
     */
    public void deleteUser(int lineNumber) {
        FileManager.updateLine(true, lineNumber, null);
    }
}
