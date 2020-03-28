package pl.simplemethod.silentpackage;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "pl.simplemethod.silentpackage.dataModel")
public class ApplicationConfig {
}