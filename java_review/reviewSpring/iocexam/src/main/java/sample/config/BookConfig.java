package sample.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import sample.bean.Book;

//@Configuration
public class BookConfig {
    @Bean
    public Book book() {
        return new Book("java", 1000);
    }
}
