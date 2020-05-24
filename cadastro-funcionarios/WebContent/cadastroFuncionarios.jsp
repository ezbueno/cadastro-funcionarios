<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Cadastro</title>
<link rel="stylesheet" href="resources/css/cadastro.css">
</head>
<body>
	<div id="topo">
		<br/><h1>Cadastro de Funcionários</h1>
	</div>
	<h3 id="msgSalvarExcluir">${msgSalvarExcluir}</h3><br/>
	<br/><br/>
	<form action="CadastroFuncionarioServlet" method="post" onsubmit="return validarCampos() ? true : false">
		<ul class="form-style-1">
			<li>
				<table class="minhatabela">
					<tr>
						<td>Código:</td>
						<c:if test="${func.id == null}">
							<td><input type="text" readonly="readonly" id="id" name="id" style="background-color: #DCDCDC" onclick="alert('Campo de preenchimento automático.')"
								style="width: 300px" value="${func.id}" class="field-long"></td>
						</c:if>
						
						<c:if test="${func.id != null}">
							<td><input type="text" readonly="readonly" id="id" name="id" style="background-color: #DCDCDC" onclick="alert('Não é permitido alterar o código do usuário.')"
								style="width: 300px" value="${func.id}" class="field-long"></td>
						</c:if>
							
						<td>Salário:</td>
						<td><input type="text" id="salario" name="salario"
							style="width: 300px" value="${func.salario}" maxlength="10" class="field-long"></td>	
					</tr>

					<tr>
						<td>Login:</td>
						<td><input type="text" id="login" name="login"
							style="width: 300px" value="${func.login}" maxlength="10" class="field-long"></td>
							
						<td>Departamento:</td>
						<td><input type="text" id="departamento" name="departamento"
							style="width: 300px" value="${func.departamento}" maxlength="50" class="field-long"></td>	
					</tr>
					
					<tr>
						<td>Senha:</td>
						<td><input type="password" id="senha" name="senha"
							style="width: 300px" value="${func.senha}" maxlength="10" class="field-long"></td>
							
						<td>Telefone:</td>
						<td><input type="text" id="telefone" name="telefone"
							style="width: 300px" value="${func.telefone}" maxlength="20" class="field-long"></td>	
					</tr>
					 
					<tr>
						<td>Nome:</td>
						<td><input type="text" id="nome" name="nome"
							style="width: 300px" value="${func.nome}" maxlength="50" class="field-long"></td>
							
						<td>Cargo:</td>
						<td><input type="text" id="cargo" name="cargo"
							style="width: 300px" value="${func.cargo}" maxlength="50" class="field-long"></td>
					</tr>																	
				</table>
								
				<br/>
				
				<div id="botao">
					<input type="submit" value="Salvar" class="botaoSalvar" />
					<a href="acessoLiberado.jsp"><input type="button" value="Voltar" class="botaoCancelar" /></a>
				</div>
			</li>
		</ul>
	</form>
	<script type="text/javascript">
			function validarCampos() {
				if (document.getElementById("login").value == "") {
					alert("ATENÇÃO! Informe o login!");
					return false;
				} else if (document.getElementById("senha").value == "") {
					alert("ATENÇÃO! Informe a senha!");
					return false;
				} else if (document.getElementById("nome").value == "") {
					alert("ATENÇÃO! Informe o nome!");
					return false;
				} else if (document.getElementById("salario").value == "") {
					alert("ATENÇÃO! Informe o salário!");
					return false;
				} else if (document.getElementById("departamento").value == "") {
					alert("ATENÇÃO! Informe o departamento!");
					return false;
				} else if (document.getElementById("telefone").value == "") {
					alert("ATENÇÃO! Informe o telefone!");
					return false;
				} else if (document.getElementById("cargo").value == "") {
					alert("ATENÇÃO! Informe o cargo!");
					return false;
				}
				return true;
			}
	</script>		
</body>
</html>