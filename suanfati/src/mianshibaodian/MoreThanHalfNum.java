package mianshibaodian;

/**
 * 找出数组中出现次数超过1半的数字
 * @author wjb
 *
 */
public class MoreThanHalfNum {
	
	/**
	 * 利用快排中的partition，返回每次排好序的下标索引，
	 * 然后将索引和数组的大小的一半进行比较，如果小于一半，则取后面一段，如果大于一半，则取前面一段
	 * 注意判断：1.是否传进来的是空值；2.中间的数是否真的出现次数超过了一半
	 * @param num
	 * @return
	 */
	public int test(int[] num){
		if(checkInvalidArray(num)){
			return 0;
		}
		int index = 0;
//		int middle = num.length/2;
		int middle = num.length >> 2;
		int head = 0;
		int tail = num.length-1;
		index = partition(num, head, tail);
		while(index != middle){
			if(index > middle){
				tail = index-1;
				index = partition(num, head, tail);
			}else{
				head = index+1;
				index = partition(num, head, tail);
			}
		}
		
		int value = num[index];
		if(!checkMoreThanHalf(num, value)){
			return 0;
		}
				
		return value;
	}
	
	public int partition(int[] num, int begin, int end){
		int temp = num[begin];
		while(begin < end){
			while(begin<end && temp<num[end]){
				end--;
			}
			swap(num, begin, end);
			while(begin<end && temp>=num[begin]){
				begin++;
			}
			swap(num, begin, end);			
		}		
		return begin;
	}
	
	public void swap(int[] num, int head, int tail){
		int temp = num[head];
		num[head] = num[tail];
		num[tail] = temp;
	}
	
	/**
	 * 检查传入的数组是否为空
	 * @param num
	 * @return
	 */
	public boolean checkInvalidArray(int num[]){
		boolean inputInvalid = false;
		if(num == null){
			inputInvalid = true;
		}
		return inputInvalid;
	}
	
	/**
	 * 判断中间的值是否真的出现次数超过了一半
	 * @param num
	 * @param value
	 * @return
	 */
	public boolean checkMoreThanHalf(int[] num, int value){
		int count = 0;
		for(int i=0; i<num.length; i++){
			if(value == num[i]){
				count++;
			}
		}
		boolean isMoreThanHalf = true;
		if(count*2 <= num.length){
			isMoreThanHalf = false;
		}
		return isMoreThanHalf;
	}
	
	public static void main(String[] args) {
		MoreThanHalfNum m = new MoreThanHalfNum();
		int[] num = {7,4,2,2,2,2,2,2,5,9};
		int value = m.test(num);
		System.out.println(value);
		
	}
}
