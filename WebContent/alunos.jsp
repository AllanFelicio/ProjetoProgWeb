<%@
page
language="java"
contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"
import="java.sql.ResultSet"
import="br.com.ProjetoWeb.jdbc.AlunoDAO"
%>
<%
String matricula = (String)session.getAttribute("matricula");
String senha = (String)session.getAttribute("senha");

if( ( !matricula.equals("") ) && ( !senha.equals("") ) ){
	
	AlunoDAO ud = new AlunoDAO();
	
	if( !ud.verificarAluno(matricula, senha) ){
		String erro = "Acesse o sistema!";
		response.sendRedirect("index.jsp?e="+erro);
	}
	
}else{
	String erro = "Acesse o sistema!";
	response.sendRedirect("index.jsp?e="+erro);
}
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Web Faculdade</title>
<link rel="stylesheet" type="text/css" href="style.css" />
<script src="js/functions.js"></script>
</head>
<body>

<div id="Tudo">

	<header>
		<div id="Logomarca">
			<a href="inicio.html"><img src="img/logomarca.png" /></a>
		</div>
	</header>
	
	<div id="Conteudo">
		<aside>
			<nav>
				<ul>
					<li><a href="inicio.jsp">Início</a></li>
					<li><a href="cursos.jsp">Cursos</a></li>
					<li><a href="disciplinas.jsp">Disciplinas</a></li>
					<li><a href="professores.jsp">Professores</a></li>
					<li><a href="alunos.jsp">Alunos</a></li>
					<li><a href="turmas.jsp">Turma</a></li>
				</ul>
			</nav>
		</aside>
		
		<div id="Principal">
			<div class="Titulo">
				<h1>Alunos</h1>
			</div>
			
			<div class="Subtitulo">
				<h2>Cadastro de Alunos</h2>
			</div>
			
			<form name="cadAluno" id="cadAluno" action="retorno_aluno.jsp" method="post">
				<div class="Campo">
					<div class="Texto">Nome</div>
					<input name="nome" type="text" />
				</div>
				<div class="Campo">
					<div class="Texto">CPF</div>
					<input name="cpf" type="text" maxlength="14" onkeyup="formatar(this,event,'###.###.###-##');" />
				</div>
				<div class="Campo">
					<div class="Texto">Data de Nascimento</div>
					<input name="dataNascimento" type="text" maxlength="10" onkeyup="formatar(this,event,'##/##/####');" />
				</div>
				<div class="Campo">
					<div class="Texto">Sexo</div>
					<select name="sexo">
						<option selected="selected">Selecione</option>
						<option value="F">Feminino</option>
						<option value="M">Masculino</option>
					</select>
				</div>
				<div class="Campo">
					<div class="Texto">Nome da M&atilde;e</div>
					<input name="nomeMae" type="text" />
				</div>
				<div class="Campo">
					<div class="Texto">Nome do Pai</div>
					<input name="nomePai" type="text" />
				</div>
				<div class="Campo">
					<div class="Texto">Curso</div>
					<select name="codigoCurso">
						<option selected="selected">Selecione</option>
						<option value="Administra&ccedil;&atilde;o">Administra&ccedil;&atilde;o</option>
						<option value="Computa&ccedil;&atilde;o">Computa&ccedil;&atilde;o</option>
						<option value="Contabeis">Contabeis</option>
						<option value="Direito">Direito</option>
					</select>
				</div>
				<div class="Campo">
					<div class="Texto">Situa&ccedil;&atilde;o</div>
					<select name="situacao">
						<option selected="selected">Selecione</option>
						<option value="Ativo">Ativo</option>
						<option value="Inativo">Inativo</option>
					</select>
				</div>
				<div class="Botao">
					<input type="submit" value="Salvar Altera&ccedil;&otilde;es" onClick="return validarForm();" />
				</div>
			</form>
			
			<div class="Subtitulo">
				<h2>Lista de Alunos</h2>
			</div>
			
			<table>
				<thead >
					<tr>
						<th width="15">CPF</th>
						<th>Nome</th>
						<th>Curso</th>
						<th>Situa&ccedil;&atilde;o</th>
						<th></th>
					</tr>
				</thead>
				<tbody>
					<%
                	AlunoDAO alunoD = new AlunoDAO();
                	ResultSet listaAluno = alunoD.listaAlunos();
                    while( listaAluno.next() ){
                    	out.println("<tr>");
                    	out.println("<td  class=\"textFixed\">"+listaAluno.getString("cpf")+"</td>");
                    	out.println("<td class=\"text\">"+listaAluno.getString("nome")+"</td>");
                    	out.println("<td class=\"textFixed\">"+listaAluno.getString("codigoCurso")+"</td>");
                    	out.println("<td class=\"textFixed\">"+listaAluno.getString("situacao")+"</td>");
                    	out.println("<td class=\"button\"><a href=\"remover_aluno.jsp?cpf="+listaAluno.getString("cpf")+"\">Remover</a></td>");
                    	out.println("</tr>");
                    }
                	%>
				</tbody>
			</table>
		</div>
	</div>
	
	<footer>
		<div id="Grupo">
			<span>Projeto da Disciplina Programação Web, ministrado pela docente Havana Alves</span>
			<span>Alunos: Geraldo Granja e Peter Mademann</span>
		</div>
	</footer>

</div>

</body>
</html>