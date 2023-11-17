import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class BrailleASCIITables {

  private static final Map<String, Character> asciiToBrailleMap = new HashMap<>();
  private static final Map<String, Character> brailleToAsciiMap = new HashMap<>();
  private static final Map<String, String> brailleToUnicodeMap = new HashMap<>();

  // Load mappings from the provided text file
  static {
    loadMappingsFromFile("braille_to_ascii.txt", "braille_to_unicode.txt", "ascii_to_braille.txt");
  }

  /**
   * Loads mappings from the specified text files and populates the maps.
   *
   * @param brailleToAsciiPath The path to the Braille-to-ASCII text file.
   * @param brailleToUnicodePath The path to the Braille-to-Unicode text file.
   * @param asciiToBraillePath The path to the ASCII-to-Braille text file.
   */
  private static void loadMappingsFromFile(String brailleToAsciiPath, String brailleToUnicodePath,
      String asciiToBraillePath) {
    loadAsciiMappings(asciiToBraillePath);
    loadBrailleMappings(brailleToAsciiPath);
    loadUnicodeMappings(brailleToUnicodePath);
  }

  private static void loadAsciiMappings(String filePath) {
    loadCharacterMapping(filePath, asciiToBrailleMap);
  }

  private static void loadBrailleMappings(String filePath) {
    loadCharacterMapping(filePath, brailleToAsciiMap);
  }

  private static void loadUnicodeMappings(String filePath) {
    loadStringMapping(filePath, brailleToUnicodeMap);
  }

  private static void loadStringMapping(String filePath, Map<String, String> map) {
    try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
      String line;
      while ((line = reader.readLine()) != null) {
        String[] parts = line.split(",");
        if (parts.length == 2) {
          map.put(parts[0], parts[1]);
        }
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  private static void loadCharacterMapping(String filePath, Map<String, Character> map) {
    try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
      String line;
      while ((line = reader.readLine()) != null) {
        String[] parts = line.split(",");
        if (parts.length == 2 && parts[1].length() == 1) {
          map.put(parts[0], parts[1].charAt(0));
        }
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  /**
   * Converts an ASCII character to its braille representation.
   *
   * @param letter The ASCII character to convert.
   * @return The braille representation in binary.
   */
  public static String toBraille(char letter) {
    return String.format("%06d", Integer.parseInt(Integer.toBinaryString(letter)));
  }

  /**
   * Converts a braille representation to the corresponding ASCII character.
   *
   * @param bits The braille representation in binary.
   * @return The ASCII character.
   */
  public static String toASCII(String bits) {
    StringBuilder result = new StringBuilder();

    for (int i = 0; i < bits.length(); i += 6) {
      String asciiChunk = bits.substring(i, Math.min(i + 6, bits.length()));
      char asciiChar = (char) Integer.parseInt(asciiChunk, 2);
      result.append(asciiChar);
    }

    return result.toString();
  }

  /**
   * Converts a braille representation to the corresponding Unicode braille character.
   *
   * @param bits The braille representation in binary.
   * @return The Unicode braille character.
   */
  public static String toUnicode(String bits) {
    return brailleToUnicodeMap.getOrDefault(bits, "");
  }
}
