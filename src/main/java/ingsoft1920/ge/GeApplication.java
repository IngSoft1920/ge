package ingsoft1920.ge;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;


@Controller
@SpringBootApplication
public class GeApplication {
	final static Logger logger = LogManager.getLogger(GeApplication.class.getName());
	
	public static void main(String[] args) {
		logger.warn("Aplicacion iniciada");
		SpringApplication.run(GeApplication.class, args);
		
	}


}
