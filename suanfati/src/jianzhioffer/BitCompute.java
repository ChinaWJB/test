package jianzhioffer;

/**
 * 题目：
 * 		实现一个函数，输入一个整数，输出该二进制表示中的1的个数。
 * 
 * >>有符号的右移，即最左边用符号位补齐，因为计算机中计算的时候都是以补码的形式计算的
 * >>>无符号位右移，即最左边用0补齐
 * <<带符号的左移，相当于乘以2
 * @author wjb
 *
 */
public class BitCompute {
	/**
	 * 方法1
	 * 会改变传进来的值
	 * 用>>>取代>>，因为如果为负数的话>>会出现死循环
	 * @param n
	 * @return
	 */
	public static int test1(int n){
		int count = 0;
		while(n!=0){
			if((n & 1) != 0){
				count++;
			}
			n = n>>>1;
		}
		return count;
	}
	
	/**
	 * 方法2
	 * 只改变用于比较的标志位
	 * 考虑正负值
	 * @param n
	 * @return
	 */
	public static int test2(int n){
		int count = 0;
		int flag = 1;
		while(flag != 0){
			if((n & flag) != 0){
				count++;				
			}
			flag = flag << 1;
		}
		return count;
	}
	
	/**
	 * 方法3，
	 * 减1，再与操作
	 * 有多少个1,就可以进行多少次这样的操作
	 * 思路：
	 * 		如果该整数的二进制表示中最右边1位于第m位，那么减去1时，第m位由1变为0，而第m位之后的所有0都变成1，整数中第m位之前的所有位都保持不变。
	 * 		再与原来的数进行与操作，相当于把最右边的一个1变成0.所以有多少个1，就可以进行多少次这样的操作
	 * @param n
	 * @return
	 */
	public static int test3(int n){
		int count = 0;
		while(n != 0){
			++ count;
			n = (n-1) & n;
		}
		return count;
	}
	
	public static void main(String[] args) {
		System.out.println(test3(0));
		//负数边界
		System.out.println(test3(0x80000000));
		System.out.println(test3(0xFFFFFFFF));
		//正数边界
		System.out.println(test3(1));
		System.out.println(test3(0x7FFFFFFF));
	}
}
