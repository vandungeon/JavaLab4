import org.example.BinarySearchTree;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class bstTest {
    BinarySearchTree bst;

    @BeforeEach
    void setUp() {
        //sets up test tree so tests will be more optimized and work better
        bst = new BinarySearchTree();
        int n = 23;
        for (int i = n; i < n + 20; i++) {
            bst.insert(i, "Value" + i);
        }
    }

    @Test
    void testOneAndTwo() {
        // Test map, creation and check
        assertEquals(20, bst.countNodes());
    }
    @Test
    void testThree() {
        // Test search
        int SearchAmount = 5;
        Random random = new Random();
        Set<Integer> randomKeys = new HashSet<>();//
        int n = 23; //min

        while (randomKeys.size() < SearchAmount) {
            int randomKey = n + random.nextInt(20);
            randomKeys.add(randomKey);
            String value = bst.search(randomKey);
            if (value != null) {
                System.out.println("Key: " + randomKey + ", Value: " + value);
                assertEquals("Value" + randomKey, value);
            }
        }
    }

    @Test
    void testFour() {
        //test deletion, insertion
        bst.delete(30);
        bst.insert(30, "NewValue");
        assertEquals(20, bst.countNodes());//was inserted?
        assertEquals("NewValue", bst.search(30));//search
        bst.insert(37, "UpdatedValue");
        assertEquals(20, bst.countNodes());//was inserted?
        assertEquals("UpdatedValue", bst.search(37));//was inserted properly?
    }

    @Test
    void testFive() {
        // Test proper deletion
        bst.delete(30); // Remove an element
        assertEquals(19, bst.countNodes());
        assertNull(bst.search(30));//was indeed deleted
    }
}
