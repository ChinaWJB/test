package com.wjb.sort;

public class InsertSort {
	/**
	 * 插入排序的原理是：当前要插入的数和之前排好序的数比较大小，比当前数大就挨个往后移位，每次移一位
	 * 可以保证稳定性
	 * @param a
	 */
	public void insertSort(int[] a){
		int j;
		int temp;
		for(int i=1; i<a.length; i++){	//因为需要将i前面的值与a[i]进行比较，所以i最小为1；
			temp = a[i];
			j = i;
			while(j>=1 && a[j-1]>temp){	//都在和temp = a[i]进行比较
				a[j] = a[j-1];			//如果前面的数比temp大，就将其向后移动一位，直到比它小或等于，就将其放置在这个位置上
				j--;					//注意：每次不直接进行交换，而是直接覆盖后面的值，最后将temp中的值赋给正确的位置上
			}
			a[j] = temp;
		}
	}
	
	public static void main(String[] args) {
		int[] array = {7,3,9,5,8,2,4};
		InsertSort is = new InsertSort();
		for(int i=0; i<array.length; i++){
			System.out.print(array[i]+" ");
		}
		System.out.println();
		is.insertSort(array);
		for(int i=0; i<array.length; i++){
			System.out.print(array[i]+" ");
		}
	}
}
