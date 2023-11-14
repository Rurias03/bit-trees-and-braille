/**
 * Utility program for translating text between ASCII, Braille, and Unicode representations
 */
public class BrailleASCII {
  public static void main(String[] args) {
    // STUB
  }

  /**
   * Translatees the source text to the target chracter set
   * 
   * @param targetCharacterSet The target chracter set (ascii, braille, unicode)
   * @param sourceText The sourse text to translate
   */
  private static void translate(String targetCharacterSet, String sourceText) {
    // STUB
  } // translate(String, String)

  /**
   * Displayed the usage of the program
   */
  private static void displayUsage() {
    System.out.println("Usage: java BrailleASCII targetCharacterSet sourceText");
    System.out.println("  targetCharacterSet: 'ascii', 'braille', or 'unnicode'");
    System.out.println("  sourceText: The text to be translated");
  } // displayUsage()
} // class BrailleASCII
