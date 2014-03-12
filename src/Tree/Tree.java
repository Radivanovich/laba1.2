package Tree;

class Tree {
	   private Tree left;   
	   private Tree right;
	   public int key;
	 
	   public Tree(int k) {   
	      key = k;
	   }
	
	   public void insert( Tree aTree) {
	     if ( aTree.key < key )
	        if ( left != null ) left.insert( aTree );
	        else left = aTree;
	     else
	        if ( right != null ) right.insert( aTree );
	        else right = aTree;
	   }
	   
	   public void traverse(TreeVisitor visitor) {
	      if ( left != null) 
	            left.traverse( visitor );
	 
	      visitor.visit(this);
	 
	      if ( right != null ) 
	            right.traverse( visitor );
	   }
	   public void check(TreeVisitor visitor, int data) {
		      if ( left != null) 
		            left.check(visitor,data);
		 
		      visitor.visit(this,data);
		 
		      if ( right != null ) 
		            right.check(visitor,data);
		   }
	}
	 
	interface TreeVisitor {
	  public void visit(Tree node);
	  public void visit(Tree node, int data);
	};
	 
	class KeyPrinter  implements TreeVisitor {
		public void visit(Tree node) {
		      System.out.println( " " + node.key );
		  }
	  public void visit(Tree node,int data) {
	      if(node.key==data)
	      System.out.println("finded");		//нельзя так делать конечно, но уже и так поздно
	  }
	};
	 
	class TreeSort {
	  public static void main(String args[]) {
	     Tree myTree;
	     myTree = new Tree(3);
	     myTree.insert( new Tree(8));
	     myTree.insert( new Tree(1));
	     myTree.traverse(new KeyPrinter());
	     myTree.check(new KeyPrinter(),1);
	  }
	}
