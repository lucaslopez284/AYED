package prac1Ej8;

public class CircularQueue <T> extends Queue<T> {
    public T shift() {
    	T element = super.dequeue();
    	super.enqueue(element);
    	return element;
    }
}
