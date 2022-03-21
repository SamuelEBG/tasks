package pg42sg.task05;

import org.pg4200.les05.MyMapBinarySearchTree;

public class BinaryTreeLeftMaxDelete<K extends Comparable<K>, V> extends MyMapBinarySearchTree<K, V> {

    /*
       If we delete a node with 2 children, instead of taking the
       first value greater than the deleted node and replacing that
       node with the deleted one, we take the first value smaller than
       then deleted note from the left subtree.
     */
    @Override
    protected TreeNode delete(K key, TreeNode subtreeRoot) {
        // Once recursively iterated through entire tree next subtree root will
        // be null, thus ending the recursive iteration and beginning to traverse upwards.
        if (subtreeRoot == null) {
            return null;
        }
        /*
            Initialize an int that compares the key of the node
            that we want to delete with the first subtreeRoot key.
            If it's smaller or greater than the current key we have recursively
            iterated to, we will traverse further down the tree either left or right.
         */
        int cmp = key.compareTo(subtreeRoot.key);
        // key is bigger than root.key, we jump down to subtree root nr 1
        // which is child to the right.
        if (cmp > 0) {
            subtreeRoot.right = delete(key, subtreeRoot.right); // start recursion
            return subtreeRoot;
        }
        // key is smaller than root.key, so we go to the left.
        if (cmp < 0) {
            subtreeRoot.left = delete(key, subtreeRoot.left);
            return subtreeRoot;
        }
        // None of the above is true, key must be equal to root.key,
        // which means that we are at the node that is to be deleted.
        assert cmp == 0;

        size--;

        /*
            0
            1 (left or right)
            2
         */

        if (subtreeRoot.left == null) {
            return subtreeRoot.right;
        }

        if (subtreeRoot.right == null) {
            return subtreeRoot.left;
        }

        // both children are present.

        assert subtreeRoot.left != null && subtreeRoot.right != null;
        // Set the node that we want to delete to a temp TreeNode obj.
        TreeNode tmp = subtreeRoot;
        subtreeRoot = max(tmp.left); // Find max value in left subtree
        subtreeRoot.left = deleteMax(tmp.left);
        subtreeRoot.right = tmp.right;

        return subtreeRoot;
    }

    private TreeNode max(TreeNode subtreeRoot) {
        // Here we want to find the largest value in the left subtree
        // from the inode we want to delete, so we iterate further down
        // from the tree from where we are now (the inode which is to be deleted)
        // and as usual we keep going until we find no more children.
        // Since each addition is greater than the previous when adding
        // to the right.
        if (subtreeRoot.right == null) {
            return subtreeRoot;
        }
        // If not, we iterate further down the left subtree until we reach the
        // largest inode.
        return max(subtreeRoot.right);
    }

    private TreeNode deleteMax(TreeNode subtreeRoot) {
        // Now we want to delete the largest inode we found.
        if (subtreeRoot.right == null) {
            return subtreeRoot.left;
        }

        subtreeRoot.right = deleteMax(subtreeRoot.right);

        return subtreeRoot;
    }
}

