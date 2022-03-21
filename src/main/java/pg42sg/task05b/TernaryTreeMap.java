package pg42sg.task05b;

import org.pg4200.les05.MyMapTreeBased;

import javax.swing.tree.TreeNode;
import java.util.Objects;

public class TernaryTreeMap<K extends Comparable<K>, V> implements MyMapTreeBased<K, V> {

    /*
        A protected class of TreeNode so that we can create TreeNode
        objects and store values in them, these are the objects that we will
        edit or remove in the TreeMap.
     */
    protected class TreeNode{

        private K firstKey;
        private K secondKey;
        private V firstValue;
        private V secondValue;

        private TreeNode left;
        private TreeNode middle;
        private TreeNode right;
    }
    // From the root of the tree we can access all the nodes.
    // So first node will be the root of the tree.
    protected TreeNode root;
    // Keeping track of the size of the tree.
    protected int size;

    /*
     This method is called with a key and value we want to add to the treeMap.
     First we check so the key is not null.
     Then we call the put method, if the root parameter that is entered
     is null, it will set the key and value to root.
     Next time this method is called it will start comparing against
     the previous element, which will be root, and so on and so on.
     */

    @Override
    public void put(K key, V value) {
        Objects.requireNonNull(key);
        root = put(key, value, root); // parameter with whatever root is set to (if it is)
    }

    private TreeNode put(K key, V value, TreeNode subtreeRoot){
            // root's values are set and after that the comparing can begin.
        if(subtreeRoot == null) {
            TreeNode node = new TreeNode();
            node.firstKey = key;
            node.firstValue = value;
            size++;
            return node;
        }
            // Compare the first key with the existing subtreeRoot.
        int firstKeyCompare = key.compareTo(subtreeRoot.firstKey);
            // Is the key smaller? We recurse down the tree to the left
        if(subtreeRoot.secondKey == null){
            size++;
            if(firstKeyCompare < 0){
                subtreeRoot.secondKey = subtreeRoot.firstKey;
                subtreeRoot.secondValue = subtreeRoot.firstValue;
                subtreeRoot.firstKey = key;
                subtreeRoot.firstValue = value;
            } else {
                subtreeRoot.secondKey = key;
                subtreeRoot.secondValue = value;
            }
            return subtreeRoot;
        }

        int secondKeyCompare = key.compareTo(subtreeRoot.secondKey);

        if(firstKeyCompare == 0){
            subtreeRoot.firstValue = value;
            return subtreeRoot;
        }

        if(secondKeyCompare == 0){
            subtreeRoot.secondValue = value;
            return subtreeRoot;
        }

        if (firstKeyCompare < 0){
            subtreeRoot.left = put(key, value, subtreeRoot.left);
            return subtreeRoot;
        } else if (firstKeyCompare > 0){
            if(secondKeyCompare < 0){
                subtreeRoot.middle = put(key, value, subtreeRoot.middle);
            }
        } else {
            subtreeRoot.right = put(key, value, subtreeRoot.right);
        }

        /*
        if(firstKeyCompare < 0){
            subtreeRoot.left = put(key, value, subtreeRoot.left); // Recursive method
            return subtreeRoot;
            // Is the key equal to the subtree key? Then we replace, remember, no double keys.
            // Instead, value is replacing old value in current key.
        } else if(firstKeyCompare == 0){
            subtreeRoot.firstValue = value;
            // Is the key bigger? Then we can add another key to the node (secondKey).
        } else if(firstKeyCompare > 0){
                // If there is no secondKey, we add this key, update key and value
            if(subtreeRoot.secondKey == null){
                size++;
                subtreeRoot.secondKey = key;
                subtreeRoot.secondValue = value;
                // If not, we make a new comparison, and start the same process but for this key.
            } else {
                // New compare, still comparing the key we want to add but to the secondKey this time.
                int secondKeyCompare = key.compareTo(subtreeRoot.secondKey);
                    // Is it smaller? Create a middle.
                if(secondKeyCompare < 0){
                    subtreeRoot.middle = put(key, value, subtreeRoot.middle);
                    // Is it equal? We replace the second value because this is now the new second.
                } else if (secondKeyCompare == 0){
                    subtreeRoot.secondValue = value;
                    // Is it bigger? Add it to the right.
                } else {
                    subtreeRoot.right = put(key, value, subtreeRoot.right);
                }
            }
        }
         */

        return subtreeRoot;
    }


    @Override
    public void delete(K key) {
        Objects.requireNonNull(key);
        root = delete(key, root);
    }

    protected TreeNode delete(K key, TreeNode subtreeRoot){

        if (subtreeRoot == null) {
            return null;
        }
        // First off we start by comparing with the first key.
        int compareFirstKey = key.compareTo(subtreeRoot.firstKey);
            // Is the key smaller than first key? then we iterate down to the left.
        if(compareFirstKey < 0){
            subtreeRoot.left = delete(key, subtreeRoot.left);
            return subtreeRoot;
        }
            // If the key is equal to the first key, and second is null
            // we know that we have arrived at a leaf node.
        if(compareFirstKey == 0){
            if(subtreeRoot.secondKey == null){
                size--;
                return null;
            }
        }

        int compareSecondKey = key.compareTo(subtreeRoot.secondKey);

        if(compareSecondKey > 0){
            subtreeRoot.right = delete(key, subtreeRoot.right);
            return subtreeRoot;
        }

        if(compareSecondKey == 0){
            TreeNode max = max(subtreeRoot.middle);

        }
        return subtreeRoot;
    }

    private TreeNode max(TreeNode subtreeRoot){
        if(subtreeRoot.right == null){
            return subtreeRoot;
        }
        return max(subtreeRoot.right);
    }

    @Override
    public Object get(Comparable key) {
        return null;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return MyMapTreeBased.super.isEmpty();
    }

    @Override
    public int getMaxTreeDepth() {
            // If root is null the tree is empty, and we return 0.
        if(root == null){
            return 0;
        }
            // Otherwise, we start a recursive method traversing down the TreeMap.
        return depth(root);
    }

    protected int depth(TreeNode node){

        int leftDepth = 0;
        int rightDepth = 0;
        int middleDepth = 0;

        if(node.left != null){
            leftDepth = depth(node.left);
        }

        if(node.middle != null){
            middleDepth = depth(node.middle);
        }

        if(node.right != null){
            rightDepth = depth(node.right);
        }

        return 1 + Math.max(leftDepth, Math.max(rightDepth, middleDepth));
    }
}
