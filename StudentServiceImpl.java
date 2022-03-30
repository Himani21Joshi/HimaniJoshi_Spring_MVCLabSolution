package com.greatlearning.studentmanagement.service;

import java.util.List;


import javax.transaction.Transactional;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.greatlearning.studentmanagement.entity.Student;

@Repository
public class StudentServiceImpl implements StudentService{

	private SessionFactory sessionfactory;
	private Session session;
	
	@Autowired
	StudentServiceImpl(SessionFactory sessionfactory){
		this.sessionfactory = sessionfactory;
		try {
			session = sessionfactory.getCurrentSession();
		}
		catch(HibernateException e){
			session = sessionfactory.openSession();
		}
	}
	
	@Transactional
	public List<Student> findAll(){
		Transaction t = session.beginTransaction();
		List<Student> students = session.createQuery("from Student").list();
		t.commit();
		return students;
		
	}
	public Student findById(int id) {
		Transaction t = session.beginTransaction();
		Student student = session.get(Student.class, id);
		t.commit();
		return student;
	}
	public void save(Student student) {
		Transaction t = session.beginTransaction();
		session.saveOrUpdate(student);
		t.commit();
	}
	public void deleteById(int id) {
		Transaction t = session.beginTransaction();
		Student student = session.get(Student.class, id);
		session.delete(student);
		t.commit();
	}
}

