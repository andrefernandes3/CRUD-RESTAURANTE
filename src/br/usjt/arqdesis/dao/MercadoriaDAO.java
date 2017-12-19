package br.usjt.arqdesis.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.usjt.arqdesis.model.Mercadoria;

public class MercadoriaDAO {
	
	private Mercadoria mercadoria = new Mercadoria();
	
	public void cadastrar(Mercadoria mercadoria) {
		String sqlInsert = "INSERT INTO mercadoria(id, tipo, descricao, preco) VALUES (?, ?, ?, ?)";
		
		

		
		try (Connection conn = ConnectionFactory.obtemConexao();
			PreparedStatement stm = conn.prepareStatement(sqlInsert);) {
			
			System.out.println("chegou no método cadastrar da mercadoriaDAO");

			
				stm.setInt(1, mercadoria.getCodigo());


				stm.setString(2, mercadoria.getTipo());

				
				stm.setString(3, mercadoria.getDescricao());

				
				
				stm.setDouble(4, mercadoria.getPreco());
				

			

				
				stm.execute();



				
				String sqlQuery = "SELECT LAST_INSERT_ID()";
			try (PreparedStatement stm2 = conn.prepareStatement(sqlQuery);
					ResultSet rs = stm2.executeQuery();) {
				if (rs.next()) {
					mercadoria.setCodigo(rs.getInt(1));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public void alterar(Mercadoria mercadoria) {
		String sqlUpdate = "UPDATE mercadoria SET tipo=?, descricao=?, preco=? WHERE id=?";

		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlUpdate);) {

			stm.setString(1, mercadoria.getTipo());
			stm.setString(2, mercadoria.getDescricao());
			stm.setDouble(3, mercadoria.getPreco());
			stm.setInt(4, mercadoria.getCodigo());
			
			stm.execute();
		} catch (Exception e) {
			
			System.out.println("Depois"); 
			e.printStackTrace();
		}
	}

	public boolean excluir(int id) {
		String sqlDelete = "DELETE FROM mercadoria WHERE id = ?";
		
		int resultado = -1;
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlDelete);) {
			stm.setInt(1, id);
			resultado = stm.executeUpdate();
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		return resultado == 1;
	}
	


	public Mercadoria consultar(Integer codigo) {
		//Mercadoria mercadoria = new Mercadoria();
		//mercadoria.setCodigo(id);
		String sqlSelect = "SELECT * FROM mercadoria WHERE id = ?";
		

		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			stm.setInt(1, codigo);
			try (ResultSet rs = stm.executeQuery();) {
				if (rs.next()) {
					mercadoria.setCodigo(rs.getInt("id"));
					mercadoria.setDescricao(rs.getString("descricao"));
					mercadoria.setPreco(rs.getDouble("preco"));
					mercadoria.setTipo(rs.getString("tipo"));
				} else {
					mercadoria.setCodigo(-1);
					mercadoria.setTipo("");
					mercadoria.setDescricao(null);
					mercadoria.setPreco(-1);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			System.out.print(e1.getStackTrace());
		}
		return mercadoria;
	}

}
