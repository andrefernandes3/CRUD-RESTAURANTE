package br.usjt.arqdesis.service;

import br.usjt.arqdesis.dao.MercadoriaDAO;
import br.usjt.arqdesis.model.Mercadoria;

public class MercadoriaService {
	
	public MercadoriaService(){
		
	}
	
	MercadoriaDAO dao = new MercadoriaDAO();


	
	public void cadastrar(Mercadoria mercadoria)
	{
		
		dao.cadastrar(mercadoria);

	}
	
	
	
	public void alterar(Mercadoria mercadoria)
	{
		dao.alterar(mercadoria);

	}
	
	public boolean excluir(int id)
	{
		return dao.excluir(id);
	}
	
	public Mercadoria consultar(Integer codigo)
	{
		return dao.consultar(codigo);
	}


}
