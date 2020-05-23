package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import beans.BeanFuncionario;
import connection.SingleConnection;

public class DaoLogin {
	
	private Connection connection;
	
	public DaoLogin() {
		connection = SingleConnection.getConnection();
	}
	
	public boolean validarLogin(String login, String senha) throws SQLException {
		String sql = "select * from funcionario where login = '" + login + "'" + "and senha = '" + senha + "'";
		PreparedStatement statement = connection.prepareStatement(sql);
		ResultSet resultSet = statement.executeQuery();
		
		if (resultSet.next()) {
			return true;
		} else {
			return false;
		}
	}
	
	public String buscarNome(String login) {
				
		try {
			String sql = "select nome from funcionario where login = '" + login + "'";
			PreparedStatement statement = connection.prepareStatement(sql);
			ResultSet resultSet = statement.executeQuery();
			
			if(resultSet.next()) {
				BeanFuncionario beanFuncionario = new BeanFuncionario();
				String nome = resultSet.getString("nome");
				beanFuncionario.setNome(nome);
				
				return beanFuncionario.getNome();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
}
