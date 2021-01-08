package com.dxc.insurance.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.hateoas.RepresentationModel;


@Entity
@Table(name="Policy")
public class Policy extends RepresentationModel<Policy> {

	@Id
	private int policyId;	
	private String policyType;
	private String beneficiaryName;
	private int policyTerm;
	private int policyAmount;
	private long sumAssured;
	
	public int getPolicyId() {
		return policyId;
	}
	public void setPolicyId(int policyId) {
		this.policyId = policyId;
	}
	public String getPolicyType() {
		return policyType;
	}
	public void setPolicyType(String policyType) {
		this.policyType = policyType;
	}
	public String getBeneficiaryName() {
		return beneficiaryName;
	}
	public void setBeneficiaryName(String beneficiaryName) {
		this.beneficiaryName = beneficiaryName;
	}
	public int getPolicyTerm() {
		return policyTerm;
	}
	public void setPolicyTerm(int policyTerm) {
		this.policyTerm = policyTerm;
	}
	public int getPolicyAmount() {
		return policyAmount;
	}
	public void setPolicyAmount(int policyAmount) {
		this.policyAmount = policyAmount;
	}
	public long getSumAssured() {
		return sumAssured;
	}
	public void setSumAssured(long sumAssured) {
		this.sumAssured = sumAssured;
	}
	public Policy(int policyId, String policyType, String beneficiaryName, int policyTerm, int policyAmount,
			long sumAssured) {
		super();
		this.policyId = policyId;
		this.policyType = policyType;
		this.beneficiaryName = beneficiaryName;
		this.policyTerm = policyTerm;
		this.policyAmount = policyAmount;
		this.sumAssured = sumAssured;
	}
	@Override
	public String toString() {
		return "Policy [policyId=" + policyId + ", policyType=" + policyType + ", beneficiaryName=" + beneficiaryName
				+ ", policyTerm=" + policyTerm + ", policyAmount=" + policyAmount + ", sumAssured=" + sumAssured + "]";
	}
	
	
	
}
