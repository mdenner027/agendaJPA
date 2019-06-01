<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Alterar Contato</h1>
	<hr> 
	<form method="get" action="controlador">
	<input type="text" name="logica" value="AlteraContato" readonly="readonly" hidden="hidden">
		<input type="text" value="${contato.id}" readonly="readonly" name="id" hidden="hidden">
		<label>
			Nome: <input type="text" value="${contato.nome}" name="nome">
		</label>
		<br>
		<label>
			Email: <input type="email" value="${contato.email}" name="email">
		</label>
		<br>
		<label>
			Endereço: <input type="text" value="${contato.endereco}" name="endereco">
		</label>
		<br>
		<label>
			Data de Nascimento: <input type="date" max="2018-01-01" name="dataNascimento"
			 value='<fmt:formatDate value="${contato.dataNascimento.time}" pattern="yyyy-MM-dd"/>'>
		</label>
		<br>
		<a href="controlador?logica=ListaContatos"><input type="button" value="Voltar"></a>
		<input type="submit" value="Alterar">		
	</form>
	<footer>
		<c:import url="rodape.html"></c:import>
	</footer>
</body>
</html>