package oop;

public class MusicPlayerMain3 {
	public static void main(String[] args) {
		MusicPlayerData data = new MusicPlayerData();

		// 음악 플레이어 켜기
		on(data);
		
		// 볼륨 증가
		volumeUp(data);
		
		// 볼륨 증가
		volumeUp(data);
		
		// 볼륨 감소
		volumeDown(data);
		
		//음악 플레이어 상태
		showStatus(data);
		
		//음악 플레이어 끄기
		off(data);
	}
	
	public static void volumeUp(MusicPlayerData data) {
		data.volume += 1;
		System.out.println("현재 볼륨 : " +  data.volume);
	}
	
	public static void volumeDown(MusicPlayerData data) {
		data.volume -= 1;
		System.out.println("현재 볼륨 : " +  data.volume);
	}
	
	public static void on(MusicPlayerData data) {
		data.isOn = true;
		System.out.println("음악 플레이어를 시작합니다.");
	}
	public static void off(MusicPlayerData data) {
		data.isOn = false;
		System.out.println("음악 플레이어를 종료합니다.");
	}
	
	public static void showStatus(MusicPlayerData data) {
		if(data.isOn) {
			System.out.println("음악 플레이어 ON, 볼룸 : " +  data.volume);
		}else {
			System.out.println("음악 플레이어 OFF");
		}
	}
}
