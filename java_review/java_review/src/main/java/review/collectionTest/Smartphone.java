package review.collectionTest;

public class Smartphone {
    public interface Camera{
        void takePhoto();
    }
    public class BasicCamera implements Camera {
        @Override
        public void takePhoto() {
            System.out.println("사진을 찍습니다.");
        }
    }
    public void activeCamera() {
        Camera camera = new BasicCamera();
        camera.takePhoto();
    }

    public static void main(String[] args) {
        Smartphone smartphone = new Smartphone();
        smartphone.activeCamera();
    }
}
