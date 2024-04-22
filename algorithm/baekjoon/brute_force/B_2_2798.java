public class B_2_2798 {
    static int search(int arr[], int N, int M) {
        int result = 0;
        for (int i = 0; i < N; i++) {
            for (int j = i; j < N; j++) {
                for (int k = j; k < N; k++) {
                    int temp = arr[i] + arr[j] + arr[k];
                    if (M == temp) {
                        return temp;
                    }
                    if (M < temp && temp < M) {
                        result = temp;
                    }
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();

        int [] arr = new int[N];

        for (int i = 0; i<N; i++){
            arr[i] = sc.nextInt();
        }

        int result = search(arr, N, M);
        System.out.println(result);

    }

}