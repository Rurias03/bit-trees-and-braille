import java.io.*;

/**
 * Provides static methods for converting between ASCII, Braille, and Unicode representations
 */
public class BrailleASCIITables {
  private static BitTree asciiToBrailleTree; // Bit tree for ASCII to Braille translation
  private static BitTree brailleToAsciiTree; // Bit tree for Braille to ASCII translation
  private static BitTree brailleToUnicodeTree; // Bit tree for Braille to Unicode translation

  // Static block to initialize bit trees form a file
  static {
    initializeBitTrees();
  }

  /**
   * Converts an ASCII character to a string of bits representing the corresponding braille
   * character
   * 
   * @param letter The ASCII character to convert
   * @return The string of bits representing the corresponding braille character
   */
  public static String toBraille(char letter) {
    return asciiToBrailleTree.get(Integer.toBinaryString(letter));
  } // toBraille(char)

  /**
   * Converts a string of bits representing a braille character to the corresponding ASCII character
   * 
   * @param bits The string of bits representing a braille character
   * @return The corresponding Unicode braille character
   */
  public static String toASCII(String bits) {
    return brailleToAsciiTree.get(bits);
  } // toASCII(String)

  /**
   * Converts a string of bits representing a braille character to the corresponding Unicode braille
   * character
   * 
   * @param bits The string of bits representing a braille character
   * @return The corresponding Unicode braille character
   */
  public static String toUnicode(String bits) {
    return brailleToUnicodeTree.get(bits);
  } // toUnicode(String)

  // Private method to initialize bit trees from a file
  private static void initializeBitTrees() {
    try (InputStream inputStream =
        BrailleASCIITables.class.getResourceAsStream("/braille_tables.txt")) {
      asciiToBrailleTree = new BitTree(7);
      brailleToAsciiTree = new BitTree(6);
      brailleToUnicodeTree = new BitTree(6);

      if (inputStream != null) {
        asciiToBrailleTree.load(inputStream);
        brailleToAsciiTree.load(inputStream);
        brailleToUnicodeTree.load(inputStream);
      } else {
        // Handle the case where the file is not found or cannot be read
        System.err.println("Error: Unable to load braille tables from file.");
      }
    } catch (IOException e) {
      // Hanlde IOException
      e.printStackTrace();
    }
  } // initializeBitTrees()
} // class BrailleASCIITables
