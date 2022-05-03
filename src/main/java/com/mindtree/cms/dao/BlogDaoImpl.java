/**
 * 
 */
package com.mindtree.cms.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mindtree.cms.model.BlogComments;
import com.mindtree.cms.model.BlogContent;

/**
 * @author ramki2711
 *
 */
@Repository
public class BlogDaoImpl implements BlogDao {

	@Autowired
	private SessionFactory sessionFactory;

	public void save(BlogContent blogContent) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.openSession();
		session.saveOrUpdate(blogContent);
		System.out.print(sessionFactory);
	}

	@SuppressWarnings("unchecked")
	public List<BlogContent> findAll() {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.openSession();
		List<BlogContent> list = session.createQuery("from BlogContent").list();
		return list;
	}

	@SuppressWarnings("unchecked")
	public List<BlogComments> findAllBlogComments(int blogId) {
		Session session = this.sessionFactory.openSession();
		List<BlogComments> list = session.createQuery("from BlogComments where blogContent.blogId=:blogId")
				.setParameter("blogId", blogId).list();
		return list;

	}

	public void saveBlogComments(BlogComments blogComments) throws Exception{
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.openSession();
		session.save(blogComments);
	}

	public BlogContent findAllBlogContent(int blogId) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.openSession();
		BlogContent blogContent = (BlogContent) session.createQuery("from BlogContent where blogId=:blogId")
				.setParameter("blogId", blogId).uniqueResult();
		return blogContent;
	}

}
