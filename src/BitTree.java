import java.io.InputStream;
import java.io.PrintWriter;

/**
 * Represents a binary tree for mapping bits to values.
 */
public class BitTree {
  private BitTreeNode root; // The root of the tree
  private final int bitLength; // The length of bits for this tree

  /**
   * Constructs a BitTree with the specified bit length.
   * 
   * @param n The length of the bits for this tree
   */
  public BitTree(int n) {
    // STUB
  } // BitTree(int)

  /**
   * Sets the value for the specified bits in the tree
   * 
   * @param bits The bits to set
   * @param value The value to associate with the bits
   * @throws IllegalArgumentException if bits is the inappropriate length or contains values other
   *         than 0 or 1
   */
  public void set(String bits, String value) {
    // STUB
  } // set(String, String)

  /**
   * Gets the value associated with the specified bits in the tree.
   * 
   * @param bits The bits to get the value for
   * @return The value associated with the bits
   * @throws IllegalArgumentException if there is no such path or if bitsis the incorrect length
   */
  public String get(String bits) {
    // STUB
  } // get(String)

  /**
   * Prints the contents of the tree in CSV format.
   * 
   * @param pen The PrintWriter to write the output to.
   */
  public void dump(PrintWriter pen) {
    // STUB
  }

  /**
   * Reads a series of lines in the form bits,v values and stores them in the tree.
   * 
   * @param source The InputStream to read from
   */
  public void load(InputStream source) {
    // STUB
  } // load(InputStream)
} // class BitTree
