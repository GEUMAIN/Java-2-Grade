package construct;

public class MemberInit {
    String name;
    int age;
    int grade;

    // 기본생성자 - 개발자가 생성자를 만들지 않을 경우에는
    // 자바가 직접 만들어 준다.
    public MemberInit(){

    }

    public void initMember(String name, int age, int grade){
        this.grade = grade;
        this.age = age;
        this.name = name;
    }
}
