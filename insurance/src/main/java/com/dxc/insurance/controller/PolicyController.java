package com.dxc.insurance.controller;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dxc.insurance.entity.Policy;
import com.dxc.insurance.service.PolicyService;

@RestController
@RequestMapping(value = "/policy")
public class PolicyController {

	@Autowired
	PolicyService policyService;

	@PostMapping(value="",consumes = "application/json")
	public void addPolicy(@RequestBody Policy policy) throws Exception {

		  policyService.addPolicy(policy);
//		Optional<Policy> p = Optional.ofNullable(policyService.getPolicy(policy.getPolicyId()));
//
//		EntityModel<Policy> resource = EntityModel.of(p.get());
//
//		Link selfLink = linkTo(PolicyController.class).slash(policy.getPolicyId()).withSelfRel();
//		resource.add(selfLink);
//		return resource;
	}

	@GetMapping(value = "/{policyId}", produces = { "application/json", "application/xml" })
	public Policy getPolicy(@PathVariable int policyId) throws Exception {
		return policyService.getPolicy(policyId);

//		Optional<Policy> p = Optional.ofNullable(policyService.getPolicy(policyId));
//
//		EntityModel<Policy> resource = EntityModel.of(p.get());
//
//		WebMvcLinkBuilder linkTo = linkTo(methodOn(this.getClass()).getAllPolicy());
//		Link selfLink = linkTo(PolicyController.class).slash(policyId).withSelfRel();
//		return resource;
	}

	@GetMapping(value="",produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public List<Policy> getAllPolicy() throws Exception {
		
		return policyService.getAllPolicy();
		
//		List<Policy> p = policyService.getAllPolicy();
//		for (final Policy policy : p) {
//			policy.add(linkTo(methodOn(PolicyController.class).getPolicy(policy.getPolicyId())).withSelfRel());
//		}
//
//		Link link = linkTo(methodOn(PolicyController.class).getAllPolicy()).withSelfRel();
//		return new CollectionModel<Policy>(p, link);

	}
	@DeleteMapping(value="/{policyid}")
	public void deletePolicy(@PathVariable int policyId)
	{
		policyService.deletePolicy(policyId);
		
	}
	
	@PutMapping(value="",consumes="application/json")
	public Policy updatePolicy(@RequestBody Policy policy)
	{
		 return policyService.updatePolicy( policy);
		
	
}
	@PutMapping(value="/premium/{policyId}",consumes="application/json")
	public List<Policy> updatePolicyPremium(@PathVariable int policyId, @RequestBody int  policyAmount)
	{
		 return policyService.updatePolicyPremium(policyAmount);
		
	
}
	
	
}
