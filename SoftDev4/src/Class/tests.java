/*
 * @author jguedel
 * @version 1.0
 * 
 */
package Class;

import java.util.ArrayList;

// TODO: Auto-generated Javadoc
/**
 * The Class tests.
 */
public class tests {
	// ASSERTS

	/**
	 * Check root connections.
	 *
	 * @param cycles the cycles
	 * @return true, if root does have a parent
	 */
	static boolean CheckRootConnections(ArrayList<String> cycles) {
		if (cycles.isEmpty())
			return false;
		else if (cycles.size() >= 2) {
			String compare = reverse(cycles.get(0));
			String compare2 = reverse(cycles.get(1));
			// System.out.println("hit " + compare + " hit " + compare2);
			for (int z = 0; z < cycles.size(); z++) {
				String compared = cycles.get(z);
				if (compare == compared && compare2 == compared) {
					return true;
				}
			}
		} else {
			String compare = reverse(cycles.get(0));
			// System.out.println("hit " + compare);
			for (int z = 0; z < cycles.size(); z++) {
				String compared = cycles.get(z);
				if (compare == compared) {
					return true;
				}
			}
		}
		return false;
	}

	/**
	 * Check loops.
	 *
	 * @param cycles the cycles
	 * @return true, if there are no loops in the tree
	 */
	// CHECK FOR LOOPS
	static boolean CheckLoops(ArrayList<String> cycles) {
		if (cycles.isEmpty())
			return false;
		else {
			for (int i = 0; i < cycles.size(); i++) {
				String compare = reverse(cycles.get(i));
				for (int z = 0; z < cycles.size(); z++) {
					String compared = cycles.get(z);
					// System.out.println("compare: " + compare + " compared: " + compared);
					if (compare == compared) {
						return true;
					}
				}
			}
			return false;
		}

	}

	/**
	 * Reverse.
	 *
	 * @param str the string you wish to reverse
	 * @return the string reversed
	 */
	private static String reverse(String str) {
		char reversedStr[];
		int strlen = str.length();
		reversedStr = new char[strlen];

		for (int i = 0; i <= strlen / 2; i++) {
			reversedStr[i] = str.charAt(strlen - 1 - i);
			reversedStr[strlen - 1 - i] = str.charAt(i);

		}
		return new String(reversedStr);
	}

	/**
	 * Check pointer small.
	 *
	 * @param n    the value compared
	 * @param node the value needed to compare
	 * @return true, if the number is bigger
	 */
	// CHECK IF SMALLER POINTS ARE BRANCHED LEFT
	public static boolean checkPointerSmall(int n, Node node) {
		Node left = node;
		if (n > left.n)
			return true;
		else
			return false;
	}

	/**
	 * Check pointer big.
	 *
	 * @param n    the value compared
	 * @param node the value needed to compare
	 * @return true, if the number is bigger
	 */
	// CHECK IF BIGGER POINTS ARE BRANCHED RIGHT
	public static boolean checkPointerBig(int n, Node node) {
		Node right = node;
		if (n < right.n)
			return true;
		else
			return false;
	}
}
