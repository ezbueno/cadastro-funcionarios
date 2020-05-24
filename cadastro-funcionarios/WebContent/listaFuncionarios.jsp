<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Lista de Funcionários</title>
<link rel="stylesheet" href="resources/css/cadastro.css">
</head>
<body>
	<div id="topo">
		<br/><h1>Lista de Funcionários</h1><br/><br/>
	</div>
	<br/><br/><br/><br/>
	<h3 id="msgSalvarExcluir">${msgSalvarExcluir}</h3><br/>
	<table class="tabela-funcionarios">

		<thead>
			<tr>
				<th>ID</th>
				<th>Nome</th>
				<th>Cargo</th>
				<th>Salário</th>
				<th>Departamento</th>
				<th>Telefone</th>
				<th>Excluir</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${funcionarios}" var="func">
				<tr>
					<td style="width: 550px"><c:out value="${func.id}"></c:out></td>
					<td style="width: 550px"><c:out value="${func.nome}"></c:out>
					<td style="width: 550px"><c:out value="${func.cargo}"></c:out>
					<td style="width: 550px"><c:out value="${func.salario}"></c:out>
					<td style="width: 550px"><c:out value="${func.departamento}"></c:out>
					<td style="width: 550px"><c:out value="${func.telefone}"></c:out>
					<td style="width: 120px"><a href="ListaFuncionarioServlet?acao=delete&func=${func.id}"><img alt="Excluir" src="resources/img/excluir.png" title="Excluir" width="22px" height="22px" onclick=" return confirm('Deseja realizar a exclusão?')"></a></td>					
				</tr>
			</c:forEach>
	</table>
	<a href="acessoLiberado.jsp" class="back-button"><img src="resources/img/voltar.png" alt="Voltar" width="35px" height="35px" /></a>
</body>
</html>