package com.hxh.map;

/**
 * @author huangxunhui
 * Date: Created in 18/10/17 下午3:52
 * Utils: Intellij Idea
 * Description:
 */
public class BinarySearchTreeMap<K extends Comparable <K>  , V> implements Map<K , V>  {

    private class Node {

        private K key;

        private V value;

        private Node left;

        private Node right;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
            this.left = null;
            this.right = null;
        }
    }

    private Node root;

    private Integer size;

    public BinarySearchTreeMap(){
        root = null ;
        size = 0;
    }

    @Override
    public void add(K k, V v) {
        root = add(root , k , v);
    }

    private Node add(Node node , K k , V v ){
        if(node == null){
            size++;
            return new Node(k , v);
        }
        if(k.compareTo(node.key) < 0 ){
            node.left = add(node.left, k , v);
        }else if(k.compareTo(node.key) > 0){
            node.right = add(node.right,k , v);
        }else{
            node.value = v;
        }
        return node;
    }

    @Override
    public V remove(K k) {
        Node node = getNode(root, k);
        if(node != null){
            root = remove(root , k);
            return node.value;
        }
        return null;
    }

    private Node remove(Node node , K k){
        if(node == null){
            return null;
        }

        if(k.compareTo(node.key)<0){
            node.left = remove(node.left , k);
            return node;
        }else if(k.compareTo(node.key)>0){
            node.right = remove(node.right ,k );
            return node;
        }else{ // e == node.e
            //如果待删除节点左子树为空的情况
            if(node .left == null){
                Node rightNode = node.right;
                node.right = null;
                size--;
                return rightNode;
            }
            // 如果待删除节点右子树为空的情况
            if(node.right == null){
                Node leftNode = node.left;
                node.left = null;
                size--;
                return leftNode;
            }
            Node successor = minimum(node.right);
            successor.right = removeMin(node.right);
            successor.left = node.right;
            node.left = node .right = null;
            return successor;
        }

    }

    @Override
    public boolean contains(K k) {
        Node node = getNode(root, k);
        return node != null;
    }


    @Override
    public V get(K k) {
        Node node = getNode(root, k);
        return node == null ? null : node.value;
    }

    @Override
    public void set(K k, V v) {
        Node node = getNode(root, k);
        if(node == null){
            throw new IllegalArgumentException((k + "doesn't exist" ));
        }
        node.value = v;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    private Node getNode(Node node , K k) {
        if(node == null){
            return null;
        }
        if(node.key.compareTo(k) == 0){
            return node;
        }
        else if(k.compareTo(node.key) < 0 ) {
            return getNode(node.left, k);
        }else if(k.compareTo(node.key) > 0) {
            return getNode(node.right, k);
        }
        return null;
    }

    private Node minimum(Node node){
        if(node.left == null){
            return node;
        }
        return minimum(node.left);
    }

    private Node removeMin(Node node) {
        if (node.left == null) {
            Node rightNode = node.right;
            node.right = null;
            size--;
            return rightNode;
        }
        node.left = removeMin(node.left);
        return node;
    }
}
