import java.io.*;

/**
 * Concrete class representing a node in the BitTree.
 */
public class BitTreeNode {
  protected BitTreeNode left;
  protected BitTreeNode right;
  protected String value; // Value associated with the node

  /**
   * Constructs a BitTreeNode.
   */
  public BitTreeNode() {
    this.value = null;
    this.left = null;
    this.right = null;
  }

  /**
   * Sets the value at the end of the path given by bits.
   *
   * @param bits The bit string representing the path.
   * @param value The value to be added or replaced.
   */
  public void set(String bits, String value) {
    if (isLeaf()) {
      throw new UnsupportedOperationException("Cannot set value on a leaf node.");
    }
    if (bits.isEmpty()) {
      this.value = value;
    } else {
      char direction = bits.charAt(0);
      if (direction == '0') {
        if (left == null) {
          left = new BitTreeNode();
        }
        left.set(bits.substring(1), value);
      } else if (direction == '1') {
        if (right == null) {
          right = new BitTreeNode();
        }
        right.set(bits.substring(1), value);
      } else {
        throw new IllegalArgumentException("Invalid bit string: " + bits);
      }
    }
  }

  /**
   * Follows the path through the tree given by bits, returning the value at the end.
   *
   * @param bits The bit string representing the path.
   * @return The value at the end of the path.
   */
  public String get(String bits) {
    if (isLeaf()) {
      return this.value;
    } else if (!bits.isEmpty()) {
      char direction = bits.charAt(0);
      if (direction == '0' && left != null) {
        return left.get(bits.substring(1));
      } else if (direction == '1' && right != null) {
        return right.get(bits.substring(1));
      }
    }
    return null;
  }

  /**
   * Prints out the contents of the tree in CSV format.
   *
   * @param pen The PrintWriter to write the output.
   * @param path The path to the current node in the tree.
   */
  public void dump(PrintWriter pen, String path) {
    if (isLeaf()) {
      pen.println(path + "," + this.value);
    } else {
      if (left != null) {
        left.dump(pen, path + "0");
      }
      if (right != null) {
        right.dump(pen, path + "1");
      }
    }
  }

  /**
   * Checks if the node is a leaf.
   *
   * @return True if the node is a leaf, false otherwise.
   */
  public boolean isLeaf() {
    return this.value != null;
  }

  /**
   * Checks if a bit string is valid (contains only 0s and 1s).
   *
   * @param bits The bit string to check.
   * @return True if the bit string is valid, false otherwise.
   */
  protected boolean isValidBitString(String bits) {
    return bits.matches("[01]+");
  }
}
