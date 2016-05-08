package com.wjb.sort;

public class MergeSort {
	/**
	 * 其实是在分治，递归返回上一层，在该层默认左右数组都是排好序的。然后将其排好序后合并返回上一层
	 * @param a
	 * @param p
	 * @param q
	 * @param r
	 */
	public static void merge(int a[], int p, int q, int r){
		int n1 = q-p+1;
		int n2 = r-q;
		int i,j,k;
		int[] L = new int[n1];	//为了将传进来的数组进行分治
		int[] R = new int[n2];	//为了将传进来的数组进行分治
		
		for(i=0,k=p; i<n1; i++,k++){
			L[i]=a[k];			//将传进来的数组二分，左半部分给左数组
		}
		for(j=0,k=q+1; j<n2; j++,k++){
			R[j]=a[k];			//将传进来的数组二分，右半部分给右数组
		}
		
		for(k=p,i=0,j=0; i<n1&&j<n2; k++){
			if(L[i]>R[j]){		//对左右数组进行比较，然后将小的放入到原数组，大的接着作比较
				a[k]=R[j];
				j++;
			}else{				//对左右数组进行比较，然后将小的放入到原数组，大的接着作比较
				a[k]=L[i];
				i++;
			}			
		}
		if(i<n1){
			for(j=i; j<n1; j++,k++){
				a[k] = L[j];	//多的部分依次放入原来的数组
			}
		}
		if(j<n2){
			for(i=j; i<n2; i++,k++){
				a[k] = R[i];
			}
		}
	}
	
	/**
	 * 递归实现归并排序
	 * @param a
	 * @param p
	 * @param r
	 */
	public void mergeSort(int a[], int p, int r){
		if(p<r){
			int q = (p+r)/2;
			mergeSort(a, p, q);
			mergeSort(a, q+1, r);
			merge(a, p, q, r);
		}
	}
	
	public static void main(String[] args) {
		int[] array = {7,3,9,5,8,2,4};
		MergeSort ms = new MergeSort();
		for(int i=0; i<array.length; i++){
			System.out.print(array[i]+" ");
		}
		System.out.println();
		ms.mergeSort(array, 0, array.length-1);
		for(int i=0; i<array.length; i++){
			System.out.print(array[i]+" ");
		}
	}
}
