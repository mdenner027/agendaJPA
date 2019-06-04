<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<c:import url="cabecalho.html"></c:import>

	<table id="table-1" border="1">
		<thead>
			<tr>
				<th>Id</th>
				<th>Nome</th>
				<th>Email</th>
				<th>Endere�o</th>
				<th>Data de Nascimento</th>
				<th>Alterar</th>
				<th>Excluir</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${contatos}" var="contato">
				<tr>
					<td align="center">${contato.id}</td>
					<td align="left">${contato.nome}</td>
					<td align="left">${contato.email}</td>
					<td align="left">${contato.endereco}</td>
					<td align="center"><fmt:formatDate
							value="${contato.dataNascimento.time}" pattern="dd/MM/yyyy" />
					<td align="center"><a
						href="controlador?logica=GetContato&id=${contato.id}">Alterar</a></td>
					<td align="center"><a
						href="controlador?logica=RemoverContato&id=${contato.id}">Excluir</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<hr>
	<a href="controlador?logica=ListaContatos"><button value="Atualizar">Atualizar</button></a>
	<a href="index.html"><button value="Voltar">Voltar</button></a>
</body>
</html>