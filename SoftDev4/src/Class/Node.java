/*
 * @author jguedel
 * @version 1.0
 * 
 */
package Class;

// TODO: Auto-generated Javadoc
/**
 * The Class Node.
 */
public class Node {
	
	/** The n. */
	// DATA MEMBERS: BINARY TREES HAVE A LEFT AND A RIGHT
	public int n;
	
	/** The left. */
	public Node left;
	
	/** The right. */
	public Node right;

	/**
	 * Instantiates a new node.
	 *
	 * @param n the n
	 */
	// EXPLICIT CONSTRUCTOR
	public Node(int n) {
		this.n = n;
		left = null;
		right = null;

	}
}
