import java.util.NoSuchElementException;

//////////////////////////////////////////////////////////////////////////////////
//
// Title: PO9 Pokemon Catalog
// Course: CS 300 Fall 2020
//
// Author: Bryce Kickbush
// Email: kickbush@wisc.edu
// Lecturer: Mouna Kacem
//
/////////////////////////////////////////////////////////////////////////////////
/**
 * This class checks the correctness of the implementation of the methods defined in the class
 * PokemonTree.
 *
 */

public class PokemonTreeTester {

  /**
   * Checks the correctness of the implementation of both addPokemon() and toString() methods
   * implemented in the PokemonTree class. This unit test considers at least the following
   * scenarios. (1) Create a new empty PokemonTree, and check that its size is 0, it is empty, and
   * that its string representation is an empty string "". (2) try adding one Pokemon and then check
   * that the addPokemon() method call returns true, the tree is not empty, its size is 1, and the
   * .toString() called on the tree returns the expected output. (3) Try adding another Pokemon
   * which is more powerful than the one at the root, (4) Try adding a third Pokemon which is less
   * powerful than the one at the root, (5) Try adding at least two further Pokemons such that one
   * must be added at the left subtree, and the other at the right subtree. For all the above
   * scenarios, and more, double check each time that size() method returns the expected value, the
   * add method call returns true, and that the .toString() method returns the expected string
   * representation of the contents of the binary search tree in an ascendant order from the most
   * powerful Pokemon to the least powerful one. (6) Try adding a Pokemon whose CP value was used as
   * a key for a Pokemon already stored in the tree. Make sure that the addPokemon() method call
   * returned false, and that the size of the tree did not change.
   * 
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  public static boolean testAddPokemonToStringSize() {
    PokemonTree bst = new PokemonTree();
    Pokemon Pikachu = new Pokemon("Pikachu", "1,2,3");
    Pokemon Dialga = new Pokemon("Dialga", "9,9,9");
    Pokemon Chimchar = new Pokemon("Chimchar", "1,1,1");

    if (bst.size() != 0) {
      return false;
    }

    if (bst.addPokemon(Pikachu) != true) {
      return false;
    }

    if (bst.size() != 1) {
      return false;
    }

    if (bst.addPokemon(Dialga) != true) {
      return false;
    }

    if (bst.size() != 2) {
      return false;
    }
    if (bst.addPokemon(Dialga) != false) {
      return false;
    }

    bst.addPokemon(Chimchar);
    if (bst.size() != 3) {
      return false;
    }

    if (!bst.toString().contentEquals(
        Chimchar.toString() + "\n" + Pikachu.toString() + "\n" + Dialga.toString() + "\n")) {
      return false;
    }

    return true;
  }

  /**
   * This method checks mainly for the correctness of the PokemonTree.lookup() method. It must
   * consider at least the following test scenarios. (1) Create a new PokemonTree. Then, check that
   * calling the lookup() method with any valid CP value must throw a NoSuchElementException. (2)
   * Consider a PokemonTree of height 3 which consists of at least 5 PokemonNodes. Then, try to call
   * lookup() method to search for the Pokemon at the root of the tree, then a Pokemon at the right
   * and left subtrees at different levels. Make sure that the lookup() method returns the expected
   * output for every method call. (3) Consider calling .lookup() method on a non-empty PokemonTree
   * with a CP value not stored in the tree, and ensure that the method call throws a
   * NoSuchElementException.
   * 
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  public static boolean testAddPokemonAndLookup() {
    PokemonTree bst = new PokemonTree();
    Pokemon Pikachu = new Pokemon("Pikachu", "1,2,3");
    Pokemon Dialga = new Pokemon("Dialga", "9,9,9");
    Pokemon Chimchar = new Pokemon("Chimchar", "1,1,1");

    bst.addPokemon(Pikachu);
    if (bst.lookup(123) != Pikachu) {
      return false;
    }

    try {
      bst.lookup(3250);
    } catch (NoSuchElementException e) {
    }

    bst.addPokemon(Dialga);
    if (bst.lookup(999) != Dialga) {
      return false;
    }

    bst.addPokemon(Chimchar);
    if (bst.lookup(111) != Chimchar) {
      return false;
    }

    return true;
  }

  /**
   * Checks for the correctness of PokemonTree.height() method. This test must consider several
   * scenarios such as, (1) ensures that the height of an empty Pokemon tree is zero. (2) ensures
   * that the height of a tree which consists of only one node is 1. (3) ensures that the height of
   * a PokemonTree with the following structure for instance, is 4. (*) / \ (*) (*) \ / \ (*)(*) (*)
   * / (*)
   * 
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  public static boolean testHeight() {
    PokemonTree bst = new PokemonTree();
    Pokemon Pikachu = new Pokemon("Pikachu", "1,2,3");
    Pokemon Dialga = new Pokemon("Dialga", "9,9,9");
    Pokemon Chimchar = new Pokemon("Chimchar", "1,1,1");
    bst.addPokemon(Pikachu);
    bst.addPokemon(Chimchar);
    bst.addPokemon(Dialga);

    if (bst.height() != 2) {
      return false;
    }

    Pokemon Wingull = new Pokemon("Wingull", "1,1,4");
    bst.addPokemon(Wingull);

    Pokemon Treeko = new Pokemon("Treeko", "1,1,5");
    bst.addPokemon(Treeko);

    if (bst.height() != 4) {
      return false;
    }

    return true;
  }

  /**
   * Checks for the correctness of PokemonTree.getLeastPowerfulPokemon() method.
   * 
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  public static boolean testGetLeastPowerfulPokemon() {
    PokemonTree bst = new PokemonTree();
    Pokemon Pikachu = new Pokemon("Pikachu", "1,2,3");
    Pokemon Dialga = new Pokemon("Dialga", "9,9,9");
    Pokemon Chimchar = new Pokemon("Chimchar", "1,1,1");
    bst.addPokemon(Pikachu);
    bst.addPokemon(Chimchar);
    bst.addPokemon(Dialga);

    if (bst.getLeastPowerfulPokemon() != Chimchar) {
      return false;
    }

    return true;
  }

  /**
   * Checks for the correctness of PokemonTree.getMostPowerfulPokemon() method.
   * 
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  public static boolean testGetMostPowerfulPokemon() {
    PokemonTree bst = new PokemonTree();
    Pokemon Pikachu = new Pokemon("Pikachu", "1,2,3");
    Pokemon Dialga = new Pokemon("Dialga", "9,9,9");
    Pokemon Chimchar = new Pokemon("Chimchar", "1,1,1");
    bst.addPokemon(Pikachu);
    bst.addPokemon(Chimchar);
    bst.addPokemon(Dialga);

    if (bst.getMostPowerfulPokemon() != Dialga) {
      return false;
    }

    return true;
  }

  /**
   * Calls the test methods
   * 
   * @param args input arguments if any
   */
  public static void main(String[] args) {
    System.out.println(testAddPokemonToStringSize());
    System.out.println(testAddPokemonAndLookup());
    System.out.println(testHeight());
    System.out.println(testGetLeastPowerfulPokemon());
    System.out.println(testGetMostPowerfulPokemon());
  }

}
