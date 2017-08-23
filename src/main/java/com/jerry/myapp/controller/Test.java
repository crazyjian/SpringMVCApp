package com.jerry.myapp.controller;

public class Test {
	
	/**
	 * 
	 * @param array
	 * @param m  x参数
	 * @param n  y参数
	 * @return
	 */
	public static void maze(int[][] array,int m, int n) {
		int[][] result = new int[m][n];
		int sum = 0;
	}
	
	

	public static void print(int[][] array, int m, int n) {
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int m = 9;
		int n = 9;
		int[][]	array ={
				{2,3,5,3,35,42,32,65,58},
				{26,3,5,3,35,42,32,65,58},
				{2,3,5,3,35,42,32,65,5},
				{24,3,5,45,35,42,32,65,58},
				{34,3,5,3,35,42,13,65,12},
				{2,3,5,33,35,42,32,65,58},
				{21,35,5,35,37,42,32,65,58},
				{2,3,5,3,35,42,32,65,51},
				{2,3,5,3,35,24,32,65,29}};
		
		for(int i=0;i<m;i++) {
			for(int j=0;j<n;j++) {
				System.out.print(array[i][j]+" ");
			}
			System.out.println();
		}
	}

}
