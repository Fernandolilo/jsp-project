# jsp-project
 ´´´
	no metodo doGet,  passando a requisição por parametro = http://localhost:8080/jsp-app/cadastrarProdutoController?descricao=Banana&quantidade=15&preco=90.15

protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		System.out.println("RECEBIDO A REQQUISIÇÃO");
		
		String descricao = request.getParameter("descricao");
		double preco = Double.parseDouble(request.getParameter("preco"));
		int quantidade = Integer.parseInt(request.getParameter("quantidade"));

		System.out.println("Nome: " + descricao);
		System.out.println("Quantidade: " + quantidade);
		System.out.println("Preço: " + preco);
	}


temos esta respota:
RECEBIDO A REQQUISIÇÃO
Nome: Banana
Quantidade: 15
Preço: 90.15

passandoesta informção: 

		String descricao = request.getParameter("descricao");
		double preco = Double.parseDouble(request.getParameter("preco"));
		int quantidade = Integer.parseInt(request.getParameter("quantidade"));

		System.out.println("Nome: " + descricao);
		System.out.println("Quantidade: " + quantidade);
		System.out.println("Preço: " + preco);



 ´´´
