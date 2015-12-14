<%@page import="java.sql.ResultSet"%>
<%@ page
language="java"
contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"
import="br.com.ProjetoWeb.jdbc.AlunoDAO"
%>
<%
String cpf = request.getParameter("cpf");

AlunoDAO  aluD = new AlunoDAO(); 
boolean cadaluno = aluD.removeAluno(cpf);
System.out.println(cadaluno);
if(cadaluno) {
	String msg = "Dados Removidos con sucesso.";
	response.sendRedirect("alunos.jsp?m="+msg);
} else {
	String erro = "Dados não removidos, tente novamente.";
	response.sendRedirect("alunos.jsp?&e="+erro);
}
%>