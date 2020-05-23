package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DaoFuncionario;

@WebServlet("/FuncionarioServlet")
public class FuncionarioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	DaoFuncionario daoFuncionario = new DaoFuncionario();

    public FuncionarioServlet() {
        super();        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			String acao = request.getParameter("acao");
			
			if (acao != null && acao.equalsIgnoreCase("listartodos")) {
				RequestDispatcher dispatcher = request.getRequestDispatcher("/listaFuncionarios.jsp");
				request.setAttribute("funcionarios", daoFuncionario.listarFuncionario());
				dispatcher.forward(request, response);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
