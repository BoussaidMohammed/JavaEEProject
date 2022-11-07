package org.java.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.java.actions.BiblioActions;
import org.java.dao.AuthorDao;
import org.java.dao.AuthorDaoJdbc;
import org.java.dao.PublisherDao;
import org.java.dao.PublisherDaoJdbc;
import org.java.dao.TitleDao;
import org.java.dao.TitleDaoJdbc;
import org.java.dao.services.BiblioService;
import org.java.dao.services.DefaultBiblioService;
import org.java.jdbc.DataBase;
import org.java.jdbc.MySQLDataSource;


@WebServlet("/docs/*")
public class BiblioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private String prefix = "/views/"; 
	private String suffix = ".jsp";
    private BiblioActions action;
    private ParameterResolver resolver;
    public BiblioServlet() {
        
    }

    @Override
    public void init() throws ServletException {
    	DataBase db = new DataBase(new MySQLDataSource("biblio"));
		AuthorDao authorDao = new AuthorDaoJdbc(db);
		TitleDao titleDao = new TitleDaoJdbc(db);
		PublisherDao publisherDao = new PublisherDaoJdbc(db);
		BiblioService bs = new DefaultBiblioService(authorDao,titleDao, publisherDao);
		resolver = new HttpParameterResolver();
    	action = new BiblioActions(bs, resolver );
    }
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String view = "Error";
		Object model = "resource introuvable";
		String uri = request.getRequestURI();
		
		if(uri.endsWith("/example")) {
			view = action.example();
			model = action.getModel();
		}else if(uri.endsWith("listeDesAuteurs")) {
			view = action.listAuthors();
			model = action.getModel();
		}else if(uri.endsWith("addAuthor")) {
			resolver.setRequest(request);
			view = action.addAuthor();
			model = action.getModel();
		}else if(uri.endsWith("listeTitre")) {
			resolver.setRequest(request);
			view = action.titleList();
			model = action.getModel();
		}
		
		request.setAttribute("model", model);
		request.getRequestDispatcher(prefix + view + suffix).forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
