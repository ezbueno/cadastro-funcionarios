package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import beans.BeanFuncionario;
import connection.SingleConnection;

public class DaoCadastroFuncionario {
	
	private Connection connection;
	
	public DaoCadastroFuncionario() {
		connection = SingleConnection.getConnection();
	}

	public boolean validarLogin(String login) throws SQLException {
		String sql = "select count(1) as qtdLogin from funcionario where login = '" + login + "'";
		PreparedStatement statement = connection.prepareStatement(sql);
		ResultSet resultSet = statement.executeQuery();
		
		if (resultSet.next()) {
			return resultSet.getInt("qtdLogin") <= 0; 
		}
		
		return false;
	}

	public void salvar(BeanFuncionario beanFuncionario) {
		try {
			String sql = "insert into funcionario(nome, cargo, salario, departamento, telefone, login, senha) values (?, ?, ?, ?, ?, ?, ?)";
			PreparedStatement insert = connection.prepareStatement(sql);
			insert.setString(1, beanFuncionario.getNome());
			insert.setString(2, beanFuncionario.getCargo());
			insert.setBigDecimal(3, beanFuncionario.getSalario());
			insert.setString(4, beanFuncionario.getDepartamento());
			insert.setString(5, beanFuncionario.getTelefone());
			insert.setString(6, beanFuncionario.getLogin());
			insert.setString(7, beanFuncionario.getSenha());
			insert.execute();
			connection.commit();
		} catch (Exception e) {
			e.printStackTrace();
			try {
				connection.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}	
	}
}
