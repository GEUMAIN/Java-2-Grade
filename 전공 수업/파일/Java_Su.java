package javaStudy;

import java.util.Scanner;
import java.util.Stack;

public class Java_Su {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in); //Scanner 불러오기
		int N = sc.nextInt(); //수열의 갯수
		int[] A = new int[N]; //배열 만들기
		boolean result = true;
		int num = 1; // 스택에 들어가야하는 수
		StringBuffer bf = new StringBuffer(); //StringBuffer 불러오기
		Stack<Integer> stack = new Stack<>(); //Stack 불러오기
		
		for(int i = 0; i< N; i++) { //수열의 처음부터 탐색해서 N번 반복
			A[i] = sc.nextInt(); //배열 i번지에 값 넣기
		}
		
		for(int i = 0; i<N; i++) { //수열의 처음부터 탐색해서 N번 반복
			int su = A[i]; //배열의 i번째 값을 su라는 변수에 저장
			if(su >= num) { //만약 su 즉 수열값이 num보다 크거나 같다면
				while(su >= num) { //while 즉 수열이 num보다 크거나 같을때까지 무한 반복
					stack.push(num++); //stack에 있는 push함수를 불러와서 불러올때마다 num이 하나씩 증가하게
					bf.append("+ \n"); //bf라는 곳에 "+" 저장
				}
				stack.pop(); //만약 while을 빠져나온다면(num이 su보다 크다면) stack의 pop함수를 불러와 맨위의 값을 삭제하기)
				bf.append("- \n"); //이후 bf라는 곳에 "-" 저장
				
			}else if (su < num) { //만약 위에 조건 수열의 값이 num보다 같거나 크지 않다면
				int n = stack.pop(); //n에 stack의 pop 결과를 저장해주고
				if(n != su) { // pop의 결과가 수열의 값과 같지 않다면
					System.out.println("NO"); //NO를 출력하고
					result = false; //boolean 변수를 false로 해주고
					break; //끝낸다
				}
				else {
					bf.append("- \n"); //만약 pop의 결과가 수열의 값과 같다면 bf에 "-" 저장
				}
			}
		}
		
		if (result) System.out.println(bf.toString()); //반복문이 끝나고 만약 result값이 true라면 저장한 bf값 출력
	}
}
