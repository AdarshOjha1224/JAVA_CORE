package Inheritance;

class Car1 {
    public String accelerator(int a){
        if(a>30) return "Speeding...";
        return "Same Speed";
    }
    public String brake(int b){
        if(b==0) return "Stop";
        return "Slowing";
    }
}