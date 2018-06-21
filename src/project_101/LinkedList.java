/*
 * Adnan Rahin
 * Department of Computer Science,
 * Queens College, CUNY
 * New York.
 * 
 * Instructor: Michael Fried
 */
package project_101;

public class LinkedList<E> implements Stack<E>, List<E> {

	private Node<E> head;
	private int size = 0;
	
	/* Checking Node is empty or not, if empty it will return true or 
	 other cases false.*/ 
	private boolean isempty() {
		if (head == null)
			return true;
		return false;
	}
	/* If List or Stack is empty, this method will initialize the Node*/
	private void instantiate(E newData) {
		head = new Node<E>(newData);
		head.next = null;
	}
	/* This method will delete the node from the List */
	private void pop_1() {
		Node<E> myNode = head;
		if (myNode.next == null) {
			head = null;
			return;
		}
		head = head.next;
	}

	/* List Implementation */
	// Adds element e to the end of the list.
	
	public void add(E newData) {
		++size;
		if (isempty()) {
			instantiate(newData);
			return;
		}
		Node<E> myNode = head;
		Node<E> newNode = new Node<E>(newData);
		newNode.next = null;
		while (myNode.next != null) {
			myNode = myNode.next;
		}
		myNode.next = newNode;
	}

	// Returns the element at the specified index,
	// or throws an IndexOutOfBoundsException if the index is out of range.
	
	public E get(int index) {
		if (index < 0 || index >= size)
			throw new IndexOutOfBoundsException();
		Node<E> myNode = head;
		while (index-- > 0) {
			myNode = myNode.next;
		}
		return myNode.data;
	}

	// Removes and returns the element at the specified index,
	// or throws an IndexOutOfBoundsException if the index is out of range.

	public E remove(int index) {

		if (index < 0 || index >= size)
			throw new IndexOutOfBoundsException();
		
		/*if (head == null) { // if first node is null it will return null 
			return null;
		}*/
		E temp = null; // Holding index value into temporary variable
		--size;
		int counter = 0;
		Node<E> myNode = head;
		while (myNode != null) {
			counter++;
			if (index == 0) {
				temp = head.data;
				head = myNode.next;
				return temp;
			}
			if (counter == index) {
				temp = myNode.next.data;
				myNode.next = myNode.next.next;
				break;
			}
			myNode = myNode.next;
		}
		return temp;
	}

	/* Stack Implementation */

	// Adds element e to the top of the stack.

	public void push(E newData) {
		++size;
		if (isempty()) {
			instantiate(newData);
			return;
		}
		Node<E> newNode = new Node<E>(newData);
		newNode.next = head;
		head = newNode;
	}

	// Removes and returns the top element of the stack, or returns null if the
	// stack is empty.
	
	public E pop() {
		--size;
		pop_1();
		return top();
	}

	// Returns but does not remove the top element of the stack, or returns null if
	// the stack is empty
	
	public E top() {
		if (isempty()) {
			return null;
		}
		return head.data;
	}
	
	// Reverses the order of all the elements of the stack.
	
	public void reverse() { 	
		Node<E> nextNode = null;
		Node<E> prevNode = null;
		Node<E> current = head;
		while (current != null) {
			nextNode = current.next;
			current.next = prevNode;
			prevNode = current;
			current = nextNode;
		}
		head = prevNode;
	}
	
	// Returns a string representation of the linked list.
	
	public String toString() {
		String megatron = "[ " + null;
		if(isempty()) return megatron + " ]";
		
		Node<E> myNode = head;
		megatron = "[";
		while (myNode != null) {
			megatron = megatron + " " + myNode.data;
			myNode = myNode.next;
		}
		megatron = megatron + " ]";
		return megatron;
	}
	
	// Returns the number of elements.
	
	public int size() {
		return size;
	}
	
	private static class Node<E> {
		E data;
		Node<E> next;

		public Node(E data) {
			this.data = data;
			next = null;
		}
	}
}
