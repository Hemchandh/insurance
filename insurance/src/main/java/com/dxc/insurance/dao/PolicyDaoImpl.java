package com.dxc.insurance.dao;

import java.util.List;

import javax.persistence.TypedQuery;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

import com.dxc.insurance.controller.PolicyController;
import com.dxc.insurance.entity.Policy;

public class PolicyDaoImpl implements PolicyDao {

	@Autowired
	SessionFactory sessionFactory;
	
	private static Logger logger = Logger.getLogger(PolicyDaoImpl.class);

	@Override
	public void addPolicy(Policy policy) {
		// TODO Auto-generated method stub
		Session session = null;
		Transaction trans = null;
		try {
			session = sessionFactory.openSession();
			trans = session.beginTransaction();
			session.save(policy);
			trans.commit();
			logger.info("Policy added: " +policy);

		} catch (HibernateException ex) {
			ex.printStackTrace();
			trans.rollback();
		} finally {
			if (session != null)
				session.close();
		}

	}

	@Override
	public Policy getPolicy(int policyId) {
		// TODO Auto-generated method stub
		Session session = null;
		Policy policy = null;
		try {
			session = sessionFactory.openSession();
			policy = session.get(Policy.class, policyId);
			logger.info("Policy fetched: " +policy);
		} catch (Exception ex) {
			ex.printStackTrace();

		} finally {
			if (session != null)
				session.close();
		}
		return policy;
	}

	@Override
	public List<Policy> getAllPolicy() {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		TypedQuery<Policy> qry = session.createQuery("from policy", Policy.class);
		logger.info("Policy fetched: " +qry.getResultList());
		return qry.getResultList();
	}

	@Override
	public void deletePolicy(int policyId) {
		// TODO Auto-generated method stub
		Session session = null;
		Policy policy = null;
		try {
			session = sessionFactory.openSession();
			policy = session.get(Policy.class, policyId);
			session.delete(policy);
			logger.info("Policy deleted: " +policy);

		} catch (Exception ex) {
			ex.printStackTrace();

		} finally {
			if (session != null)
				session.close();
		}
	}

	@Override
	public Policy updatePolicy(int policyId, Policy policy) {
		// TODO Auto-generated method stub
		Session session = null;
		Transaction trans = null;
		try {
			session = sessionFactory.openSession();
			trans = session.beginTransaction();
			session.update(policy);
			trans.commit();
			logger.info("Policy updated: " +policy);

		} catch (HibernateException ex) {
			ex.printStackTrace();
			trans.rollback();
		} finally {
			if (session != null)
				session.close();
		}
		return policy;
	}

	@Override
	public List<Policy> updatePolicyPremium(int policyId, int policyAmount) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		TypedQuery<Policy> qry = session.createQuery("update policy set policyAmount=?2 where policyId=?1", Policy.class);
		logger.info("Policy updated: " +qry.getResultList());
		return qry.getResultList();
	}

}
