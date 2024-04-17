package hash;

import java.util.HashSet;
import java.util.Scanner;

public class HashSetEx01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int target = sc.nextInt();
        int[] arr = new int[N];

        for (int i = 0; i < N; i++){
            arr[i] = sc.nextInt();
        }

        System.out.println(solution(arr, target));
    }
    //solution 메소드 생성하고 구현
    public static boolean solution(int[] arr, int target){
        HashSet<Integer> set = new HashSet<Integer>();

        for(int i : arr){
            if(set.contains(target -= i)){
                return true;
            }
            set.add(i);

        }
        return false;
        /*for (int i = 0; i < arr.length; i++){
            for(int j = 0; j < i; j++){
                if(arr[i] + arr[j] == target) {
                    return true;
                }
            }
        }*/
    }

}
