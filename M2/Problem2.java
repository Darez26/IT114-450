package M2;
import java.util.Arrays;
import java.lang.Math;


public class Problem2 {
    public static void main(String[] args) {
        //Don't edit anything here
        double[] a1 = new double[]{10.001, 11.591, 0.011, 5.991, 16.121, 0.131, 100.981, 1.001};
        double[] a2 = new double[]{1.99, 1.99, 0.99, 1.99, 0.99, 1.99, 0.99, 0.99};
        double[] a3 = new double[]{0.01, 0.01, 0.01, 0.01, 0.01, 0.01, 0.01, 0.01, 0.01, 0.01};
        double[] a4 = new double[]{10.01, -12.22, 0.23, 19.20, -5.13, 3.12};
        
        getTotal(a1);
        getTotal(a2);
        getTotal(a3);
        getTotal(a4);
    }
    static void getTotal(double[] arr){
        System.out.println("Processing Array:" + Arrays.toString(arr));
        double total = 0;
        String totalOutput = "";
        //TODO add/edit code here
        // UCID: 31485020
        // June 4, 2022
        // in order to solve this problem I will create a variable that will keep track of the the total
        // then I will loop trough the array and add each value to the total. 
        // In order to make sure that the total has 2 decimal places I will need to keep use the math library and round the 
        // number.

        for (int i=0; i < arr.length;i++)
        {
            total += arr[i];
        }

        total = (double) Math.round(total*100.0) /100.0;
       
        //set the double to a string variable
        totalOutput = total+"";
        //end add/edit section
        System.out.println("Total is " + totalOutput);
        System.out.println("End process");
    }
    
}