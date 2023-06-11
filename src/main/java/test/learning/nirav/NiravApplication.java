package test.learning.nirav;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class NiravApplication {

	public static void main(String[] args) {
		SpringApplication.run(NiravApplication.class, args);
	}

	@Bean
	public Docket productApi() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.any())
				.paths(PathSelectors.any())
				.build();
	}

/*	@Bean
	public CommandLineRunner demo(DoctorRepository repository) {
		return (args) -> {
			// save a few customers
			repository.save(new DoctorEntity("Sudhir Shah", Specification.ENTSPECIALIST, LocalTime.of(10, 0), LocalTime.of(14, 0)));
			repository.save(new DoctorEntity("Parag Sheth", Specification.ORTHOPEDIC, LocalTime.of(9, 0), LocalTime.of(13, 0)));
			repository.save(new DoctorEntity("Ravindra Lodha", Specification.PSYCHIATRISTS, LocalTime.of(14, 0), LocalTime.of(17, 0)));
			repository.save(new DoctorEntity("Sanjay Rajput", Specification.DENTIST, LocalTime.of(15, 0), LocalTime.of(19, 0)));
			repository.save(new DoctorEntity("Yogesh Harwani", Specification.CARDIOLOGIST, LocalTime.of(18, 0), LocalTime.of(21, 0)));
			repository.save(new DoctorEntity("Kawid Kothari", Specification.PSYCHIATRISTS, LocalTime.of(13, 0), LocalTime.of(14, 0)));

		};
	}*/

}
