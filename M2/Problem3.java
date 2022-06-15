package M2;

import java.util.Arrays;

public class Problem3 {
    public static void main(String[] args) {
        //Don't edit anything here
        Integer[] a1 = new Integer[]{-1, -2, -3, -4, -5, -6, -7, -8, -9, -10};
        Integer[] a2 = new Integer[]{-1, 1, -2, 2, 3, -3, -4, 5};
        Double[] a3 = new Double[]{-0.01, -0.0001, -.15};
        String[] a4 = new String[]{"-1", "2", "-3", "4", "-5", "5", "-6", "6", "-7", "7"};
        
        bePositive(a1);
        bePositive(a2);
        bePositive(a3);
        bePositive(a4);
    }
    static <T> void bePositive(T[] arr){
        System.out.println("Processing Array:" + Arrays.toString(arr));
        //your code should set the indexes of this array
        Object[] output = new Object[arr.length];

        //TODO convert each value to positive
        //set the result to the proper index of the output array
        //hint: don't forget to handle the data types properly

        // UCID: 31485020
        // June 4, 2022
        //for this problem I noticed that each array consisted of different data types. 
        // If I were to loop trough the array then I would need to make sure that the data type was the same.
        // so for each loop of the array i would store the data type of the value in a variable called type and then the value 
        // as a string in a variable called strNum.
        // Since we are already in a for loop, I created a switch statement where each case was a data type.
        // integers and booleans would  be checked to see if it's less than 0. if it is less then zero then it would be multipled by 
        // -1 to make it postive. strings would have to be convereted to integers or doubles in order for it to be evaluated.
        for(int i =0 ;i< arr.length; i++)
        {
            // switch case;
            String type = arr[i].getClass().getSimpleName();
            String strNum = arr[i].toString();
            switch(type)
            {
                case "Integer":
                {
                    // check if its odd or even 
                    int num = Integer.parseInt(strNum);
                    if(num <0)
                    {
                        num*=-1;
                        output[i]=num;
                    }
                    else
                        output[i]=num;
                    
                    break;

                }
                case "Double":
                {
                    double num = Double.parseDouble(strNum);
                    if(num <0.0)
                    {
                        num*=-1.0;
                        output[i]=num;
                    }
                    else    
                        output[i]=num;
                    break;
                }
                case "String":
                {
                    int num = Integer.parseInt(strNum);
                    if(num <0)
                    {
                        num*=-1;
                        output[i]=num;
                    }
                    else
                        output[i]=num;
                    
                    break;
                }
            }

        }
        
        //end edit section

        StringBuilder sb = new StringBuilder();
        for(Object i : output){
            if(sb.length() > 0)
                sb.append(",");
            }
            sb.append(String.format("%s (%s)", i, i.getClass().getSimpleName().substring(0,1)));
        }
        System.out.println("Result: " + sb.toString());
    }
}