/**
 * Represents user data with attributes such as first name, last name, ID, phone number, address, and email.
 * Provides methods to set and retrieve each attribute while checking validation rules.
 */
class UserData {
    private String firstName;
    private String lastName;
    private String id;
    private String phoneNumber;
    private String address;
    private String email;


    /**
     * Sets the first name of the user.
     *
     * @param name The first name to be set.
     * @throws IllegalArgumentException If the name is less than 3 or more than 12 characters,
     *                                  or if it does not start with an uppercase character.
     */
    public void setFirstName(String name) {
        canBeInName(name);
        if (name.length() < 3 || name.length() > 12) {
            throw new IllegalArgumentException("First name must be between 3 and 12 characters!");
        } else if (!Character.isUpperCase(name.charAt(0))) {
            throw new IllegalArgumentException("First name must start with a uppercase character!");
        } else {
            this.firstName = name;
        }
    }

    /**
     * Sets the last name of the user.
     *
     * @param name The last name to be set.
     * @throws IllegalArgumentException If the last name is less than 3 characters,
     *                                  or if it does not start with an uppercase character.
     */
    public void setLastName(String name) {
        canBeInName(name);
        if (name.length() < 3) {
            throw new IllegalArgumentException("Last Name must be longer than 3 characters!");
        } else if (!Character.isUpperCase(name.charAt(0))) {
            throw new IllegalArgumentException("Last Name must start with a uppercase character!");
        } else {
            this.lastName = name;
        }
    }
    /**
     * Sets the ID of the user.
     *
     * @param id The ID to be set.
     * @throws IllegalArgumentException If the ID is not 11 characters long, if the first six digits are not numbers,
     *                                  or if it contains special characters after the sixth position.
     */
    public void setId(String id) {
        if (!(id.length() == 11)) {
            throw new IllegalArgumentException("Id must be 11 characters long!");
        }
        for (int i = 0; i < 6; i++) {
            char currentChar = id.charAt(i);
            if(!(Character.isDigit(currentChar))) {
                throw new IllegalArgumentException("First six digits must be numbers!");
            }
        }
        for (int i = 6; i < 11; i++) {
            char currentChar = id.charAt(i);
            if(!Character.isLetterOrDigit(currentChar) && currentChar != '-') {
                throw new IllegalArgumentException("Cannot include special characters!");
            }
        }
        this.id = id;
    }
    /**
     * Sets the phone number of the user.
     *
     * @param number The phone number to be set.
     * @throws IllegalArgumentException If the number is not 10 or 11 digits long or if it contains non-digit characters.
     */
    public void setPhoneNumber(String number) {
        if (!(number.length() == 10 || number.length() == 11)) {
            throw new IllegalArgumentException("Must be 10 or 11 numbers long!");
        }
        for (int i = 0; i < number.length(); i++) {
            char currentChar = number.charAt(i);
            if(!(Character.isDigit(currentChar))) {
                throw new IllegalArgumentException("Must contain only numbers!");
            }
        }
        this.phoneNumber = number;
    }
    /**
     * Sets the address of the user.
     *
     * @param address The address to be set.
     * @throws IllegalArgumentException If the address does not start with an uppercase letter or
     *                                  if it contains special characters other than spaces.
     */
    public void setAddress (String address) {
        if (!Character.isUpperCase(address.charAt(0))) {
            throw new IllegalArgumentException("Must start with uppercase letter!");
        }
        for(int i = 0; i < address.length(); i++) {
            char currentChar = address.charAt(i);
            if (!Character.isLetterOrDigit(currentChar) && currentChar != ' ') {
                throw new IllegalArgumentException("Cannot include special characters!");
            }
        }
        this.address = address;
    }
    /**
     * Sets the email of the user.
     *
     * @param email The email to be set.
     * @throws IllegalArgumentException If the email is less than 5 characters, or if it lacks '@' or '.' symbols.
     */
    public void setEmail (String email) {
        if(email.length() < 5) {
            throw new IllegalArgumentException("Must be longer than 5 characters!");
        } else if (!email.contains("@") || !email.contains(".")) {
            throw new IllegalArgumentException("Must include '@' and '.'!");
        }
        this.email = email;
    }

    /**
     * Retrieves the first name of the user.
     *
     * @return The first name of the user.
     */
    public String getFirstName() {
        return this.firstName;
    }
    /**
     * Retrieves the last name of the user.
     *
     * @return The last name of the user.
     */
    public String getLastName() {
        return this.lastName;
    }
    /**
     * Retrieves the ID of the user.
     *
     * @return The ID of the user.
     */
    public String getId() {
        return this.id;
    }
    /**
     * Retrieves the phone number of the user.
     *
     * @return The phone number of the user.
     */
    public String getPhoneNumber() {
        return this.phoneNumber;
    }
    /**
     * Retrieves the address of the user.
     *
     * @return The address of the user.
     */
    public String getAddress() {
        return this.address;
    }
    /**
     * Retrieves the email of the user.
     *
     * @return The email of the user.
     */
    public String getEmail() {
        return this.email;
    }
    /**
     * Checks if a given string can be used as a name, ensuring it does not contain numbers or special characters.
     *
     * @param name The string to be checked.
     * @throws IllegalArgumentException If the name contains numbers or special characters.
     * @return True if the name is valid, false otherwise.
     */
    private static boolean canBeInName(String name) {
        for(int i = 0; i < name.length(); i++) {
            char currentChar = name.charAt(i);
            if (Character.isDigit(name.charAt(i))) {
                throw new IllegalArgumentException("Cannot include numbers!");
            }
            if (!Character.isLetterOrDigit(currentChar)) {
                throw new IllegalArgumentException("Cannot include special characters!");
            }
        }
        return true;
    }
}
