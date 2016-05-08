package com.wjb.sort;

public class QuickSort {
	/**
	 * 方法一分治递归都写在一个方法中
	 * 快排是根据元素的值来分组，大于某个值的元素放在一组，而小于的放在另一组，该值称为基准
	 * 而归并排序的分组策略是假设待排序的元素存放在数组中，那么其把数组前面一半元素作为一组，后面一半作为另一组。
	 * 快排和归并排序，如果分组策略越简单，则后面的合并策略就越复杂
	 * @param a
	 * @param low
	 * @param high
	 */
	public void quicksort(int a[], int low, int high){
		int i = low;
		int j = high;
		if(i >= j){		//一定要有这个判断终止，否则递归无法停止，直至内存溢出
			return;
		}
		int temp = a[i];
		while(i<j){
			while(i<j && a[j]>=temp){//从前往后比较
				j--;
			}
			if(i<j){
				a[i++]=a[j];		//将比temp小的值，赋给，a[i],饭后i=i-1
			}
			
			while(i<j && a[i]<temp){//从后往前比较
				i++;
			}
			if(i<j){
				a[j--]=a[i];		//将比temp大的值，赋给，a[j],然后j=j+1
			}
		}
		a[i]=temp;
		quicksort(a, low, i-1);
		quicksort(a, i+1, high);	
	}
	
	public void sort(int[] a){
		quicksort(a, 0, a.length-1);
	}
	
	/**
	 * 方法2
	 * 每一趟快排之后，begin=end，此时的a[begin]=a[end]=midvalue
	 * 将第一个数作为基准，并存到暂存变量中，用于比较，但是真正交换的是通过数组交换的真正的值。
	 * @param a
	 * @param begin
	 * @param end
	 * @return
	 */	
	public int partition(int[] a, int begin, int end){
		int midvalue = a[begin];
		while(begin < end){
			while(begin < end && a[end]>=midvalue){
				end--;
			}
			swap(a, begin, end);
			while(begin < end && a[begin]<midvalue){
				begin++;
			}
			swap(a, begin, end);
		}
		return begin;	//此时的a[begin]=a[end]=midvalue，返回的数组下标为排好序的
	}
		
	public void swap(int[] a, int begin, int end){
		int temp = a[end];
		a[end] = a[begin];
		a[begin] = temp;
	}
	
	/**
	 * 进入排序之后，先求得通过partition，排好一个序，即将最开头的那个元素排好序，返回排序后的坐标值
	 * 再进入递归，将拆分的两个分别进行排序
	 * @param a
	 * @param begin
	 * @param end
	 */
	public void qSort(int[] a, int begin, int end){
		int middle;
		if(begin < end){		//一定要有这个判断终止，否则递归无法停止，将内存溢出
			middle = partition(a, begin, end);
			qSort(a, begin, middle-1);
			qSort(a, middle+1, end);
		}
	}
	
	public void sort2(int[] a){
		qSort(a, 0, a.length-1);
	}
	
	public static void main(String[] args) {
//		int[] array = {7,3,9,5,8,2,4};
		int[] array = {1,4,2,2,2,2,2,8,5};
		QuickSort qs = new QuickSort();
		for(int i=0; i<array.length; i++){
			System.out.print(array[i]+" ");
		}
		System.out.println();
		qs.sort2(array);
		for(int i=0; i<array.length; i++){
			System.out.print(array[i]+" ");
		}
	}
	
}	
