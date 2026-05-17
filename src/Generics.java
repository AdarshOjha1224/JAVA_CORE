class Box<T> {
    private T item;
    public void setItem(T item) {this.item = item;}
    public T getItem() {return item;}
}
public class Generics {

    public static <E> void printArray(E[] array) {
        for (E element : array) System.out.print(element + " ");
        System.out.println();

    }



    public static void main(String[] args) {
        System.out.println("--- Generic Class Example ---");

        Box<String> stringBox = new Box<>();
        stringBox.setItem("Hello, Generics!");
        String message = stringBox.getItem();
        System.out.println("String Box contains: " + message);

        Box<Integer> integerBox = new Box<>();
        integerBox.setItem(100);
        Integer number = integerBox.getItem();

        System.out.println("Integer Box contains: " + number);
        System.out.println("\n--- Generic Method Example ---");
        Integer[] intArray = { 1, 2, 3, 4, 5 };
        String[] stringArray = { "Java", "Python", "C++" };
        System.out.print("Integer Array: ");


        printArray(intArray);
        System.out.print("String Array: ");
        printArray(stringArray);
    }
}