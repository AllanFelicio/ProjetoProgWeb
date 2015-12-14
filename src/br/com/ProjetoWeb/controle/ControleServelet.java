package br.com.ProjetoWeb.controle;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.ProjetoWeb.jdbc.AlunoDAO;
import br.com.ProjetoWeb.entidade.Aluno;

@WebServlet("/ControleServelet")
public class ControleServelet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ControleServelet() {
        super();
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("chamando method GET");
		
		AlunoDAO alunoDao = new AlunoDAO();
		List<Aluno> lista = alunoDao.buscaTodos();
		
		//String nome = request.getParameter("nome");
		//String empresa = request.getParameter("empresa");
		//System.out.println("Nome: "+ nome);
		//saida.println("nome: "+ nome +"empresa: " + empresa);
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		String nome = request.getParameter("nome");
		
		PrintWriter saida = response.getWriter();
		saida.println(lista);
		saida.println("<HTML><BODY>");
		saida.println("<H1>Seja bem vindo, " + nome + "</H1>");
		saida.println("</BODY></HTML>");
		saida.flush();
		saida.close();
		
	}

	protected void Cadastrar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("chamando method Cadastrar");
		
		//recebe dados na tela
		//String id = request.getParameter("id");
		String nome = request.getParameter("nome");
		String senha = request.getParameter("senha");
		String matricula = request.getParameter("matricula");
		String rg = request.getParameter("rg");
		String email = request.getParameter("email");
		String sexo = request.getParameter("sexo");
		String pais = request.getParameter("paises");
		String estado = request.getParameter("estado");
		String curso = request.getParameter("curso");
		String escolaridade = request.getParameter("escolaridade");
		String turno = request.getParameter("turno");
		String cpf = request.getParameter("cpf");
		
		//cria o objeto e seta os valores vindo da tela
		Aluno aluno = new Aluno();
		
		//if(id!=""){
			//usuari.setId(Integer.parseInt(id));
		//}
		aluno.setNome(nome);
		aluno.setCpf(cpf);
		aluno.setMatricula(matricula);
		aluno.setCurso(curso);
		aluno.setEmail(email);
		aluno.setEscolaridade(escolaridade);
		aluno.setEstado(estado);
		aluno.setRg(rg);
		aluno.setPais(pais);
		aluno.setSexo(sexo);
		aluno.setTurno(turno);
		aluno.setSenha(senha);
		
		//pede pra salvar no banco
		AlunoDAO alunoDao = new AlunoDAO();
			
		alunoDao.cadastrar(aluno);
		
		//PrintWriter saida = response.getWriter();
		//saida.println("salvo com sucesso!");
		
		String msg = "Dados inseridos com sucesso.";
		
		System.out.println(nome);
		response.sendRedirect("listaAluno.jsp?m="+msg);
		
		//doGet(request, response);
	}
	
	protected void retornoLogin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("chamando method retornoLogin");
		
		String matricula = request.getParameter("matricula");
		String senha = request.getParameter("senha");
		
		AlunoDAO alunoDao = new AlunoDAO();
	
		if( ( !matricula.equals("") ) && ( !senha.equals("") ) ){
			
			if( alunoDao.verificarAluno(matricula, senha) ){
				response.sendRedirect("listaAluno.jsp");
			}else{
				String erro = "Matricula e/ou Senha não cadastrados!";
				response.sendRedirect("index.jsp?e="+erro);
			}
			
		}else{
			String erro = "Matricula e/ou Senha inválidos!";
			response.sendRedirect("index.jsp?e="+erro);
		}
	}
	
	protected void pesquisa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("chamando method pesquisa");
		
		//recebe dados na tela
		//String id = request.getParameter("id");
		String nome = request.getParameter("nome");
		String senha = request.getParameter("senha");
		String matricula = request.getParameter("matricula");
		String rg = request.getParameter("rg");
		String email = request.getParameter("email");
		String sexo = request.getParameter("sexo");
		String pais = request.getParameter("paises");
		String estado = request.getParameter("estado");
		String curso = request.getParameter("curso");
		String escolaridade = request.getParameter("escolaridade");
		String turno = request.getParameter("turno");
		String cpf = request.getParameter("cpf");	
		
		//cria o objeto e seta os valores vindo da tela
		Aluno aluno = new Aluno();
		
		//if(id!=""){
			//aluno.setId(Integer.parseInt(id));
		//}

		aluno.setNome(nome);
		aluno.setCpf(cpf);
		aluno.setMatricula(matricula);
		aluno.setCurso(curso);
		aluno.setEmail(email);
		aluno.setEscolaridade(escolaridade);
		aluno.setEstado(estado);
		aluno.setRg(rg);
		aluno.setPais(pais);
		aluno.setSexo(sexo);
		aluno.setTurno(turno);
		aluno.setSenha(senha);
		
		//pede pra pesquisar no banco
		AlunoDAO alunoDao = new AlunoDAO();
			
		alunoDao.buscarPorNome(aluno.getNome());
		
		PrintWriter saida = response.getWriter();
		saida.println("salvo com sucesso!");
		
		//doGet(request, response);
	}

	protected void atualizar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("chamando method atualizar");
		
		//recebe dados na tela
		//String id = request.getParameter("id");
		String nome = request.getParameter("nome");
		String senha = request.getParameter("senha");
		String matricula = request.getParameter("matricula");
		String rg = request.getParameter("rg");
		String email = request.getParameter("email");
		String sexo = request.getParameter("sexo");
		String pais = request.getParameter("paises");
		String estado = request.getParameter("estado");
		String curso = request.getParameter("curso");
		String escolaridade = request.getParameter("escolaridade");
		String turno = request.getParameter("turno");
		String cpf = request.getParameter("cpf");	
		
		//cria o objeto e seta os valores vindo da tela
		Aluno aluno = new Aluno();
		
		//if(id!=""){
			//aluno.setId(Integer.parseInt(id));
		//}

		aluno.setNome(nome);
		aluno.setCpf(cpf);
		aluno.setMatricula(matricula);
		aluno.setCurso(curso);
		aluno.setEmail(email);
		aluno.setEscolaridade(escolaridade);
		aluno.setEstado(estado);
		aluno.setRg(rg);
		aluno.setPais(pais);
		aluno.setSexo(sexo);
		aluno.setTurno(turno);
		aluno.setSenha(senha);
		
		//pede pra alterar no banco
		AlunoDAO alunoDao = new AlunoDAO();
			
		alunoDao.alterar(aluno);
		
		PrintWriter saida = response.getWriter();
		saida.println("Alterado com sucesso!");
		
		
		//doGet(request, response);
	}
}
