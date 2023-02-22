// TO DO: add your implementation and JavaDocs.
/**
 * Stire class.
 */
public class Strie{
	//----------------------------------------------------
	// NO MORE INSTANCE VARIABLES ALLOWED!
	//----------------------------------------------------
	
	// Do NOT change the name or type of these variables
	/**
	 * The root of stire.
	 */
	private StrieNode root;  // the root of a strie
	/**
	 * Number of words represented by the strie.
	 */
	private int numWords = 0; // number of words represented by the strie
	
	//----------------------------------------------------
	// NO MORE INSTANCE VARIABLES ALLOWED!
	//----------------------------------------------------
	/**
	 * Constructor.
	 */
	public Strie(){
		// Constructor
		// Initialize root to be an empty node; initially no words are in the strie
		
		// O(1)
		this.root = new StrieNode();
	}
	/**
	 * Number of words.
	 * @return number of words in the strie.
	 */
	public int numWords(){
		// return number of words in the strie
		
		// O(1)
	
		return this.numWords; //default return; change or remove as needed	
	}
	/**
	 * The root of the strie.
	 * @return root of the strie.
	 */
	public StrieNode getRoot(){
		// return root of the strie
		
		// O(1)
		
		return this.root; //default return; change or remove as needed	
	
	}
	/**
	 * Insert word into your Strie.
	 * @param word word added.
	 */
	public void insert(String word){
		// Insert word into your Strie. 

		// O(n) where n is the number of characters in word
		int length = word.length();
		StrieNode empty = new StrieNode();
		if(length == 1){
			root.putChild(word.charAt(0), empty);
			root.getChild(word.charAt(0)).setEnd();
		}
		if(length > 1){
			root.putChild(word.charAt(0), empty);
			StrieNode temp = root.getChild(word.charAt(0));
			for(int i = 1; i < length; i++){
				if(temp.containsChild(word.charAt(i)) == true){
					temp = temp.getChild(word.charAt(i));
					continue;
				}
				temp.putChild(word.charAt(i),empty);
				if(i == length - 1){
					temp.setEnd();
				}
				temp = empty;
			}
		}
		this.numWords += 1;
	}

	/**
	 * Check the strie contains word or not.
	 * @param word word contained or not.
	 * @return true if Strie contains the given word.
	 */
	public boolean contains(String word){
		// Returns true if Strie contains the given word.
		
		// O(n) where n is the number of characters in word
		int length = word.length();
		if(length == 1){
			return this.root.containsChild(word.charAt(0));
		}
		if(this.root.containsChild(word.charAt(0)) == false){
			return false;
		}
		StrieNode temp = this.root.getChild(word.charAt(0));
		for(int i = 1; i < length; i++){
			if(temp.containsChild(word.charAt(i)) == false){
				return false;
			}
			temp = temp.getChild(word.charAt(i));
		}
		return true;//default return; change or remove as needed	
	}
	/**
	 * Removes the given word from Strie.
	 * @param word word need to be removed.
	 * @return true if remove success, false if not.
	 */
	public boolean remove(String word){
		// Removes the given word from Strie.
		
		// If word is not present in strie, return false;
		// Otherwise, remove word and return true.
		
		// Hint: Consider using recursion in your implementation.
		// Hint: You can define recursive helper functions.
		
		// Note: While there are **no Big-O restrictions** on this
		// method, it can be done in O(n) where n is the number
		// of characters in word
		if(this.contains(word) == false){
			return false;
		}
		int length = word.length();
		if(length == 1){
			return this.root.removeChild(word.charAt(0));
		}
		StrieNode temp = this.root.getChild(word.charAt(0));
		if(length == 2){
			temp.removeChild(word.charAt(1));
			return remove(word.substring(0, 1));
		}
		for(int i = 1; i < length - 1; i++){
			temp = temp.getChild(word.charAt(i));
			temp.removeChild(word.charAt(i + 1));
		}
		return remove(word.substring(0, length-1));//default return; change or remove as needed	
	}

	/**
	 * List all the character in strie.
	 * @return string.
	 */
	public String levelOrderTraversal(){
		// Perform a Breadth First Traversal of your Strie tree
		// and return a string of all characters encountered in the traversal.
		// - If a Strie has no words, return an empty string.
		// - A single space should be padded between characters.
		// - For multiple children of a single node, use the order of characters in 
		// getKeys() of the hash map to determine the traverse order.
		//
		// Check main() for examples.
		
		// Hint: you can use SimpleList to implement a queue easily.
		
		// Note: While there are **no Big-O restrictions** on this
		// method, level order traversals are traditionally O(n)
		// where n is the number of nodes in the tree. This may not
		// be the case here due to the hash table implementation
		// of children.
		if(this.root.getNumChildren() == 0){
			return "";
		}
		String result = "";
		HashMap<Character, StrieNode> firstLevel = this.root.getAllChildren();
		SimpleList<Character> firstLevelKey = firstLevel.getKeys();
		//Iterator<Character> iter = firstLevelKey.iterator();
		/*while(iter.hasNext()){
			result += String.valueOf(iter.next()) + " ";
		}
		while(firstLevel.size() != 0){
			StrieNode tempNode =  firstlevel.getValue(keys.removeFirst());
			HashMap<Character, StrieNode> otherlevel = tempNode.getAllChildren();
			SimpleList<Character> otherLevelKey = firstLevel.getKeys();
			Iterator<Character> iterTwo = firstLevelKey.iterator();
			while(iterTwo.hasNext()){
				result += String.valueOf(iterTwo.next()) + " ";
			}
		}*/
		return null;
	}
 

	/**
	 * List all the words in strie.
	 * @return simple list.
	 */
	public SimpleList<String> getStrieWords(){
		// Return all words currently stored in Strie.
		// If Strie has no words, return null.
		//
		// When there are multiple characters to continue from one node,
		// use the order of characters in getKeys() of the hash map to 
		// determine the traverse order.
		//
		// Also, prefix-words come before words that they are prefixes of. 
		// For example, 'bar' comes before 'barn'. 
		//
		// Check main() for examples.
		
		// Hint: Consider using recursion in your implementation.
		// Hint: You can define recursive helper functions.
		
		// Note: There are **no Big-O restrictions** on this
		// method, but it **can** be done in the same runtime as
		// a walk of the tree.
		if(this.numWords == 0){
			return null;
		}

		String result = "";
		HashMap<Character, StrieNode> firstLevel = this.root.getAllChildren();
		SimpleList<Character> firstLevelKey = firstLevel.getKeys();
		while(firstLevelKey.size() != 0){
			String temp = "";
			Character c = firstLevelKey.removeFirst();
			if(this.root.getChild(c) == null){
				temp += String.valueOf(c);
				result += (temp + " ");
				continue;
			}
			else{
				StrieNode tempNode = this.root.getChild(c);
				while(tempNode.getNumChildren() > 0){
					temp += String.valueOf(c);
					
				}
			}
		}

		return null;//default return; change or remove as needed	
	}


	//----------------------------------------------------
	// example testing code... make sure you pass all ...
	// and edit this as much as you want!
	//----------------------------------------------------
	/**
	 *  The main method for teting.
	 *  
	 *  @param args not used. 
	 */
	public static void main(String[] args){
		Strie myStrie = new Strie();
	
		if(myStrie.numWords()==0 && myStrie.getRoot().getNumChildren() == 0)
			System.out.println("Yay 1");
			
		myStrie.insert("a");
		StrieNode myRoot = myStrie.getRoot();
		
		if(myStrie.numWords()==1 && myRoot.getChild('a').getNumChildren() == 0 
			&& myRoot.getChild('a').isEnd() && myRoot.containsChild('a'))
			System.out.println("Yay 2");

		myStrie.insert("bat");
		myStrie.insert("bar");
		myStrie.insert("barn");
		myStrie.insert("cat");

		if(myStrie.contains("cat"))
			System.out.println("Yay 3");

		
		String res = myStrie.levelOrderTraversal();
		String actualOut = "a b c a a t r t n";
		if(res.equals(actualOut))
			System.out.println("Yay 4");
		//System.out.println(res);
		//System.out.println(myStrie.getNumber());

		SimpleList<String> yourWords = myStrie.getStrieWords();
		String display = "[a,bat,bar,barn,cat]";
		if (yourWords.size()==5 && yourWords.toString().equals(display))
			System.out.println("Yay 5");
		//System.out.println(yourWords.toString());
 

		if(myStrie.remove("cat") && !myStrie.contains("cat"))
			System.out.println("Yay 6");

	}
}
