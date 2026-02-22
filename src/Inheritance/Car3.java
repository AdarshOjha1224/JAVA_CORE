package Inheritance;

class Car3 extends Car2 {
    public String backCamera(boolean bc){
        if(bc) return "Back Camera is on";
        return "Back camera is off";
    }

    public String airCondition(boolean ac){
        if(ac) return "AC is on";
        return "AC is off";
    }
}
