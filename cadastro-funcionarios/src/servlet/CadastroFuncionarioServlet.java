package servlet;

import java.io.IOException;
import java.math.BigDecimal;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.BeanFuncionario;
import dao.DaoCadastroFuncionario;

@WebServlet("/CadastroFuncionarioServlet")
public class CadastroFuncionarioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private DaoCadastroFuncionario daoCadastroFuncionario = new DaoCadastroFuncionario();

    public CadastroFuncionarioServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
String acao = request.getParameter("acao");
		
		if (acao != null && acao.equalsIgnoreCase("cadastrar")) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("/cadastroFuncionarios.jsp");
			dispatcher.forward(request, response);
			
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id = request.getParameter("id");
		String login = request.getParameter("login");
		String senha = request.getParameter("senha");
		String nome = request.getParameter("nome");
		String salario = request.getParameter("salario");
		String departamento = request.getParameter("departamento");
		String telefone = request.getParameter("telefone");
		String cargo = request.getParameter("cargo");
		
		BeanFuncionario beanFuncionario = new BeanFuncionario();
		
		beanFuncionario.setId((id != null && !id.isEmpty()) ? Long.parseLong(id) : null);
		beanFuncionario.setLogin(login);
		beanFuncionario.setSenha(senha);
		beanFuncionario.setNome(nome);
		
		BigDecimal sal = converter(salario);
		beanFuncionario.setSalario(sal);
		
		beanFuncionario.setDepartamento(departamento);
		beanFuncionario.setTelefone(telefone);
		beanFuncionario.setCargo(cargo);
		
		try {
			if (login != null && !login.isEmpty()) {
				daoCadastroFuncionario.salvar(beanFuncionario);
				request.setAttribute("msgSalvarExcluir", "Funcionário cadastrado com sucesso!");
			}
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("/cadastroFuncionarios.jsp");
			dispatcher.forward(request, response);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private BigDecimal converter(String salario) {
		BigDecimal bigDecimal = new BigDecimal(salario);
		return bigDecimal;
	}
	
}
