<%@page import="com.sun.org.apache.xalan.internal.xsltc.compiler.Parser"%>
<%@ page
language="java"
contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"
import="java.sql.Date"
import="java.text.DateFormat"
import="java.text.SimpleDateFormat"
import="br.com.ProjetoWeb.jdbc.AlunoDAO"
%>
<%

String nome = request.getParameter("nome");
String senha = request.getParameter("senha");
String matricula = request.getParameter("matricula");
String rg = request.getParameter("rg");
String cpf = request.getParameter("cpf");
String email = request.getParameter("email");
String sexo = request.getParameter("sexo");
String pais = request.getParameter("pais");
String estado = request.getParameter("estado");
String escolaridade = request.getParameter("escolaridade");
String curso = request.getParameter("curso");
String turno = request.getParameter("turno");

AlunoDAO alunoD = new AlunoDAO();

	alunoD.inserirAluno(nome, senha, matricula, rg, cpf, email, sexo, pais, estado, escolaridade, curso, turno);
		
			String msg = "Dados inseridos com sucesso.";
			alunoD.listaAlunos();
			
			System.out.println(nome);
			response.sendRedirect("alunos.jsp?m="+msg);
			
%>