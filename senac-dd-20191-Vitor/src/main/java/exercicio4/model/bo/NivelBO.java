package exercicio4.model.bo;

import java.util.ArrayList;

import exercicio4.model.dao.NivelDAO;
import exercicio4.model.vo.NivelVO;

public class NivelBO {
	public ArrayList<NivelVO> consultarNiveisBO(){
		NivelDAO nivelDAO = new NivelDAO();
	return nivelDAO.consultarNiveisDAO();	
	}
}
