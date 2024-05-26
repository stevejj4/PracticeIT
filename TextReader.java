import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

/**
 * The class is a driver to read the WarAndPeace.txt file in the same directory 
 * with TextReader.java file. The class uses two parallel arrays: one to hold
 * the words and one to hold the frequencies of the words. The word and its frequency
 * should have the same indexes in two parallel arrays
 *
 * @version 1.0
 */
public class TextReader {
    public static final int MAX_LENGTH = 1000000;
    public static final int NOT_FOUND = -1;

    public static void main(String[] args) {
        // Declare arrays to store words and their frequencies
        String[] words = new String[MAX_LENGTH];
        int[] frequencies = new int[MAX_LENGTH];

        // Declare a variable to store the number of unique words
        int uniqueWordCount = readWordFromFile("WarAndPeace.txt", words, frequencies);

        // Declare a scanner for user input
        Scanner scanner = new Scanner(System.in);

        while (true) {
            // Display the menu
            displayMenu();

            // Ask user to enter an option from 0 to 3
            System.out.print("Please enter option [0-3]: ");
            int option = scanner.nextInt();
            scanner.nextLine(); // consume the newline character

            // Execute the function based on the option selected
            if (option == 0) {
                System.out.println("Thank you for using the program");
                break;
            } else if (option == 1) {
                System.out.print("Enter the word to find its frequency: ");
                String word = scanner.nextLine().toLowerCase();
                int index = getWordIndexFromArray(word, words, uniqueWordCount);
                if (index != NOT_FOUND) {
                    System.out.println("The frequency of the word \"" + word + "\" is: " + frequencies[index]);
                } else {
                    System.out.println("The word \"" + word + "\" is not found.");
                }
            } else if (option == 2) {
                System.out.print("Enter the least frequency to list all words: ");
                int minFrequency = scanner.nextInt();
                scanner.nextLine(); // consume the newline character
                System.out.print("The list of words that have frequency greater than " + minFrequency + ":");
                for (int i = 0; i < uniqueWordCount; i++) {
                    if (frequencies[i] > minFrequency) {
                        System.out.print(" " + words[i]);
                    }
                }
                System.out.println();
            } else if (option == 3) {
                // Reserved for extra credit
                System.out.println("This option is reserved for extra credit.");
            } else {
                System.out.println("Sorry, I could not find the function for the option " + option);
            }
        }

        scanner.close();
    }

    /**
     * The method displays the menu to the console
     */
    public static void displayMenu() {
        System.out.println("======================================");
        System.out.println("Please select option below to operate:");
        System.out.println("  0. Quit the program");
        System.out.println("  1. Print out the frequency of an entered word");
        System.out.println("  2. Print out all words that have a frequency that is greater than an entered value");
        System.out.println("  3. Reserved for extra credit");
    }

    /**
     * The method reads the words from the input file into array of string
     * @param filename the file name
     * @param words the array of words (strings)
     * @param frequencies the array of frequencies (integers)
     * @return the number of unique words in the text file
     */
    public static int readWordFromFile(String filename, String[] words, int[] frequencies) {
        int size = 0;
        try {
            Scanner fileScanner = new Scanner(new File(filename));
            while (fileScanner.hasNext()) {
                String word = removePunctuations(fileScanner.next().toLowerCase());
                int index = getWordIndexFromArray(word, words, size);
                if (index != -1) {
                    frequencies[index]++;
                } else {
                    words[size] = word;
                    frequencies[size] = 1;
                    size++;
                }
            }
            fileScanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + filename);
        }
        return size;
    }

    /**
     * The method removes all punctuations from a word
     * @param word the given word
     * @return the word that is removed all punctuations
     */
    public static String removePunctuations(String word) {
        return word.replaceAll("[.,:;'\"!?\\-\\[\\]()]", "");
    }

    /**
     * The method returns the index of the given word in the array of words
     * @param word the given word that need to check its index in the array
     * @param words the array of words
     * @param size the size of unique words
     * @return the index of the word (-1 if the word is not in the array)
     */
    public static int getWordIndexFromArray(String word, String[] words, int size) {
        for (int i = 0; i < size; i++) {
            if (words[i].equals(word)) {
                return i;
            }
        }
        return NOT_FOUND;
    }
}
