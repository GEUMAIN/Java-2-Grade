package poly.sort;

import java.util.Scanner;

public class SortTest {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		Sort[] sort = {new BubbleSort(),new HeapSort(), new QuickSort()};
		
		int[] nums = new int[5];
		
		System.out.println("정렬 방식을 선택하세요.");
		System.out.println("[1] : BubbleSort");
		System.out.println("[2] : HeapSort");
		System.out.println("[3] : QuickSort");
		
		int choice = sc.nextInt();
		
		seletedSort(nums,choice,sort);
	}
	
	private static void seletedSort(int[] nums, int choice, Sort[] sort) {
		
			sort[choice-1].ascending(nums);
			sort[choice-1].descending(nums);
			sort[choice-1].description();
	}
}
