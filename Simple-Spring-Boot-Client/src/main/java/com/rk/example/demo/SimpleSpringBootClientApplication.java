package com.rk.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.classify.Classifier;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.retry.RetryContext;
import org.springframework.retry.RetryPolicy;
import org.springframework.retry.annotation.EnableRetry;
import org.springframework.retry.backoff.FixedBackOffPolicy;
import org.springframework.retry.policy.ExceptionClassifierRetryPolicy;
import org.springframework.retry.policy.NeverRetryPolicy;
import org.springframework.retry.policy.SimpleRetryPolicy;
import org.springframework.retry.support.RetryTemplate;
import org.springframework.web.client.HttpServerErrorException;

@SpringBootApplication
@EnableRetry
public class SimpleSpringBootClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(SimpleSpringBootClientApplication.class, args);
	}
	
	@Bean
	public RetryTemplate retryTemplate() {
		SimpleRetryPolicy policy = new SimpleRetryPolicy();
		FixedBackOffPolicy backOffPolicy = new FixedBackOffPolicy();
		ExceptionClassifierRetryPolicy classifierRetryPolicy = new ExceptionClassifierRetryPolicy();
		backOffPolicy.setBackOffPeriod(500l);
		policy.setMaxAttempts(3);
		RetryTemplate template = new RetryTemplate();
		template.setBackOffPolicy(backOffPolicy);
		template.setRetryPolicy(policy);
		classifierRetryPolicy.setExceptionClassifier(new Classifier<Throwable, RetryPolicy>() {
			
			@Override
			public RetryPolicy classify(Throwable classifiable) {
				if(classifiable instanceof HttpServerErrorException) {
					if((((HttpServerErrorException) classifiable).getStatusCode() == HttpStatus.UNAUTHORIZED) ||
							(((HttpServerErrorException) classifiable).getStatusCode() == HttpStatus.INTERNAL_SERVER_ERROR) ||
							(((HttpServerErrorException) classifiable).getStatusCode() == HttpStatus.REQUEST_TIMEOUT) ||
							(((HttpServerErrorException) classifiable).getStatusCode() == HttpStatus.GATEWAY_TIMEOUT))
					{
				return policy;
				} }
				return new NeverRetryPolicy();
			}
		});
		return template;
	}

}
