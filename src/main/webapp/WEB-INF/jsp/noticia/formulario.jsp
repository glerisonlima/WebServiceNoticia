<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Formulario de Cadastro</title>
</head>
<body>	
	<div>
		<h3>${mensagem}</h3>
	</div>
	<form action="${linkTo[NoticiaController].cadastrar}" method="post" enctype="multipart/form-data">
		Titulo:<br> <input type="text" name="noticia.titulo" /><br>
		Subtitulo:<br> <input type="text" name="noticia.subtitulo" /><br>
		Categoria: 
		<select name="noticia.categoria">
			<option value="syspdv">SYSPDV</option>
			<option value="varejo">VAREJO FACIL</option>
			<option value="milenio">MILENIO</option>
			<option value="easy">EASY@SSYST</option>
		</select><br>
		Descrição:<br> <textarea name="noticia.descricao" rows="10" cols="100"></textarea><br>	
		<input type="file"  name="file"/><br>
		<button type="submit" >Cadastrar Noticia</button>
	</form>
	<a href="${linkTo[NoticiaController].listarTodos}">Mostra Lista Json</a>
</body>
</html>