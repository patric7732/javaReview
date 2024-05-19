package annotation;

public class Service {
    @PrintAnnotation("@")
    public void method01(){
        System.out.println("METHOD 01 RUN");
    }
    @PrintAnnotation("&")
    public void method02(){
        System.out.println("METHOD 02 RUN");
    }

    @PrintAnnotation(value = "#", number = 10)
    public void method03(){
        System.out.println("METHOD 03 RUN");
    }
    public void method04(){
        System.out.println("METHOD 04 RUN");
    }
}
