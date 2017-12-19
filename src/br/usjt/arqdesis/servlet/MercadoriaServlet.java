package br.usjt.arqdesis.servlet;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.usjt.arqdesis.model.Mercadoria;
import br.usjt.arqdesis.service.MercadoriaService;

/**
 * Servlet implementation class MercadoriaServlet
 */
@WebServlet("/MercadoriaServlet")
public class MercadoriaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private Mercadoria mercadoria;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MercadoriaServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		Integer codigoMercadoria = Integer.parseInt(request.getParameter("codigo"));

		String opcao = request.getParameter("opcao");
		
		System.out.println(opcao);
		
		MercadoriaService service = new MercadoriaService();
		
		

			switch (opcao){
				case "Cadastrar": 
					try {
						int codigo =Integer.parseInt(request.getParameter("codigo"));
						String tipo = request.getParameter("tipo");
						String descricao =request.getParameter("descricao");
						double preco =Double.parseDouble(request.getParameter("preco"));
						
						mercadoria = new Mercadoria(codigo, tipo, descricao, preco);
						
						service.cadastrar(mercadoria);
						
						request.setAttribute("sucesso", "Cardapio: " + mercadoria.getDescricao() + " cadastrada com sucesso");
					
					} catch (Exception e) {
						// TODO: handle exception
					} finally {
						request.getRequestDispatcher("index.jsp").forward(request, response);
					}
					
					

					break; 
				case "Consultar":
					
					try {
						mercadoria = service.consultar(codigoMercadoria);
						 
						 request.setAttribute("mercadoria", mercadoria);
					} catch (Exception e) {
						request.setAttribute("Mensagem", e.getMessage());
					} finally {
						request.getRequestDispatcher("exibirMercadoria.jsp").forward(request, response);
					}
					 
					 
					

					break; 
				case "alterar":
					
					try {
						Integer codigo = Integer.parseInt(request.getParameter("codigo"));
						String tipo = request.getParameter("tipo");
						String descricao = request.getParameter("descricao");
						Double preco = Double.parseDouble(request.getParameter("preco"));
						
						mercadoria = new Mercadoria(codigo, tipo, descricao, preco);

						service.alterar(mercadoria);
						
						request.setAttribute("alterar", "Mercadoria: " + mercadoria.getDescricao() + " Alterarda com sucesso");
						
					} catch (Exception e) {
						// TODO: handle exception
					} finally {
						request.getRequestDispatcher("index.jsp").forward(request, response);
					}
					
					break; 	
					
				case "Remover": 
					
					
					try {
						
						
						boolean excluiu = service.excluir(codigoMercadoria);
						
						if(!excluiu){
							System.out.println("mercadoria não encontrada");
						}
						
					
					} catch (Exception e) {
						// TODO: handle exception
					} finally {
						request.getRequestDispatcher("index.jsp").forward(request, response);
					}
					
					break; 
					

					
					
			}

	}

}
