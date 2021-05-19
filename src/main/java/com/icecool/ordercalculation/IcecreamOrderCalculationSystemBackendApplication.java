package com.icecool.ordercalculation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.data.repository.init.Jackson2RepositoryPopulatorFactoryBean;

@SpringBootApplication
public class IcecreamOrderCalculationSystemBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(IcecreamOrderCalculationSystemBackendApplication.class, args);
	}

	/* The following repository populator bean will read the data from the manage-data.json file and populate the Base flavors, Condiments,
	 * and Container data into the database when the application starts. A backend user (System Administrator) can change the data of the 
	 * aforementioned types in the manage-data.json file, where the updated records will be updated in the database accordingly. 
	*/
	@Bean
	public Jackson2RepositoryPopulatorFactoryBean getRespositoryPopulator() {
	    Jackson2RepositoryPopulatorFactoryBean jascksonRepositoryPopulatorFactoryBean = new Jackson2RepositoryPopulatorFactoryBean();
	    jascksonRepositoryPopulatorFactoryBean.setResources(new Resource[]{new ClassPathResource("manage-data.json")});
	    return jascksonRepositoryPopulatorFactoryBean;
	}
}
