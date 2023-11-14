/**
 * Represents a lead in the BitTree.
 */
class BitTreeLeaf extends BitTreeNode {
  private String value; // The value associated with this leaf

  /**
   * Constructs a BitTreeLeaf with the specified values
   * 
   * @param value The value associated with this lead
   */
  public BitTreeLeaf(String value) {
    this.value = value;
  } // BitTreeLeaf(String)

  /**
   * Gets the value associated with this leaf
   * 
   * @return The value associated with this leaf
   */
  public String getValue() {
    return value;
  } // getValue()

  /**
   * Sets the value associated with this leaf
   * 
   * @param value The value to set
   */
  public void setValue(String value) {
    this.value = value;
  } // setValue(String)
} // class BitTreeLeaf
