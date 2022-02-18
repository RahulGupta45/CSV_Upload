/* ******************This file is not needed because of StudentRepository *****************
 * package com.project.csvupload.dao;
 * 
 * import java.util.List;
 * 
 * import javax.persistence.EntityManager; import
 * javax.transaction.Transactional;
 * 
 * import org.hibernate.Session; import org.hibernate.query.Query; import
 * org.springframework.stereotype.Repository;
 * 
 * import com.project.csvupload.entity.Student;
 * 
 * @Repository public class StudentDAOHibernateImpl implements
 * StudentRepository{
 * 
 * private EntityManager entityManager;
 * 
 * public StudentDAOHibernateImpl(EntityManager entityManager) {
 * this.entityManager = entityManager; }
 * 
 * @Override
 * 
 * @Transactional public List<Student> findAll() {
 * 
 * Session currentSession =entityManager.unwrap(Session.class);
 * 
 * Query<Student> theQuery =
 * currentSession.createQuery("from Student",Student.class);
 * 
 * List<Student> students=theQuery.getResultList();
 * 
 * return students; }
 * 
 * 
 * }
 */