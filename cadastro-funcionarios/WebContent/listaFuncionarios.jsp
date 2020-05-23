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
	<table class="tabela-funcionarios">
	<caption><strong>Lista de Funcionários</strong><br/><br/></caption>
		<thead>
			<tr>
				<th>ID</th>
				<th>Nome</th>
				<th>Cargo</th>
				<th>Salário</th>
				<th>Departamento</th>
				<th>Telefone</th>
				<th>Excluir</th>
				<th>Editar</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${funcionarios}" var="func">
				<tr>
					<td style="width: 280px"><c:out value="${func.id}"></c:out></td>
					<td style="width: 280px"><c:out value="${func.nome}"></c:out>
					<td style="width: 280px"><c:out value="${func.cargo}"></c:out>
					<td style="width: 280px"><c:out value="${func.salario}"></c:out>
					<td style="width: 280px"><c:out value="${func.departamento}"></c:out>
					<td style="width: 280px"><c:out value="${func.telefone}"></c:out>
					<td style="width: 280px"><a href="FuncionarioServlet?acao=delete&funcionario=${func.id}"><img alt="Excluir" src="resources/img/excluir.png" title="Excluir" width="22px" height="22px" onclick=" return confirm('Deseja realizar a exclusão?')"></a></td>
					<td style="width: 280px"><a href="FuncionarioServlet?acao=editar&user=${func.id}"><img alt="Editar" src="resources/img/editar.png" title="Editar" width="22px" height="22px"></a></td>
				</tr>
			</c:forEach>
	</table>
	<a href="acessoLiberado.jsp" class="back-button"><img src="resources/img/voltar.png" alt="Voltar" width="35px" height="35px" /></a>
</body>
</html>