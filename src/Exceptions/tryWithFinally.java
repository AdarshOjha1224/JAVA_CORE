package Exceptions;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class tryWithFinally {
    public static void main(String[] args) throws IOException {

        int num = 0 ;
        BufferedReader br = null ;

        // instead of catch, we are using finally
        // Advantage of finally - we know that which resource we are closing.
        //                      - If we have multiple object created
        // Try() technique close the resource automatically. and have only one object
        try {
            br = new BufferedReader(new InputStreamReader(System.in));
            num = Integer.parseInt(br.readLine());
            System.out.println(num);
        }

        // Finally must execute irrespective to Getting Exception or Not.
        // Whenever You want to Close the resource - Use "finally"
        finally {
            br.close();
        }
    }
}
