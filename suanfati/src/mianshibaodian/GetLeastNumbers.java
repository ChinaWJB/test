package mianshibaodian;

import java.util.ArrayList;

import com.wjb.heap.Heap;

public class GetLeastNumbers {
	/**
	 * 在一个整型数组中，找出最小的前k个整数
	 * 方法1，log(n)，因为不需要排序，只需要partition
	 * 缺点：会修改输入数组中的元素位置
	 * 利用快排的partition（包含排序），找出index，将该index和k进行比较，如果相等，则返回前k个数
	 * 如果小于k则查找index+1到end
	 * 如果大于k则查找begin到index-1
	 * 最终一定能找到index == k，并利用此作为跳出循环的条件
	 * @param num
	 * @param k
	 */
	public void test1(int[] num, int k){
		if(k<=0 || k>num.length){	//输入的k不符合要求
			return ;
		}
		int[] kvalue = new int[k];
		int index = 0;
		int start = 0;
		int end = num.length-1;
		index = partition(num, 0, num.length-1);
		while(index != k-1){
			if(index < k-1){
				start = index+1;
				index = partition(num, start, end);
			}else{
				end = index-1;
				index = partition(num, start, end);
			}
		}
	}
	
	/**
	 * partition每次只能将一个元素放到正确的位置，并返回这个位置
	 * 每次进入patition将第一个元素作为要确定位置的元素
	 * @param num
	 * @param begin
	 * @param end
	 * @return
	 */
	public int partition(int[] num, int begin, int end){
		int temp = num[begin];
		while(begin < end){
			while(begin < end && num[end] > temp){
				end--;
			}
			swap(num, begin, end);
			while(begin < end && num[begin] <= temp){//注意：必须有一个等号，否则出现相等的话会死循环
				begin++;
			}
			swap(num, begin, end);
		}
		return begin;	
	}
	
	public void swap(int[] num, int m, int n){
		int temp = num[m];
		num[m] = num[n];
		num[n] = temp;
	}
	
	
	
	/**
	 * 方法2，O(nlgk),因为要遍历n次，并且每次维护大顶堆，都为logk
	 * 
	 * 适合海量数据
	 * 
	 * 利用大顶堆来实现
	 * 首先新建一个容量为k的容器，
	 * 然后每次从传入的数组读取一个数，并将它和容器中的数比较，若小于最大的，则替换，若大于最大的，则放弃，
	 * 每次替换后需要维护该容器的大顶堆性质
	 * 
	 * 并没有改变num中的值，而且只是利用了一个大小为k的数组，不停的替换数组的第一个元素，即大顶堆的堆顶，在维护大顶堆
	 * 
	 */
	public int[] test2(int[] num, int k){
		int[] value = new int[k];
		int i = 0;
		for(i = 0; i<k; i++){
			value[i] = num[i];
		}
		Build_Max_Heap(value, k);
		
		for(int j = i; j<num.length-1; j++){
			if(value[0]>num[j]){
				value[0] = num[j];
				Max_Heap(value, k, 0);
			}else{
				
			}
		}				
		return value;
	}
	
	/**
	 * 自下而上
	 * 递归法维，护某个结点的大顶堆
	 * 传入一个数组的下标，也是二叉树的一个结点下标，维护这个结点以下的所有结点
	 * @param index
	 */
	public void Max_Heap(int heapArray[], int k,  int index){
		int l = left(index);
		int r = right(index);
		int largest = 0;	//用于将最大值的下标保存下来
		
		//查找传进来的节点和它的左右孩子节点的最大值的数组索引，并将该最大值的数组索引和传进来的数组元素值进行交换
		if(l<k && heapArray[l]>heapArray[index]){
			largest = l;
		}else{
			largest = index;
		}		
		if(r<k && heapArray[r]>heapArray[largest]){
			largest = r;
		}
		
		//结束递归条件
		//如果已经是大顶堆就返回，因为是自下而上的，所以若改点满足大顶堆，下面的子结点必定满足大顶堆性质，无需向下再判断
		//当判断到叶子结点时，满足largest > heapsize所以会return
		if(largest == index || largest > heapArray.length){
			return;
		}
		
		//不一定执行
		//如果不是父节点，则交换最大值和传进来的数组元素，并再次递归，维护子结点作为父节点的下一级子树
		int temp = heapArray[largest];
		heapArray[largest] = heapArray[index];
		heapArray[index] = temp;
		//如果largest不是父节点，则再次递归，维护
		Max_Heap(heapArray, k, largest);
	}
	public int left(int i){
		return 2*(i+1)-1;
	}
	public int right(int i){
		return 2*(i+1);
	}
	
	/**
	 * 建大顶堆
	 * 
	 * ！！！切记：
	 * ！！！自下向上，从非叶子结点开始
	 * ！！！原因：每次维护好下面的大顶堆，上面的再维护时不会破坏下面的大顶堆结构
	 * @param h
	 */
	public void Build_Max_Heap(int[] a, int k){
		for(int i = k/2-1; i>=0; i--){
			Max_Heap(a, k, i);
		}
	}
	
	
	public static void main(String[] args) {
		GetLeastNumbers gln = new GetLeastNumbers();
		int[] num = {4,6,9,3,5,7,1,2,8};
		int k = 0;
		
		gln.test1(num, k);	//因为快排直接在输入数组上操作，所以直接取输入数组的前k个就可以了
		for(int i = 0; i<k; i++){
			System.out.print(num[i] + " ");
		}
		
//		int[] temp = new int[k];
//		temp = gln.test2(num, k);
//		
//		for(int i = 0; i<k; i++){
//			System.out.print(temp[i] + " ");
//		}
	}
}
