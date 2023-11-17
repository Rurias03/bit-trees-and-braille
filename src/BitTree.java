import java.io.*;

/**
 * Class representing a BitTree for mapping bits to values.
 */
public class BitTree {
  private static final int NUM_BITS = 6; // Number of bits for English braille
  private BitTreeNode root;

  /**
   * Constructs a BitTree with the specified number of bits.
   *
   * @param n The number of bits for the tree.
   */
  public BitTree(int n) {
    if (n != NUM_BITS) {
      throw new IllegalArgumentException("BitTree only supports " + NUM_BITS + " bits.");
    }
    this.root = new BitTreeNode();
  }

  /**
   * Adds or replaces the value at the end of the path given by bits.
   *
   * @param bits The bit string representing the path.
   * @param value The value to be added or replaced.
   * @throws IllegalArgumentException If bits is of inappropriate length or contains values other
   *         than 0 or 1.
   */
  public void set(String bits, String value) {
    if (bits.length() != NUM_BITS || !isValidBitString(bits)) {
      throw new IllegalArgumentException("Invalid bit string: " + bits);
    }
    root.set(bits, value);
  }

  /**
   * Follows the path through the tree given by bits, returning the value at the end.
   *
   * @param bits The bit string representing the path.
   * @return The value at the end of the path.
   * @throws IllegalArgumentException If there is no such path or if bits is of incorrect length.
   */
  public String get(String bits) {
    if (bits.length() != NUM_BITS || !isValidBitString(bits)) {
      throw new IllegalArgumentException("Invalid bit string: " + bits);
    }
    return root.get(bits);
  }

  /**
   * Prints out the contents of the tree in CSV format.
   *
   * @param pen The PrintWriter to write the output.
   */
  public void dump(PrintWriter pen) {
    root.dump(pen, "");
  }

  /**
   * Reads a series of lines in the form bits,value and stores them in the tree.
   *
   * @param source The InputStream containing the input lines.
   */
  public void load(InputStream source) {
    try (BufferedReader reader = new BufferedReader(new InputStreamReader(source))) {
      String line;
      while ((line = reader.readLine()) != null) {
        String[] parts = line.split(",");
        if (parts.length == 2) {
          set(parts[0], parts[1]);
        }
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  /**
   * Checks if a bit string is valid (contains only 0s and 1s).
   *
   * @param bits The bit string to check.
   * @return True if the bit string is valid, false otherwise.
   */
  private boolean isValidBitString(String bits) {
    return bits.matches("[01]+");
  }
}
