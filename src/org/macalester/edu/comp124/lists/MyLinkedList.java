package org.macalester.edu.comp124.lists;

/**
 * An unfinished implementation of a basic doubly-linked list.
 *
 * Note that the head and the tail contain "sentinel" nodes without values.
 * This makes the edge cases of the algorithm easier because the list always has a discrete head and tail.
 *
 * @author shilad
 * @param <E>
 */
public class MyLinkedList<E> {
	private MyLinkedNode<E> head;
	private MyLinkedNode<E> tail;
	private int numElements = 0;

    /**
     * Creates a new empty linked list.
     */
	public MyLinkedList() {
		head = new MyLinkedNode<E>(null);
		tail = new MyLinkedNode<E>(null);
		clear();
	}

    /**
     * Returns the element at position index.
     * @param index
     * @return
     */
	public E get(int index) {
        MyLinkedNode <E> currentNode = this.getHead();
        for (int i = 0; i < (index + 1); i++) {
            currentNode = currentNode.getNext();
        }
        return currentNode.getValue();
	}

    /**
     * Adds a new element to the end of the list:
     *
     * @param elem
     */
	public void add(E elem) {
        MyLinkedNode <E> oldNode = this.getTail().getPrev();
        MyLinkedNode <E> newNode = new MyLinkedNode <E> (elem);
        oldNode.setNext(newNode);
        newNode.setPrev(oldNode);
        newNode.setNext(this.getTail());
        this.getTail().setPrev(newNode);
        this.numElements++;
	}

    /**
     * Inserts a new element at the specified index.
     *
     * @param elem
     */
	public void add(int i, E elem) {
        MyLinkedNode <E> currentNode = this.getHead();
        MyLinkedNode <E> newNode = new MyLinkedNode <E> (elem);

        for (int n = 0; n < (i + 1); n++) {
            currentNode.getNext();
        }

        MyLinkedNode <E> prevNode = currentNode.getPrev();
        prevNode.setNext(newNode);
        newNode.setPrev(prevNode);
        newNode.setNext(currentNode);
        currentNode.setPrev(newNode);
        this.numElements++;
	}

    /**
     * Returns the current size of the list.
     * @return
     */
	public int size() {
		return numElements;
	}

    /**
     * Clears the contents of the list.
     */
	public void clear() {
		// set head's next to the tail
		head.setNext(tail);
		head.setPrev(null);
		
		// set tails prev to the head
		tail.setPrev(head);
		tail.setNext(null);
		numElements = 0;
	}


    /**
     * These methods are only used by the unit tests.
     * They are intentionally not public.
     * @return
     */
    MyLinkedNode getHead() { return head; }
    MyLinkedNode getTail() { return tail; }
}
