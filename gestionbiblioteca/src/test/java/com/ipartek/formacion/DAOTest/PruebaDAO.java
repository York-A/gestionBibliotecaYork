package com.ipartek.formacion.DAOTest;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ipartek.formacion.dao.BookDAOImp;
import com.ipartek.formacion.dao.interfaces.BookDAO;
import com.ipartek.formacion.dao.persistence.Book;

public class PruebaDAO {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext ctx=new ClassPathXmlApplicationContext("classpath:/spring.xml");
		
		BookDAO bD=ctx.getBean(BookDAOImp.class);
		
		
		Book b=new Book();
		b.setAuthor("Aldous Huxley");
		b.setTitle("Un Mundo Feliz");
		b.setIsbn("1758392648");
		bD.create(b);
		
//		Book b=bD.getById(1);
//		System.out.println(b.getTitle());
//		ctx.close();
		

	}

}
