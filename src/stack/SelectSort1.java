package stack;

import java.util.Arrays;

public class SelectSort1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {101, 34, 119, 1,-1,90,123};
		System.out.println("����ǰ");
		System.out.println(Arrays.toString(arr));
		
		selectSort(arr);

		System.out.println("�����");
		System.out.println(Arrays.toString(arr));
		

	}
	// ѡ������
		public static void selectSort(int[] arr){
			// �����ʱ�临�ӵ�ʱO��n^2��
			for (int i = 0; i < arr.length - 1; i++) {
				int minIndex = i;
				int min = arr[i];
				for (int j = i + 1; j < arr.length; j++) {
					if (min > arr[j]) { // ˵���ٶ�����Сֵ����������С
						min = arr[j]; // ����min
						minIndex = j; // ����minIndex
					}
				}
				
				// ����Сֵ������arr[0],������
				if (minIndex != i) {
					arr[minIndex] = arr[i];
					arr[i] = min;
				}
				
				// System.out.println("��"+(i+1)+"һ�ֺ�~");
				// System.out.println(Arrays.toString(arr));
				
			}
		}
}
