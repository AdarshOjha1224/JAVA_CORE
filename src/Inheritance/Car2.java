package Inheritance;

class Car2 extends Car1 {
    public String headlight(boolean head){
        if(head) return "Head light is on";
        return "head light is off";
    }

    public String musicSystem(boolean music){
        if(music) return "Music System is on";
        return "Music System is off";
    }

}
