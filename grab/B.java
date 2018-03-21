package grab;

/**
 * @author chopra
 * 21/03/18
 */
public class B {
    public int solution(int[] A) {
        if(A.length >= 23) {
            return 25;
        } else if(A.length <= 3) {
            return 2 * A.length;
        }
        int ans = Math.min(solve(A, 1, A[0]+6)+7, solve(A, 1, 0)+2);
        return Math.min(ans, 25);
    }

    int solve(int[] A, int index, int max) {
        if (index >= A.length) {
            return 0;
        }
        if (A[index] <= max) {
            return solve(A, index + 1, max);
        } else {
            return (Math.min(solve(A, index + 1, A[index] + 6) + 7, solve(A, index + 1, 0) + 2));
        }
    }

    public static void main(String[] args) {
        B b = new B();

        int[] a = new int[10];
        a[0]=1;
        a[1]=2;
        a[2]=4;
        a[3]=5;
        a[4]=7;
        a[5]=29;
        a[6]=30;
        System.out.println(b.solution(a));
    }


}
