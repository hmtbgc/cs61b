public class ShowDog extends myDog {
    public ShowDog(String na, String ty, int ag, double we) {
        super(na, ty, ag, we);
    }

    @Override
    public void bark() {
        System.out.println("Look! A dog is barking!!");
    }
}
