package com.bridgelabz;


public class MyBinaryTree<K extends Comparable<K>>{

    private MyBinaryNode<K> root;
    public void add (K key){
        this.root = this.addRecursively(root, key);
    }
    public K search(K key) {
        return key = this.searchRecursively(root, key);
    }

    private MyBinaryNode<K> addRecursively(MyBinaryNode<K> current, K key){
        if (current == null)
            return new MyBinaryNode<K>(key);
        int compareResult = key.compareTo(current.key);
        if (compareResult == 0)
            return current;
        if(compareResult < 0){
            current.left = addRecursively(current.left , key);
        }else{
            current.right = addRecursively(current.right , key);
        }
        return current;
    }
    private K searchRecursively(MyBinaryNode<K> current, K key){
        K searchKey = null;
        if (current == null)
            return current.key;
        int compareResult = key.compareTo(current.key);
        if (compareResult == 0 || current == key){
            searchKey = current.key;
        }
        if (compareResult <0){
            searchKey = searchRecursively(current.left, key);
        }if (compareResult > 0){
            searchKey = searchRecursively(current.right , key);
        }
        return searchKey;
    }

    public int getSize(){
        return this.getSizeRecursive(root);
    }
    private int getSizeRecursive(MyBinaryNode<K> current){
        return current == null ? 0 : 1 + this.getSizeRecursive(current.left) +
                this.getSizeRecursive(current.right);
    }
}
