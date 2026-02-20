
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
        System.out.println(c1.showImages(11));
        System.out.println(c1.showImages(2));

    }
}
