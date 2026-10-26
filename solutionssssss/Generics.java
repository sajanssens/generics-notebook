import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Generics {
    void main() {
        Box<Candy> candies = new Box<>();
        Box<Chocolate> chocolates = new Box<>();

        inspect(candies);
        // inspect(chocolates); // ❌

        inspectCo(candies);
        inspectCo(chocolates); // ✅

        copy(chocolates, candies);
    }

    void inspect(Box<Candy> box) {
        for (Candy c : box.getValues()) {
            if (c.isStale()) throw new RuntimeException("I'm not a fool!");
        }
        if (!box.isFull()) {
            box.add(new Chocolate());
        }
    }

    void inspectCo(Box<? extends Candy> box) {
        for (Candy c : box.getValues()) {
            if (c.isStale()) throw new RuntimeException("I'm not a fool!");
        }

        if (!box.isFull()) {
            // box.add(new Chocolate()); // ❌
        }
    }

    void inspectContra(Box<? extends Candy> box) {
        for (Candy c : box.getValues()) {
            if (c.isStale()) throw new RuntimeException("I'm not a fool!");
        }

        if (!box.isFull()) {
            // box.add(new Chocolate()); // ❌
        }
    }

    static <C extends Candy> void copy(Box<? extends C> from, Box<? super C> to) {
        for (C c : from.getValues()) {
            to.add(c);
        }
    }
}

class Candy {
    public boolean isStale() { return new Random().nextInt(2) % 2 == 0; }
}

class Chocolate extends Candy { }

class Box<T> {
    private List<T> values = new ArrayList<>();

    public void add(T t) {
        this.values.add(t);
    }

    public boolean isFull() {
        return values.size() > 0;
    }

    public List<T> getValues() { return values; }
}