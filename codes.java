// Sort the array

public class ArraySorter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Prompt the user to enter the size of the array
        System.out.print("Enter the size of the array: ");
        int size = scanner.nextInt();

        // Create an array of the specified size
        int[] array = new int[size];

        // Prompt the user to enter the elements of the array
        System.out.println("Enter the elements of the array:");

        for (int i = 0; i < size; i++) {
            System.out.print("Enter element " + (i + 1) + ": ");
            array[i] = scanner.nextInt();
        }

        // Sort the array
        Arrays.sort(array);

        // Display the sorted array
        System.out.println("Sorted array:");
        for (int num : array) {
            System.out.print(num + " ");
        }

        scanner.close();
    }
}


// Recover the BST
 Node {
    int data;
    Node left, right;

    Node(int d) {
        data = d;
        left = right = null;
    }
}

public class Main {
    Node first, middle, last, prev;

    void correctBSTUtil(Node root) {
        if (root != null) {
            correctBSTUtil(root.left);

            if (prev != null && root.data < prev.data) {
                if (first == null) {
                    first = prev;
                    middle = root;
                } else {
                    last = root;
                }
            }

            prev = root;

            correctBSTUtil(root.right);
        }
    }

    void correctBST(Node root) {
        first = middle = last = prev = null;
        correctBSTUtil(root);

        if (first != null && last != null) {
            int temp = first.data;
            first.data = last.data;
            last.data = temp;
        } else if (first != null && middle != null) {
            int temp = first.data;
            first.data = middle.data;
            middle.data = temp;
        }
    }

    void printInorder(Node node) {
        if (node == null)
            return;
        printInorder(node.left);
        System.out.print(" " + node.data);
        printInorder(node.right);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the number of nodes in the BST:");
        int n = scanner.nextInt();
        System.out.println("Enter the values of the nodes:");

        Node root = null;
        Main tree = new Main();

        for (int i = 0; i < n; i++) {
            int val = scanner.nextInt();
            if (root == null) {
                root = new Node(val);
            } else {
                insert(root, val);
            }
        }

        System.out.println("Inorder Traversal of the original tree");
        tree.printInorder(root);

        tree.correctBST(root);

        System.out.println("\nInorder Traversal of the fixed tree");
        tree.printInorder(root);

        scanner.close();
    }

    // Function to insert a new node with the given value into the BST
    static Node insert(Node root, int value) {
        if (root == null) {
            return new Node(value);
        }

        if (value < root.data) {
            root.left = insert(root.left, value);
        } else if (value > root.data) {
            root.right = insert(root.right, value);
        }

        return root;
    }
}

// Left view
class BinaryTree {
  Node root;

  // Function to create a new binary tree node
  public Node newNode(int item) {
    return new Node(item);
  }

  // Class representing a node in the binary tree
  class Node {
    int data;
    Node left, right;

    public Node(int item) {
      data = item;
      left = right = null;
    }
  }

  // Function to construct a binary tree from user input in level order
  public Node constructTree() {
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter the tree data in level order (space-separated, -1 for null): ");
    String[] elements = sc.nextLine().split(" ");

    int i = 0;
    Queue<Node> queue = new LinkedList<>();

    // Create root node from the first element
    if (!elements[i].equals("-1")) {
      root = newNode(Integer.parseInt(elements[i]));
      queue.add(root);
    }
    i++;

    while (!queue.isEmpty()) {
      Node current = queue.poll();

      // Process left child
      if (i < elements.length && !elements[i].equals("-1")) {
        current.left = newNode(Integer.parseInt(elements[i]));
        queue.add(current.left);
      }
      i++;

      // Process right child
      if (i < elements.length && !elements[i].equals("-1")) {
        current.right = newNode(Integer.parseInt(elements[i]));
        queue.add(current.right);
      }
      i++;
    }

    return root;
  }

  // Recursive function to print the left view of a binary tree
  public void leftViewUtil(Node node, int level, int[] maxLevel) {
    if (node == null) {
      return;
    }

    // If this is the first node of its level, print it
    if (maxLevel[0] < level) {
      System.out.print(node.data + " ");
      maxLevel[0] = level;
    }

    // Recur for left and right subtrees, prioritizing left subtree
    leftViewUtil(node.left, level + 1, maxLevel);
    leftViewUtil(node.right, level + 1, maxLevel);
  }

  // Print the left view of the binary tree
  public void leftView() {
    if (root == null) {
      return;
    }
    int[] maxLevel = {0}; // Keep track of the deepest level visited so far
    leftViewUtil(root, 1, maxLevel);
  }

  public static void main(String[] args) {
    BinaryTree tree = new BinaryTree();
    tree.root = tree.constructTree();

    System.out.println("Left view of the Binary Tree:");
    tree.leftView();
  }
}

// Boundary Traversal
class BinaryTree {
 Node root;

 // Function to create a new binary tree node
 public Node newNode(int item) {
   return new Node(item);
 }

 // Class representing a node in the binary tree
 class Node {
   int data;
   Node left, right;

   public Node(int item) {
     data = item;
     left = right = null;
   }
 }

 // Function to construct a binary tree from user input in level order
 public Node constructTree() {
   Scanner sc = new Scanner(System.in);
   System.out.println("Enter the tree data in level order (space-separated, -1 for null): ");
   String[] elements = sc.nextLine().split(" ");

   int i = 0;
   Queue<Node> queue = new LinkedList<>();

   // Create root node from the first element
   if (!elements[i].equals("-1")) {
     root = newNode(Integer.parseInt(elements[i]));
     queue.add(root);
   }
   i++;

   while (!queue.isEmpty()) {
     Node current = queue.poll();

     // Process left child
     if (i < elements.length && !elements[i].equals("-1")) {
       current.left = newNode(Integer.parseInt(elements[i]));
       queue.add(current.left);
     }
     i++;

     // Process right child
     if (i < elements.length && !elements[i].equals("-1")) {
       current.right = newNode(Integer.parseInt(elements[i]));
       queue.add(current.right);
     }
     i++;
   }

   return root;
 }

 // Function to print the boundary traversal of a binary tree
 public void printBoundaryTraversal() {
   if (root == null) {
     return;
   }

   System.out.print(root.data + " "); // Print the root

   printLeftBoundary(root.left); // Print left boundary

   printLeafNodes(root); // Print leaf nodes

   // Print reverse right boundary, excluding leaf nodes
   printRightBoundary(root.right);
 }

 // Recursive function to print left boundary in top-down manner
 private void printLeftBoundary(Node node) {
   if (node == null) {
     return;
   }

   if (node.left != null) {
     System.out.print(node.data + " ");
     printLeftBoundary(node.left);
   } else if (node.right != null) {
     System.out.print(node.data + " ");
     printLeftBoundary(node.right);
   }
 }

 // Recursive function to print leaf nodes
 private void printLeafNodes(Node node) {
   if (node == null) {
     return;
   }

   printLeafNodes(node.left);

   if (node.left == null && node.right == null) {
     System.out.print(node.data + " ");
   }

   printLeafNodes(node.right);
 }

 // Recursive function to print right boundary in bottom-up manner
 private void printRightBoundary(Node node) {
   if (node == null) {
     return;
   }

   if (node.right != null) {
     printRightBoundary(node.right);
     System.out.print(node.data + " ");
   } else if (node.left != null) {
     printRightBoundary(node.left);
     System.out.print(node.data + " ");
   }
 }

 public static void main(String[] args) {
   BinaryTree tree = new BinaryTree();
   tree.root = tree.constructTree();

   System.out.println("Boundary Traversal of the Binary Tree:");
   tree.printBoundaryTraversal();
 }
}

// Binomial Heap
class BinomialHeap {
    public static class Node {
        public int value;
        public Node parent;
        public List<Node> children;
        public int degree;
        public boolean marked;

        public Node(int val) {
            value = val;
            parent = null;
            children = new ArrayList<>();
            degree = 0;
            marked = false;
        }
    }

    public List<Node> trees;
    public Node min_node;
    public int count;

    public BinomialHeap() {
        min_node = null;
        count = 0;
        trees = new ArrayList<>();
    }

    public boolean is_empty() {
        return min_node == null;
    }

    public void insert(int value) {
        Node node = new Node(value);
        BinomialHeap heap = new BinomialHeap();
        heap.trees.add(node);
        merge(heap);
    }

    public int get_min() {
        return min_node.value;
    }

    public int extract_min() {
        Node minNode = min_node;
        trees.remove(minNode);
        BinomialHeap heap = new BinomialHeap();
        heap.trees = minNode.children;
        merge(heap);
        _find_min();
        count -= 1;
        return minNode.value;
    }

    public void merge(BinomialHeap other_heap) {
        trees.addAll(other_heap.trees);
        count += other_heap.count;
        _find_min();
    }

    public void _find_min() {
        min_node = null;
        for (Node tree : trees) {
            if (min_node == null || tree.value < min_node.value) {
                min_node = tree;
            }
        }
    }

    public void decrease_key(Node node, int new_value) {
        if (new_value > node.value) {
            throw new IllegalArgumentException("New value is greater than the current value");
        }
        node.value = new_value;
        _bubble_up(node);
    }

    public void delete_node(Node node) {
        decrease_key(node, Integer.MIN_VALUE);
        extract_min();
    }

    public void _bubble_up(Node node) {
        Node parent = node.parent;
        while (parent != null && node.value < parent.value) {
            int temp = node.value;
            node.value = parent.value;
            parent.value = temp;
            node = parent;
            parent = node.parent;
        }
    }

    public void _link(Node tree1, Node tree2) {
        if (tree1.value > tree2.value) {
            Node temp = tree1;
            tree1 = tree2;
            tree2 = temp;
        }
        tree2.parent = tree1;
        tree1.children.add(tree2);
        tree1.degree += 1;
    }

    public void _consolidate() {
        int max_degree = (int) Math.floor(Math.log(count) / Math.log(2)) + 1;
        Node[] degree_to_tree = new Node[max_degree + 1];

        while (!trees.isEmpty()) {
            Node current = trees.get(0);
            trees.remove(0);
            int degree = current.degree;
            while (degree_to_tree[degree] != null) {
                Node other = degree_to_tree[degree];
                degree_to_tree[degree] = null;
                if (current.value < other.value) {
                    _link(current, other);
                } else {
                    _link(other, current);
                    current = other;
                }
                degree++;
            }
            degree_to_tree[degree] = current;
        }

        min_node = null;
        trees.clear();
        for (Node tree : degree_to_tree) {
            if (tree != null) {
                trees.add(tree);
                if (min_node == null || tree.value < min_node.value) {
                    min_node = tree;
                }
            }
        }
    }

    public int size() {
        return count;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BinomialHeap heap = new BinomialHeap();

        while (true) {
            System.out.println("1. Insert");
            System.out.println("2. Extract Min");
            System.out.println("3. Get Min");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter value to insert: ");
                    int value = scanner.nextInt();
                    heap.insert(value);
                    break;
                case 2:
                    if (heap.is_empty()) {
                        System.out.println("Heap is empty.");
                    } else {
                        int min = heap.extract_min();
                        System.out.println("Min value extracted: " + min);
                    }
                    break;
                case 3:
                    if (heap.is_empty()) {
                        System.out.println("Heap is empty.");
                    } else {
                        int min = heap.get_min();
                        System.out.println("Min value: " + min);
                    }
                    break;
                case 4:
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}

// Kary Heap
public class KaryHeap {

	public static void main(String[] args) {
	    Scanner obj = new Scanner(System.in);
	    
		final int capacity = 100;
		int size = obj.nextInt();
		
		int[] arr = new int[capacity];
		
		for (int i = 0; i < size; i++) {
		    arr[i] = obj.nextInt();
		}
		
		int n = obj.nextInt();
		int k = obj.nextInt();

		
		buildHeap(arr, n, k);

		System.out.println("Built Heap: ");
		for (int i = 0; i < n; i++)
			System.out.print(arr[i] + " ");

		int element = 3;
		insert(arr, n, k, element);
		n++;

		System.out.println("\n\nHeap after insertion of " + element + ": ");
		for (int i = 0; i < n; i++)
			System.out.print(arr[i] + " ");

		System.out.println("\n\nExtracted max is " + extractMax(arr, n, k));
		n--;

		System.out.println("\n\nHeap after extract max: ");
		for (int i = 0; i < n; i++)
			System.out.print(arr[i] + " ");
	}

	public static void buildHeap(int[] arr, int n, int k) {
		for (int i = (n - 1) / k; i >= 0; i--)
			restoreDown(arr, n, i, k);
	}

	public static void insert(int[] arr, int n, int k, int elem) {
		arr[n - 1] = elem;
		restoreUp(arr, n - 1, k);
	}

	public static int extractMax(int[] arr, int n, int k) {
		int max = arr[0];
		arr[0] = arr[n - 1];
		restoreDown(arr, n - 1, 0, k);
		return max;
	}

	public static void restoreDown(int[] arr, int len, int index, int k) {
		int[] child = new int[k + 1];
		while (true) {
			for (int i = 1; i <= k; i++)
				child[i] = (k * index + i) < len ? (k * index + i) : -1;

			int maxChild = -1, maxChildIndex = 0;
			for (int i = 1; i <= k; i++) {
				if (child[i] != -1 && arr[child[i]] > maxChild) {
					maxChildIndex = child[i];
					maxChild = arr[child[i]];
				}
			}

			if (maxChild == -1)
				break;

			if (arr[index] < arr[maxChildIndex])
				swap(arr, index, maxChildIndex);

			index = maxChildIndex;
		}
	}

	public static void restoreUp(int[] arr, int index, int k) {
		int parent = (index - 1) / k;
		while (parent >= 0) {
			if (arr[index] > arr[parent]) {
				swap(arr, index, parent);
				index = parent;
				parent = (index - 1) / k;
			} else
				break;
		}
	}

	public static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
}

// Binomial Heap
class BinomialHeapNode {
	int key, degree;
	BinomialHeapNode parent;
	BinomialHeapNode sibling;
	BinomialHeapNode child;
	public BinomialHeapNode(int k){
		key = k;
		degree = 0;
		parent = null;
		sibling = null;
		child = null;
	}
	public BinomialHeapNode reverse(BinomialHeapNode sibl){
		BinomialHeapNode ret;
		if (sibling != null)
			ret = sibling.reverse(this);
		else
			ret = this;
		sibling = sibl;
		return ret;
	}public BinomialHeapNode findMinNode(){
		BinomialHeapNode x = this, y = this;
		int min = x.key;
		while (x != null) {
			if (x.key < min) {
				y = x;
				min = x.key;
			}
			x = x.sibling;
		}
		return y;
	}
	public BinomialHeapNode findANodeWithKey(int value){
		BinomialHeapNode temp = this, node = null;
		while (temp != null) {
			if (temp.key == value) {
				node = temp;
				break;
			}
			if (temp.child == null)
				temp = temp.sibling;
	            else {
				node = temp.child.findANodeWithKey(value);
				if (node == null)
					temp = temp.sibling;
				else
					break;
			}
		}
		return node;
	}
	public int getSize(){
		return (1 + ((child == null) ? 0 : child.getSize())+ ((sibling == null) ? 0 : sibling.getSize()));
	}
}
class BinomialHeap {
	private BinomialHeapNode Nodes;
	private int size;
	public BinomialHeap(){
		Nodes = null;
		size = 0;
	}

      public boolean isEmpty() { 
	    return Nodes == null; 
	}
	public int getSize() { 
	    return size; 
	}
	public void makeEmpty(){
		Nodes = null;
		size = 0;
	}
	public void insert(int value){
		if (value > 0) {
			BinomialHeapNode temp = new BinomialHeapNode(value);
			if (Nodes == null) {
				Nodes = temp;
				size = 1;
			}
			else {
				unionNodes(temp);size++;
			}
		}
	}
      private void merge(BinomialHeapNode binHeap){
		BinomialHeapNode temp1 = Nodes, temp2 = binHeap;
		while ((temp1 != null) && (temp2 != null)) {
			if (temp1.degree == temp2.degree) {
				BinomialHeapNode tmp = temp2;
				temp2 = temp2.sibling;
				tmp.sibling = temp1.sibling;
				temp1.sibling = tmp;
				temp1 = tmp.sibling;
			}
			else {
				if (temp1.degree < temp2.degree) {
					if ((temp1.sibling == null) ||         							(temp1.sibling.degree > temp2.degree)){
						BinomialHeapNode tmp = temp2;
						temp2 = temp2.sibling;
						tmp.sibling = temp1.sibling;
						temp1.sibling = tmp;
						temp1 = tmp.sibling;
					}
					
			            else
						temp1 = temp1.sibling;
				}
				else {
					BinomialHeapNode tmp = temp1;
					temp1 = temp2;
					temp2 = temp2.sibling;
					temp1.sibling = tmp;
					if (tmp == Nodes)
						Nodes = temp1;
				}
			}
		}
		if (temp1 == null) {
			temp1 = Nodes;
			while (temp1.sibling != null)
				temp1 = temp1.sibling;
			temp1.sibling = temp2;
		}
	}
      private void unionNodes(BinomialHeapNode binHeap){
		merge(binHeap);
		BinomialHeapNode prevTemp = null, temp = Nodes, nextTemp = 										Nodes.sibling;
		while (nextTemp != null) {
			if ((temp.degree != nextTemp.degree) || 				((nextTemp.sibling != null) && (nextTemp.sibling.degree == 	temp.degree))){
				prevTemp = temp;
				temp = nextTemp;
			}
			else {
				if (temp.key <= nextTemp.key) {
					temp.sibling = nextTemp.sibling;
					nextTemp.parent = temp;
					nextTemp.sibling = temp.child;
					temp.child = nextTemp;
					temp.degree++;
				}
				else {
					if (prevTemp == null)
						Nodes = nextTemp;				
                              else
						prevTemp.sibling = nextTemp;
					temp.parent = nextTemp;
					temp.sibling = nextTemp.child;
					nextTemp.child = temp;
					nextTemp.degree++;
					temp = nextTemp;
				}
			}
			nextTemp = temp.sibling;
		}
	}
	public int findMinimum(){
		return Nodes.findMinNode().key;
	}
	public void delete(int value){
		if ((Nodes!=null) && (Nodes.findANodeWithKey(value)!=null)){
			decreaseKeyValue(value, findMinimum() - 1);
			extractMin();
		}
	}
      public void decreaseKeyValue(int old_value,int new_value){
		BinomialHeapNode temp = Nodes.findANodeWithKey(old_value);
		if (temp == null)
			return;
		temp.key = new_value;
		BinomialHeapNode tempParent = temp.parent;
		while ((tempParent != null)	&& (temp.key < tempParent.key)) {
			int z = temp.key;
			temp.key = tempParent.key;
			tempParent.key = z;
			temp = tempParent;
			tempParent = tempParent.parent;
		}
	}
	public int extractMin(){
		if (Nodes == null)
			return -1;
		BinomialHeapNode temp = Nodes, prevTemp = null;
		BinomialHeapNode minNode = Nodes.findMinNode();
	
            while (temp.key != minNode.key) {
			prevTemp = temp;
			temp = temp.sibling;
		}
		if (prevTemp == null)
			Nodes = temp.sibling;
		else
			prevTemp.sibling = temp.sibling;
		temp = temp.child;
		BinomialHeapNode fakeNode = temp;
		while (temp != null) {
			temp.parent = null;
			temp = temp.sibling;
		}
		if ((Nodes == null) && (fakeNode == null))
			size = 0;
		else {
			if ((Nodes == null) && (fakeNode != null)) {
				Nodes = fakeNode.reverse(null);
				size = Nodes.getSize();
			}
                  else {
				if ((Nodes != null) && (fakeNode == null))
					size = Nodes.getSize();
				else {
					unionNodes(fakeNode.reverse(null));
					size = Nodes.getSize();
				}
			}
		}
		return minNode.key;
	}
	public void displayHeap(){
		System.out.print("\nHeap : ");displayHeap(Nodes);
		System.out.println("\n");
	}
	private void displayHeap(BinomialHeapNode r){
		if (r != null) {
			displayHeap(r.child);System.out.print(r.key + " ");
			displayHeap(r.sibling);
		}
	}
 }
 public class Main {
	public static void main(String[] args){
		BinomialHeap binHeap = new BinomialHeap();
		Scanner s=new Scanner(System.in);
		int n=s.nextInt();
		for(int i=0; i<n; i++)
		    binHeap.insert(s.nextInt());
		System.out.println("Size:" + binHeap.getSize());
		binHeap.displayHeap();
		binHeap.delete(s.nextInt());
		System.out.println("Size:" + binHeap.getSize());
		binHeap.displayHeap();
		System.out.println(binHeap.isEmpty());
		binHeap.makeEmpty();
		System.out.println(binHeap.isEmpty());
	}
 }

 // Top view
 import java.util.*;

class TreeNode {
    int val;
    TreeNode left, right;

    public TreeNode(int val) {
        this.val = val;
        left = right = null;
    }
}

public class TopViewBinaryTree {
    static TreeNode buildTree(int[] arr, int index) {
        if (index >= arr.length || arr[index] == -1) {
            return null;
        }
        TreeNode root = new TreeNode(arr[index]);
        root.left = buildTree(arr, 2 * index + 1);
        root.right = buildTree(arr, 2 * index + 2);
        return root;
    }

    static void topView(TreeNode root) {
        if (root == null) {
            return;
        }

        Queue<Map.Entry<TreeNode, Integer>> queue = new LinkedList<>();
        Map<Integer, Integer> topViewMap = new TreeMap<>();

        // Pair of node and its horizontal distance from the root
        queue.offer(new AbstractMap.SimpleEntry<>(root, 0));

        while (!queue.isEmpty()) {
            Map.Entry<TreeNode, Integer> entry = queue.poll();
            TreeNode node = entry.getKey();
            int hd = entry.getValue();

            // If the horizontal distance is not present in the map, add it to the map
            if (!topViewMap.containsKey(hd)) {
                topViewMap.put(hd, node.val);
            }

            // Enqueue left and right children with updated horizontal distance
            if (node.left != null) {
                queue.offer(new AbstractMap.SimpleEntry<>(node.left, hd - 1));
            }
            if (node.right != null) {
                queue.offer(new AbstractMap.SimpleEntry<>(node.right, hd + 1));
            }
        }

        // Print the top view of the binary tree
        for (int val : topViewMap.values()) {
            System.out.print(val + " ");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input array of integers
        System.out.println("Enter the array of integers separated by spaces:");
        String[] inputValues = scanner.nextLine().split("\\s+");
        int[] arr = new int[inputValues.length];
        for (int i = 0; i < inputValues.length; i++) {
            arr[i] = Integer.parseInt(inputValues[i]);
        }

        // Construct the binary tree
        TreeNode root = buildTree(arr, 0);

        // Print the top view of the binary tree
        System.out.println("Top view of the binary tree:");
        topView(root);
    }
}
