package oop;

public class Account {
    int balance = 0;

    public void deposit(int amount){
        balance += amount;
    }

    public void withdraw(int amount){
        if(balance > amount){
            balance -= amount;
        }else if(balance < amount){
            System.out.println("잔액 부족");
        }
    }
}
