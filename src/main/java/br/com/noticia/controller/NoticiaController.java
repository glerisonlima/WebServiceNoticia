package br.com.noticia.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;

import javax.inject.Inject;
import javax.servlet.ServletContext;

import org.apache.commons.io.IOUtils;
import org.hibernate.annotations.Parameter;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.observer.upload.UploadedFile;
import br.com.caelum.vraptor.view.Results;
import br.com.noticia.entidade.Noticia;
import br.com.noticia.repository.NoticiaRepository;

@Controller
public class NoticiaController {
	private static final String url = "http://localhost:8080/WebServiceNoticia/imgNoticia/";
	@Inject
	private Result result;
	@Inject
	private NoticiaRepository noticiaRepositoriy;

	@Get("/noticia/formulario")
	public void formulario(){}
	
	@Post("/noticia/cadastrar")
	public void cadastrar(Noticia noticia, UploadedFile file, ServletContext context) throws FileNotFoundException, IOException{
		String caminhoImagens = context.getRealPath("/imgNoticia/");
		File caminho = new File(caminhoImagens);
		if(!caminho.exists()){
			caminho.mkdir();
		}
		File picture = new File(caminhoImagens+file.getFileName());		
		IOUtils.copyLarge(file.getFile(), new FileOutputStream(picture));
		
		// Data atual 
		Calendar c = Calendar.getInstance();
		Date data = c.getTime();
		
		noticia.setDataNoticia(data);		
		noticia.setImagem(url+file.getFileName());
		
		noticiaRepositoriy.salvar(noticia);
		result.include("mensagem", "Gravado com sucesso!");
		result.redirectTo(NoticiaController.class).formulario();
	}
	
	@Get("/noticia/listaTodos")
	public void listarTodos(){
		result.use(Results.json()).withoutRoot().from(noticiaRepositoriy.Lista()).serialize();
	} 
	
	@Get("/noticia/lista/{categoria}")
	public void listarCategoria(String categoria){
		result.use(Results.json()).withoutRoot().from(noticiaRepositoriy.listaByCategoria(categoria)).serialize();;
	}
	
}
