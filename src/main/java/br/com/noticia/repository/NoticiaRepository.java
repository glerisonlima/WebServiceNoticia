package br.com.noticia.repository;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import br.com.noticia.entidade.Noticia;


@RequestScoped
public class NoticiaRepository {

	@Inject
	private Session session;
	
	private Criteria createCriteria(){
		return session.createCriteria(Noticia.class);
	}
	
	@SuppressWarnings("unchecked")
	public List<Noticia> Lista(){
		return createCriteria().list();
	}
	
	public void salvar(Noticia noticia){
		session.save(noticia);
	}
	
	@SuppressWarnings("unchecked")
	public List<Noticia> listaByCategoria(String categoria){	
		Query lista = session.createQuery("select n from Noticia n where n.categoria =:pcategoria").setParameter("pcategoria", categoria);
	
		return lista.list();
	}
}
