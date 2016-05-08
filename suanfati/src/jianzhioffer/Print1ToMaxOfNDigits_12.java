package jianzhioffer;

/**
 * 20160429
 * 题目（12）：（注意大数问题）
 * 		输入数字n，按顺序打印出从1到最大的n位十进制数。
 * 		比如：输入3，则打印出1、2、3一直打到最大的3位数即999
 * 
 * 利用字符数组操作（char[]）
 * 
 * @author wjb
 *
 */
public class Print1ToMaxOfNDigits_12 {
	public static void test(int n){
		if(n<=0){
			return;
		}
		char[] num = new char[n];
		for(int i = 0; i < n; i++){
			num[i] = '0';
		}
		while(!increate(num)){
			printNum(num);
		}
	}
	
	public static boolean increate(char[] num){
		int len = num.length;
		int sum = 0;
		int over = 0;
		boolean flag = false;	//外循环的结束标志位，当大于最大数时，结束
		for(int i = len-1; i >= 0; i--){
			sum = num[i] - '0' + over;
			if(i == len-1){	//只有每次重新进来，即个位加1的时候才进来
				sum++;
			}
			if(sum >= 10){//有进位
				if(i == 0){
					flag = true;	//此时已经是最大了
				}
				over = sum/10;
				int gewei = sum%10;
				num[i] = (char)(gewei + '0');
			}else{//没有进位
				num[i] = (char)(sum + '0');
				break;//如果没有进位，加1后退出循环
			}
		}
		return flag;
	}
	
	public static void printNum(char[] num){
		String s = "";
		boolean flag = false;
		for(int i = 0; i < num.length; i++){
			if(num[i] != '0' && flag == false){
				s += num[i];
				flag = true;
				continue;
			}
			if(flag){
				s += num[i];
			}
		}
		System.out.println(s);
	}
	
	public static void main(String[] args) {
		test(3);
	}
}
