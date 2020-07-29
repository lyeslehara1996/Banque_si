package org.dev;


import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.remoting.jaxws.SimpleJaxWsServiceExporter;
import org.springframework.remoting.rmi.RmiServiceExporter;

@Configuration
public class myConfig {

	@Bean
	public SimpleJaxWsServiceExporter getJWS() {
	SimpleJaxWsServiceExporter exporter= new SimpleJaxWsServiceExporter() ;
		exporter.setBaseAddress("http://localhost:8022/MaBanque");
return exporter;
	}
	

}
