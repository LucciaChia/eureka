package com.profesorp.capitalsservice;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


@RestController
public class CapitalsServiceController {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private CapitalsServiceProxy proxy;
	HashMap<Integer, Integer> htPuerto=new HashMap<>();	
	
	@GetMapping("/{country}")
	public CapitalsBean getCountry(@PathVariable String country) {
		CapitalsBean response = proxy.getCountry(country);
		htPuerto.put(response.getPort(), htPuerto.getOrDefault(response.getPort(),0)+1);
		logger.info("CapitalesService -> {} ",response);
		return response;
	}
	
	@GetMapping("/puertos")
	public String getCountryUsingFeign() {
		StringBuffer response=new StringBuffer();
		htPuerto.forEach((k,v) -> response.append(" Puerto: "+k+" Valor: "+v));
		return response.toString();
	}
	
	@GetMapping("/template/{country}")
	public CapitalsBean getCountryUsingRestTemplate(@PathVariable String country) {
		
		Map<String, String> uriVariables = new HashMap<>(); // uriVariables su premenne z URL adressy, to co je medzi lomitkami
		uriVariables.put("country", country);		        // napr.:http://localhost:8100/template/es "es" je uriVariabla
		
		ResponseEntity<CapitalsBean> responseEntity = new RestTemplate().getForEntity(
				"http://localhost:8000/{countryShortcut}",
				CapitalsBean.class, 
				uriVariables );
		
		CapitalsBean response = responseEntity.getBody();
		System.out.println("CapitalsServiceController -> RESPONSE ENTITY: " + responseEntity.toString());
		return response;
	}
	
	@Autowired
	private CapitalsServiceProxySimple simpleProxy;
	@GetMapping("/feign/{country}")
	public CapitalsBean getCountryUsingFeign(@PathVariable String country) {
		CapitalsBean response = simpleProxy.getCountry(country);
		System.out.println("CapitalsServiceController -> SIMPLE PROXY: " + simpleProxy.toString());
		return response;
	}
	
	
}
