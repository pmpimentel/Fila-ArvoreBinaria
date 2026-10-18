public class QueueTest {
    public static CircularQueue merge(CircularQueue a, CircularQueue b) {
        CircularQueue r = new CircularQueue(a.size() + b.size() == 0 ? 1 : a.size() + b.size());
        while (!a.isEmpty() && !b.isEmpty()) {
            if (a.first() <= b.first()) {
                r.insert(a.remove());
            } else {
                r.insert(b.remove());
            }
        }
        while (!a.isEmpty()) r.insert(a.remove());
        while (!b.isEmpty()) r.insert(b.remove());
        return r;
    }

    public static void main(String[] args) {
        CircularQueue a = new CircularQueue(6);
        CircularQueue b = new CircularQueue(6);
        a.insert(12);
        a.insert(35);
        a.insert(52);
        a.insert(64);
        b.insert(5);
        b.insert(15);
        b.insert(23);
        b.insert(55);
        b.insert(75);

        System.out.print("Fila A: ");
        a.show();
        System.out.print("Fila B: ");
        b.show();
        CircularQueue r = merge(a, b);
        System.out.print("Fila R: ");
        r.show();
    }
}
