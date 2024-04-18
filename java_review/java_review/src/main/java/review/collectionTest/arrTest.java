package review.collectionTest;

public class arrTest {
    public static void path(){
        String pathVariable = System.getenv("PATH");
        System.out.println("Path Variable : " + pathVariable);
    }

    public static void arrCpy(){
        int[] sourceArray = {1, 2, 3, 4, 5};
        int[] destArray = new int[5];
        System.arraycopy(sourceArray, 0, destArray, 0, sourceArray.length);
// 이제 destArray는 sourceArray의 복사본을 포함합니다.

        for (int i = 0; i<destArray.length; i++){
            System.out.print(destArray[i]+ " ");
        }
    }

    public static void main(String[] args) {
        path();
        arrCpy();
    }
}
