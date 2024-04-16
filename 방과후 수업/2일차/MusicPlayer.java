package oop;

public class MusicPlayer {
	boolean isOn;
	int volume;
	
	public void volumeUp() {
		volume += 1;
		System.out.println("현재 볼륨 : " +  volume);
	}
	
	public void volumeDown() {
		volume -= 1;
		System.out.println("현재 볼륨 : " +  volume);
	}
	
	public void on() {
		isOn = true;
		System.out.println("음악 플레이어를 시작합니다.");
	}
	public void off() {
		isOn = false;
		System.out.println("음악 플레이어를 종료합니다.");
	}
	
	public void showStatus() {
		if(isOn) {
			System.out.println("음악 플레이어 ON, 볼룸 : " + volume);
		}else {
			System.out.println("음악 플레이어 OFF");
		}
	}
}
