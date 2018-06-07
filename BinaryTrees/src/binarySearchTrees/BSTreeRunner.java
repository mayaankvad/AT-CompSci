package binarySearchTrees;

public class BSTreeRunner {
	
	public static void main(String args[]) {
		// add test cases here
		int[] vals = { 90, 80, 100, 70, 85, 98, 120 };

		BinarySearchTree tree = new BinarySearchTree();

		for (int i : vals) {
			tree.add(i);
		}

		tree.inOrder();
		tree.preOrder();
		tree.postOrder();
		tree.revOrder();

		System.out.println("Height: " + tree.getHeight());
		System.out.println("Width: " + tree.getWidth());
		System.out.println("Leaves: " + tree.getNumLeaves());
		System.out.println("nodes: " + tree.getNumNodes());
		System.out.println("levels: " + tree.getNumLevels());
		System.out.println("toString: " + tree.toString());
		System.out.println("The tree is " + (!tree.isFull() ? "not " : "") + "full.");

	}
}