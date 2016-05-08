package com.wjb.sort;

public class BubbleSort {
	/**
	 * 小的往上冒
	 * @param a
	 */
//	public static void bubbleSort(int[] a){
//		int i, j;
//		int len = a.length;
//		int temp;
//		for(i=0; i<len-1; ++i){
//			for(j=len-1; j>i; --j){
//				if(a[j]<a[j-1]){
//					temp = a[j];
//					a[j] = a[j-1];
//					a[j-1] = temp;					
//				}
//			}
//			for(int m=0; m<a.length; m++){
//				System.out.print(a[m]+" ");
//			}
//			System.out.println();
//		}
//	}
	/**
	 * 大的往上冒
	 * @param a
	 */
	public static void bubbleSort(int[] a){
		int i, j;
		int len = a.length;
		int temp;
		for(i=len-1; i>=0; --i){
			for(j=1; j<=i; ++j){
				if(a[j]<a[j-1]){
					temp = a[j];
					a[j] = a[j-1];
					a[j-1] = temp;					
				}
			}
			for(int m=0; m<a.length; m++){
				System.out.print(a[m]+" ");
			}
			System.out.println();
		}
	}
	
	public static void main(String[] args) {
		int[] array = {7,3,9,5,8,2,4};
		BubbleSort bs = new BubbleSort();
		for(int i=0; i<array.length; i++){
			System.out.print(array[i]+" ");
		}
		System.out.println();
		bs.bubbleSort(array);
	}	
}
