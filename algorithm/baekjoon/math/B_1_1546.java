public class B_1_1546 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double [] arr = new double[n];
        double avg = 0;
        double max = 0;
        double sum = 0;

        for(int i = 0; i<arr.length; i++){
            arr[i] = sc.nextInt();
        }
            Arrays.sort(arr);
            max = arr[n-1];

            for(int i=0;i<arr.length;i++) {
                arr[i] = (arr[i]/max)*100;
                sum += arr[i];
            }
            avg = sum/n;

        System.out.println(avg);
        }
    }
