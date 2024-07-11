package java_level4.lang.math.test;

public class LottoGeneratorMain {
	public static void main(String[] args) {
		LottoGenerator generator = new LottoGenerator();
		int[] lottoNumbers = generator.generator();
		
		for(int lottoNumber : lottoNumbers) {
			System.out.println(lottoNumber + " ");
		}
	}
}

// 1~45 중에 6개의 중복없이 뽑아야 한다.
//실행할 때 마다 결과가 달라야 한다.
