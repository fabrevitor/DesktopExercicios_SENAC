package exercicio4.model.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import exercicio4.model.vo.NivelVO;

public class NivelDAO {

	public ArrayList<NivelVO> consultarNiveisDAO() {
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		ResultSet resultado = null;
		ArrayList<NivelVO> listaNiveis = new ArrayList<NivelVO>();
		
		String query = "SELECT * FROM NIVEL";
		try {
			resultado = stmt.executeQuery(query);
			while(resultado.next()) {
				NivelVO nivelVO = new NivelVO();
				nivelVO.setId(resultado.getInt("ID_NIVEL"));
				nivelVO.setDescricao(resultado.getString("DESCRICAO"));
				listaNiveis.add(nivelVO);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Erro ao listar níveis!");
			e.printStackTrace();
		} finally {
			Banco.closeResultSet(resultado);
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}
		
		return listaNiveis;
	}
	public NivelVO consultarPorId(int idNivel) {
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		ResultSet resultado = null;
		NivelVO nivel = new NivelVO();
		
		String query = "SELECT * FROM NIVEL WHERE ID_NIVEL";
		
		try {
			resultado = stmt.executeQuery(query);
			
			while(resultado.next()) {
				//Construir o nivel com os dados do resultSet
			}
			
		} catch (SQLException e) {
			System.out.println("Erro ao consultar nível por Id");
			e.printStackTrace();
		} finally {
			Banco.closeResultSet(resultado);
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}
		return nivel;
	}
}
