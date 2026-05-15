package co.com.cineapp.backmongo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignAutoConfiguration;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication(scanBasePackages = {
	"co.com.cineapp.backmongo",
	"co.com.clients.parent",
	"co.com.clients.parent.service.rabbitmq"
})
@EnableFeignClients
@ImportAutoConfiguration({FeignAutoConfiguration.class})
@EnableScheduling
public class CineAppBackMongoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CineAppBackMongoApplication.class, args);
	}

}