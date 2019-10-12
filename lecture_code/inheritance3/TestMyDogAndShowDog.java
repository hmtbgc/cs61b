public class TestMyDogAndShowDog {
    public static void main(String[] args) {
        Object o2 = new ShowDog("Mortimer", "Corgi", 25, 512.2);
        ShowDog sdx = ((ShowDog) o2);       // Correct!
        sdx.bark();                         // Print "Look! A dog is barking!!"

        myDog dx = ((myDog) o2);            // Correct!
        dx.bark();                          // Print "Look! A dog is barking!!"

        ((myDog) o2).bark();                // Correct! Print "Look! A dog is barking!!"

        Object o3 = (myDog) o2;             // Correct!
      //  o3.bark();                        // Wrong! o3 static type is "Object", which has no "bark" method
        ((myDog) o3).bark();                // Print "Look! A dog is barking!!"

        Object o4 = new myDog("Mortimer", "Corgi", 25, 512.2);
        ((myDog) o4).bark();                // Correct! Print "Mortimer is barking!!"
    }
}
