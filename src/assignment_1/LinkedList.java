package assignment_1;


public class LinkedList<E> implements List<E>, Stack<E> {
	private Node<E> first, last;
	private int size = 0;

	private static class Node<E> {
		E data;
		Node<E> next;

		Node(E data, Node<E> next) {
			this.data = data;
			this.next = next;
		}
	}

	// Construct a new empty list.
	public LinkedList() {
		first = last = new Node<>(null, null);
	}

	// Adds element e to the end of the list.
	public void add(E e) {
		last.next = new Node<>(e, null);
		last = last.next;
		++size;
	}

	// Returns the element at the specified index,
	// or throws an IndexOutOfBoundsException if the index is out of range.
	public E get(int index) {
		if (index < 0 || index >= size)
			throw new IndexOutOfBoundsException();
		Node<E> t = first.next;
		for (int i = 0; i < index; ++i)
			t = t.next;
		return t.data;
	}

	// Removes and returns the element at the specified index,
	// or throws an IndexOutOfBoundsException if the index is out of range.
	public E remove(int index) {
		// Fill in.
		return top();
	}

	public void removeLast() {

		if (last == null)
			return;

		else {
			if (first == last) {
				first = null;
				last = null;
			} 
			else {
				Node<E> previousToTail = first;
				while (previousToTail.next != last) {
					previousToTail = previousToTail.next;
				}
				last = previousToTail;
				last.next = null;
			}
		}
	}

	// Adds element e to the top of the stack.
	public void push(E e) {
		// Fill in.
		Node<E> newNode = new Node<E>(e, null);
		newNode.next = first;
		first = newNode;
	}

	// Removes and returns the top element of the stack, or returns null if the
	// stack is empty.
	public E pop() {
		// Fill in.
		removeLast();
		return top();
	}

	// Returns but does not remove the top element of the stack, or returns null if
	// the stack is empty.
	public E top() {
		
		if(first == null) return null;
		Node<E> myNode = first;
		while(myNode.next.next!=null) {
			myNode = myNode.next;
		}
		return myNode.data;
	}
	public void display() {
		Node<E> newNode = first;
		while(newNode.next!=null) {
			System.out.print(newNode.data + " ");
			newNode = newNode.next;
		}
		System.out.println();
	}

	// Reverses the order of all the elements of the stack.
	public void reverse() {
		// Fill in.
		Node <E> nextnode = null;
		Node <E> prevnode = null;
		Node <E> current = first;
		while(current!=null){
			nextnode = current.next;
			current.next  = prevnode;
			prevnode = current;
			current = nextnode;
		}
		first = prevnode;
	}

	// Returns a string representation of the linked list.
	/*public String toString() {
		// Fill in.
	}*/

	// Returns the number of elements.
	public int size() {
		return size;
	}

}