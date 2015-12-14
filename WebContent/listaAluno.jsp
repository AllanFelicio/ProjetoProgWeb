<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"
import="br.com.ProjetoWeb.jdbc.*"
import="br.com.ProjetoWeb.controle.*" 
import="br.com.ProjetoWeb.entidade.AlunoDao"
import="java.sql.ResultSet"
%>

<!DOCTYPE html>
<html>
	<head>		
		<meta charset="ISO-8859-1">
		
		<link rel="stylesheet" type="text/css" href="css/estiloConsulta.css">
		
		<title>Consulta de Aluno</title>

		<style type="text/css">
			body{margin:0; padding:0; background:url("img/bg.jpg") no-repeat; background-size:cover;}

			#header {
			/*background-color:#146DFF;*/
			color:white;
			text-align:center;
			padding:5px;
			}
		</style>
	</head>
	
	<body>
	    <div id="header" align="center">
	    	<header>
	    		<img src="img\logo_fnr.png">
	    	</header>
	    </div>
	
		<div align="center">
	    	<h1>Consulta de Aluno</h1>
	    </div>
	    
	    <a href="http://localhost:8080/ProjetoProgWeb/cadastroAluno.html"><img id="addbig" src="img\addbig.png"></a>
	    <br></br>
	    
	    <div id="pesq">
	    	<center>
	    		<label>
	    		
	    		Pesquisar: 

				</label>
				<input id="pesquisar" type="text" name="pesquisar"  action="" placeholder="Digite o nome do aluno"></input>
				<img id="pesquisarimg" src="img\pesquisar.png"></img>
				
			</center>
			<br/><br/>
		</div>
	    
	    <div class="Subtitulo">
			<h2>Lista de Alunos</h2>
		</div>
	
		<table action="ControleServelet" method="atualizar" border="2" width="100%">
			<thead >
				<tr>
					<th>ID</th>
					<th>Matricula</th>
					<th width="70%">Nome</th>
					<th>Status</th>
					<th>Alterar</th>
					<th>Excluir</th>
				</tr>
			</thead>
			<tbody>
			<%
	           	AlunoDAO alunoD = new AlunoDAO();
	           	ResultSet listaAluno = alunoD.listaAlunos();
	               while( listaAluno.next() ){
	               	out.println("<tr>");
	               	out.println("<td  class=\"textFixed\">"+listaAluno.getString("id")+"</td>");
	               	out.println("<td  class=\"textFixed\">"+listaAluno.getString("matricula")+"</td>");
	               	out.println("<td class=\"text\">"+listaAluno.getString("nome")+"</td>");
	               	out.println("<td class=\"textFixed\">"+listaAluno.getString("status")+"</td>");
	               	out.println("<td class=\"button\"><a href=\"cadastroAluno.jsp?matricula="+listaAluno.getString("matricula")+"\"><img src='img/alterar.png'></a></td>");
	               	out.println("<td class=\"button\"><a href=\"cadastroAluno.jsp?matricula="+listaAluno.getString("matricula")+"\"><img src='img/excluir.png'></a></td>");
	               	out.println("</tr>");
	               }
           	%>
			</tbody>
		</table>
	  
	  	<br/><br/>
		<br/><br/>
		
		<footer>
			<div id="footer" class="rodape">
				<span>&copy Equipe de Autores:</span><br>
				<span>Allan Carlos</span><br>
			   	<span>Danilo Correia</span><br>
			   	<span>Elízio Neto</span><br>
				<span>Joanna Maressith</span><br>
				<span>2015 - Faculdade Nova Roma - Todos os Direitos Reservados</span>
			</div><!-- Fim do Rodapé -->
		</footer>
	</body>
</html>