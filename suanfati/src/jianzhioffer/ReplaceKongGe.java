package jianzhioffer;

/**
 * 没有实现
 * 
 * 将一个字符串中的空格转换成"%20"，
 * 要求：只能在原来的字符数组上改变，不允许实例新的数组
 * 方法1：O(n*n)
 * 方法2：O(n)
 * 方法2思路：(从尾到头)
 * 先遍历一遍找出空格数
 * 实例两个整型变量，oldlength和newlength，分别从旧数组的尾部，和新数组的尾部往前遍历，将旧的字符往新的字符数组中复制，
 * 最终当oldlength==newlength时说明，已经没有空格了
 * @author wjb
 *
 */
public class ReplaceKongGe {
	/**
	 * ch[]中包含字符串还有额外的足够的空间
	 * length为ch的空间大小
	 * @param ch
	 * @param length
	 * @return
	 */
	public static String replace(char[] ch, int length){
		int index = 0;
		int oldlength = 0;
		int newlength = 0;
		while(ch[index] != '\0'){	
			char c = ch[index];
			oldlength++;
			if(ch[index] == ' '){
				newlength++;
			}
			index++;
		}
		newlength = oldlength + newlength*2;
		if(newlength > length){
			return null;		//说明ch的空间不足以扩展
		}
		
		while(oldlength < newlength && oldlength >= 0){
			if(ch[oldlength] == ' '){
				ch[newlength--] = '0';
				ch[newlength--] = '2';
				ch[newlength--] = '%';
			}else{
				ch[newlength--] = ch[oldlength];
			}
		}
		
		return String.valueOf(ch);
	}
	
	public static void main(String[] args) {
		String str = "I am wang";
//		char[] ch = {'I',' ','a','m',' ','w','a','n','g','\0','','','','','',''};
		char[] ch = new char[20];
		System.out.println("ch.length: " + ch.length);
		ch = str.toCharArray();
		System.out.println("ch.length2: " + ch.length);
		int i = 0;
		while(ch[i] != '\0'){
			System.out.println(String.valueOf(ch[i]) + ":");
			i++;
		}
//		System.out.println(replace(ch, ch.length));
	}
}
