package com.dxc.insurance.dao;

import java.util.List;

import com.dxc.insurance.entity.Policy;

public interface PolicyDao {

	public void addPolicy(Policy policy);

	public Policy getPolicy(int policyId);

	public List<Policy> getAllPolicy();

	public void deletePolicy(int policyId);

	public Policy updatePolicy(int policyId, Policy policy);

	public List<Policy> updatePolicyPremium(int policyId, int policyAmount);
}
