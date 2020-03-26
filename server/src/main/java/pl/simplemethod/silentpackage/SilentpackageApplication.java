package pl.simplemethod.silentpackage;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SilentpackageApplication {

    public static void main(String[] args) throws JsonProcessingException {
        SpringApplication.run(SilentpackageApplication.class, args);
        ObjectMapper objectMapper = new ObjectMapper();
        try {
        }
        catch (Throwable e)
        {
            System.out.println(e);
        }
    }

}
