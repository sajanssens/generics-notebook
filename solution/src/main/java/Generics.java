import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static java.lang.IO.println;

public class Generics {
    void main() {
        Box<Candy> candies = new Box<>();
        Box<Chocolate> chocolates = new Box<>();

        inspect(candies);       // ✅
        // inspect(chocolates); // ❌
        println(candies.isFull());    // true
        println(chocolates.isFull()); // false 💔

        inspectCo(candies);     // ✅
        inspectCo(chocolates);  // ✅
        println(candies.isFull());    // true
        println(chocolates.isFull()); // false 💔

        inspectContra(candies);    // ✅
        inspectContra(chocolates); // ✅
        println(candies.isFull());    // true
        println(chocolates.isFull()); // true 💚

        println(candies.getValues().size() == 1); // true
        copy(chocolates, candies);
        println(candies.getValues().size() == 2); // true
    }

    void inspect(Box<Candy> box) {
        for (Candy c : box.getValues()) {
            if (c.isStale()) throw new RuntimeException("I'm not a fool! Try again...");
        }
        if (!box.isFull()) {
            box.add(new Chocolate());
        }
    }

    void inspectCo(Box<? extends Candy> box) {
        for (Candy c : box.getValues()) {
            if (c.isStale()) throw new RuntimeException("I'm not a fool! Try again...");
        }

        if (!box.isFull()) {
            // box.add(new Chocolate()); // ❌ box is a consumer only
        }
    }

    void inspectContra(Box<? super Chocolate> box) {
        // for (Candy c : box.getValues()) { // ❌ box is a producer
        //
        // }

        if (!box.isFull()) {
            box.add(new Chocolate()); //✅
        }
    }

    <C extends Candy> void copy(Box<? extends C> from, Box<? super C> to) {
        for (C c : from.getValues()) {
            to.add(c);
        }
    }
}

class Candy {
    public static final int FRESH_FACTOR = 6;

    public boolean isStale() { return new Random().nextInt(FRESH_FACTOR) % FRESH_FACTOR == 0; }
}

class Chocolate extends Candy { }

class Box<T> {
    private final List<T> values = new ArrayList<>();

    public void add(T t) {
        this.values.add(t);
    }

    public boolean isFull() {
        return !values.isEmpty();
    }

    public List<T> getValues() { return values; }
}