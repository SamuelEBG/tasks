package pg42sg.Eks2021;

import org.pg4200.les05.MyMap;
import java.util.ArrayList;
import java.util.Collections;

public class StudentMap implements MyMap<Integer, StudentMap.Student> {

    private static TreeNode TreeNode;
    // public ArrayList<TreeNode> treeMap = new ArrayList<>(10);
    public ArrayList<TreeNode> treeMap = new ArrayList<>(Collections.nCopies(10, StudentMap.TreeNode));

    protected class TreeNode{

        public int key;
        public Student value;

        public TreeNode left;
        public TreeNode right;
    }

    private int indexValue(Integer key){
        String rk = String.valueOf(key);
        return Integer.parseInt(rk.substring(0, 1));
    }

    @Override
    public void put(Integer key, Student value) {

        int rootKey = indexValue(key);
        TreeNode root = put(key, value, treeMap.get(rootKey));

        treeMap.set(rootKey, root);
    }

    private TreeNode put(Integer key, Student value, TreeNode currentNode){

        if(currentNode == null){
            TreeNode node = new TreeNode();
            node.key = key;
            node.value = value;
            return node;
        }

        int cmp = key.compareTo(currentNode.key);

        if(cmp < 0){
            currentNode.left = put(key, value, currentNode.left);
            return currentNode;
        }

        if(cmp > 0){
            currentNode.right = put(key, value, currentNode.right);
            return currentNode;
        }

        currentNode.value = value;

        return currentNode;
    }

    @Override
    public void delete(Integer key) {

        int rootKey = indexValue(key);
        TreeNode root = delete(key, treeMap.get(rootKey));

        treeMap.set(rootKey, root);
    }

    private TreeNode delete(Integer key, TreeNode currentNode){

        if(currentNode == null){
            return null;
        }

        int cmp = key.compareTo(currentNode.key);

        if(cmp < 0){
            currentNode.left = delete(key, currentNode.left);
            return currentNode;
        }

        if(cmp > 0){
            currentNode.right = delete(key, currentNode.right);
            return currentNode;
        }

        assert cmp == 0;

        if(currentNode.left == null){
            return currentNode.right;
        }

        if(currentNode.right == null){
            return currentNode.left;
        }

        assert currentNode.left != null && currentNode.right != null;

        TreeNode tempNode = currentNode;
        currentNode = max(tempNode.left);
        currentNode.left = deleteMax(tempNode.left);
        currentNode.right = tempNode.right;

        return currentNode;
    }

    private TreeNode max(TreeNode currentNode){
        if(currentNode.right == null){
            return currentNode;
        }

        return max(currentNode.right);
    }

    private TreeNode deleteMax(TreeNode currentNode){

        if(currentNode.right == null){
            return currentNode.left;
        }

        currentNode.right = deleteMax(currentNode.right);

        return currentNode;
    }

    @Override
    public Student get(Integer key) {

        int rootKey = indexValue(key);
        return get(key, treeMap.get(rootKey));
    }

    private Student get(Integer key, TreeNode currentNode){

        if(currentNode == null){
            return null;
        }

        int cmp = key.compareTo(currentNode.key);

        if(cmp > 0){
            return get(key, currentNode);
        }

        if(cmp < 0){
            return get(key, currentNode);
        }

        assert cmp == 0;

        return currentNode.value;
    }

    @Override
    public int size() {return treeMap.size();}

    public static class Student {

        private int id;
        private String name;

        public Student() {
            this.id = 0;
            this.name = "";
        }

        public int getId() {
            return this.id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return this.name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
