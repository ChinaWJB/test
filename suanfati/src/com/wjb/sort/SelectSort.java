package com.wjb.sort;

public class SelectSort {
	/**
	 * 选择排序原理：两个for循环，选择最小的往前换
	 * @param a
	 */
	public void selectSort(int[] a){
		int temp = 0;	//用于记录最小值
		int num = 0;
		for(int i=0; i<a.length; i++){
			temp = a[i];	//用于记录最小值
			num = i;		//用于记录最小值得下标		
			for(int j=i+1; j<a.length; j++){
				if(a[j]<temp){	//注意：每次比较完之后不直接进行交换，而是记录下来当前较小值得值和坐标，最后一并交换
					temp = a[j];
					num = j;
				}
			}
			if(num!=i){
				a[num] = a[i];
				a[i] = temp;
			}
		}
	}
	
	public static void main(String[] args) {
		int[] array = {7,3,9,5,8,2,4};
		SelectSort ss = new SelectSort();
		for(int i=0; i<array.length; i++){
			System.out.print(array[i]+" ");
		}
		System.out.println();
		ss.selectSort(array);
		for(int i=0; i<array.length; i++){
			System.out.print(array[i]+" ");
		}
	}
}
