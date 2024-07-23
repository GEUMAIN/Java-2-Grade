package review.extend;

public class HamBurgerMain {
	public static void main(String[] args) {
        HamBurger[] hamBurgers = {
        		new HamBurger(), 
        		new CheeseBurger(),
        		new ShrimpBurger()};

        System.out.println("주문하신 메뉴를 만듭니다.");
        System.out.println("-------------");
        for (HamBurger hamBurger : hamBurgers) {
            hamBurger.cook();
            System.out.println("-------------");
        }
        System.out.println("메뉴 준비가 완료되었습니다.");
    }
}
