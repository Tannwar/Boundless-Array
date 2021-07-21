
public class Queue {

	/*
	 * For this exercise, implement a queue of Objects. Formally, support the following operations:
constructor - initialize an empty queue.
delete - return (and delete) the Object extracted from the front of the queue.
insert - insert a given Object on the back of the queue.
isEmpty - return true if the queue is empty, and false otherwise.
toString - return a String summarizing the entire contents of the queue (from front to back).
toStore - return a String summarizing the entire contents of queue storage 
(from array index 0 to length-1).

Use a single array of Strings to store the Queue. Give it an initial size of 10, but allow it to grow, if necessary. 
If the user asks to insert an element beyond the end of the array, allocate an array twice the current size, copy the
contents of the old array to the new one (you will actually be copying references), and carry out the requested 
insertion. If the user requests a deletion from an empty Queue, just return null. (The isEmpty method is 
available to enable the user to detect that exceptional case.) 

Use the 'boundless' array implementation strategy discussed in class. Allocate a single array to store the queue's 
contents and maintain two indexes: one for the front of the queue, and a second for the index of the next open 
element on the back. For simplicity, also maintain a data member for the size. The implementation must be 
efficient. (To help with debugging and visualizing the queue contents, when constructing an empty queue, 
initialize each array element to the String "O", for 'open').

	 */
	
	private Object[] q;
	private int size;
	private int back; // next available index
	private int front;
	public static final int INITAL_CAPACITY = 10;
	
	public Queue() {
		super();
		q = new Object[INITAL_CAPACITY];
		for (int i = 0; i < q.length; i++) {
			 q[i] = "O";
		}
		size = 0;
		back = 0;
		front = 0;
	}
	
	public boolean isEmpty() {
		return size == 0;
	}
	
	public int size() {
		return size;
	}
	
	public Object delete() {
		if (isEmpty()) {
			return null;
		}
		Object obj = q[front];
		q[front] = "O";
		front++;
		if (front == q.length) {
			front = 0;
		}
		// front = (front + 1) % q.length;
		size--;
		return obj;
	}
	
	public void insert(Object name) {
		if (size == q.length) {
			reSize();
		}
		q[back] = name;
		back++;
		if (back == q.length) {
			back = 0;
		}
		// back = (back + 1) % q.length;
		size++;
	}
	
	private void reSize() {
		Object[] bigger = new Object[q.length * 2];
		int index = front;
		for (int i = 0; i < bigger.length; i++) {
			if (i < size) {
				bigger[i] = q[index];
				index++;
				if (index == q.length) {
					index = 0;
				}
			} else {
				bigger[i] = "O";
			}
		}
		
		front = 0;
		back = size;
		q = bigger;
	}

	public String toString() {
		String s = "";
		int index = front;
		for (int i = 0; i < size; i++) {
			Object name = q[index];
			s += name + " ";
			index++;
			if (index == q.length) {
				index = 0;
			}
			// index = (index + 1) % q.length;
		}
		return s;
	}
	
	public String toStore() {
		String s = "";
		for (int i = 0; i < q.length; i++) {
			Object name = q[i];
			s += name + " ";
		}
		return s;
	}
}
