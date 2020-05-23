package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DaoLogin;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	DaoLogin daoLogin = new DaoLogin();

    public LoginServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				
		try {
			String login = request.getParameter("username");
			String senha = request.getParameter("password");
			
			if (login != null && !login.isEmpty() && senha != null && !senha.isEmpty()) {
				if (daoLogin.validarLogin(login, senha)) {
					RequestDispatcher dispatcher = request.getRequestDispatcher("/acessoLiberado.jsp");
					dispatcher.forward(request, response);
				} else {
					RequestDispatcher dispatcher = request.getRequestDispatcher("/acessoNegado.jsp");
					dispatcher.forward(request, response);
				}
			} else {
				RequestDispatcher dispatcher = request.getRequestDispatcher("/index.jsp");
				request.setAttribute("msg", "ATENÇÃO! Favor informar o login e a senha!");
				dispatcher.forward(request, response);
			}
			
		} catch (Exception e) {
			
		}
		
	}

}
