package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.ApplicationContext;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Random;

@SpringBootApplication
@EnableFeignClients
@EnableScheduling
public class Application {

	private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
	private int code = new Random().nextInt(1000);

	@Autowired
	private ApplicationContext appContext;

	//public static Logger logger = LoggerFactory.getLogger(Application.class);

	private MyFeignClient feignClient;

	public Application(MyFeignClient feignClient) {
		this.feignClient = feignClient;
	}

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Scheduled(fixedDelay = 61000)
	public void task() {
		String message = LocalDateTime.now(ZoneId.of("Europe/Moscow")).format(formatter);
		System.out.println("begin " + message);
		String result = feignClient.runTask(Integer.toString(code), message);


//		MyFeignClient client = Feign.builder()
//				.client(new OkHttpClient())
//				.encoder(new GsonEncoder())
//				.decoder(new GsonDecoder())
//				.logger(new Slf4jLogger(MyFeignClient.class))
//				.logLevel(Logger.Level.FULL)
//				.target(MyFeignClient.class, "http://organization-service-myproject.192.168.99.100.nip.io");
		//String result = client.runTask(Integer.toString(code), message);
		System.out.println("end " + result + ", " + LocalDateTime.now().format(formatter));
	}

}
