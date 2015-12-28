package sort;

public class HeapSort {
	public static void main(String[] args) {
		int[] src = { 66, 89, 8, 123, 9, 44, 55, 37, 200, 127, 98 };
		System.out.println("��ʼֵ��");
		print(src);
		HeapSort(src, src.length);
		System.out.println("���ź�");
		print(src);
	}

	/**
	 * �󶥶������㷨
	 */
	private static void HeapSort(int src[], int length) {// �󶥶������㷨
		// ��ʼ����,�����һ���ڵ� i= (length-1) / 2
		for (int i = (length - 1) >> 1; i >= 0; --i)
			HeapAdjust(src, i, length);
		for (int i = length - 1; i > 0; --i) {// �Ӷ�β��ǰ����
			src[i] = src[0] + (src[0] = src[i]) * 0;// �����Ѷ����ֵ����βֵ�
			HeapAdjust(src, 0, i);// ���µ�����
		}
	}

	/**
	 * src[i+1,��. ,j]�Ѿ��ɶѣ����� i ������Ϊ��.
	 * 
	 * @param src�Ǵ������Ķ�����
	 * @param i�Ǵ�����������Ԫ�ص�λ��
	 * @param j�Ǵ���������ĳ���
	 */
	private static void HeapAdjust(int src[], int i, int j) {// ���±�Ϊi�Ľڵ㣬����������Ϊ��
		int temp = src[i];
		int child = 2 * i + 1; // ���ӵ�λ�á�(child+1 Ϊ��ǰ���������Һ��ӵ�λ��)
		while (child < j) {// ��ֹ��һ��lengthΪż��12ʱ��i=5��child=11�Ǹ��ӹ�ϵ
			if (child + 1 < j && src[child] < src[child + 1]) { // ��λ�ϴ�ĵĺ��ӽ��
				++child;
			}
			if (src[i] < src[child]) { // ����ϴ���ӽ����ڸ����
				src[i] = src[child]; // ��ô�ѽϴ���ӽ�������ƶ����滻���ĸ����
				i = child; // ����i���Ա�ʹ������Ϊ�ѣ������ṹ���ܸı䣩
				src[i] = temp; // �����ŵ�������ĺ��ӽ���ϣ�tempֵδ�䣩
				child = 2 * i + 1;// ��child<length�������ѭ������
			} else { // �����ǰ�������������������Һ��ӣ�����Ҫ������ֱ���˳�
				break;// ��ֹ��ѭ��
			}
		}
		print(src);
	}

	private static void print(int a[]) {
		for (int i : a) {
			System.out.print(i + " ");
		}
		System.out.println();
	}
}
