import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Collectors;

public class A {

    public static int fib(int n) {
        if (n < 2) {
            return n;
        } else {
            return fib(n - 1) + fib(n - 2);
        }
    }

    public static int fac(int n) {
        if (n < 2) {
            return n;
        } else {
            return n * fac(n - 1);
        }
    }

    // Armstrong
    public static int count(int n) {
        int cnt = 0;
        while (n > 0) {
            cnt++;
            n = n / 10;
        }
        return cnt;
    }

    public static int armstrong(int n) {
        int cnt = count(n);
        int result = 0;
        while (n > 0) {
            int rem = n % 10;
            result = (int) Math.pow(rem, cnt) + result;
            n = n / 10;
        }
        return result;
    }

    public int[] reverseAarrays(int[] arr) {
        int l = 0;
        int r = arr.length - 1;
        while (l < r) {
            int temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;
            l++;
            r--;
        }
        return arr;
    }

    public int[] sortAnArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] < arr[j]) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        return arr;
    }

    public static void trianglePattern(int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = n; j > i; j--) {
                System.out.print(" ");
            }
            for (int j = 1; j <= i; j++) {
                if (j == i || j == 1) {
                    System.out.print("* ");
                } else {
                    System.out.print("  ");
                }
            }
            System.out.println();
        }
        for (int i = n - 1; i >= 1; i--) {
            for (int j = n; j > i; j--) {
                System.out.print(" ");
            }
            for (int j = 1; j <= i; j++) {
                if (j == i || j == 1) {
                    System.out.print("* ");
                } else {
                    System.out.print("  ");
                }
            }

            System.out.println();
        }
    }

    public static void square(int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (i == 1 || j == 1 || i == n || j == n) {
                    System.out.print("* ");
                } else {
                    System.out.print("  ");
                }
            }
            System.out.println();
        }
    }

    public static String reversAnString(String s) {
        return s.chars().mapToObj(a -> (char) a).sorted(Comparator.reverseOrder()).map(String::valueOf)
                .collect(Collectors.joining());
    }

    public static void main(String[] args) {
        // System.out.println(fac(5));
        // System.out.println(armstrong(153));
        // int[] result = new A().reverseAarrays(new int[] { 1, 2, 4, 5, 6, 7, 8, 9, 3
        // });
        // for (int i = 0; i < result.length; i++) {
        // System.out.print(result[i] + " ");
        // }
        // System.out.println();
        // int[] result1 = new A().sortAnArray(new int[] { 1, 2, 4, 5, 6, 7, 8, 9, 3 });
        // for (int i = 0; i < result1.length; i++) {
        // System.out.print(result1[i] + " ");
        // }
        // trianglePattern(5);
        // square(5);
        System.out.println(reversAnString("Hello"));
    }
}