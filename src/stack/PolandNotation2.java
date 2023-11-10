package stack;

import java.util.*;


public class PolandNotation2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// �ȶ���һ���沨�����ʽ
		// (30+4)*5-6 => 3 4 + 5 * 6 - => 164
		// 4 * 5 - 8 + 60 + 8 / 2 =>4 5 * 8 - 60 + 8 2 / + => 22 
		// ˵��Ϊ���㣬�沨�����ʽ �����ֺͷ���ʹ�ÿո����
		String suffixExpression = "4 5 * 8 - 60 + 8 2 / +";
		// ˼·
		// 1. �� "3 4 + 5 * 6 -"=>�ŵ�ArrayList��
		// 2. �� ArrayList ���ݸ�һ������������ArrayList ���ջ ��ɼ���
		List<String> rpnList = getListString(suffixExpression);
		System.out.println(rpnList);
		
		int res = calculate(rpnList);
		System.out.println(res);
	}
	
	// ��һ���沨�����ʽ�����ν����ݺ������ �ŵ� ArrayList��
		public static List<String> getListString(String suffixExpression){
			// �� suffixExpression �ָ�
			String[] split = suffixExpression.split(" ");
			List<String> list = new ArrayList<String>();
			for(String ele : split){
				list.add(ele);
			}
			return list;
		}
		// ��ɶ��沨�����ʽ������
		/*
		 * 1. ��������ɨ�裬��3��4ѹ���ջ��
		 * 2.����+���������˵���4��3��4Ϊջ��Ԫ�أ�3Ϊ�ζ�Ԫ�أ��������3+4��ֵ����7���ڽ�7��ջ��
		 * 3.��5��ջ
		 * 4.�������ġ����������˵���5��7�������7��5=35����35��ջ��
		 * 5.��6��ջ��
		 * 6.�����-������������35-6��ֵ����29���ɴ˵ó����յĽ��
		 */
		
		public static int calculate(List<String> ls){
			// ������ջ��ֻ��Ҫһ��ջ����
			Stack<String> stack = new Stack<String>();
			// ���� ls
			for(String item:ls){
				// ����ʹ��������ʽ��ȡ���� 
				if (item.matches("\\d+")) { // ƥ����Ƕ�λ��
					// ��ջ
					stack.push(item);
				}else{
					// pop���������������㣬����ջ
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
						throw new RuntimeException("���������");
					}
					// ��res��ջ
					stack.push(""+ res);
				}
			}
			// �������stack�е�������������
			return Integer.parseInt(stack.pop());
		}
}
























