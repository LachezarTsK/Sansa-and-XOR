import java.util.Scanner;

public class SolutionThree {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int numberOfTestCases = scanner.nextInt();

    while (numberOfTestCases-- > 0) {
      int numberOfElements = scanner.nextInt();
      int[] inputArray = new int[numberOfElements + 1];

      for (int i = 1; i <= numberOfElements; i++) {
        inputArray[i] = scanner.nextInt();
      }

      int result = findXOR_on_elementsOfAllSubarrays(inputArray, numberOfElements);
      System.out.println(result);
    }
    scanner.close();
  }

  /**
   * The method finds the XOR of the elements of all contiguous subarrays.
   *
   * The XOR operation on two integers with the same value is '0'. 
   * The expression for the total number of occurrence of an element 
   * in the subarrays is:
   *
   * position + (allArrayElements - position)*position 
   * 'position' is the actual place in the array, not the index.
   *
   * There are four possible configurations:
   * 1. 'allArrayElements' and 'position' are both even.
   * 2. 'allArrayElements' is even, 'position' is odd.   
   * 3. 'allArrayElements' is odd, and 'position' is even.
   * 4. 'allArrayElements' and 'position' are both odd.
   *
   * Case 1, 2, and 3 result in an even number of total occurrence of an element.
   * Case 4 results in an odd number of total occurrence of an element.
   *
   * Therefore, the method finds the XOR on all the elements in case 4.
   * 
   * @return An integer, representing the value of XOR as described above.
   */ 
  private static int findXOR_on_elementsOfAllSubarrays(int[] inputArray, int numberOfElements) {

    int result = 0;
    if (numberOfElements % 2 == 0) {
      return result;
    }

    for (int i = 1; i <= numberOfElements; i +=2) {
      result ^= inputArray[i];
    }

    return result;
  }
}
