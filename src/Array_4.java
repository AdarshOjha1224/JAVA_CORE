import java.util.Scanner;

public class Array_4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] num = {1,2,3,4,5};
        int[] num1 = new int[5];
        num1[0] = 2;
        num1[1] = 3;
        num1[2] = 5;
        num1[3] = 10;
        num1[4] = 12;

        for(int i = 0 ; i < num1.length ; i++){
            System.out.println(num1[i]);
        }
        System.out.println();

        System.out.print("Enter the x-axis : ");
        int x = sc.nextInt();
        System.out.print("Enter the y-axis : ");
        int y = sc.nextInt();
        System.out.print("Enter the z-axis : ");
        int z = sc.nextInt();


        int[][][] arr = new int[x][y][z];

        for(int i = 0 ; i < z ; i++){
            for(int j = 0 ; j < y ; j++){
                for(int k = 0 ; k < x ; k++){
                    arr[k][j][i] = (int)(Math.random() * 10);
                }
            }
        }

        for(int i = 0 ; i < z ; i++){
            for(int j = 0 ; j < y ; j++){
                for(int k = 0 ; k < x ; k++){
                    System.out.print(arr[k][j][i] + " ");
                }
                System.out.println();
            }
            System.out.println();
        }

    }
}