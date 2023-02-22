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
	
	/**
	 * Flag.
	 */
	private boolean flag;  	
	/**
	 * Default length of the hashmap to start.
	 */
	private static final int INIT_MAP_LENGTH = 5; 

	/**
	 * Constructor.
	 */
	public StrieNode(){
		this.children = new HashMap(INIT_MAP_LENGTH);
		this.endMarker = false;
	}
	/**
	 * Report number of children nodes.
	 * @return the total number of children.
	 */
	public int getNumChildren(){
		//O(1)
		
		return this.children.size(); 	
	}
	/**
	 * Get all children.
	 * @return the storage of all children.
	 */
	public HashMap<Character, StrieNode> getAllChildren(){
		// O(1)
		
		return this.children;	
	}
	/**
	 * Set the end of a word.
	 */
	public void setEnd(){
		// O(1)
		this.endMarker = true;
	}
	/**
	 * Unsets the end marker.
	 */
	public void unsetEnd(){
		// O(1)
		this.endMarker = false;
	}
	/**
	 * Check is end.
	 * @return true if it is end.
	 */
	public boolean isEnd(){
		// O(1)
		
		return this.endMarker; 	
	}
	/**
	 * Check contains child or not.
	 * @param ch character to be checked.
	 * @return true if node has a child node corresponding to ch.
	 */
	public boolean containsChild(char ch){

		// O(1)
		
		return this.children.contains(ch); 
	}
	/**
	 * Get child.
	 * @param ch character.
	 * @return the child node corresponding to ch.
	 */
	public StrieNode getChild(char ch){
		// O(1)
		
		return this.children.getValue(ch); 
	}
	/**
	 * Set a child node corresponding to ch to node.
	 * @param ch character.
	 * @param node StireNode.
	 */
	public void putChild(char ch, StrieNode node){

		// O(1)
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
	
		// O(1)
		
		return this.children.remove(ch); 
	}

	/**
	 * Set flag.
	 */
	public void setFlag(){
		// O(1)
		this.flag = true;
	}
	/**
	 * Unset flag.
	 */
	public void unSetFlag(){
		// O(1)
		this.flag = false;
	}
	/**
	 * Check flag.
	 * @return true if flag is true.
	 */
	public boolean checkFlag(){
		// O(1)
		
		return this.flag;
	}

}
