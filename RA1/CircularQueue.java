public class CircularQueue {
    private int[] values;
    private int start;
    private int end;
    private int count;

    public CircularQueue(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("A capacidade deve ser positiva.");
        }
        values = new int[capacity];
        start = 0;
        end = 0;
        count = 0;
    }

    public boolean isFull() {
        return count == values.length;
    }

    public boolean isEmpty() {
        return count == 0;
    }

    public void insert(int e) {
        if (isFull()) {
            throw new IllegalStateException("Fila cheia.");
        }
        values[end] = e;
        end = (end + 1) % values.length;
        count++;
    }

    public int remove() {
        if (isEmpty()) {
            throw new IllegalStateException("Fila vazia.");
        }
        int removed = values[start];
        start = (start + 1) % values.length;
        count--;
        return removed;
    }

    public int first() {
        if (isEmpty()) {
            throw new IllegalStateException("Fila vazia.");
        }
        return values[start];
    }

    public int last() {
        if (isEmpty()) {
            throw new IllegalStateException("Fila vazia.");
        }
        int position = (end - 1 + values.length) % values.length;
        return values[position];
    }

    public int size() {
        return count;
    }

    public void show() {
        System.out.print("[");
        for (int i = 0; i < count; i++) {
            if (i > 0) System.out.print(", ");
            System.out.print(values[(start + i) % values.length]);
        }
        System.out.println("]");
    }
}
