package niuke;

/**
 * 原理是Fibonacci的算法题
 * 题目：
 * 		一只青蛙一次可以跳1级台阶，也可以一次跳2级台阶，
 * 请问：
 * 		n级台阶，总共有多少中跳法
 * 解析：
 * 		第一次跳一级，则剩下的有f(n-1)种情况
 * 		第一次跳二级，则剩下的有f(n-2)种情况
 * 		总共f(n)=f(n-1)+f(n-2)种情况
 * 		n=1， 1种
 * 		n=2， 2种
 * 		n=3， 3种
 * 		n=4， 5种
 * 
 * @author wjb
 *
 */
public class Fibonacci {
	/**
	 * 方法1
	 * 递归
	 * 效率低，大量的重复计算
	 * @param n
	 * @return
	 */
	public static int test1(int n){
		if(n == 0){
			return 0;
		}
		if(n == 1){
			return 1;
		}
		return test1(n-1) + test1(n-2);
	}
	
	/**
	 * 方法2
	 * 时间复杂度为O(n)
	 * 
	 * @param n
	 * @return
	 */
	public static long test2(long n){
		long[] result = {0,1};
		if(n < 2){
			return result[(int) n];
		}
		long n1 = 0;
		long n2 = 1;
		long sum = 0;
		for(int i = 2; i<=n; i++){
			sum = n2 + n1;
			n1 = n2;
			n2 = sum;
		}
		return sum;			
	}
	
	public static void main(String[] args) {
//		System.out.println(test1(50));	//太大了，递归的层数太深了时间太慢
		System.out.println(test2(50));
	}
}
