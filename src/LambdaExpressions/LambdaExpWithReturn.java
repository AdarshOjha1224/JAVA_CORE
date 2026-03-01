package LambdaExpressions;

@FunctionalInterface
interface first {
    int add(int i , int j);
}



public class LambdaExpWithReturn {
    public static void main(String[] args) {

//        first f1 = new first() {
//            @Override
//            public int add(int i, int j) {
//                return i+j;
//            }
//        };

        /// LAMBDA EXPRESSION ->>>

        first f1 = (i,j) -> i+j;

        
        int result = f1.add(13,17);
        System.out.println(result);
    }
}
