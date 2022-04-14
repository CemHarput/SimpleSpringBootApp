package MaviDevStudyCase.demo.Info;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class InfoConfig {
    @Bean
    CommandLineRunner commandLineRunner(InfoRepository repository){
        return args -> {
             Info info=new Info(
                    "Istanbul",
                    "Besiktas"
            );
            Info info1=new Info(
                    "Ankara",
                    "Çankaya"
            );
            Info info2=new Info(

                    "Istanbul",
                    "Kadıköy"
            );

            repository.saveAll(List.of(info,info1,info2));
        };
    }
}
