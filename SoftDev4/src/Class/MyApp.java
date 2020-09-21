/*
 * @author jguedel
 * @version 1.0
 * 
 */
package Class;

/**
 * The Class MyApp.
 */
public class MyApp {

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		// TASK 1: INSTANTIATE A BINARY TREE
		Tree tree = new Tree();

		// TASK 2: ADD NODES TO THE BINARY TREE
		tree.addNode(7);
		tree.addNode(9);
		tree.addNode(5);
		tree.addNode(8);
		tree.addNode(6);
		tree.addNode(2);
		tree.addNode(3);
		tree.addNode(222);

		// TASK 3: TEST TREE
		System.out.println("The node count is: ");
		tree.displayCountNodes();
		System.out.println("Displaying the nodes in-order:");
		tree.displayInOrder();
		tree.deleteNode(7);
		tree.deleteNode(222);
		System.out.println("Displaying the nodes in-order:");
		tree.displayInOrder();
		tree.addNode(-3);
		tree.addNode(-7568);
		tree.addNode(1234);
		System.out.println("The node count is: ");
		tree.displayCountNodes();
		System.out.println("Displaying the nodes in-order:");
		tree.displayInOrder();

		// IF ALL ASSERTS PASSED
		System.out.println("success!!!!!");

	}
}