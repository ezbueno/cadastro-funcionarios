<%@page import="dao.DaoLogin"%>
<%@page import="beans.BeanFuncionario"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="resources/css/cadastro.css">
</head>
<body>
	<div id="topo">
		<h1>Cadastro de Funcionários</h1>
	</div>
	<div id="menu_lateral">
		<ul>
			<li><a href="especialidade.jsp">Especialidades</a></li>
			<li><a href="contato.jsp">Contato</a></li>
			<li><a href="FuncionarioServlet?acao=listartodos">Listar</a></li>
			<li><a href="index.jsp">Sair</a></li>
		</ul>
	</div>
	
	<div class="paragrafo">
		<p>
		</p>
		<br/><br/>
		<div>
			<!-- <img class="img_clinica" src="resources/img/saudacao.png" /> -->
			<h3 class="img_clinica">Bem-Vindo ao Sistema,
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
	</div>
	<div id="rodape">
		Todos os direitos reservados © 2020<br> 
		Desenvolvido por Ezandro Bueno
	</div>
</body>
</html>