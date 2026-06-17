package Input;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class IO_bufferedReader {
    public static void main(String[] args) throws IOException {
        // For any project or appication - dont add throws Exception on main

        // println method belongs to PrintStream class
        // To use this method we need Object , but the object "out" is already created a static variable for PrintStream class inside the System class.

        System.out.println("Enter a Number :");
//        int num = System.in.read(); // Storing in Integer
//        System.out.println(num - 48); // Giving ASCII value and 0(Ascii) = 48.


        // "in" Object is already created static variable for InputStream class inside the System class.
        // InputStreamReader constructor need a object of InputStream class to pass.
        InputStreamReader in = new InputStreamReader(System.in);

        // Passing the object of InputStreamReader in BufferReader.
        // InputStreamReader extends Reader so passing its object in BufferedReader Constructor which needs the Object of Reader class to pass
        BufferedReader bf = new BufferedReader(in);
        // It can take input from not just system keyboard but anywhere like file , network etc
        // You can mention the source.

        int input = Integer.parseInt(bf.readLine());
        System.out.println(input);

        bf.close(); // Close resources

    }
}
