package br.com.ProjetoWeb.teste;

import java.util.List;

import br.com.ProjetoWeb.jdbc.AlunoDAO;
import br.com.ProjetoWeb.entidade.Aluno;

public class TesteAlunoDAO {


	public static void main(String[] args) {
		
		//testeCadastrar();
		//testeAlterar();
		//testeExcluir();
		//testeBucarTodos();
		testeAutenticar();
		//testeBuscarPorId();

	}

	private static void testeCadastrar() {
		Aluno aluno = new Aluno();
		
		aluno.setNome("Allan");
		aluno.setMatricula("201410211");
		aluno.setSenha("123456");
		aluno.setCpf("07734712436");
		aluno.setRg("4545");
		aluno.setEmail("asdf@asdf");
		aluno.setEscolaridade("seg grau");
		aluno.setEstado("alagoas");
		aluno.setPais("brasil");
		aluno.setSexo("masc");
		aluno.setCurso("comp");
		aluno.setTurno("noite");
		
		AlunoDAO alunoDao = new AlunoDAO();
		alunoDao.cadastrar(aluno);
	}
	
	private static void testeAlterar(){
		Aluno aluno = new Aluno();
		aluno.setId(2);
		//aluno.setNome("jao da silva");
		//aluno.setSenha("js123");
		
		AlunoDAO alunoDao = new AlunoDAO();
		alunoDao.alterar(aluno);
	}
	
	private static void testeExcluir(){
		Aluno aluno = new Aluno();
		aluno.setId(2);

		AlunoDAO alunoDao = new AlunoDAO();
		alunoDao.excluir(aluno);
	}
	
	private static void testeBucarTodos(){
		AlunoDAO alunoDao = new AlunoDAO();
		List<Aluno> listaResultado = alunoDao.buscaTodos();
		
		for(Aluno u: listaResultado){
			System.out.println(u.getId()+" "+u.getNome()+" "+u.getNome()+" "+u.getSenha());
		}
	}
	
	public static void  testeAutenticar(){
		Aluno aluno = new Aluno();
		aluno.setSenha("123456");
		
		AlunoDAO alunoDao = new AlunoDAO();
		System.out.println(alunoDao.autenticar(aluno));
				
	}
	
	public static void  testeBuscarPorId(){
		AlunoDAO alunoDao = new AlunoDAO();
		
		Aluno alunoRetorno = alunoDao.buscarPorId(10);
		if (alunoRetorno!=null){
			System.out.println("nome: "+alunoRetorno.getNome());
		}
				
	}
}
