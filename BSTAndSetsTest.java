import java.util.*;

public class BSTAndSetsTest {

	private static long height (TreeSet<Item> tree) {
		long maxComp = 0;
		for (Item current : tree) {
		 Item.resetCompCount();
		 tree.contains(current);
		 if (maxComp < Item.getCompCount()) {
		 maxComp = Item.getCompCount();
		 }
		}
		return maxComp-1;
		}

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		BinarySearchTree<Item> bst = new BinarySearchTree<Item>();
		List<Item> dataSet = new LinkedList<Item>();
		HashSet<Item> hset = new HashSet<Item>();
		TreeSet<Item> tset = new TreeSet<Item>();
		
		Item test = new Item(5);
		Random ran = new Random();
        System.out.print("Please enter the size of the data set: ");
        try (Scanner keyboard = new Scanner(System.in)) {
            int size = keyboard.nextInt();
            int count = 0;
            System.out.println("The current size is: "+ size);
           	while (bst.size() < size && hset.size() < size && tset.size() < size) {
           		Item candidate = new Item(ran.nextInt(size)); // add numbers from 1 to size in random order
            	count++;
            		
               	if (bst.add(candidate) && hset.add(candidate) && tset.add(candidate)) {
                   	dataSet.add(candidate);
               	}
            }
           	System.out.println("Height of BST is: "+ bst.height());
           	System.out.println("Number of Leaves in the BST is: "+ bst.leaves());
           	System.out.println("Height of TreeSet is: "+ height(tset));
            //System.out.println("CompCount after add(): " + Item.getCompCount());
            Item.resetCompCount();
            System.out.printf("Added %d elements from %d numbers.\n", size, count);
             }
     //   System.out.print("Dataset:");
     //   for (Item l: dataSet){
     //   	System.out.print(" " + l);
     //   }
     //   System.out.print("\n");
     //   System.out.println(bst);
     //   System.out.println(hset);
     //   System.out.println(tset);
        int errorCount = 0;
       
       
        System.out.println("Searching for value: " + test.value());
 
               		if (bst.contains(test)) { // even number tests for absence
                    errorCount++;
            //        System.out.printf("Error %d: contains(%d) returns true.\n", errorCount, test.value());
                }
               		
               		else if(!bst.contains(test)) {
                	errorCount++;
                	//System.out.printf("Error %d: contains(%d) returns false.\n", errorCount, d);
            	}
        	
       	System.out.println("BST CompCount after contains(): " + Item.getCompCount());
    	Item.resetCompCount();
    	
    	
    
    			if (tset.contains(test)) { // even number tests for absence
    			errorCount++;
    		//	System.out.printf("Error %d: contains(%d) returns true.\n", errorCount, test.value());
    		}
       		
    			else if(!tset.contains(test)) {
    			errorCount++;
    		//	System.out.printf("Error %d: contains(%d) returns false.\n", errorCount, test);
    		}
    	
	System.out.println("TreeSet CompCount after contains(): " + Item.getCompCount());
	Item.resetCompCount();
	
	
	
   			if (hset.contains(new Item(test.value()))) { // even number tests for absence
   			errorCount++;
   		//	System.out.printf("Error %d: contains(%d) returns true.\n", errorCount, test.value());
   		}
   		
   			else if(!hset.contains(new Item(test.value()))) {
   			errorCount++;
   		 //	System.out.printf("Error %d: contains(%d) returns false.\n", errorCount, test);
   		}
	
	System.out.println("HashSet CompCount after contains(): " + Item.getCompCount());
	Item.resetCompCount();

	}
	
	
}
