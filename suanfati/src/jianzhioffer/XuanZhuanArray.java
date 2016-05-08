package jianzhioffer;

/**
 * 
 * 旋转数组的最小数字
 * 
 * 题目：
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。输入一个递增排序的数组的一个旋转，输出旋转数组的最小元素。
 * 例如：
 * 		{3,4,5,1,2}是{1,2,3,4,5}的一个旋转。
 * 
 * 思路：
 * 	二分法查找，属于二分法的变体，需要两个指针（两个索引变量），前一个一直处于前半部分，后一个一直处于后半部分
 * 	直到，前一个索引+1等于后一个索引，则结束，最小值为后一个索引指的数组值
 * 注意：
 * 	！！！相等值的情况！！！
 *  ！！！null情况！！！
 *  ！！！只包含一个数字的数组！！！
 *  ！！！不是旋转，而是升序的数组！！！
 * @author wjb
 *
 */
public class XuanZhuanArray {
	public static int findMinNum(int[] arr) throws Exception{
		if(arr == null){
			throw new Exception("Invalid parameters");
		}
		
		int start = 0;
		int end = arr.length-1;
		int mid = end/2;
		int value = arr[start];
		
		while(arr[start] >= arr[end]){			
			if((end-start)==1){
				value = arr[end];
				break;
			}			
			//如果出现三个值都相等，只能通过循环查找
			if(arr[mid] == arr[start] && arr[mid] == arr[end]){
				value = test(arr, start, end);
				return value;
			}
			
			if(arr[mid] >= arr[start]){	//3,4,5,1,2或2,2,2,0,1
				start = mid;
			}else if(arr[mid] <= arr[end]){	//4,5,1,2,3或2,0,1,1,1
				end = mid;
			}
			mid = (start+end)/2;
		}		
		return value;
	}
	
	/**
	 * 如果出现三个索引对应的数组的值都相等，那么就只能通过循环遍历查找了
	 * @param arr
	 * @param start
	 * @param end
	 * @return
	 */
	public static int test(int[] arr, int start, int end){
		int value = arr[start];
		for(int i = start+1; i<end; ++i){
			if(value > arr[i]){
				value = arr[i];
			}
		}		
		return value;
	}
	
	public static void main(String[] args) throws Exception {
//		int[] arr = {3,4,5,1,2};
//		int[] arr = {1,2,3,4,5}; 
		int[] arr = {1};
//		int[] arr = {2,0,2,2,2};
//		int[] arr = {2,2,2,0,2};
		
		System.out.println(findMinNum(arr));
	}
}
