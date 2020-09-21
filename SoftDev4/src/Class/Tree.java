/*
 * @author jguedel
 * @version 1.0
 * 
 */
package Class;

import java.util.ArrayList;

// TODO: Auto-generated Javadoc
/**
 * The Class Tree.
 */
public class Tree {

	/** The root. */
	// TASK 1: SPECIFY THE DATA MEMBER - SIMPLY THE ROOT REFERENCE TO THE TREE
	public Node root;

	/** The cycles. */
	ArrayList<String> cycles = new ArrayList<String>();

	/**
	 * Instantiates a new tree.
	 */
	// TASK 2: CREATE THE CONSTRUCTOR.
	public Tree() {
		// TIP: THE ROOT SHOULD BE INITIALIZED TO NULL, BECAUSE TREES BEGIN EMPTY.
		root = null;
	}

	/**
	 * Delete node.
	 *
	 * @param n the n
	 */
	// DELETE NODE
	public void deleteNode(int n) {
		// TASK 1: DEFINE VARIABLES
		Node toDelete = root;
		Node parentoTD = null;
		boolean found = false;

		// TASK 2: LOCATE THE NODE TO DELETE
		while (!found && toDelete != null) {
			if (n == toDelete.n)
				found = true;
			else {
				parentoTD = toDelete;
				if (n > toDelete.n)
					toDelete = toDelete.right;
				else
					toDelete = toDelete.left;
			}
		}

		// TASK 3: DELETE THE NODE
		// node not found
		if (!found)
			return;
		// if node to delete is a node
		if (toDelete.left == null || toDelete.right == null) {
			Node theChild;
			if (toDelete.left == null)
				theChild = toDelete.right;
			else
				theChild = toDelete.left;

			// DEAL WITH THE SITUATION WHEN THE PARENT IS NULL
			if (parentoTD == null) {
				root = theChild;
				assert tests.CheckLoops(cycles) == false : "Error: Your tree has cycles";
				assert tests.CheckRootConnections(cycles) == false : "Error: Root has a parent";
			} else if (parentoTD.left == toDelete) {
				parentoTD.left = theChild;
				assert tests.checkPointerSmall(n, root) == true: "Error: Left pointers are wrong";;
				assert tests.CheckLoops(cycles) == false : "Error: Your tree has cycles";
				assert tests.CheckRootConnections(cycles) == false : "Error: Root has a parent";
			} else {
				parentoTD.right = theChild;
				assert tests.checkPointerSmall(n, root) == true: "Error: Left pointers are wrong";;
				assert tests.CheckLoops(cycles) == false : "Error: Your tree has cycles";
				assert tests.CheckRootConnections(cycles) == false : "Error: Root has a parent";
			}
			return;

		}
		// if node to delete only has one child
		// position smallestParent
		Node smallestParent = toDelete;
		Node smallest = toDelete.right;
		while (smallest.left != null) {
			smallestParent = smallest;
			smallest = smallest.left;
		}
		// task b: Smallest contains the smallest child on the right subtree. Swap the
		// contents unlink.
		toDelete.n = smallest.n;
		if (smallest == toDelete) {
			smallestParent.right = smallest.right;
			assert tests.checkPointerSmall(n, root) == true: "Error: Left pointers are wrong";;
			assert tests.CheckLoops(cycles) == false : "Error: Your tree has cycles";
			assert tests.CheckRootConnections(cycles) == false : "Error: Root has a parent";
		} else {
			smallestParent.left = smallest.right;
			System.out.println(n + root.n);
			assert tests.checkPointerBig(n, root) == true: "Error: Right pointers are wrong";
			assert tests.CheckLoops(cycles) == false : "Error: Your tree has cycles";
			assert tests.CheckRootConnections(cycles) == false : "Error: Root has a parent";
		}
	}

	/**
	 * Adds the node.
	 *
	 * @param n the n
	 */
	// ADD NODE
	public void addNode(int n) {
		Node temp = new Node(n);
		// IF EMPTY TREE
		if (isEmpty() == true) {
			root = temp;
		}
		// ELSE THE TREE HAS NODES ALREADY
		else {
			assert isEmpty() == false : "Error: Tree is empty";
			Node loc = root;
			while (true) {
				// TRAVEL TO THE LEFT SIDE
				if (temp.n < loc.n) {
					if (loc.left != null) {
						loc = loc.left;
					} else {
						loc.left = temp;
						String inp = String.valueOf(loc.n) + String.valueOf(temp.n);
						// System.out.println("small " + inp);
						cycles.add(inp);
						assert tests.checkPointerSmall(loc.n, temp) == true : "Error: Left pointers are wrong";
						assert tests.CheckLoops(cycles) == false : "Error: Your tree has cycles";
						assert tests.CheckRootConnections(cycles) == false : "Error: Root has a parent";
						break;
					}
				}
				// TRAVEL TO THE RIGHT SIDE
				else if (temp.n > loc.n) {
					if (loc.right != null) {
						loc = loc.right;
					} else {
						loc.right = temp;
						String inp = String.valueOf(loc.n) + String.valueOf(temp.n);
						// System.out.println("big " + inp);
						cycles.add(inp);
						assert tests.checkPointerBig(loc.n, temp) == true : "Error: Right pointers are wrong";
						assert tests.CheckLoops(cycles) == false : "Error: Your tree has cycles";
						assert tests.CheckRootConnections(cycles) == false : "Error: Root has a parent";
						break;
					}
				} else {
					assert tests.CheckLoops(cycles) == false : "Error: Your tree has cycles";
					System.out.println(
							"Error: this number already appears in tree (" + temp.n + "). So its not added to tree");
					break;
				}
			}
		}

	}

	// IN-ORDER TRAVERSAL: LVR
	/**
	 * Display in order.
	 */
	// display inOrder(): calls inOrder()
	public void displayInOrder() {
		inOrder(root);
	}

	/**
	 * In order.
	 *
	 * @param loc the node
	 */
	// inOrder() : recursive method
	public void inOrder(Node loc) {
		if (loc != null) {
			if (loc.left != null)
				assert tests.checkPointerSmall(loc.n, loc.left) == true : "Error: Left pointer is wrong for node "
						+ loc.n + " pointing at node " + loc.left.n;
			inOrder(loc.left);
			System.out.println(loc.n);
			if (loc.right != null)
				assert tests.checkPointerBig(loc.n, loc.right) == true : "Error: Right pointer is wrong for node "
						+ loc.n + " pointing at node " + loc.right.n;
			inOrder(loc.right);
		}
	}

	/**
	 * Display count nodes.
	 */
	// COUNT NODES
	public void displayCountNodes() {
		System.out.println(countNodes(root));
	}

	/**
	 * Count nodes.
	 *
	 * @param root the tree
	 * @return the number of nodes
	 */
	public static int countNodes(Node root) {
		if (null == root)
			return 0;

		int nLeftSubtree = countNodes(root.left);
		int nRightSubtree = countNodes(root.right);
		return nLeftSubtree + nRightSubtree + 1;
	}

	/**
	 * Checks if is empty.
	 *
	 * @return true, if is empty
	 */
	public boolean isEmpty() {
		return root == null;
	}

}
