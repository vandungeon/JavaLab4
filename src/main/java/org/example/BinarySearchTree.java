package org.example;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import static org.junit.jupiter.api.Assertions.*;

class BSTNode {
    int key;
    String value;
    BSTNode left;
    BSTNode right;

    public BSTNode(int key, String value) {
        this.key = key;
        this.value = value;
    }
}

public class BinarySearchTree {
    private BSTNode root;

    public void insert(int key, String value) {
        root = insertRecursive(root, key, value);
    }

    private BSTNode insertRecursive(BSTNode root, int key, String value) {
        if (root == null) {
            return new BSTNode(key, value);
        }

        if (key < root.key) {
            root.left = insertRecursive(root.left, key, value);
        } else if (key > root.key) {
            root.right = insertRecursive(root.right, key, value);
        } else {
            root.value = value; // Key already exists, value shall be updated
        }

        return root;
    }

    public String search(int key) {
        return searchRecursive(root, key);
    }

    private String searchRecursive(BSTNode root, int key) {
        if (root == null) {
            return null;
        }

        if (key == root.key) {
            return root.value;
        } else if (key < root.key) {
            return searchRecursive(root.left, key);
        } else {
            return searchRecursive(root.right, key);
        }
    }

    public void delete(int key) {
        root = deleteRecursive(root, key);
    }

    private BSTNode deleteRecursive(BSTNode root, int key) {
        if (root == null) {
            return root;
        }

        if (key < root.key) {
            root.left = deleteRecursive(root.left, key);
        } else if (key > root.key) {
            root.right = deleteRecursive(root.right, key);
        } else {
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }

            root.key = minDelValue(root.right);
            root.right = deleteRecursive(root.right, root.key);
        }

        return root;
    }

    private int minDelValue(BSTNode node) {
        int minDelValue = node.key;//minimal value to the right, which will be used for deletion
        while (node.left != null) {
            minDelValue = node.left.key;
            node = node.left;
        }
        return minDelValue;
    }

    public int countNodes() {
        return countNodesRecursive(root);
    }

    private int countNodesRecursive(BSTNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + countNodesRecursive(root.left) + countNodesRecursive(root.right);
    }
}

