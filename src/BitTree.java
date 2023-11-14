import java.io.*;
import java.util.HashMap;

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
    this.bitLength = n;
    this.root = new BitTreeNode();
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
    if (bits.length() != bitLength || !isValidBits(bits)) {
      throw new IllegalArgumentException("Invalid bits");
    }

    BitTreeNode currentNode = root;

    for (char bit : bits.toCharArray()) {
      if (bit == '0') {
        if (currentNode.getLeft() == null) {
          currentNode.setLeft(new BitTreeNode());
        }
        currentNode = currentNode.getLeft();
      } else if (bit == '1') {
        if (currentNode.getRight() == null) {
          currentNode.setRight(new BitTreeNode());
        }
        currentNode = currentNode.getRight();
      }
    }

    // Create a new leaf node with the specified value
    currentNode.setLeft(new BitTreeLeaf(value));
  } // set(String, String)

  /**
   * Gets the value associated with the specified bits in the tree.
   * 
   * @param bits The bits to get the value for
   * @return The value associated with the bits
   * @throws IllegalArgumentException if there is no such path or if bitsis the incorrect length
   */
  public String get(String bits) {
    if (bits.length() != bitLength || !isValidBits(bits)) {
      throw new IllegalArgumentException("Invalid bits");
    }
    BitTreeNode currentNode = root;

    for (char bit : bits.toCharArray()) {
      if (bit == '0') {
        if (currentNode.getLeft() == null) {
          throw new IllegalArgumentException("No such path");
        }
        currentNode = currentNode.getLeft();
      } else if (bit == '1') {
        if (currentNode.getRight() == null) {
          throw new IllegalArgumentException("No such path");
        }
        currentNode = currentNode.getRight();
      }
    }

    // Check if the node is a leaf
    if (currentNode instanceof BitTreeLeaf) {
      return ((BitTreeLeaf) currentNode).getValue();
    } else {
      throw new IllegalArgumentException("No such path");
    }
  } // get(String)

  /**
   * Prints the contents of the tree in CSV format.
   * 
   * @param pen The PrintWriter to write the output to.
   */
  public void dump(PrintWriter pen) {
    dumpHelper(root, "", pen);
  } // dump(PrintWriter)

  private void dumpHelper(BitTreeNode node, String bits, PrintWriter pen) {
    if (node instanceof BitTreeLeaf) {
      pen.println(bits + "," + ((BitTreeLeaf) node).getValue());
    } else {
      if (node.getLeft() != null) {
        dumpHelper(node.getLeft(), bits + "0", pen);
      }
      if (node.getRight() != null) {
        dumpHelper(node.getRight(), bits + "1", pen);
      }
    }
  }

  /**
   * Reads a series of lines in the form bits,v values and stores them in the tree.
   * 
   * @param source The InputStream to read from
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
  } // load(InputStream)

  // Helper method to check if bits contain only '0' and '1'
  private boolean isValidBits(String bits) {
    return bits.matches("[01]+");
  } // isValidBits(String)
} // class BitTree
