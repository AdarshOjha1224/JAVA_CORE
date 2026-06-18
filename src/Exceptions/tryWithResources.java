package Exceptions;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class tryWithResources {
    public static void main(String[] args) throws IOException {
        int num = 0 ;

        // Try() technique close the resource automatically if the resource Object of class extends the autoClosable.
        // for multiple resources use simple try-catch.
        // Here , br resource will close automatically.
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {

            num = Integer.parseInt(br.readLine());
            System.out.println(num);
        }

        // Finally must execute irrespective to Getting Exception or Not.
        // Whenever You want to Close the resource - Use "finally"
    }
}
