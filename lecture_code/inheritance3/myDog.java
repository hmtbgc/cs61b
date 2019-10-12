public class myDog {
    private String name;
    private String type;
    private int age;
    private double weight;

    public myDog(String na, String ty, int ag, double we) {
        name = na;
        type = ty;
        age = ag;
        weight = we;
    }

    public void bark() {
        System.out.println(name + " is barking!!");
    }
}
