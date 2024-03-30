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
