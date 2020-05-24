<%@page import="dao.DaoLogin"%>
<%@page import="beans.BeanFuncionario"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home</title>
<link rel="stylesheet" href="resources/css/cadastro.css">
</head>
<body>
	<div id="topo">
	</div>
	<div id="menu_lateral">
		<ul>
			<li><a href="CadastroFuncionarioServlet?acao=cadastrar">Cadastro</a></li>
			<li><a href="ListaFuncionarioServlet?acao=listartodos">Listar</a></li>
			<li><a href="index.jsp" onclick="return confirm ('Deseja realmente Sair do sistema?')">Sair</a></li>
		</ul>
	</div>
	
		<br/><br/>
		<div>
			<h3 class="bem-vindo">Bem-Vindo ao Sistema,
				<%
					String login = request.getParameter("username");
					
					if (login != null) {
						DaoLogin daoLogin = new DaoLogin();
						String nome = daoLogin.buscarNome(login);
						session.setAttribute("nome", nome);
						out.print(nome + " !");
					} else {
						out.print(session.getAttribute("nome") + " !");
					}
				%>
			</h3>
		</div>
	<div id="rodape">
		<br/>Todos os direitos reservados © 2020<br/> 
		Desenvolvido por Ezandro Bueno
	</div>
</body>
</html>