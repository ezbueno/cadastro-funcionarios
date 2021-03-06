package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DaoListaFuncionario;

@WebServlet("/ListaFuncionarioServlet")
public class ListaFuncionarioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	DaoListaFuncionario daoListaFuncionario = new DaoListaFuncionario();

    public ListaFuncionarioServlet() {
        super();        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			String acao = request.getParameter("acao");
			String funcionario = request.getParameter("func");
			
			if (acao != null && acao.equalsIgnoreCase("listartodos")) {
				RequestDispatcher dispatcher = request.getRequestDispatcher("/listaFuncionarios.jsp");
				request.setAttribute("funcionarios", daoListaFuncionario.listarFuncionario());
				dispatcher.forward(request, response);
			} else if (acao != null && acao.equalsIgnoreCase("delete")) {
				daoListaFuncionario.deletar(funcionario);
				request.setAttribute("msgSalvarExcluir", "Funcionário deletado com sucesso!");
				
				RequestDispatcher dispatcher = request.getRequestDispatcher("/listaFuncionarios.jsp");
				request.setAttribute("funcionarios", daoListaFuncionario.listarFuncionario());
				dispatcher.forward(request, response);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
