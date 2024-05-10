package sample.run;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import sample.bean.Book;
import sample.config.BookConfig;

@SpringBootApplication
public class BookApplication {
        public static void main(String[] args) {
            ApplicationContext context = new AnnotationConfigApplicationContext(BookConfig.class);
            Book book = context.getBean(Book.class);
            System.out.println(book);
        }
}
