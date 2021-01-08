package com.dxc.insurance.service;

import java.util.List;

import com.dxc.insurance.entity.Policy;

public interface PolicyService {

	public void addPolicy(Policy policy);

	public Policy getPolicy(int policyId);

	public List<Policy> getAllPolicy();

	public void deletePolicy(int policyId);

	public Policy updatePolicy(Policy policy);

	public List<Policy> updatePolicyPremium(int policyAmount);
}
