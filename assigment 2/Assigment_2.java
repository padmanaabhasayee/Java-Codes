// Base Bird class with general bird properties
class Bird {
    void eat() {
        System.out.println("This bird is eating.");
    }
}

// Interface for birds that can fly
interface Flyable {
    void fly();
}

// Flying bird: Sparrow implements Flyable
class Sparrow extends Bird implements Flyable {
    @Override
    public void fly() {
        System.out.println("Sparrow is flying.");
    }
}

// Non-flying bird: Penguin does not implement Flyable
class Penguin extends Bird {
    void swim() {
        System.out.println("Penguin is swimming.");
    }
}

// Main class to demonstrate LSP compliance
public class Assigment_2 {
    public static void main(String[] args) {
        Bird genericBird = new Bird();
        genericBird.eat();

        Flyable sparrow = new Sparrow();
        sparrow.fly(); // Substitution works correctly for flying birds

        Penguin penguin = new Penguin();
        penguin.eat();
        penguin.swim(); // No flying behavior expected
    }
}
