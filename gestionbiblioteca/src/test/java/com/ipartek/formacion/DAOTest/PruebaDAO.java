package com.ipartek.formacion.DAOTest;

import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ipartek.formacion.dao.BookDAOImp;
import com.ipartek.formacion.dao.CopyDAOImp;
import com.ipartek.formacion.dao.interfaces.BookDAO;
import com.ipartek.formacion.dao.interfaces.CopyDAO;
import com.ipartek.formacion.dao.persistence.Book;
import com.ipartek.formacion.dao.persistence.Copy;

public class PruebaDAO {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext ctx=new ClassPathXmlApplicationContext("classpath:/spring.xml");
		
		BookDAO bD=ctx.getBean(BookDAOImp.class);
		CopyDAO cD=ctx.getBean(CopyDAOImp.class);
		
		int n=1;
//		Book b=bD.getById(n);
//		List<Copy> cs=b.getCopies();
//		for (Copy copy : cs) {
//			System.out.println(copy.getnPages());
//		}
//		Copy c=cD.getById(n);
//		System.out.println(c.getBook().getTitle());
		
//		Book b=bD.getById(n);
//		System.out.println(b.getTitle());
//		List<Copy>cs=bD.getCopies(1);
//		for (Copy copy : cs) {
//			System.out.println(copy.getPublisher());
//		}
		
		List<Book>bs=bD.getAll();
		for (Book book : bs) {
			System.out.println(book.getTitle());
		
		}
		Book b=bD.getById(2);
		System.out.println(b.getAuthor());
		
		ctx.close();
		

	}

}
