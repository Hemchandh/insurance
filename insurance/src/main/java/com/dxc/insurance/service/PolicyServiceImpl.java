package com.dxc.insurance.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dxc.insurance.dao.PolicyDao;
import com.dxc.insurance.entity.Policy;

@Service
public class PolicyServiceImpl implements PolicyService {

	@Autowired
	private PolicyDao dao;
	
	@Override
	public void addPolicy(Policy policy) {
		// TODO Auto-generated method stub
		dao.addPolicy(policy);
	}

	@Override
	public Policy getPolicy(int policyId) {
		// TODO Auto-generated method stub
		return dao.getPolicy(policyId);
	}

	@Override
	public List<Policy> getAllPolicy() {
		// TODO Auto-generated method stub
		return dao.getAllPolicy();
	}

	@Override
	public void deletePolicy(int policyId) {
		// TODO Auto-generated method stub
		dao.deletePolicy(policyId);
	}

	@Override
	public Policy updatePolicy( Policy policy) {
		return dao.updatePolicy(policy);
	}

	@Override
	public List<Policy> updatePolicyPremium(int policyAmount) {
		// TODO Auto-generated method stub
		return dao.updatePolicyPremium(policyAmount);
		
	}

}
