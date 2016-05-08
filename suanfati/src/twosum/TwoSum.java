package twosum;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {
	
	public static void main(String[] args) {
		TwoSum ts = new TwoSum();
		int[] arrynums = new int[]{2,4,5,7,9,12,11,24,10,16};
		int[] temp;
		int target = 16;
		
		temp = ts.twoNums(arrynums, target);
		System.out.println("index : " + temp[0] + " and " + temp[1]);
	}
	
	public int[] twoNums(int[] nums, int target){
		int[] indexarray = null;
		Map<Integer, Integer> valuesIndex = new HashMap<>();
		for(int i = 0; i < nums.length; i++){
			Integer index = valuesIndex.get(target - nums[i]);
			if(index == null){
				valuesIndex.put(nums[i], i);
			}else{
				indexarray = new int[] {index, i};
				break;
			}
		}
		return indexarray;
	}

}
