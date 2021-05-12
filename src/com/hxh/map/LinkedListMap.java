package com.hxh.map;

/**
 * @author huangxunhui
 * Date: Created in 18/10/17 下午3:11
 * Utils: Intellij Idea
 * Description: 基于链表的MAP
 */
public class LinkedListMap<K , V> implements Map<K , V>  {

    private class  Node{

        public K key;

        public V value;

        public Node next;

        public Node(K key, V value, Node next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }

        public Node(K key) {
            this(key, null ,null );
        }
        public Node(){
            this(null,null ,null);
        }

        @Override
        public String toString() {
            return key.toString() + ":" + value.toString();
        }
    }

    private Node dummyHead;
    private int size;

    public LinkedListMap() {
        dummyHead = new Node();
        size = 0 ;
    }

    @Override
    public void add(K k, V v) {
        Node node = getNode(k);
        if(node == null){
            dummyHead.next = new Node(k , v , dummyHead.next);
            size ++;
        }else{
            node.value = v;
        }
    }

    @Override
    public V remove(K k) {
        Node prev = dummyHead;
        while(prev.next != null){
            if(prev.next.key.equals(k)){
                break;
            }
            prev = prev.next;
        }

        if(prev.next != null){
            Node delNode = prev.next;
            prev.next = delNode.next;
            delNode.next = null;
            size --;
            return delNode.value;
        }
        return null;
    }

    @Override
    public boolean contains(K k) {
        return getNode(k) != null;
    }

    @Override
    public V get(K k) {
        Node node = getNode(k);
        return node == null ? null : node.value ;
    }

    @Override
    public void set(K k, V v) {
        Node node = getNode(k);
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

    private Node getNode(K key){
        Node cur = dummyHead.next;
        while (cur != null){
            if(cur.key.equals(key)){
                return cur;
            }
            cur = cur .next;
        }
        return null;
    }

}
