package com.luv2code.springdemo.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.luv2code.springdemo.entity.Customer;
import com.luv2code.springdemo.utils.SortUtil;

@Repository
public class CustomerDAOImpl implements CustomerDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Customer> getCustomers(int sort) {
		Session session = sessionFactory.getCurrentSession();
		
		Query<Customer> query = null;

		String sortField = getSortField(sort);
		
		query = session.createQuery("from Customer order by " + sortField, Customer.class);

		return query.getResultList();
	}

	private String getSortField(int sort) {
		String sortField = null;

		switch (sort) {
		case SortUtil.FIRST_NAME:
			sortField = "firstName";
			break;
		case SortUtil.LAST_NAME:
			sortField = "lastName";
			break;
		case SortUtil.EMAIL:
			sortField = "email";
			break;
		default:
			sortField = "lastName";
		}
		return sortField;
	}

	@Override
	public void saveCustomer(Customer customer) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(customer);
	}

	@Override
	public Customer getCustomer(int id) {
		Session session = sessionFactory.getCurrentSession();
		return session.get(Customer.class, id);
	}

	@Override
	public void deleteCustomer(int id) {
		Session session = sessionFactory.getCurrentSession();

		Query query = session.createQuery("delete from Customer where id = :id");

		query.setParameter("id", id);

		query.executeUpdate();
	}

	@Override
	public List<Customer> searchCustomers(String filter) {
		Session session = sessionFactory.getCurrentSession();
		
		Query<Customer> query = null;

		String queryString = "from Customer";
		
		if (null != filter && filter.trim().length() > 0) {
			queryString += " where firstName like :first or lastName like :last";
			query = session.createQuery(queryString, Customer.class);
			query.setParameter("first", "%" + filter + "%");
			query.setParameter("last", "%" + filter + "%");
		} else {
			query = session.createQuery(queryString, Customer.class);
		}
		
		return query.getResultList();
	}
}
