
import java.util.Iterator;
/**
 * Three ten hash set.
 * @param <T> simple list.
 * @author Hongjia Hao.
 */
class ThreeTenHashSet<T> {
	/**
	 * A simple list table.
	 */
	private SimpleList<T>[] table;

	/**
	 * Capacity.
	 */
	private int initLength;
	/**
	 * List size.
	 */
	private int size = 0;
	/**
	 * Create a hash table where the storage is with initLength.
	 * @param initLength capacity.
	 */
	@SuppressWarnings("unchecked")
	public ThreeTenHashSet(int initLength){
		// O(1)

		this.initLength = initLength;
		this.table = (SimpleList<T>[])new SimpleList[this.initLength];
	}
	/**
	 * Storage length.
	 * @return capacity.
	 */
	public int capacity() {
		// O(1)
		
		return this.initLength; 
	}
	/**
	 * The length of the size.
	 * @return the number of items in the table.
	 */
	public int size() {
		// O(1)
		
		return this.size; 
	}
	/**
	 * Add an item to the set.
	 * @param value value should be added.
	 * @return true if you successfully add value, false if the value can not be added.
	 */
	public boolean add(T value) {
		// O(N) worst case, where N is the number of values in table
		// O(N/M) average case where N is the number of values in table and M is the table length
		
		if(value == null){
			return false;
		}
		double load = this.size/this.initLength;
		if(load >= 2.0){
			this.rehash(initLength * 2);
		}
		int index = Math.abs(value.hashCode()) % this.initLength;
		if(this.contains(value) == true){
			return false;
		}
		if(this.table[index] == null){
			SimpleList<T> temp = new SimpleList<T>();
			this.table[index] = temp;
			this.table[index].addLast(value);
			this.size += 1;
			return true;
		}
		else{
			this.table[index].addLast(value);
			this.size += 1;
			return true;
		}
	}
	/**
	 * Removes a value from the set.
	 * @param value value removed.
	 * @return true if you remove the item, false if the item is not present.
	 */
	public boolean remove(T value) {
		// O(N) worst case, where N is the number of values in table
		// O(N/M) average case where N is the number of values in table and M is the table length

		int index = Math.abs(value.hashCode()) % this.initLength;
		if(this.table[index] == null){
			return false;
		}
		else{
			boolean result = this.table[index].remove(value);
			if(result == true){
				this.size -= 1;
			}
			return result;
		}
	}
	/**
	 * Check the list contains value or not.
	 * @param value value contained.
	 * @return true if value is in the set, false otherwise.
	 */
	public boolean contains(T value) {
		// O(N) worst case, where N is the number of values in table
		// O(N/M) average case where N is the number of values in table and M is the table length

		int index = Math.abs(value.hashCode()) % this.initLength;
		if(this.table[index] == null){
			return false;
		}
		if(this.table[index].get(value) != null){
			return true;
		}
		else{
			return false;
		}
	}
	/**
	 * Get the value from the list.
	 * @param value value in list.
	 * @return the term from the hash table if it was found.
	 */
	public T get(T value) {
		
		// O(N) worst case, where N is the number of values in table
		// O(N/M) average case where N is the number of values in table and M is the table length
		
		int index = Math.abs(value.hashCode()) % this.initLength;
		return this.table[index].get(value);
		//default return; change or remove as needed
	}
	/**
	 * Rehash to table size newCapacity.
	 * @param newCapacity new capacity.
	 * @return true if rehash success.
	 */
	@SuppressWarnings("unchecked")
	public boolean rehash(int newCapacity) {
		
		// O(N+M) where N is the number of values in table and M is the table size
		
		if(newCapacity <= this.initLength){
			return false;
		}
		SimpleList<T> tempList = this.allValues();
		SimpleList<T>[] newTable = (SimpleList<T>[])new SimpleList[newCapacity];
		this.table = newTable;
		this.initLength = newCapacity;
		this.size = 0;
		int tempsize = tempList.size();
		for(int i = 0; i < tempsize; i++){
			this.add(tempList.removeFirst());
			this.size += 1;
		}
		return true; //default return; change or remove as needed
				
	}
	
	/**
	 * To string method.
	 * @return string.
	 */
	@Override
	public String toString() {
		StringBuilder s = new StringBuilder("ThreeTenHashSet (non-empty entries):\n");
		for(int i = 0; i < table.length; i++) {
			if(table[i] != null && table[i].size()!=0) {
				s.append(i);
				s.append(" :");
				s.append(table[i]);
				s.append("\n");
			}
		}
		return s.toString().trim();
	}
	
	/**
	 * String debug.
	 * @return string.
	 */
	public String toStringDebug() {
		StringBuilder s = new StringBuilder("ThreeTenHashSet (all entries):\n");
		for(int i = 0; i < table.length; i++) {
			s.append(i);
			s.append(" :");
			s.append(table[i]);
			s.append("\n");
		}
		return s.toString().trim();
	}

	/**
	 * All values.
	 * @return simple list contain all value.
	 */
	public SimpleList<T> allValues(){
		// return all items in set as a list
		SimpleList<T> all = new SimpleList<>();
		for(int i = 0; i < table.length; i++) {
			if (table[i]!=null){
				for (T value: table[i])
					all.addLast(value);
			}
		}
		return all;
	}

	/**
	 * Main.
	 * @param args args.
	 */
	public static void main(String[] args) {

	
		ThreeTenHashSet<String> names = new ThreeTenHashSet<>(5);
		
		//basic table w/o collision: add / size / capacity
		if(names.add("Alice") && names.add("Bob") && !names.add("Alice") 
			&& names.size() == 2 && names.capacity() == 5) 	{
			System.out.println("Yay 1");
		}
		//System.out.println(names.toString());
		//System.out.println("-----------------------");
		//System.out.println(names.toStringDebug());
		//System.out.println("-----------------------");
		
		//remove / contains / get
		if(!names.remove("Alex") && names.remove("Bob") && names.contains("Alice") 
			&& !names.contains("Bob") && names.get("Bob")==null) {
			System.out.println("Yay 2");
		}
		//System.out.println(names.toString());
		//System.out.println("-----------------------");
		
		//table with collision
		ThreeTenHashSet<Integer> nums = new ThreeTenHashSet<>(5);
		for(int i = 0; i <7 ; i++) {
			nums.add(i);
		}
		//System.out.println(nums.toString());
		String expectedString = 
			"ThreeTenHashSet (non-empty entries):\n0 :[0,5]\n1 :[1,6]\n2 :[2]\n3 :[3]\n4 :[4]";
		String allValueString = "[0,5,1,6,2,3,4]";
		if (nums.size()==7 && nums.toString().equals(expectedString)
			&& nums.allValues().toString().equals(allValueString)){
			System.out.println("Yay 3");			
		}
		//System.out.println(nums.allValues().toString());		

		//rehash

		String rehashedString = 
			"ThreeTenHashSet (non-empty entries):\n0 :[0]\n1 :[1]\n2 :[2]\n3 :[3]\n4 :[4]\n5 :[5]\n6 :[6]";
		if (!nums.rehash(3) && nums.rehash(11) && nums.capacity()==11
			&& nums.toString().equals(rehashedString)){
			System.out.println("Yay 4");					
		}	
		
	}
}
