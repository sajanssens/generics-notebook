import java.util.ArrayList;
import java.util.List;

import static java.lang.IO.println;

public class Generics {
    void main() {
        Box<Candy> candies = new Box<>();
        Box<Chocolate> chocolates = new Box<>();

        inspect(candies);       // ✅
        // inspect(chocolates); // ❌ 😢
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
        for (Candy c : box.getValues()) { c.validate(); }

        if (!box.isFull()) {
            box.add(new Gummybear()); // leads to heartbreak...
        }
    }

    void inspectCo(Box<? extends Candy> box) {
        for (Candy c : box.getValues()) { c.validate(); }

        if (!box.isFull()) {
            // box.add(new Gummybear()); // ❌ box is a consumer only, ✅ heartbreak deflected 💪🏻
        }
    }

    void inspectContra(Box<? super Chocolate> box) {
        // for (Candy c : box.getValues()) { c.validate(); } // ❌ box is a producer

        if (!box.isFull()) {
            // box.add(new Gummybear()); // ❌ not allowed in this type of Box ✅ heartbreak deflected 💪🏻
            box.add(new Chocolate());    // ✅ love secured ❤️
        }
    }

    <C extends Candy> void copy(Box<? extends C> from, Box<? super C> to) {
        for (C c : from.getValues()) {
            to.add(c);
        }
    }
}

abstract class Candy {
    abstract void validate();
}

class Chocolate extends Candy {
    @Override void validate() { /* Chocolate is OK */ }
}

class Gummybear extends Candy {
    @Override void validate() { throw new RuntimeException("🤮"); }
}

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