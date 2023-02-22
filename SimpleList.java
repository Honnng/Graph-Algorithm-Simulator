// TO DO: add your implementation and JavaDocs.

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Simple list class. 
 *  
 * @param <T> values in list.
 * @author Hongjia Hao.
 */
class SimpleList<T> implements Iterable<T> {
	
	// A linked list class 
	// You decide the internal attributes and node structure
	// But they should all be private

	// Class for the internal node: not visible to the outside 
	// Do not change the provided fields: otherwise the provided iterator() will not work
	
	//DO NOT CHANGE THIS CLASS EXCEPT TO ADD JAVADOCS
	/**
	 * Node class.
	 * @param <T> node.
	 */
	private class Node<T> {
		/**
		 * Data to store.
		 */
		T value;		// data to store
		/**
		 * Link to the next node.
		 */
		Node<T> next;	// link to the next node
		
		/**
		 * Constructor.
		 * @param value node value
		 */
		public Node(T value){
			this.value = value;
		}
	}
	
	/**
	 * First node.
	 */
	private Node<T> head;  	// first node, not dummy
	/**
	 * Last node.
	 */
	private Node<T> tail;  	// last node, not dummy

	// ADD MORE PRIVATE MEMBERS HERE IF NEEDED!
	/**
	 * List size.
	 */
	private int size = 0;

	/**
	 * Constructor.
	 */
	public SimpleList(){ 
		// Constructor
		// Initialize an empty list
		
		// O(1)
		this.head = null;
		this.tail = null;
	}
	/**
	 * List size.
	 * @return the size of the list.
	 */
	public int size(){
		//Return the number of nodes in list
		//O(1)
		
		return this.size; //default return; change or remove as needed
	}
	/**
	 * Add a node at last in the list.
	 * @param value node added.
	 * @throws IllegalArgumentException if value is null.
	 */
	public void addLast(T value) throws IllegalArgumentException{
		// Add a new node to the tail of the linked list to hold value
		
		// O(1) 
		
		// Note: The value to be added cannot be null.
		// - Throw IllegalArgumentException if value is null. 
		// - Use this _exact_ error message for the exception 
		//  (quotes are not part of the message):
		//    "Cannot add null value!"

		if(value == null){
			throw new IllegalArgumentException("Cannot add null value!");
		}
		Node<T> temp = new Node(value);
		if(size == 0){
			this.head = temp;
			this.tail = temp;
		}
		else if(this.size == 1){
			this.tail = temp;
			this.head.next = this.tail;
		}
		else{
			this.tail.next = temp;
			this.tail = this.tail.next;
		}
		this.size += 1;
	}
	/**
	 * Remove the first node in the list.
	 * @return value that removed.
	 */
	public T removeFirst(){
		// Remove the node from the head of the linked list 
		// and return the value from the node.
		// If linked list is empty, return null.
		
		// O(1)
		if(this.size == 0){
			return null;
		}
		else if(this.size == 1){
			Node<T> temp = this.head;
			this.head = null;
			this.tail = null;
			this.size -= 1;
			return temp.value;
		}
		else{
			Node<T> temp = this.head;
			this.head = this.head.next;
			this.size -= 1;
			return temp.value;
		}
		//default return; change or remove as needed
	}

	/**
	 * Remove the first occurrence of that value.
	 * @param value value should be removed.
	 * @return return true if value removed, return false if value not present.
	 */
	public boolean remove(T value){
		// Given a value, remove the first occurrence of that value
		// Return true if value removed
		// Return false if value not present
		
		// O(N) where N is the number of nodes in list
		
		// NOTE: remember to use .equals() for comparison
		if(this.size == 0){
			return false;
		}
		if(this.size == 1){
			if(this.head.value.equals(value)){
				this.head = null;
				this.tail = null;
				this.size -= 1;
				return true;
			}
		}
		if(this.size == 2){
			if(this.head.value.equals(value)){
				this.head = this.tail;
				this.size -= 1;
				return true;
			}
			if(this.tail.value.equals(value)){
				this.tail = this.head;
				this.size -= 1;
				return true;
			}
		}
		if(this.head.value.equals(value)){
			this.head = this.head.next;
			this.size -= 1;
			return true;
		}
		Node<T> temp = this.head;
		for(int i = 1; i < this.size - 1; i++){
			if(temp.next.value.equals(value)){
				if(temp.next == this.tail){
					this.tail = temp;
					this.size -= 1;
					return true;
				}
				else{
					temp.next = temp.next.next;
					this.size -= 1;
					return true;
				}
			}
			temp = temp.next;
		}
		return false; //default return; change or remove as needed		
	}
	/**
	 * Find the node with the specified value.
	 * @param value value should be find.
	 * @return	return the value stored.
	 */
	public T get(T value){
		// Find the node with the specified value and
		// *RETURN THE VALUE STORED* from linked list,
		// do NOT return the incoming value.
		// Return null if value is not present.
		
		// O(N) where N is the number of nodes in list
		
		// NOTE: two values might be considered "equivalent" but not identical
		//       example: check Pair class in HashMap.java:
		//				Pair <k,v1> and <k,v2> equal to each other for different v1 and v2 
		// NOTE: remember to use .equals() for comparison

		if(this.size == 0){
			return null;
		}
		if(this.size == 1){
			if(this.head.value.equals(value)){
				return this.head.value;
			}
			else{
				return null;
			}
		}
		Node<T> temp = this.head;
		for(int i = 0; i < this.size - 1; i++){
			if(temp.value.equals(value)){
				return temp.value;
			}
			temp = temp.next;
		}
		if(this.tail.value.equals(value)){
			return this.tail.value;
		}
		return null; //default return; change or remove as needed	
	}

	// Provided: do not change but you will need to add JavaDoc
	/**
	 * Iterator class.
	 * @return new Iterator.
	 */
	public Iterator<T> iterator(){
		// return a basic iterator of T
		// Note that this method uses your linked list!
		// so if the iterator doesn't work, that's on you...

		return new Iterator<>(){
			private Node<T> current = head;
			
			/**
			 * Has next class.
			 * @return true if has next, false if null.
			 */
			public boolean hasNext(){			
				return (current!=null);
			}
			
			/**
			 * Next class.
			 * @return next value.
			 */
			public T next(){
				if(!hasNext()) {
					throw new NoSuchElementException();
				}
				T toReturn = current.value;
				current = current.next;
				return toReturn;
			}
		};
	}
	
	// Provided: do not change but you will need to add JavaDoc
	/**
	 * To string method.
	 * @return string.
	 */
	@Override
	public String toString(){
		// list all values from head to tail
		StringBuilder s = new StringBuilder("[");
		Node<T> current = head;
		String prefix="";
		while (current!=null){
			s.append(prefix);
			s.append(current.value);
			prefix=",";
			current = current.next;
		}
		s.append("]");
		return s.toString();

	}
	
	
	//----------------------------------------------------
	// example testing code... make sure you pass all ...
	// and edit this as much as you want!
	/**
	 * Main.
	 * @param args args.
	 */
	public static void main(String[] args){
		//These are _sample_ tests. If you're seeing all the "yays" that's
		//an excellend first step! But it does NOT guarantee your code is 100%
		//working... You may edit this as much as you want, so you can add
		//own tests here, modify these tests, or whatever you need!

		//add, get
		SimpleList<Integer> nums = new SimpleList<Integer>();
		nums.addLast(11);
		nums.addLast(20);
		nums.addLast(5);
		
		if (nums.size()==3 && nums.get(5).equals(5) && 
			nums.get(2) == null){
			System.out.println("Yay 1");
		}
		
		//uncomment to check the list details
		//System.out.println(nums);

		//remove
		if (!nums.remove(16) && nums.remove(11) &&
			nums.get(11)==null && nums.removeFirst().equals(20)){
			System.out.println("Yay 2");			
		} 
		
		//toString and iterator
		nums.addLast(31);
		nums.addLast(10);
		String expectedString = "[5,31,10]";
		Iterator iter = nums.iterator();
		if (nums.toString().equals(expectedString) && iter.hasNext() && 
			iter.next().equals(5) && iter.hasNext() && iter.next().equals(31)){
			System.out.println("Yay 3");						
		}
		
		
	}

}