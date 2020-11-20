package com.org.onlinetailoring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

// TODO: Auto-generated Javadoc
/**
 * The Class OnlineTailoringApplication.
 */
@SpringBootApplication
public class OnlineTailoringApplication extends SpringBootServletInitializer{

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		SpringApplication.run(OnlineTailoringApplication.class, args);
	}
	
    /* (non-Javadoc)
     * @see org.springframework.boot.web.servlet.support.SpringBootServletInitializer#configure(org.springframework.boot.builder.SpringApplicationBuilder)
     */
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(OnlineTailoringApplication.class);
    }

}
