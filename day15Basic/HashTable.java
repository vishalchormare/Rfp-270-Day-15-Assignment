package day15Basic;

import java.util.ArrayList;
import java.util.List;

public class HashTable<K,V> {

	 int bucketSize;
	    List<MyLinkedList<K, V>> bucketArray = new ArrayList<>(bucketSize);
	    // array list size increases at run-time, that's why it is called dynamic array

	    public HashTable() {
	    }

	    public HashTable(int bucketSize) {
	        this.bucketSize = bucketSize;
	        for (int i = 0; i < bucketSize; i++) {
	            bucketArray.add(i, null);
	        }
	    }

	    public int getIndex(K key) {
	        int index = Math.abs(key.hashCode()) % bucketSize;
	        return index;
	    }

	    public void addOrUpdate(K key, V value) {
	        int index = getIndex(key);
	        MyLinkedList<K, V> myLinkedList = bucketArray.get(index);
	        if (myLinkedList == null) {
	            myLinkedList = new MyLinkedList<>();
	            bucketArray.add(index, myLinkedList);
	            myLinkedList.add(key, value);
	        } else {
	            MyNode<K, V> currentNode = myLinkedList.search(key);
	            if(currentNode != null)
	                currentNode.value = value;
	            else
	                myLinkedList.add(key, value);
	        }
	    }

	    public V get(K key) {
	        int index = getIndex(key);
	        MyLinkedList<K, V> myLinkedList = bucketArray.get(index);
	        if (myLinkedList == null)
	            return null;
	        MyNode<K, V> currentNode = myLinkedList.search(key);
	        return currentNode != null ? currentNode.value : null;
	    }

	    public void searchAndMakeNull(K searchData,V value){
	        int index = getIndex(searchData);
	        MyLinkedList<K, V> myLinkedList = bucketArray.get(index);
	        myLinkedList.searchAndMakeNull(searchData);
	    }

	    @Override
	    public String toString() {
	        return "HashTable{" +
	                "bucketArray=" + bucketArray +
	                '}';
	    }
}
