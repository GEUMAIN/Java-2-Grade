package review.enum1;

public class ReviewEnum {
	
	public static void main(String[] args) {
		Resolution resolution = Resolution.HD;
		System.out.println("resolution : " + resolution);
		
		resolution = Resolution.FHD;
		System.out.println("resolutuon : " + resolution);
		
		System.out.print("동영상 녹화 품질 : ");
		switch (resolution){
			case HD:
				System.out.println("일반 화질");
				break;
			case FHD:
				System.out.println("고화질");
				break;
			case UHD:
				System.out.println("초고화질");
				break;
		}
		
		resolution = resolution.valueOf("UHD");
		System.out.println("resolutuon : " + resolution);
		
		System.out.println("------------------------");
		
		for(Resolution myRes : Resolution.values()) {
			System.out.println(myRes.name() + " : " + myRes.ordinal());
		}
		
		System.out.println("------------------------");
		
		for(Resolution myRes : Resolution.values()) {
			System.out.println(myRes.name() + " : " + myRes.getWidth());
		}
	}
}


enum Resolution {
	HD(1280),
	FHD(1920),
	UHD(3840);
	
	private final int width;
	
	Resolution(int width) {
		this.width = width;
	}
	
	public int getWidth() {
		return width;
	}
	
	
}
