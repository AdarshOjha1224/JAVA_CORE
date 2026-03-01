package Objects;

class Laptop {
    String model ;
    int price ;

    //    we want to compare with the values.
//    so we are creating this method which can override the method of the Object class.

//    public boolean equals(Objects.Laptop that){
//        return (this.model.equals(that.model) && this.price == that.price);
//    }


    @Override
    public String toString() {
        return "Objects.Laptop{" +
                "model='" + model + '\'' +
                ", price=" + price +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;

        Laptop laptop = (Laptop) o;
        return price == laptop.price && model.equals(laptop.model);
    }

    @Override
    public int hashCode() {
        int result = model.hashCode();
        result = 31 * result + price;
        return result;
    }
}


public class ObjectClassEqualsToStringHashcode {
    public static void main(String[] args) {

        Laptop l1 = new Laptop();
        l1.model = "Dell-latitude";
        l1.price = 54000;

        Laptop l2 = new Laptop();
        l2.model = "Dell-latitudee";
        l2.price = 54000;


//        every time you trying to call the object it will call toString() method.
//        hash -> trying to convert all the data into single string.

                System.out.println(l1);

        boolean result = l1.equals(l2) ;
        // equals is a part of Object class in java , which compare the hexadecimal of the data.

        System.out.println(result);
    }
}
