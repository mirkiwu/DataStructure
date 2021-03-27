package com.hxh.array;

/**
 * @author huangxunhui
 * Date: Created in 18/10/4 下午1:09
 * Utils: Intellij Idea
 * Description: 动态数组（类似于ArrayList）
 */
public class Array<E> {

    private E[] data;

    private int size;


    public Array (int capacity){
        data = (E[]) new Object[capacity];
        size = 0;
    }

    public Array (){
        this(10);
    }

    public int getSize(){
        return size;
    }

    public int getCapacity(){
        return data.length;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public void addLast(E e){
        add(size , e );
    }

    public void addFirst(E e){
        add(0 , e);
    }

    public void add(int index , E e){

        if(index < 0 || index > size){
            throw new IllegalArgumentException("AddLast failed . Require index > 0 and index <= index .");
        }

        if(size == data.length){
            resize(2 * data.length);
        }

        for (int i = size - 1; i >= index ; i--) {
             data[i+1] = data[i];
        }
        data[index] = e;
        size++;
    }

    private void resize(int newCapacity) {
        E[] newData = (E[]) new Object[newCapacity];
        for (int i = 0; i < size ; i++) {
            newData[i] = data[i];
        }
        data = newData;
    }

    /**
     * 根据索引获取数据
     * @param index 索引
     * @return E
     */
    public E get (int index){
        if(index < 0 || index > size){
            throw new IllegalArgumentException("Get failed , Index is illegal");
        }
        return data[index];
    }

    public E getLast(){
        return get(size - 1 );
    }

    public E getFirst(){
        return get(0);
    }

    void set(int index , E e){
        if(index < 0 || index > size){
            throw new IllegalArgumentException("Get failed , Index is illegal");
        }
        data[index] = e;
    }

    /**
     * 查找数组中是否有元素e
     * @param e 参数
     * @return 返回true 或者 false
     */
    public boolean contains(E e) {
        for (int i = 0; i < size ; i++) {
            if(data[i] .equals (e)){
                return true;
            }
        }
        return false;
    }

    public int find(E e){
        for (int i = 0; i < size ; i++) {
            if(data[i] .equals (e)){
                return i;
            }
        }
        return -1;
    }

    /**
     * 删除指定位置的元素
     * @param index 参数
     */
    public E remove(int index){
        if(index < 0 || index > size){
            throw new IllegalArgumentException("Remove failed , Index is illegal");
        }

        E ret = data[index];

        for (int i = index + 1; i < size ; i++) {
            data[i-1] = data[i];
        }
        size--;
        data[size] = null;
        // lazy缩容
        if(size == data.length / 4 && data.length / 2 != 0){
            resize(data.length / 2);
        }

        return ret;
    }

    public E removeFirst(){
        return remove(0);
    }

    public E removeLast(){
        return remove(size-1);
    }

    public void removeElement(E e){
        int index = find(e);
        if(index != -1){
            remove(index);
        }
    }

    @Override
    public String toString(){
        StringBuilder res = new StringBuilder();
        res.append(String.format("Array: size = %d , capacity = %d",size , data.length));
        res.append("\n");
        res.append("[");
        for (int i = 0; i < size; i++) {
            res.append(data[i]);
            if(i != size - 1 ){
                res.append(", ");
            }
        }
        res.append("]");
        return res.toString();
    }

}
