class BST11
{

    class Node
    {
        int key;
        Node left, right;
        Node(int key)
        {
            this.key = key;
            this.left = this.right =null;
        }
    }
    
    private Node root = null;
    // THIS BETTER BE A PRIVATE MEMBER OF TREE OBJECT,
    // AND NOT STATIC (NOT RELATED TO ANY OBJECT)..THAT KIND OF BEATS THE PURPOSE OF MAKING OBJECTS!
    
    public void insert(int key)
    {
        root = insert(root, key);
    }
    public Node insert(Node n, int key)
    {
        if(n==null)return new Node(key);
        if(key<n.key)n.left = insert(n.left, key);
        else n.right = insert(n.right, key);
        return n;
    }
    public Node getMin(Node n)
    {
        if(n.left == null)return n;
        return getMin(n.left);
    }
    public void delete(int key)
    {
        root = delete(root, key);  // insert() WAS MISTAKENLY CALLED HERE 
    }
    
    public Node delete(Node n, int key)
    {
        if(n == null) return null;
        
        if(key < n.key) n.left = delete(n.left, key);
        else
        if(key > n.key) n.right = delete(n.right, key);
        else
        {
         /*   if(n.right == null && n.left == null)  // NOT NEEDED, THE BELOW CONDITIONS WILL DO THIS TOO
                root = null;
          */
            if(n.right == null) return n.left;
            else if(n.left == null) return n.right;
            else
            {
                Node temp = getMin(n.right);
                
                /*
                 n.key = temp.key;  // JUST SWAPPING VALUES IS NOT RECOMMENDED,
                                    // WHAT IF THE NODE HAS A THOUSAND MEMBERS, NOT JUST ONE KEY?
                 n.right = delete(n.right,temp.key);  // WE NEED A deleteMin() FUNCTION HERE!
                */
                
                temp.right = deleteMin(n.right);
                temp.left = n.left;
                return temp;
            }
        }
        return n;
    }
    
    /* A FUNCTION TO DELETE MIN NODE */
    public Node deleteMin(Node n) {
    	if(n.left == null) return n.right; // right child (if any) attaches to n's parent in place of left (min) node
    	else n.left = deleteMin(n.left);
    	return n;
    }
    
    public void search(int key)
    {
     search(root, key);
    }
    
    public void search(Node n, int key)
    {
        if(n == null) {
        	System.out.println("NOT FOUND");
        	return;
        }
        
        else if(key == n.key) System.out.println("FOUND");
        else if(key < n.key) search(n.left, key);
        else search(n.right, key); 
        // THERE WAS A LETHAL DOT HERE! ORIGINAL: else search(n.right.key); <- Problem!
    }
    
    public static void main(String []arg)
    {
        BST11 t =  new BST11();
        t.insert(15);
        t.insert(10);
        t.insert(8);
        t.insert(6);
        t.insert(9);
        t.insert(20);
        t.insert(16);
        t.insert(17);
        t.insert(25);
        
        t.search(20);        
        t.delete(20);
        t.search(20);
    }
}