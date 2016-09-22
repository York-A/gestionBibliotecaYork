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
//		Book b=new Book();
//		b.setAuthor("Aldous Huxley");
//		b.setTitle("Un Mundo Feliz");
//		b.setIsbn("1758392648");
//		bD.create(b);
		
		//Book b=bD.getById(n);
		//System.out.println(b.getTitle());
//		Book b=bD.getById(12);
//		Copy c= new Copy();
//		c.setBook(b);
//		c.setnPages(134);
//		c.setPublisher("milagritos");
//		cD.create(c);
		
//		Copy c=cD.getById(3);
//		System.out.println(c.getBook().getTitle());
//		System.out.println(c.getPublisher());
//		
		
		List<Book> bs=bD.getAll();
		
		for (Book book : bs) {
			System.out.println(book.getIdBook());
		}
		
		
		
		ctx.close();
		

	}

}
