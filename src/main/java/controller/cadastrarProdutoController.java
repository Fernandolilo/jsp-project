package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class cadastrarProdutoController
 */
@WebServlet("/cadastrarProdutoController")
public class cadastrarProdutoController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public cadastrarProdutoController() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		System.out.println("RECEBIDO A REQQUISIÇÃO");

		// agora passando um parametro mais semantico, como os dados são iguais, apenas
		// preciso pegar o doPost.

		this.doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		String descricao = request.getParameter("descricao");
		double preco;
		int quantidade;
		String mensagem;
		//redirecionando caso tudo ocorra com sucesso!
		RequestDispatcher dispatcher = request.getRequestDispatcher("cadastrarProduto.jsp");

		if (
				descricao != null && !descricao.isEmpty() 
				&& request.getParameter("quantidade") != null
				&& !request.getParameter("quantidade").isEmpty() 
				&& request.getParameter("preco") != null
				&& !request.getParameter("preco").isEmpty()) {

			quantidade = Integer.parseInt(request.getParameter("quantidade"));
			preco = Double.parseDouble(request.getParameter("preco"));

			/*System.out.println("Nome: " + descricao);
			System.out.println("Quantidade: " + quantidade);
			System.out.println("Preço: " + preco);*/
			boolean online = false;
			if (request.getParameter("online") != null && request.getParameter("online").equals("on")) {
				online = true;
				//System.out.println("Disponivel: " + online);			
			} 
			mensagem ="Produto cadastrado com sucesso!";
			
			request.setAttribute("mensagem", mensagem);
						
			//para que o dispatcher atue precisamos do forward desta forma
			dispatcher.forward(request, response);
			}else {
				mensagem = "Os campos precisão ser todos preenchidos!";
				request.setAttribute("mensagem", mensagem);		
				
				//para que o dispatcher atue precisamos do forward desta forma
				dispatcher.forward(request, response);

		}

	}

}
