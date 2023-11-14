/**
 * Represents a node in the BitTree.
 */

class BitTreeNode {
  private BitTreeNode left; // Reference to the left child node
  private BitTreeNode right; // Reference to the right child node

  /**
   * Constructs a BitTreeNode with no children
   */
  public BitTreeNode() {
    this.left = null;
    this.right = null;
  } // BitTreeNode()

  /**
   * Gets the left child node
   * 
   * @return The left child node
   */
  public BitTreeNode getLeft() {
    return left;
  }

  /**
   * Sets the left child node
   * 
   * @param left The left child node to set
   */
  public void setLeft(BitTreeNode left) {
    this.left = left;
  } // setLeft(BitTreeNode)

  /**
   * Gets the right child node
   * 
   * @return The right child node
   */
  public BitTreeNode getRight() {
    return right;
  } // getRight()

  /**
   * Sets the right child node
   * 
   * @param right The right child node to set
   */
  public void setRight(BitTreeNode right) {
    this.right = right;
  } // setRight(BitTreeNode)
} // class BitTreeNode
