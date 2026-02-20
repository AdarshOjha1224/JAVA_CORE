import java.util.Scanner;

public class jaggedArray_5 {
    public static void main(String[] args) {

        int[][] nums = new int[3][];   // Jagged Array

        nums[0] = new int[3];
        nums[1] = new int[5];
        nums[2] = new int[4];


        for(int i = 0 ; i < nums.length ; i++){
            for(int j = 0 ; j < nums[i].length ; j++){
                nums[i][j] = (int)(Math.random() * 10);
            }
        }

        for(int[] n : nums){
            for(int m : n){
                System.out.print(m + " ");
            }
            System.out.println();
        }
        System.out.println("\n");

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the x-axis : ");
        int x = sc.nextInt();
        System.out.print("Enter the y-axis : ");
        int y = sc.nextInt();
        System.out.print("Enter the z-axis : ");
        int z = sc.nextInt();

        int[][][] arr = new int[z][y][x];

//        arr[0] = new int[2][];
//        arr[1] = new int[3][];
//        arr[2] = new int[1][];
//
//        arr[0][0] = new int[4];
//        arr[0][1] = new int[3];
//
//        arr[1][0] = new int[6];
//        arr[1][1] = new int[2];
//        arr[1][2] = new int[5];
//
//        arr[2][0] = new int[4];

        for(int i = 0 ; i < arr.length ; i++){
            for(int j = 0 ; j < arr[i].length ; j++){
                for (int k = 0 ; k < arr[i][j].length ; k++){
                    arr[i][j][k] = (int)(Math.random()*10);
                }
            }
        }

        for(int[][] a : arr){
            for(int[] b : a){
                for(int c : b){
                    System.out.print(c + " ");
                }
                System.out.println();
            }
            System.out.println();
        }
    }
}
