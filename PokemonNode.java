//////////////////////////////////////////////////////////////////////////////////
//
//Title: PO9 Pokemon Catalog
//Course: CS 300 Fall 2020
//
//Author: Bryce Kickbush
//Email: kickbush@wisc.edu
//Lecturer: Mouna Kacem
//
/////////////////////////////////////////////////////////////////////////////////
public class PokemonNode {
  private Pokemon data; // data field of this PokemonNode
  private PokemonNode leftChild;
  private PokemonNode rightChild;

  /**
   * Set nodes to null, throws exception if data is null
   */
  public PokemonNode(Pokemon data) {
    if (data == null) {
      throw new IllegalArgumentException();
    }
    this.data = data;
    this.leftChild = null;
    this.rightChild = null;
  }

  /**
   * 
   * @return - Reference to this nodes left child
   */
  public PokemonNode getLeftChild() {
    return this.leftChild;
  }

  /**
   * 
   * @return - Reference to this nodes right child
   */
  public PokemonNode getRightChild() {
    return this.rightChild;
  }

  /**
   * 
   * @return - Pokemon in this node
   */
  public Pokemon getPokemon() {
    return this.data;
  }

  /**
   * 
   * @param left
   */
  public void setLeftChild(PokemonNode left) {
    this.leftChild = left;
  }

  /**
   * 
   * @param right
   */
  public void setRightChild(PokemonNode right) {
    this.rightChild = right;
  }

}
