package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import beans.BeanFuncionario;
import connection.SingleConnection;

public class DaoFuncionario {
	
	private Connection connection;
	
	public DaoFuncionario() {
		connection = SingleConnection.getConnection();
	}
	
	public List<BeanFuncionario> listarFuncionario() throws SQLException {
		List<BeanFuncionario> beanFuncionario = new ArrayList<BeanFuncionario>();
		
		String sql = "select * from funcionario";
		PreparedStatement statement = connection.prepareStatement(sql);
		ResultSet resultSet = statement.executeQuery();
		
		while(resultSet.next()) {
			BeanFuncionario funcionario = new BeanFuncionario();
			funcionario.setId(resultSet.getLong("id"));
			funcionario.setNome(resultSet.getString("nome"));
			funcionario.setCargo(resultSet.getString("cargo"));
			funcionario.setSalario(resultSet.getBigDecimal("salario"));
			funcionario.setDepartamento(resultSet.getString("departamento"));
			funcionario.setTelefone(resultSet.getString("telefone"));
			beanFuncionario.add(funcionario);
		}
		return beanFuncionario;
	}

}
