import java.io.*;
import java.util.*;

public class Test {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        List<List<Integer>> arr = new ArrayList<>();

		// gets user inputs as row-wise in space seperated integers
		// i.e.: 1 2 3 4 5 6
        for (int i = 0; i < 6; i++) {
			System.out.println(String.format("Enter space seperated 6 numbers for line %d :", i + 1));
            String[] arrRowTempItems = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

            List<Integer> arrRowItems = new ArrayList<>();

            for (int j = 0; j < 6; j++) {
                int arrItem = Integer.parseInt(arrRowTempItems[j]);
                arrRowItems.add(arrItem);
            }

            arr.add(arrRowItems);
        }
        
        // finds the max value
        int max = Integer.MIN_VALUE;
        for (int k = 0; k < 4; k++) {
            for (int l = 0; l < 4; l++) {
                int current = 0;
                for (int m = 0; m < 3; m++) {
                    for (int n = 0; n < 3; n++) {
                        if (!(m == 1 && n%2 == 0)) {
                            current += arr.get(k+m).get(l+n);                            
                        }
                    }
                }
                if (current > max) {
                    max = current;
                }
            }   
        }
        
		// prints the max value
        System.out.println("\n Largest hourglass sum is : " + max);

        bufferedReader.close();
    }
}