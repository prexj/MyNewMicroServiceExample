package com.example.service.communication;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.example.entity.User;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class SuperviserServiceCommunication {

	@Autowired
	LoadBalancerClient loadBalancerClient;
	
	public List<User> getSupervisorInfo() throws JsonMappingException, JsonProcessingException {
		System.out.println("getSupervisorInfo ::: ");
		ServiceInstance serviceInstance = loadBalancerClient.choose("MANGER-SERVICE");
		System.out.println("serviceInstance.getUri() ::: "+serviceInstance.getUri());
		String uri = serviceInstance.getUri()+"/api/supervisors";
		RestTemplate restTemplate = new RestTemplate();
		System.out.println(uri);
		String resonse1 =restTemplate.getForObject(uri, String.class);
		
		ObjectMapper mapper = new ObjectMapper();
		List<User> responseEntity  = mapper.readValue(resonse1,new TypeReference<List<User>>(){});
		//restTemplate.getForEntity(uri, User.class);
		//System.out.println(resonse1);
		//List<User> responseEntity  = (List<User>) restTemplate.getForEntity(uri, User.class);
		return responseEntity;
	}
}
