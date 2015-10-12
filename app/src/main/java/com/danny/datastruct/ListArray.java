package com.danny.datastruct;

import java.io.Serializable;
import java.util.AbstractList;

public class ListArray<E> extends AbstractList<E> implements Cloneable, Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 6078578128810543738L;
	private Object[] array;
	private static final int CAPACITY_INCREMENT = 10;
	private int size;
	
	public ListArray() {
		super();
		array = new Object[CAPACITY_INCREMENT];
	}
	
	public ListArray(int capacity) {
		if (capacity < 0)
			throw new IllegalArgumentException();
		array = new Object[capacity];
	}

	@Override
	@SuppressWarnings("unchecked")
	public synchronized E get(int index) {
		if (index >= array.length || index < 0)
			throwIndexOutOfBoundsException(index, array.length);
		return (E) array[index];
	}

	public synchronized int get(E obj) {
		for (int i = 0; i < array.length; i++) {
			Object o = array[i];
			if (obj == o)
				return i;
		}
		return -1;
	}
	
	@Override
	public synchronized int size() {
		return size;
	}

	
	@SuppressWarnings("unchecked")
	@Override
	public synchronized E set(int index, E object) {
		if (index >= array.length || index < 0)
			throwIndexOutOfBoundsException(index, array.length);
		E old = (E) array[index];
		array[index] = object;
		return old;
	}

	@Override
	public synchronized void add(int index, Object object) {
		if (index > array.length || index < 0)
			throwIndexOutOfBoundsException(index, array.length);
		Object old = null;
		if (index < array.length)
			old = array[index];
		if (size < array.length) {
			System.arraycopy(array, index, array, index+1, size-index);
		} else {
			Object[] newArray = new Object[newCapacity(array.length)];
			System.arraycopy(array, 0, newArray, 0, index);
			System.arraycopy(array, index, newArray, index+1, size-index);
			array = newArray;
		}
		array[index] = object;
		if (old == null)
			size++;
	}

	private static int newCapacity(int currentCapacity) {
		return currentCapacity + CAPACITY_INCREMENT;
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public synchronized E remove(int index) {
		if (index >= array.length || index < 0)
			throwIndexOutOfBoundsException(index, array.length);
		E result = (E) array[index];
		if (result != null)
			size--;
		array[index] = null;
//		System.arraycopy(array, index, array, index-1, array.length-index);
		return result;
	}
	
    static IndexOutOfBoundsException throwIndexOutOfBoundsException(int index, int size) {
        throw new IndexOutOfBoundsException("Invalid index " + index + ", bound is 0-" + (size-1));
    }

	@Override
	@SuppressWarnings("unchecked")
	public synchronized ListArray<E> clone() throws CloneNotSupportedException {
		ListArray<E> clone = (ListArray<E>) super.clone();
		clone.array = array.clone();
		return clone;
	}
    
    
}
