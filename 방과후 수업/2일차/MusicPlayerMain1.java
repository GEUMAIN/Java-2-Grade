package oop;

public class MusicPlayerMain1 {
	public static void main(String[] args) {
		boolean isOn = false;
		int volume = 0;
		
		// 음악 플레이어 켜기
		isOn = true;
		System.out.println("음악 플레이어를 시작합니다.");
		
		// 볼륨 증가
		volume++;
		System.out.println("현재 볼륨 : " + volume);
		
		// 볼륨 증가
		volume++;
		System.out.println("현재 볼륨 : " + volume);
		
		// 볼륨 감소
		volume--;
		System.out.println("현재 볼륨 : " + volume);
		
		//음악 플레이어 상태
		if(isOn) {
			System.out.println("음악 플레이어 ON, 볼룸 : " + volume);
		}else {
			System.out.println("음악 플레이어 OFF");
		}
		
		//음악 플레이어 끄기
		isOn = false;
		System.out.println("음악 플레이어를 종료합니다.");
	}
}
