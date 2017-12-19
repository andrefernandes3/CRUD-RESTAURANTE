<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<a href="index.jsp">Home</a><br/><br/>
	
	<form name="formulario" method="post" action="MercadoriaServlet?opcao=alterar">
	
			<label>código</label><br>
	<input type="text" id="codigo" name="codigo" value="${mercadoria.codigo}" readonly="readonly"/><br>
	
	<label>tipo</label><br>
	<input type="text" id="tipo" name="tipo" value="${mercadoria.tipo}"/><br>
	
	<label>descrição</label><br>
	<input type="text" id="descricao" name="descricao" value="${mercadoria.descricao}"/><br>
	
	<label>preço</label><br>
	<input type="text" id="preco" name="preco" value="${mercadoria.preco}"/><br>
	
	<button type="submit">Alterar</button>
	
	
	</form>


	
	
	
	

</body>
</html>