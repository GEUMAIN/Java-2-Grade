package poly.ex.pay1;

public class PayMain1 {
	public static void main(String[] args) {
		
		PayService payService = new PayService();
		
		// kakao 결제
		int amount1 = 5000;
		String payOption1 = "kakao";
		
		payService.processPay(payOption1,amount1);
		
		// naver 결제
		String payOption2 = "naver";
		int amount2 = 10000;
		
		payService.processPay(payOption2, amount2);
		
		// 잘못된 결제수단
		String payOption3 = "apple";
		int amount3 = 15000;
		
		payService.processPay(payOption3, amount3);
	}
}
