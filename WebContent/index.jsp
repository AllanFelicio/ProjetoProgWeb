<%@ page language="java" 
contentType="text/html; charset=ISO-8859-1" 
pageEncoding="ISO-8859-1"
%>
<html>
	<head>
		<title>
			Login do Usuário
		</title>	
		<link rel="stylesheet" type="text/css" href="css/estilo.css">
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
	
	<body id="bodyIndex">
		<header>
			<div id="header" align="center">
				<a href="index.jsp"><img src="img\logo_fnr.png"/></a>
			</div>
		</header>
		
		<div id="Conteudo">
			<div id="Login">
				<!--form id="form" action="retorno_login.jsp" method="post"-->
				<form action="ControleServelet" method="retornoLogin" onsubmit="return confimaSenhaSenha(this)">
					<div class="Campo">
						<label>
							<div class="Texto">Matrícula:</div>
							<input id=matricula name="matricula" type="text" size="30" placeholder="Digite sua Matricula" maxlength="10" onkeyup="formatar(this,event,'##########');" />
						</label>
					</div>
					<div class="Campo">
						<div class="Texto">Senha</div>
						<label>
							<input id="senha" name="senha" type="password" maxlength="8" size="30" placeholder="Digite sua senha"/>
						</label>
					</div>
					<div class="Botao" align="center">
					<label>
						<input id="acessar" type="submit" value="Acessar" />
					</label>
					</div>
				</form>
			</div>
			<div  align="center">
				<a href="cadastroAluno.jsp"><p>Não sou Cadastrado</p></a>
			</div>
		</div>	
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