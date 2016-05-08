package com.wjb.heap;

public class Heap {
	int[] heapArray;
	int heapsize;
	public Heap(int[] array){
		this.heapArray = array;
		this.heapsize = array.length;	//初始化的时候相等，当在排序的时候，会将堆顶最大的元素放到最后面，这事heapsize会-1
	}
	/**
	 * 递归法维，护某个结点的大顶堆
	 * 传入一个数组的下标，也是二叉树的一个结点下标，维护这个结点以下的所有结点
	 * @param index
	 */
	public void Max_Heap(int index){
		int l = left(index);
		int r = right(index);
		int largest = 0;	//用于将最大值的下标保存下来
		//查找传进来的节点和它的左右孩子节点的最大值的数组索引，并将该最大值的数组索引和传进来的数组元素值进行交换
		if(l<heapsize && heapArray[l]>heapArray[index]){
			largest = l;
		}else{
			largest = index;
		}
		if(r<heapsize && heapArray[r]>heapArray[largest]){
			largest = r;
		}
		//结束递归条件
		//如果已经是大顶堆就返回，因为是自下而上的，所以若改点满足大顶堆，下面的子结点必定满足大顶堆性质，无需向下再判断
		//当判断到叶子结点时，满足largest > heapsize所以会return
		if(largest == index || largest > heapsize){
			return;
		}
		//交换最大值和传进来的数组元素
		int temp = heapArray[largest];
		heapArray[largest] = heapArray[index];
		heapArray[index] = temp;
		
		Max_Heap(largest);
	}
	
	public int left(int i){
		return 2*(i+1)-1;
	}
	public int right(int i){
		return 2*(i+1);
	}	
	public int parents(int i){
		return (i-1)/2;
	}
	
	/**
	 * 建大顶堆
	 * 自下向上，从非叶子结点开始
	 * 原因：每次维护好下面的大顶堆，上面的再维护时不会破坏下面的大顶堆结构
	 * @param h
	 */
	public void Build_Max_Heap(Heap h){
		for(int i = h.heapsize/2-1; i>=0; i--){
			Max_Heap(i);
		}
	}
	
	/**
	 * 堆排序
	 */
	public void heapsort(){
		for(int i = 0; i<heapArray.length; i++){
			//执行n次，将每个当前最大的值放到堆末尾，并维护大顶堆
			int temp = heapArray[0];
			heapArray[0] = heapArray[heapsize-1];
			heapArray[heapsize-1] = temp;
			heapsize--;
			Max_Heap(0);
		}
	}
	
	
	/**
	 * 打印堆结构
	 * 每一层的第一个元素的下标，都是上一层元素下标的2*i-1
	 * @param array
	 */
	private static void printHeapTree(int[] array){
	    for(int i=1; i<array.length; i=i*2){
	        for(int k=i-1; k<2*i-1 && k<array.length; k++){
	            System.out.print(array[k]+" ");
	        }
	        System.out.println();
	    }    
	}
	
	/**
	 * 打印当前堆数组
	 * @param array
	 */
	private static void printheap(int[] array){
		for(int i=0;i<array.length;i++){
	        System.out.print(array[i]+" ");
	    }
		System.out.println();
	}
	
	/**
	 * 测试
	 * @param args
	 */
	public static void main(String[] args){
	    int[] array=new int[]{1,2,3,4,7,8,9,10,14,16};
	    Heap heap=new Heap(array);
	    
	    System.out.println("执行最大堆化前堆的结构：");
	    printHeapTree(heap.heapArray);
	    printheap(heap.heapArray);
	    
	    heap.Build_Max_Heap(heap);
	    System.out.println("执行最大堆化后堆的结构：");
	    printHeapTree(heap.heapArray);
	    printheap(heap.heapArray);
	    
	    heap.heapsort();
	    System.out.println("执行堆排序后数组的内容");
	    printheap(heap.heapArray);	    
	}
}
