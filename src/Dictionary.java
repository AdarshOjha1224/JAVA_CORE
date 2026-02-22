import java.util.Arrays;
import java.util.Scanner;

public class Dictionary {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the count of values : ");
        int n = sc.nextInt();

        String[] word = new String[n];

        for(int i = 0 ; i < n ; i++){
            System.out.print("Enter the word no. " + (i+1) + " : ");
            word[i] = sc.next();
        }


        int[][] letter = new int[n][];

        for(int i = 0 ; i < n ; i++){
            int word_l = word[i].length();
            letter[i] = new int[word_l];
            for(int j = 0; j < letter[i].length ; j++){
                letter[i][j] = word[i].charAt(j);
            }
        }

        // to be continue.....
    }
}
