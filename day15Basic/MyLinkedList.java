package day15Basic;

public class MyLinkedList<K, V> {

	MyNode<K, V> head;
	MyNode<K, V> tail;

	public void push(K key, V value) {
		MyNode<K, V> newNode = new MyNode(key, value);
		if (head == null) {
			head = newNode;
			tail = newNode;
		} else {
			newNode.next = head;
			head = newNode;
		}
	}

	public void add(K key, V value) {
		MyNode<K, V> newNode = new MyNode(key, value);
		if (head == null) {
			head = newNode;
			tail = newNode;
		} else {
			tail.next = newNode;
			tail = newNode;
		}
	}

	public void show() {
		MyNode<K, V> temp = head;
		while (temp != null) {
			System.out.print(temp.key + " = " + temp.value + " -> ");
			temp = temp.next;
		}
		System.out.println();
	}

	public MyNode<K, V> pop() {
		if (head == null)
			return null;
		MyNode<K, V> popData = head;
		head = head.next;
		return popData;
	}

	public MyNode<K, V> popLast() {
		if (head == null)
			return null;
		MyNode<K, V> popData = tail;
		if (head == tail) {
			head = null;
			return popData;
		}
		MyNode<K, V> temp = head;
		while (temp.next != tail) {
			temp = temp.next;
		}
		temp.next = null;
		tail = temp;
		return popData;
	}

	public MyNode<K, V> search(K searchData) {
		MyNode<K, V> temp = head;
		while (temp != null) {
			if (temp.key.equals(searchData))
				return temp;
			temp = temp.next;
		}
		return null;
	}

	public boolean insertAfter(K searchData, K insertKey, V insertValue) {
		MyNode<K, V> newNode = new MyNode<>(insertKey, insertValue);
		MyNode<K, V> searchedNode = search(searchData);
		if (searchedNode != null) {
			newNode.next = searchedNode.next;
			searchedNode.next = newNode;
			return true;
		}
		return false;
	}

	public void searchAndMakeNull(K searchData) {
		MyNode<K, V> temp = head;
		MyNode<K, V> searchedNode = search(searchData);
		if (searchedNode != null) {
			searchedNode.key = null;
			searchedNode.value = null;
		}
	}

	@Override
	public String toString() {
		return " \n{" + head + "}";
	}

}
