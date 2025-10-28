public class Main {
    public static void main(String[] args) {
        int[] arry = {5,4,6,0,3,6,2,1,8};

        for (int i = 0; i < arry.length; i++) {
            if (arry[i] % 2 == 0) {
                continue;
            }
            System.out.println(arry[i]);
        }
    }
}
