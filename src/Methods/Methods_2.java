package Methods;

class Computer {
    public void playmusic(){
        System.out.println("The music is playing !!");
    }

    public String showImages(int num){
        if(num>=10) return "Images";

        return "nothing";
    }
}


public class Methods_2 {

    // main is method -> where the program start the execution.
    public static void main(String[] args) {
        Computer c1 = new Computer();
        c1.playmusic();
        // what happens BTS ->
        // create a box(Object) with address in the heap which have method playmusic and showImages.
        // c1 is here actually a reference variable because it is referring the object in the heap

        // TWO STEPS ---->>>
        // Methods.Computer c1 ; // reference creation which is c1 . (In the heap with the address)
        // c1 = new Methods.Computer(); // Creating an object and assigning the value to c1. (In the stack with reference variable which referring that same address)
        System.out.println(c1.showImages(11));
        System.out.println(c1.showImages(2));


        new Computer(); // if the constructor is present in the class Methods.Computer that will run
        // this is what we call a anonymous object.
        // if you want to use the anonymous object , you can use it only once like if the method is present
        // In the class Methods.Computer then we can use it like - new Methods.Computer().show(); , but we cant use it again
        // because it doest have any referring variable




    }
}
