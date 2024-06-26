package javaStudy;

import java.io.*;
import java.util.*;

public class BaseBall {
	public static int playGame() throws IOException {
		int x,y,z;
		Random r = new Random();
		
		x = Math.abs(r.nextInt() % 9) + 1;
		
		do {
			y = Math.abs(r.nextInt() % 9) + 1;
		}while(x==y);
		
		do {
			z = Math.abs(r.nextInt() % 9) + 1;
		}while((z==x) || (z==y));
		
		return playGame(x,y,z);
	}
	
	public static int playGame(int x, int y, int z) throws IOException{
		int count; //얼마나 했는지
		int strike, ball; //스트라이크와 볼 수
		
		int[] usr = new int[3]; //유저가 입력할 숫자를 넣을 배열
		int[] com = {x,y,z}; //컴퓨터의 변수에는 받아온 난수들을 넣는다.
		
		System.out.println("숫자 야구 게임");
		
		count = 0; //0으로 초기화해준다
		
		do {
			count++; //일단 횟수가 한 번 늘고 시작
			
			do {
				System.out.println("\n카운트: "+count); //몇번째 카운트인지
				
				BufferedReader in = new BufferedReader(new InputStreamReader(System.in)); //콘솔창에 입력하는 내용을 내부 메모리에 저장하는 내부함수
				
				String user; //in을 받아들일려면 String 형으로 선언해야 한다.
				
				System.out.print("1번째 숫자 : ");
				user = in.readLine(); //readLine()이라는 메소드를 이용해서 in에 들어있는 값을 user 변수에 저장한다.
				
				usr[0] = new Integer(user).intValue(); //Integer 형태로 형변환해서 0번째 자리에 넣었다
				
				System.out.print("2번째 숫자 : ");
				user = in.readLine();
				
				usr[1] = new Integer(user).intValue();
				
				System.out.print("3번째 숫자 : ");
				user = in.readLine();
				
				usr[2] = new Integer(user).intValue();
				
				if(usr[0]==0||usr[1]==0||usr[2]==0) { //만약 0번지 자리 또는 1번지 자리 또는 2번지 자리가 0이라면
					System.out.println("0은 입력하지 마세요. 다시 입력해주세요.");
				}else if(usr[0]>9||usr[1]>9||usr[2]>9) { //만약 0번지 자리 또는 1번지 자리 또는 2번지 자리가 9보다 크다면
					System.out.println("1부터 9까지의 숫자 중 하나를 입력해주세요. 다시 입력해주세요.");
				}else if(usr[0]==usr[1]||usr[1]==usr[2]||usr[0]==usr[2]) { //만약 0번지 자리와 1번지 자리가 또는 1번지 자리와 2번지 자리가 또는 0번지 자리가 2번지 자리와 같다면
					System.out.println("모두 다른 숫자를 입력해주세요. 다시 입력해주세요.");
				}
			}while((usr[0]==0||usr[1]==0||usr[2]==0)||
					(usr[0]>9||usr[1]>9||usr[2]>9)||
					(usr[0]==usr[1]||usr[1]==usr[2]||usr[0]==usr[2]));
			
			//모든 숫자가 1~9사이, 같은 숫자가 없는 경우에만 반복문을 빠져나오게 하기
			
			strike = ball = 0;
			//스트라이크와 볼을 0으로 초기화
			
			if(usr[0]==com[0]) strike++; //만약 유저의 0번지 자리값이 컴의 0번지 자리값이 같다면 스트라이크 추가
			if(usr[1]==com[1]) strike++; //만약 유저의 1번지 자리값이 컴의 1번지 자리값이 같다면 스트라이크 추가
			if(usr[2]==com[2]) strike++; //만약 유저의 2번지 자리값이 컴의 2번지 자리값이 같다면 스트라이크 추가
			
			if(usr[0]==com[1]) ball++;   //만약 유저의 0번지 자리값이 컴의 1번지 자리값이 같다면 볼 추가
			if(usr[0]==com[2]) ball++;	 //만약 유저의 0번지 자리값이 컴의 2번지 자리값이 같다면 볼 추가
			if(usr[1]==com[0]) ball++;	 //만약 유저의 1번지 자리값이 컴의 0번지 자리값이 같다면 볼 추가
			if(usr[1]==com[2]) ball++;	 //만약 유저의 1번지 자리값이 컴의 2번지 자리값이 같다면 볼 추가
			if(usr[2]==com[0]) ball++;	 //만약 유저의 2번지 자리값이 컴의 0번지 자리값이 같다면 볼 추가
			if(usr[2]==com[1]) ball++;	 //만약 유저의 2번지 자리값이 컴의 1번지 자리값이 같다면 볼 추가
			
			System.out.println("Strike: "+ strike +" Ball: "+ ball); //스트라이크 값과 볼 값을 출력하기
			
			
		}while((strike<3)&&(count<11)); //스트라이크가 3번 미만이고 카운트가 11번 미만일때까지 계속 돌린다
		
		
		return count; //빈복문에서 나왔다면 count를 return 해준다
	}
	
	public static void main(String[] args) throws IOException{
		
		int result; //카운트횟수를 받을 변수
		
		if(args.length == 3) { //프로그램이 실행할 때 내가 컴퓨터에서 난수 발생 대신 직접 입력한 것의 길이가 3일 때
			int x = Integer.valueOf(args[0]).intValue(); 
			int y = Integer.valueOf(args[1]).intValue();
			int z = Integer.valueOf(args[2]).intValue();
			
			result = playGame(x, y, z); //x,y,z를 넣고 실행한다.
		}else {
			result = playGame(); //난수 발생으로 인생 시도 횟수를 저장
		}
		
		System.out.println();
		
		if(result<=2){
			System.out.println("참 잘했어요!"); //시도횟수가 2번 이하
		}else if(result<=5){
			System.out.println("잘했어요!");//시도횟수가 3번부터 5번 이하
		}else if(result<=9){
			System.out.println("보통이네요!"); //시도횟수가 6번~9번
		}else{
			System.out.println("분발하세요!");// 시도횟수가 10번
		}
		
	}
}

