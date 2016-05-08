package mianshibaodian;

import java.util.ArrayList;

public class SuShu100 {
	public ArrayList<Integer> primeNumber(int n){
		ArrayList<Integer> al = new ArrayList<Integer>();
		for(int i = 2; i<=n; i++){	//最小的素数为2
			double sqrti;
			boolean flag = true;	//标志位，用于判断第二个for循环跳出时，是素数跳出的还是不是素数跳出的
			sqrti = Math.sqrt(i);	//只需要判断到2到该数的根号值之前，就可以判断是不是素数了
			for(int j = 2; j<sqrti; j++){
				if(i%j == 0){
					flag = false;
					break;
				}
			}
			if(flag){				//标志位，是素数时将它添加到ArrayList中
				al.add(i);
			}
		}		
		return al;
	}
	
	public static void main(String[] args) {
		ArrayList<Integer> al = new ArrayList<Integer>();
		SuShu100 ss = new SuShu100();
		al = ss.primeNumber(100);
		System.out.println(al);
	}
}
