public class EfficientStringTest {
    public static void main(String[] args) {
        EfficientString val = new EfficientString("boy");
        System.out.println(val.hashcode());
        System.out.println(val.toString());
        val.setVal("girl");
        System.out.println(val.hashcode());
        System.out.println(val.toString());
        System.out.println(val.equals(3));
        System.out.println(val.equals("girl"));
        EfficientString val_test = new EfficientString("girl");
        System.out.println(val.equals(val_test));
    }
}
