package sample.run;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import sample.bean.MyBean;
import sample.config.MyBeanConfig;

public class SpringExam01 {
    public static void main(String[] args) {
        // 직접 사용하는 경우
//        MyBean bean = new MyBean();
//        bean.setName("jeon");
//
//        System.out.println(bean);

        // 스프링 ioc container를 이용해서 사용할 경우
        // 1. 애노테이션으로 알려줌 - 그러려면 컴포넌트 스캔 하도록

        // 2, 자바 파일을 통해서 알려줌
//        BeanFactory - 빈을 생성하는데 간단한 기능만 포함하고 있따, aop 기술은 사용할 수 없음
        System.out.println("ApplicationContext 생선 전");
        ApplicationContext context = new AnnotationConfigApplicationContext(MyBeanConfig.class); // 공장이 생성할때 어떤 빈을 생성해야할지
        System.out.println("ApplicationContext 생선 후");
        MyBean bean1 = (MyBean) context.getBean("myBean");  // lookup 하는 방식, 아이디를 알려줌

        bean1.setName("patric");

        System.out.println(bean1);


//        MyBean bean2 = context.getBean(MyBean.class); // 타입만 알려줌
        MyBean bean2 = context.getBean("myBean2", MyBean.class); // 타입만 알려줌

        bean2.setName("vincent");
        System.out.println(bean2);
        System.out.println(bean1);

        if (bean2 == bean1) {
            System.out.println("같은 인스턴스입니다.");
        } else {
            System.out.println("bean1과 bean2는 다른 인스턴스입니다.");
        }

        MyBean bean3 = context.getBean("myBean", MyBean.class);

        if (bean3 == bean1) {
            System.out.println("bean3과 bean1은 같은 인스턴스입니다.");
        }

        MyBean bean4 = context.getBean("myBean3", MyBean.class);
        bean4.setName("hong");

        MyBean bean5 = context.getBean("myBean3", MyBean.class);
        bean5.setName("lee");


        System.out.println(bean4);
        System.out.println(bean5);


        // 3. xml을 통해서 알려줌 - 이 방법은 많이 사용하지 않음
    }

}
