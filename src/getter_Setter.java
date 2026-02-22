class employees {
    // private makes the things only accessible only in this class.

    private int id;
    public String name;
    private int salary;

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public int getSalary() { return salary; }
    public void setSalary(int salary) { this.salary = salary; }

}


public class getter_Setter {
    public static void main(String[] args) {

        employees e1 = new employees();
        e1.name = "Adarsh";
        e1.setId(1004);
        e1.setSalary(1500000);

        System.out.println(e1.getId() + " " + e1.name + " " + e1.getSalary());

    }
}
