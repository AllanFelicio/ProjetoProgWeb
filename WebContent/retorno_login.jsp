<%@ page
language="java"
contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"
import = "br.com.ProjetoWeb.jdbc.AlunoDAO"
%>

<%
String matricula = request.getParameter("matricula");
String senha = request.getParameter("senha");

if( ( !matricula.equals("") ) && ( !senha.equals("") ) ){
	
	AlunoDAO aluno = new AlunoDAO();
	
	if( aluno.verificarAluno(matricula, senha) ){
		session.setAttribute("matricula",matricula);
		session.setAttribute("senha",senha);
		response.sendRedirect("consultaAluno.jsp");
	}else{
		String erro = "Matricula e/ou Senha n�o cadastrados!";
		response.sendRedirect("index.jsp?e="+erro);
	}
	
}else{
	String erro = "Matricula e/ou Senha inv�lidos!";
	response.sendRedirect("index.jsp?e="+erro);
}
%>