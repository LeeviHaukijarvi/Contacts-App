# ContactsApp

The ContactsApp is a simple console application for managing contacts. It allows users to create, view, update, and remove contacts. This application is built in Java and utilizes file operations to store and retrieve contact information. Created for school's java course.

## Build status

App is ready to use but has some known bugs. User validation should be more accurate.

## Features

- Create new contacts with information such as first name, last name, ID, phone number, address, and email.
- View a list of all contacts.
- Update the information of an existing contact.
- Remove a contact from the list.

## How to Use

1. **Run the Application:**
   - Compile and run from the Contacts-App folder using command "cd src/ && javac *.java && java ContactsApp"

2. **Navigation:**
   - Follow the menu to choose options (create, view, update, remove, or exit).

3. **Creating a Contact:**
   - Choose option 1 to create a new contact.
   - Enter the required information when prompted.

4. **Viewing Contacts:**
   - Choose option 2 to view the list of contacts.

5. **Updating a Contact:**
   - Choose option 3 to update an existing contact.
   - Follow the instructions to select the contact to update and provide new information.

6. **Removing a Contact:**
   - Choose option 4 to remove a contact.
   - Follow the instructions to select the contact to delete.

7. **Exiting the Application:**
   - Choose option 5 to exit the application.

## Validation Rules

- Input validation is applied to ensure the correctness of user-provided information.
- Various checks are in place for each type of user data, such as name, ID, phone number, address, and email.

## File Operations

- The application uses file operations to store contact information persistently.
- The contact data is stored in a file named `Contacts.txt`.

## Author

- Leevi Haukijärvi


## Screencast

- https://youtu.be/4YVl1t7QodE