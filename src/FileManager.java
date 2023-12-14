import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

/**
 * Utility class for managing file operations related to "Contacts.txt".
 */
public class FileManager {
    /**
     * add the given array of strings as a new line to the "Contacts.txt" file.
     *
     * @param array An array of strings to be add as a new line.
     */

    public static void writeArrayToFile(final String[] array) {
        int atWhatIndex = 0;

        try (BufferedReader reader =
        new BufferedReader(new FileReader("Contacts.txt"))) {
            while (reader.readLine() != null) {
                atWhatIndex++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (BufferedWriter writer =
        new BufferedWriter(new FileWriter("Contacts.txt", true))) {
            writer.write((atWhatIndex + 1) + ": ");

            for (int i = 0; i < array.length; i++) {
                String value = array[i];
                writer.write(value);
                if (i < array.length - 1) {
                    writer.write(", ");
                }
            }
            writer.newLine();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    /**
     * Reads the content of a specific line from the "Contacts.txt" file.
     *
     * @param lineNumber The line number to be read. Use 0 to read the entire file.
     * @return A string containing the content of the specified line
     *         or the entire file.
     */
    public static String readFromFile(final int lineNumber) {
        StringBuilder content = new StringBuilder();
        String line;

        try (BufferedReader reader =
        new BufferedReader(new FileReader("Contacts.txt"))) {
            int currentLine = 0;
            if (lineNumber == 0) {
                while ((line = reader.readLine()) != null) {
                    content.append(line);
                    content.append(System.lineSeparator());
                }
            } else {
                while ((line = reader.readLine()) != null) {
                    currentLine++;
                    if (currentLine == lineNumber) {
                        return line;
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return content.toString();
    }
    /**
     * Updates or deletes a specific line in the "Contacts.txt" file.
     * If deleteLine is true, it deletes the line at
     * the specified lineNumber.
     *
     * If deleteLine is false, it updates the
     * line at the specified lineNumber with the new data.
     *
     * @param deleteLine A boolean indicating whether to delete or update the line.
     * @param lineNumber The line number to be deleted or updated.
     * @param newData    An array of strings containing
     *                   the new data to update the line.
     */
    public static void updateLine(final boolean deleteLine,
    final int lineNumber, final String[] newData) {
        try (BufferedReader reader = new BufferedReader(new FileReader("Contacts.txt"));
            BufferedWriter writer = new BufferedWriter(new FileWriter("temp.txt"))) {

            String line;
            int currentLine = 0;

            if (!deleteLine) {
                while ((line = reader.readLine()) != null) {
                    currentLine++;
                    if (currentLine == lineNumber) {
                        writer.write(lineNumber + ": ");
                        for (int i = 0; i < newData.length; i++) {
                            String value = newData[i];
                            writer.write(value);
                            if (i < newData.length - 1) {
                                writer.write(", ");
                            }
                        }
                    } else {
                        writer.write(line);
                    }
                    writer.newLine();
                }
            }


            if (deleteLine) {
                while ((line = reader.readLine()) != null) {
                    currentLine++;
                    if (currentLine != lineNumber) {
                        writer.write(line);
                        writer.newLine();
                    }
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        File temp = new File("temp.txt");
        File original = new File("Contacts.txt");

        try {
            Files.copy(temp.toPath(), original.toPath(),
                        StandardCopyOption.REPLACE_EXISTING);
            Files.delete(temp.toPath());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}



