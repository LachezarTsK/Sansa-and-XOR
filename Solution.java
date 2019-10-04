import java.util.Scanner;
import java.util.Set;
import java.util.HashSet;

public class SolutionSet {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int numberOfTestCases = scanner.nextInt();

    while (numberOfTestCases-- > 0) {
    
      int numberOfElements = scanner.nextInt();
      int[] inputArray = new int[numberOfElements + 1];

      for (int i = 1; i <= numberOfElements; i++) {
        inputArray[i] = scanner.nextInt();
      }

      Set<Integer> elementsForXOR = findElementsForXOR(inputArray, numberOfElements);
      int result = findXOR_on_elementsOfAllSubarrays(elementsForXOR);
      System.out.println(result);
    }
    scanner.close();
  }

  /**
   * The method finds those elements, part of all contiguous subarrays, that have an influence
   * on the result of the XOR operation.
   *
   * Since the XOR operation done on two integers with the same value returns '0', we need 
   * to find those elements of the subarrays that have an odd total number of occurrence, 
   * and record one representative of each. The elements that have an even total number 
   * of occurrence will cancel out each other with the XOR operation, thus they will not change 
   * the result of XOR operation.
   *
   * @return A Set of integers for the XOR operation.
   */
  private static Set<Integer> findElementsForXOR(int[] inputArray, int numberOfElements) {

    /**
     * The Set contains representatives of those elements that have an odd number of total occurence
     * in the subarrays. The XOR operation will be done on those elements.
     */
    Set<Integer> elementsForXOR = new HashSet<Integer>();

    for (int i = 1; i <= numberOfElements; i++) {
    /**
    * The total occurrence of an element in all contiguous subarrays
    * is determined by the expression:
    * (i + (numberOfElements - i) * i)
    * where 'i' is actual position(not index) in the inputArray.
    */
      int totalOccurrenceOfElement = i + (numberOfElements - i) * i;

      if (!elementsForXOR.contains(inputArray[i]) && (totalOccurrenceOfElement % 2 != 0)) {
        elementsForXOR.add(inputArray[i]);
      } else {
        elementsForXOR.remove(inputArray[i]);
      }
    }
    return elementsForXOR;
  }

  /** 
  * The method finds the XOR of those subarray elements that do not cancel out each other. 
  */
  private static int findXOR_on_elementsOfAllSubarrays(Set<Integer> elementsForXOR) {
    int result = 0;
    for (Integer n : elementsForXOR) {
      result = result ^ n;
    }
    return result;
  }
}
