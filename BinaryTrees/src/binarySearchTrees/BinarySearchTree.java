package binarySearchTrees;


@SuppressWarnings({"unchecked", "rawtypes"})
public class BinarySearchTree
{
	private TreeNode root;

	public BinarySearchTree()
	{
		root = null;
	}

	public void add(Comparable val)
	{
		root = add(val, root);
	}

	private TreeNode add(Comparable val, TreeNode tree)
	{
	   if(tree == null) {
			tree = new TreeNode(val);
			return tree;
		}
		
		Comparable treeValue = tree.getValue();
		int dirTest = val.compareTo(treeValue);
		
		
		if(dirTest <= 0) {
			tree.setLeft(add(val, tree.getLeft()));
		}
		else if(dirTest > 0) {
			tree.setRight(add(val, tree.getRight())); 
		}
		
		return tree;
	}

   public void inOrder()
	{
		inOrder(root);
		System.out.println("\n\n");
	}

	private void inOrder(TreeNode tree)
	{
		if (tree != null){
			inOrder(tree.getLeft());
			System.out.print(tree.getValue() + " ");
			inOrder(tree.getRight());
		}
	}

	//add preOrder, postOrder, and revOrder
	
	public void preOrder() {
		System.out.print("[");
		preOrder(this.root);
		System.out.println("]\n\n");
	}

	private void preOrder(TreeNode tree) {
		if (tree != null) {
			System.out.print(tree.getValue() + ", ");
			preOrder(tree.getLeft());
			preOrder(tree.getRight());
		}
	}
	
	
	public void postOrder() {
		System.out.print("[");
		postOrder(this.root);
		System.out.println("]\n\n");
	}

	private void postOrder(TreeNode tree) {
		if (tree != null) {
//			System.out.print(tree.getValue() + ", ");
			postOrder(tree.getLeft());
			postOrder(tree.getRight());
			System.out.print(tree.getValue() + ", ");
		}
	}
	
	
	public void revOrder() {
		System.out.print("[");
		revOrder(this.root);
		System.out.println("]\n\n");
	}

	private void revOrder(TreeNode tree) {
		if (tree != null) {
//			System.out.print(tree.getValue() + ", ");
			revOrder(tree.getRight());
			System.out.print(tree.getValue() + ", ");
			revOrder(tree.getLeft());
		}
	}
	
	
	

	public int getNumLevels()
	{
		return getNumLevels(root);
	}

	private int getNumLevels(TreeNode tree)
	{
		if(tree==null) {
			return 0;
		}
		else if(getNumLevels(tree.getLeft())>getNumLevels(tree.getRight())) {
			return 1+getNumLevels(tree.getLeft());
		}
		return 1+getNumLevels(tree.getRight());
	}



	//add getNumLeaves, getWidth, getHeight, getNumNodes, and isFull
	
	public int getNumLeaves() {
		return getNumLeaves(this.root);
	}

	private int getNumLeaves(TreeNode tree) {
		if (tree != null) {
			if (tree.getLeft() == null && tree.getRight() == null) {
				return 1;
			}
			return getNumLeaves(tree.getLeft()) + getNumLeaves(tree.getRight());
		}
		return 0;
	}

	
	public int getWidth() {
		return (1 + getNumLevels(this.root.getRight()) + getNumLevels(this.root.getLeft()));
	}
	

	public int getHeight() {
		return getHeight(this.root) - 1;
	}

	private int getHeight(TreeNode tree) {
		if(tree == null) {
			return 0;
		}
		if(getHeight(tree.getLeft()) > getHeight(tree.getRight())) {
			return 1 + getHeight(tree.getLeft());
		}
		return 1 + getHeight(tree.getRight());
	}

	
	public int getNumNodes() {
		return getNumNodes(this.root);
	}

	private int getNumNodes(TreeNode tree) {
		if (tree != null) {
			return 1 + getNumNodes(tree.getLeft()) + getNumNodes(tree.getRight());
		}
		return 0;
	}

	
	public boolean isFull() {
		return isFull(this.root);
	}

	public boolean isFull(TreeNode tree) {
		if (tree != null) {
			if (tree.getLeft() != null && tree.getRight() == null) {
				return false;
			}
			else if (tree.getLeft() == null && tree.getRight() != null) {
				return false;
			}
			else {
				return isFull(tree.getLeft()) && isFull(tree.getRight());
			}
		} 
		return true;
	}

	
	//search
	
	// task 1
	public boolean search(Comparable x) {
		return this.toString().contains(x.toString());
	}
	
	
	//maxNode
	
	//task 2
	public Comparable getLargest(){
		return this.getMax(root, root).getValue();
	}
	
	private TreeNode getMax(TreeNode tree, TreeNode max) {
        if (tree != null) {
        	
        	//set max from two childs of tree
            if (tree.getLeft() != null && tree.getLeft().getValue().compareTo(max.getValue()) > 0) {
                max = tree.getLeft();
            }
            
            if (tree.getRight() != null && tree.getRight().getValue().compareTo(max.getValue()) > 0) {
                max = tree.getRight();
            }
            
            // find max of child tree left if left is bigger
            if (getMax(tree.getLeft(), max).getValue().compareTo(getMax(tree.getRight(), max).getValue()) > 0) {
                return getMax(tree.getLeft(), max);
            }
            
            // find max of child tree right
            return getMax(tree.getRight(), max);
        }
 
        return max;
    }
	
	
	//minNode
	
	//task 2
	public Comparable getSmallest(){
		return this.getMin(root, root).getValue();
	}
	
	private TreeNode getMin(TreeNode tree, TreeNode min) {
        if (tree != null) {
        	
        	//set min from two childs of tree
            if (tree.getLeft() != null && tree.getLeft().getValue().compareTo(min.getValue()) < 0) {
                min = tree.getLeft();
            }
            
            if (tree.getRight() != null && tree.getRight().getValue().compareTo(min.getValue()) < 0) {
                min = tree.getRight();
            }
            
            // find min of child tree left if left is smaller
            if (getMin(tree.getLeft(), min).getValue().compareTo(getMin(tree.getRight(), min).getValue()) < 0) {
                return getMin(tree.getLeft(), min);
            }
            
            // find min of child tree right
            return getMin(tree.getRight(), min);
        }
 
        return min;
    }
	
	private TreeNode getMinAsNode(TreeNode tree) {
		return this.getMin(tree, tree);
	}
	
	
	//level order
	
	// task 3
	public void levelOrder() {
		int h = getHeight(this.root);
		int i;
		for (i = 1; i <= h; i++) {
			levelOrder(root, i);
		}
	}

	private void levelOrder(TreeNode root, int level) {
		if (root != null) {
			if (level == 1)
				System.out.print(root.getValue() + " ");
			else if (level > 1) {
				levelOrder(root.getLeft(), level - 1);
				levelOrder(root.getRight(), level - 1);
			}
		}
	}
	
	
	//display like a tree
	
	// task 5
	public void displayTree() {
		
	}
	
	
	//remove
	
	//task 4
	public void remove(Comparable x) {
		this.root = remove(x, this.root);
	}

	private TreeNode remove(Comparable x, TreeNode tree) {
		if (tree != null) {
			int tst = x.compareTo(tree.getValue());

			if (tst < 0) {
				tree.setLeft(remove(x, tree.getLeft()));
			}
			else if (tst > 0) {
				tree.setRight(remove(x, tree.getRight()));
			}
			else {
				if (tree.getRight() == null) {
					tree = tree.getLeft();
				}
				else {
					TreeNode s = getMinAsNode(tree.getRight());
					tree.setValue(s.getValue());
					tree.setRight(remove(s.getValue(), tree.getRight()));
				}
			}
		}
		return tree;
	}
	
	

	public String toString()
	{
		return toString(this.root);
	}

	private String toString(TreeNode tree)
	{
		if(tree != null) {
			return toString(tree.getLeft()) + " " + tree.getValue() + " " + toString(tree.getRight());
		}
		return "";
	}


}