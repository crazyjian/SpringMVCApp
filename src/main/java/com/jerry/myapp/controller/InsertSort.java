package com.jerry.myapp.controller;

import java.util.Collections;

public class InsertSort {
	
	/**
	 * ֱ�Ӳ�������
	 * @param array
	 */
	public static void insertSort(int[] array) {
		for(int i=1; i<array.length; i++) {
			int temp = array[i];
			int j = i-1;
			for(;j>=0&&temp<array[j];j--) {
				array[j+1] = array[j];
			}
			array[j+1] = temp;
		}
	}
	
	/**
	 * ϣ������
	 * @param array
	 */
	public static void shellSort(int[] array) {
		int grap = array.length;
		do {
			grap = grap%2==0?grap/2:grap/2+1;
			for(int i=grap;i<array.length;i++) {
				int temp = array[i];
				int j = i-grap;
				for(; j>=0&&temp<array[j]; j-=grap) {
					array[j+grap] = array[j];
				}
				array[j+grap] = temp;
			}
		} while(grap!=1);
	}
	
	/**
	 * ѡ������
	 */
	public static void selectSort(int[] array) {
		for(int i=0;i<array.length;i++) {
			int temp = array[i];
			int position = i;
			for(int j=i+1;j<array.length;j++) {
				if(temp>array[j]) {
					position = j;
					temp = array[j];
				}
			}
			array[position] = array[i];
			array[i] = temp;
		}
	}
	
	/**
	 * ð������
	 * @param args
	 */
	public static void bubbleSort(int[] array) {
		for(int i=0;i<array.length;i++) {
			for(int j=0;j<array.length-i-1;j++) {
				if(array[j]>array[j+1]) {
					int temp = array[j];
					array[j] = array[j+1];
					array[j+1] = temp;
				}
			}
		}
	}
	
	/**
	 * ������
	 */
	public static void heapSort(int[] array) {
		int size = array.length - 1;
		for(int i = (size -1)/2; i>=0; i--) {
			createMaxHeap(array, size, i);
		}
		print(array);
		
		for(int i=size; i>0; i--) {
			swap(array, 0, i);
			createMaxHeap(array, i-1, 0);
			print(array);
		}
	}
	
	/**
	 * ��������Ϊ index ������ݣ�ʹ���϶ѵ�����
	 * @param array  
	 * @param size  δ����Ķѣ����飩�ĳ���
	 * @param position  ��Ҫ�ѻ��������ݵ����� 
	 */
	public static void createMaxHeap(int[] array, int size, int index) {
		int left = index * 2 + 1;
		int right = left + 1;
		int large = left;
		if(left > size) {
			return;
		}
		if(right <= size && array[right] > array[left]) {
			large = right;
		}
		if(array[large] > array[index]) {
			swap(array, index, large);
			createMaxHeap(array, size, large);
		}
	}
	
	/**
	 * ��������Ԫ��
	 * @param array
	 * @param i
	 * @param j
	 */
	public static void swap(int[] array, int i, int j) {
		array[i] = array[i] + array[j];
		array[j] = array[i] - array[j];
		array[i] = array[i] - array[j];
	}
	
	/**
	 * ������
	 * @param array
	 */
	public static void print(int[] array) {
		System.out.print("��ǰ���");
		for(int i : array) {
			System.out.print(i+" ");
		}
		System.out.println();
	}
	
	/**
	 * ��������
	 * @param array
	 */
	public static void quickSort(int[] array) {
		quickSort(array, 0 , array.length-1);
	}
	
	public static void quickSort(int[] array, int min,int max) {
		if(min < max) {
			int middle = getMiddle(array, min , max);
			quickSort(array, min, middle-1);
			quickSort(array,middle+1, max);
		}
	}
	
	public static int getMiddle(int[] array, int min, int max) {
		int temp = array[min];
		while(min<max) {
			while(min<max && temp<=array[max]) {
				max--;
			}
			array[min] = array[max];
			while(min<max && temp>=array[min]) {
				min++;
			}
			array[max] = array[min];
		}
		array[min] = temp;
		return min;
	}
	
	


	public static void main(String args[]) {
		
		int[] array = {23,43,43,54,12,56,55,30,40,4};
		InsertSort.quickSort(array);
		InsertSort.print(array);
	}
}
