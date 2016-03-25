package com.mongodb;

import java.net.UnknownHostException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.data.repository.init.Jackson2RepositoryPopulatorFactoryBean;

@Configuration
@EnableMongoRepositories(basePackages = "com.mongodb.repositories")
public class MongoConfig extends AbstractMongoConfiguration {

	@Value("${spring.data.mongodb.uri}")
	private String uri;

	@Value("${spring.data.mongodb.database}")
	private String databaseName;

	@Autowired
	private ApplicationContext applicationContext;

	@Bean
	public Mongo mongo() throws UnknownHostException {
		return new MongoClient(new MongoClientURI(uri));
	}

	protected String getDatabaseName() {
		return databaseName;
	}

	@Bean
	public MongoTemplate mongoTemplate() {
		try {
			return new MongoTemplate(mongoDbFactory());
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Bean
	Jackson2RepositoryPopulatorFactoryBean repositoryPopulator() {
		Jackson2RepositoryPopulatorFactoryBean jackson2RepositoryPopulatorFactoryBean = new Jackson2RepositoryPopulatorFactoryBean();
		Resource resource = applicationContext.getResource("classpath:populate.js");
		Resource[] resourceArr = new Resource[1];
		resourceArr[0] = resource;
		jackson2RepositoryPopulatorFactoryBean.setResources(resourceArr);
		return jackson2RepositoryPopulatorFactoryBean;
	}

	@Bean
	public MongoDbFactory mongoDbFactory() throws UnknownHostException {
		return new SimpleMongoDbFactory(mongo(), getDatabaseName());
	}

}
