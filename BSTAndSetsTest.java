package part1;
import java.util.*;

public class BSTAndSetsTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		BinarySearchTree<Item> bst = new BinarySearchTree<Item>();
		List<Item> dataSet = new LinkedList<Item>();
		HashSet<Item> hset = new HashSet<Item>();
		TreeSet<Item> tset = new TreeSet<Item>();
		
		Random ran = new Random();
        System.out.print("Please enter the size of the data set: ");
        try (Scanner keyboard = new Scanner(System.in)) {
            int size = keyboard.nextInt();
            System.out.println("#teamBeeby");
            int count = 0;
           	System.out.println("The current size is: "+ size);
           	while (bst.size() < size && hset.size() < size && tset.size() < size) {
           		Item candidate = new Item(ran.nextInt(100000)); // add numbers from 1 to size in random order
            	count++;
            		
               	if (bst.add(candidate) && hset.add(candidate) && tset.add(candidate)) {
                   	dataSet.add(candidate);
               	}
            }
            System.out.println("CompCount after add(): " + Item.getCompCount());
            Item.resetCompCount();
            System.out.printf("Added %d elements from %d numbers.\n", size, count);
        }
        System.out.print("Dataset:");
        for (Item l: dataSet){
        	System.out.print(" " + l);
        }
        System.out.print("\n");
        System.out.println(hset);
        System.out.println(tset);
        int errorCount = 0;
    	System.out.println("Testing contains() method:");
        for (Item d : dataSet) {
        	if (bst.contains(bst.size() + 3)) { // tests for absence of number out of bounds
        		errorCount++;
        		System.out.printf("Error %d: contains(%d) returns true.\n", errorCount, (d.value()/2)*2);
        	}
        	if (hset.contains(hset.size() + 3)) { 
        		errorCount++;
        		System.out.printf("Error %d: contains(%d) returns true.\n", errorCount, (d.value()/2)*2);
        	}
        	if (tset.contains(tset.size() + 3)) { 
        		errorCount++;
        		System.out.printf("Error %d: contains(%d) returns true.\n", errorCount, (d.value()/2)*2);
        	}
    	}
    	System.out.println("CompCount after contains(): " + Item.getCompCount());
    	Item.resetCompCount();
    	for (Item d : dataSet) {       
    		if (!bst.contains(d)) {
    			errorCount++;
    			System.out.printf("Error %d: contains(%d) returns false.\n", errorCount, d);
    		}
    		if (!hset.contains(d)) {
    			errorCount++;
    			System.out.printf("Error %d: contains(%d) returns false.\n", errorCount, d);
    		}
    		if (!tset.contains(d)) {
    			errorCount++;
    			System.out.printf("Error %d: contains(%d) returns false.\n", errorCount, d);
    		}
    	}
    	System.out.println("CompCount after contains(): " + Item.getCompCount());
    	Item.resetCompCount();
        
	}

}
