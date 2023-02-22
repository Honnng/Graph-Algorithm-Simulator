// TO DO: add your implementation and JavaDocs.
/**
 * Stire node class.
 */
public class StrieNode{

	// Use a HashMap to hold children nodes.
	// Keys of the map can be any Character while values are the children nodes.
	// Each key in the map leads to a child node of this node.
	/**
	 * Hash map children.
	 */
	private HashMap<Character, StrieNode> children; 

	// Marks the end of a word
	/**
	 * End of a word.
	 */
	private boolean endMarker;  
	
	// OPTIONAL boolean flag that you can use.
	// It is completely optional to use this in your implementation.
	// We will NOT test its usage but it is provided for more flexibility.
	// Still, remember to write JavaDoc for it.
	/**
	 * Flag.
	 */
	private boolean flag;  	
	/**
	 * Default length of the hashmap to start.
	 */
	private static final int INIT_MAP_LENGTH = 5; //default length of the hashmap to start

	// ADD MORE PRIVATE MEMBERS HERE IF NEEDED
	/**
	 * Constructor.
	 */
	public StrieNode(){
		// Constructor
		// Initialize anything that needs initialization
		// HashMap must start with INIT_MAP_LENGTH entries
		
		// O(1)
		this.children = new HashMap(INIT_MAP_LENGTH);
		this.endMarker = false;
	}
	/**
	 * Report number of children nodes.
	 * @return the total number of children.
	 */
	public int getNumChildren(){
		//report number of children nodes
		//O(1)
		
		return this.children.size(); 	//default return; change or remove as needed	
	}
	/**
	 * Get all children.
	 * @return the storage of all children.
	 */
	public HashMap<Character, StrieNode> getAllChildren(){
		// return the storage of all children
		// O(1)
		
		return this.children;//default return; change or remove as needed	
	}
	/**
	 * Set the end of a word.
	 */
	public void setEnd(){
		// Sets the end marker to indicate this node is the end of a string/word
		// O(1)
		this.endMarker = true;
	}
	/**
	 * Unsets the end marker.
	 */
	public void unsetEnd(){
		// Unsets the end marker
		// O(1)
		this.endMarker = false;
	}
	/**
	 * Check is end.
	 * @return true if it is end.
	 */
	public boolean isEnd(){
		// Checks whether the current node is marked as the end of a string/word
		// O(1)
		
		return this.endMarker; //default return; change or remove as needed	
	}
	/**
	 * Check contains child or not.
	 * @param ch character to be checked.
	 * @return true if node has a child node corresponding to ch.
	 */
	public boolean containsChild(char ch){
		// returns true if node has a child node corresponding to ch;
		// return false otherwise 

		// O(1)
		// You can assume all HashMap operations are O(1)
		
		return this.children.contains(ch); //default return; change or remove as needed	
	}
	/**
	 * Get child.
	 * @param ch character.
	 * @return the child node corresponding to ch.
	 */
	public StrieNode getChild(char ch){
		// returns the child node corresponding to ch
		// returns null if no such node

		// O(1)
		// You can assume all HashMap operations are O(1)
		
		return this.children.getValue(ch); //default return; change or remove as needed	
	}
	/**
	 * Set a child node corresponding to ch to node.
	 * @param ch character.
	 * @param node StireNode.
	 */
	public void putChild(char ch, StrieNode node){
		// set a child node corresponding to ch to node
		// if a node already exists, change the mapping of ch to the specified node

		// O(1)
		// You can assume all HashMap operations are O(1) except getKeys() and toString()
		if(this.children.has(ch,node) == true){
			this.children.update(ch, node);
		}
		else{
			this.children.add(ch,node);
		}
	}
	/**
	 * Remove child node corresponding to ch if a node is present.
	 * @param ch character.
	 * @return true if success.
	 */
	public boolean removeChild(char ch){
		// remove child node corresponding to ch if a node is present
		// return true if a child was removed;
		// if no such child node, return false
	
		// O(1)
		// You can assume all HashMap operations are O(1) except getKeys() and toString()
		
		return this.children.remove(ch); //default return; change or remove as needed	
	}

	// Below are methods with the optional flag
	// - implementation of those are optional 
	// - no testing on them in grading
	// Still, remember to write JavaDoc for them.
	/**
	 * Set flag.
	 */
	public void setFlag(){
		// set the optional flag to be true
		// O(1)
		this.flag = true;
	}
	/**
	 * Unset flag.
	 */
	public void unSetFlag(){
		// set the optional flag to be false
		// O(1)
		this.flag = false;
	}
	/**
	 * Check flag.
	 * @return true if flag is true.
	 */
	public boolean checkFlag(){
		// report the status of the optional flag
		// O(1)
		
		return this.flag;//default return; change or remove as needed	
	}

}
