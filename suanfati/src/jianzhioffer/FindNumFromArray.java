package jianzhioffer;

/**
 * 面试题3
 * 题目：
 * 在一个二维数组中，每一行都按照从左到右，递增，每一列，从上到下，递增。
 * 完成一个函数，输入一二维数组和一个整数，判断数组中是否有该整数，并返回比较的次数
 * 
 * 方法：从右上角开始比较，每次可以去掉一整行或一整列，
 * 
 * 最多比较    7   次
 * 
 * @author wjb
 *
 */
public class FindNumFromArray {
	public static int[] findNumber(int[][] arr, int n, int m, int num){
		int[] index = new int[2];
		if(arr == null){
			index[0] = 0;
			index[1] = 0;
			return index;
		}
		int count = 0;
		int k = m-1;
		int l = 0;
		for(int i = l; i<n; i++){
			for(int j = k; j>=0; j--){
				count++;
				if(arr[i][j] == num){
					index[0] = 1;
					index[1] = count;
					return index;
				}
				if(arr[i][j] > num){
					k--;
				}
				if(arr[i][j] < num){
					l++;
					break;
				}
			}
		}
		index[0] = 0;
		index[1] = count;
		return index;
	}
	
	
	public static void main(String[] args) {
		int[][] array = {{1,2,8,9},{2,4,9,12},{4,7,10,13},{6,8,11,15}};
//		int[][] array = new int[4][4];
//		int[][] array = null;
		int[] flag = findNumber(array, 4, 4, 0);
		System.out.println("boolean: " + flag[0] + ", count: " + flag[1]);
	}
}
