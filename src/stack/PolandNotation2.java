package stack;

import java.util.*;


public class PolandNotation2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 先定义一个逆波兰表达式
		// (30+4)*5-6 => 3 4 + 5 * 6 - => 164
		// 4 * 5 - 8 + 60 + 8 / 2 =>4 5 * 8 - 60 + 8 2 / + => 22 
		// 说明为方便，逆波兰表达式 的数字和符号使用空格隔开
		String suffixExpression = "4 5 * 8 - 60 + 8 2 / +";
		// 思路
		// 1. 将 "3 4 + 5 * 6 -"=>放到ArrayList中
		// 2. 将 ArrayList 传递给一个方法，变量ArrayList 配合栈 完成计算
		List<String> rpnList = getListString(suffixExpression);
		System.out.println(rpnList);
		
		int res = calculate(rpnList);
		System.out.println(res);
	}
	
	// 将一个逆波兰表达式，依次将数据和运算符 放到 ArrayList中
		public static List<String> getListString(String suffixExpression){
			// 将 suffixExpression 分割
			String[] split = suffixExpression.split(" ");
			List<String> list = new ArrayList<String>();
			for(String ele : split){
				list.add(ele);
			}
			return list;
		}
		// 完成对逆波兰表达式的运算
		/*
		 * 1. 从左至右扫描，将3和4压入堆栈；
		 * 2.遇到+运算符，因此弹出4和3（4为栈顶元素，3为次顶元素），计算出3+4的值，得7，在将7入栈；
		 * 3.将5入栈
		 * 4.将下来的×运算符，因此弹出5个7，计算出7×5=35，将35入栈；
		 * 5.将6入栈；
		 * 6.最后是-运算符，计算出35-6的值，即29，由此得出最终的结果
		 */
		
		public static int calculate(List<String> ls){
			// 创建给栈，只需要一个栈即可
			Stack<String> stack = new Stack<String>();
			// 遍历 ls
			for(String item:ls){
				// 这里使用正则表达式来取出数 
				if (item.matches("\\d+")) { // 匹配的是多位数
					// 入栈
					stack.push(item);
				}else{
					// pop出两个数，并运算，在入栈
					int num2 = Integer.parseInt(stack.pop());
					int num1 = Integer.parseInt(stack.pop());
					int res = 0;
					if (item.equals("+")) {
						res = num1 + num2;
					}else if (item.equals("-")) {
						res = num1 - num2;
					}else if (item.equals("*")) {
						res = num1 * num2;
					}else if (item.equals("/")){
						res = num1 / num2;
					}else {
						throw new RuntimeException("运算符有误");
					}
					// 把res入栈
					stack.push(""+ res);
				}
			}
			// 最后留在stack中的数据是运算结果
			return Integer.parseInt(stack.pop());
		}
}
























