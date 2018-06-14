package binarySearchTrees;
import static java.lang.System.*;

public class BSTPart2Tester {

	public static void main(String[] args) {
		BinarySearchTree tree = new BinarySearchTree();

		tree.add(200);
		tree.add(100);
		tree.add(800);
		tree.add(25);
		tree.add(350);
		tree.add(2);
		tree.add(880);
		tree.add(1);

		out.println("PARTNER TASK SECTION \n");

		out.print(tree.search(200) ? "The tree contains 200!\n" : "The does NOT contain 200!\n");

		out.print(tree.search(500) ? "The tree contains 500!\n" : "The tree does NOT contain 500!\n");

		out.print("The smallest tree node: " + tree.getSmallest() + "\n");

		out.print("The largest tree node: " + tree.getLargest());

		out.println("\n\nTree before removing any nodes - using level order traversal.");
		tree.levelOrder();

		tree.remove(25);
		out.println("Tree after removing 25.");
		tree.levelOrder();
		out.println("\n");

		tree.remove(350);
		out.println("Tree after removing 350.");
		tree.levelOrder();
		out.println("\n");

		tree.remove(2);
		out.println("Tree after removing 2.");
		tree.levelOrder();
		out.println("\n");

		tree.remove(100);
		out.println("Tree after removing 100.");
		tree.levelOrder();
		out.println("\n");

		tree.remove(880);
		out.println("Tree after removing 880.");
		tree.levelOrder();
		out.println("\n");

		tree.remove(800);
		out.println("Tree after removing 800.");
		tree.levelOrder();
		out.println("\n");

		tree.remove(1);
		out.println("Tree after removing 1.");
		tree.levelOrder();
		out.println("\n");
	}
}