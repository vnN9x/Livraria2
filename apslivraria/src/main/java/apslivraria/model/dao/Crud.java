package apslivraria.model.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import apslivraria.entidades.Autor;
import apslivraria.entidades.Editora;
import apslivraria.entidades.Livro;
import apslivraria.model.Model;

public class Crud implements Model{
	//variaveis utilizada em todas as funções para abrir/fechar o banco 
	 EntityManagerFactory factory = 
		      Persistence.createEntityManagerFactory("Livraria");
	 EntityManager manager = factory.createEntityManager();
	
	//METODO PRECISA SER CHAMADO NO COMEÇO DO PROGRAMA, abre a conexão
	public SessionFactory getCurrentSessionFromJPA() {
		  Session session = manager.unwrap(org.hibernate.Session.class);
		  SessionFactory SeFactory = session.getSessionFactory();
		  return SeFactory;
		}	
	
	//adiciona um objeto livro no banco de dados
	public void addLivro(Livro livro, List <Long> autoresId, long idEditora) {
		Session session = getCurrentSessionFromJPA().openSession();
		Transaction tx = null;
		Editora editora = null;
		Autor autor = null;
		try {
			tx = session.beginTransaction();
			List <Autor> autores = new ArrayList<Autor>();
			List <Livro> livros = new ArrayList<Livro>();
			livros.add(livro);
			for (Long autors: autoresId) {
				autor = getAutorById(autors);
				autores.add(autor);
				autor.setLivros(livros);
				session.update(autor);
			}
			editora = getEditoraById(idEditora);
			editora.setLivros(livros);
			livro.setAutores(autores);
			livro.setEditora(editora);
			session.update(editora);
			session.persist(livro);
			tx.commit();
		}catch(Exception e) {
			if (tx!= null) tx.rollback();
			e.printStackTrace();
		}finally {
			session.close();
		}
	}
	
	//adiciona um objeto editora no banco de dados.
	public void addEditora(Editora editora) {
		Session session = getCurrentSessionFromJPA().openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.persist(editora);
			tx.commit();
		}catch(Exception e) {
			if (tx!=null) tx.rollback();
			e.printStackTrace();
		}finally {
			session.close();
		}
	}
	
	//adiciona um objeto autor no banco de dados
	public void addAutor(Autor autor) {
		Session session = getCurrentSessionFromJPA().openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.persist(autor);
			tx.commit();
		}catch(Exception e) {
			if(tx!=null) tx.rollback();
			e.printStackTrace();
		}finally {
			session.close();
		}
	}
	
	//lista todos os livros
	@SuppressWarnings("unchecked")
	public List <Livro> findAllBooks() {
		Query q = manager.createQuery("SELECT livro FROM Livro livro");
		List<Livro> livros = q.getResultList();
		manager.getTransaction();
        return livros;
	}
	
	@SuppressWarnings("unchecked")
	public List <Autor> findAllAuthors() {
		Query q = manager.createQuery("SELECT autor FROM Autor autor");
		List<Autor> autores = q.getResultList();
		manager.getTransaction();
        return autores;
	}
	
	@SuppressWarnings("unchecked")
	public List <Editora> findAllPublishers() {
		Query q = manager.createQuery("SELECT editora FROM Editora editora");
		List<Editora> editoras = q.getResultList();
		manager.getTransaction();
        return editoras;
	}
	
	public Livro getLivroById(final String id) {
        return manager.find(Livro.class, id);
    }
	
	public Autor getAutorById(final long id) {
		return manager.find(Autor.class, id);
	}
	
	public Editora getEditoraById(final long id) {
        return manager.find(Editora.class, id);
    }
	
	//muda algumas informações de um objeto livro ja existente
	public void updateLivro(String isbn, String titulo, double preco) {
		Session session = getCurrentSessionFromJPA().openSession();
		Transaction tx = null;
		Livro livro = null;
		try {
			tx = session.beginTransaction();
			livro = getLivroById(isbn);
			livro.setPreco(preco);
			livro.setTitulo(titulo);
			session.update(session.contains(livro) ? livro : session.merge(livro));
			tx.commit();
		}catch(Exception e) {
			if (tx != null)	tx.rollback();
			e.printStackTrace();
		}finally {
			session.close();
		}
	}
	
	public void updateAutor(long id, String nome, String sobrenome) {
		Session session = getCurrentSessionFromJPA().openSession();
		Transaction tx = null;
		Autor autor = null;
		try {
			tx = session.beginTransaction();
			autor = getAutorById(id);
			autor.setNome(nome);
			autor.setSobrenome(sobrenome);
			session.update(session.contains(autor) ? autor : session.merge(autor));
			tx.commit();
		}catch(Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		}finally {
			session.close();
		}
	}
	
	public void updateEditora(long id, String nome, String site) {
		Session session = getCurrentSessionFromJPA().openSession();
		Transaction tx = null;
		Editora editora = null;
		try {
			tx = session.beginTransaction();
			editora = getEditoraById(id);
			editora.setNome(nome);
			editora.setSite(site);
			session.update(session.contains(editora) ? editora : session.merge(editora));
			tx.commit();
		}catch(Exception e) {
			if (tx != null) tx.rollback();
			e.printStackTrace();
		}finally {
			session.close();
		}
	}
	
	//deleta um objeto livro do banco de dados
	public void deleteLivro(String isbn) {
		Session session = getCurrentSessionFromJPA().openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.remove(session.contains(getLivroById(isbn)) ? getLivroById(isbn) : session.merge(getLivroById(isbn)));
			tx.commit();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
	}
	
	public void deleteAutor(long id) {
		Session session = getCurrentSessionFromJPA().openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.remove(session.contains(getAutorById(id)) ? getAutorById(id) : session.merge(getAutorById(id)));
			tx.commit();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
	}
	
	public void deleteEditora(long id) {
		Session session = getCurrentSessionFromJPA().openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.remove(session.contains(getEditoraById(id)) ? getEditoraById(id) : session.merge(getEditoraById(id)));
			tx.commit();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
	}
}