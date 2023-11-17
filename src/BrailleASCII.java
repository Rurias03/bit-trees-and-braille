/**
 * Main class for translating text between different character sets (braille, ASCII, and Unicode).
 */
public class BrailleASCII {

  /**
   * Main method to execute the translation based on command-line parameters.
   *
   * @param args Command-line parameters: <target_charset> <source_text>
   */
  public static void main(String[] args) {
    // Check if there are two command-line parameters
    if (args.length != 2) {
      System.out.println("Usage: java BrailleASCII <target_charset> <source_text>");
      System.exit(1);
    }

    // Extract target character set and source text from command-line parameters
    String targetCharset = args[0].toLowerCase();
    String sourceText = args[1];

    // Perform translation based on the target character set
    switch (targetCharset) {
      case "braille":
        translateToBraille(sourceText);
        break;
      case "ascii":
        translateToASCII(sourceText);
        break;
      case "unicode":
        translateToUnicode(sourceText);
        break;
      default:
        System.out
            .println("Invalid target character set. Supported values: braille, ascii, unicode");
        System.exit(1);
    }
  }

  /**
   * Translates the source text to braille representation.
   *
   * @param sourceText The source text to translate.
   */
  private static void translateToBraille(String sourceText) {
    StringBuilder result = new StringBuilder();
    for (char c : sourceText.toCharArray()) {
      // Check if the character is uppercase and convert to braille
      if (Character.isUpperCase(c)) {
        result.append(BrailleASCIITables.toBraille(Character.toLowerCase(c)));
      } else {
        result.append(BrailleASCIITables.toBraille(c));
      }
    }
    System.out.println(result.toString());
  }

  /**
   * Translates the source bits to ASCII characters.
   *
   * @param sourceBits The source bits to translate.
   */
  /**
   * Translates the source bits to ASCII characters.
   *
   * @param sourceBits The source bits to translate.
   */
  private static void translateToASCII(String sourceBits) {
    StringBuilder result = new StringBuilder();
    for (int i = 0; i < sourceBits.length(); i += 6) {
      String brailleChunk = sourceBits.substring(i, Math.min(i + 6, sourceBits.length()));
      String asciiChar = BrailleASCIITables.toASCII(brailleChunk);
      result.append(asciiChar);
    }
    System.out.println(result.toString());
  }

  /**
   * Translates the source text to Unicode braille characters.
   *
   * @param sourceText The source text to translate.
   */
  private static void translateToUnicode(String sourceText) {
    StringBuilder result = new StringBuilder();
    for (char c : sourceText.toCharArray()) {
      // Check if the character is uppercase and convert to Unicode braille
      if (Character.isUpperCase(c)) {
        result.append(
            BrailleASCIITables.toUnicode(BrailleASCIITables.toBraille(Character.toLowerCase(c))));
      } else {
        result.append(BrailleASCIITables.toUnicode(BrailleASCIITables.toBraille(c)));
      }
    }
    System.out.println(result.toString());
  }
}
