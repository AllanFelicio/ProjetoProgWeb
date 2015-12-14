package br.com.ProjetoWeb.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.ProjetoWeb.jdbc.Conexao;
import br.com.ProjetoWeb.entidade.Aluno;

public class AlunoDAO {

private Connection con = Conexao.getConnection();
	
	public void cadastrar(Aluno aluno){
		String sql = "INSERT INTO ALUNO (nome, senha, matricula, rg, cpf, email, sexo, pais, estado, escolaridade, curso, turno) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";

		// constroe o PreparedStatement com sql
		try {
			PreparedStatement preparador = con.prepareStatement(sql);
			preparador.setString(1, aluno.getNome());
			preparador.setString(2, aluno.getSenha());
			preparador.setString(3, aluno.getMatricula());
			preparador.setString(4, aluno.getRg());
			preparador.setString(5, aluno.getCpf());
			preparador.setString(6, aluno.getEmail());
			preparador.setString(7, aluno.getSexo());
			preparador.setString(8, aluno.getPais());
			preparador.setString(9, aluno.getEstado());
			preparador.setString(10, aluno.getEscolaridade());
			preparador.setString(11, aluno.getCurso());
			preparador.setString(12, aluno.getTurno());

			preparador.execute();
			preparador.close();

			System.out.println("Cadastrado com sucesso!");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void alterar(Aluno aluno){
		String sql = "UPDATE ALUNO SET nome=?, matricula=?, senha=MD5(?), rg=?, cpf=?, email=?, sexo=?, pais=?, estado=?, escolaridade=?, curso=?, turno=? WHERE id=?";

		// constroe o PreparedStatement com sql
		try {
			PreparedStatement preparador = con.prepareStatement(sql);
			preparador.setString(1, aluno.getNome());
			preparador.setString(2, aluno.getMatricula());
			preparador.setString(3, aluno.getSenha());
			preparador.setString(4, aluno.getRg());
			preparador.setString(5, aluno.getCpf());
			preparador.setString(6, aluno.getEmail());
			preparador.setString(7, aluno.getSexo());
			preparador.setString(8, aluno.getPais());
			preparador.setString(9, aluno.getEstado());
			preparador.setString(10, aluno.getEscolaridade());
			preparador.setString(11, aluno.getCurso());
			preparador.setString(12, aluno.getTurno());
			preparador.setInt(13, aluno.getId());
			
			preparador.execute();
			preparador.close();

			System.out.println("alterado com sucesso!");

		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}
    
	public void salvar (Aluno aluno){
		if(aluno.getId()> 0){
			alterar(aluno);
		}else{
			cadastrar(aluno);
		}
	}
	
	public void excluir(Aluno aluno){
		String sql = "DELETE FROM ALUNO WHERE id=?";

		// constroe o PreparedStatement com sql
		try {
			PreparedStatement preparador = con.prepareStatement(sql);
			preparador.setInt(1, aluno.getId());

			preparador.execute();
			preparador.close();

			System.out.println("Excluido com sucesso!");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public List<Aluno> buscaTodos(){

		String sql = "SELECT * FROM ALUNO";

		List<Aluno> lista = new ArrayList<Aluno>();

		try {
			PreparedStatement preparador = con.prepareStatement(sql);

			ResultSet resultado = preparador.executeQuery();

			while(resultado.next()){
				Aluno aluno = new Aluno();

				aluno.setId(resultado.getInt("id")); //o valor da coluna
				aluno.setNome(resultado.getString("nome"));
				aluno.setSenha(resultado.getString("senha"));
				aluno.setMatricula(resultado.getString("matricula"));
				aluno.setRg(resultado.getString("rg"));
				aluno.setCpf(resultado.getString("cpf"));
				aluno.setEmail(resultado.getString("email"));
				aluno.setSexo(resultado.getString("sexo"));
				aluno.setPais(resultado.getString("pais"));
				aluno.setEstado(resultado.getString("estado"));
				aluno.setEscolaridade(resultado.getString("escolaridade"));
				aluno.setCurso(resultado.getString("curso"));
				aluno.setTurno(resultado.getString("turno"));

				lista.add(aluno);
			}			

			preparador.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return lista;

	}
	
	public Aluno buscarPorId(Integer id){
		String sql="SELECT * FROM ALUNO WHERE ID = ?";
		Aluno aluno = null;
		try {
			PreparedStatement preparador = con.prepareStatement(sql);
			preparador.setInt(1,id);

			ResultSet resultado = preparador.executeQuery();

			if(resultado.next()){
				aluno = new Aluno();
				aluno.setId(resultado.getInt("id"));
				aluno.setNome(resultado.getString("nome"));
				aluno.setSenha(resultado.getString("senha"));
				aluno.setMatricula(resultado.getString("matricula"));
				aluno.setRg(resultado.getString("rg"));
				aluno.setCpf(resultado.getString("cpf"));
				aluno.setEmail(resultado.getString("email"));
				aluno.setSexo(resultado.getString("sexo"));
				aluno.setPais(resultado.getString("pais"));
				aluno.setEstado(resultado.getString("estado"));
				aluno.setEscolaridade(resultado.getString("escolaridade"));
				aluno.setCurso(resultado.getString("curso"));
				aluno.setTurno(resultado.getString("turno"));
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return aluno;

	}
	
	public List<Aluno> buscarPorNome(String nome){
		String sql="SELECT * FROM ALUNO WHERE NOME LIKE = ?";
		List<Aluno> lista = new ArrayList<Aluno>();
		try {
			PreparedStatement preparador = con.prepareStatement(sql);
			preparador.setString(1, "%"+nome+"%");

			ResultSet resultado = preparador.executeQuery();

			while(resultado.next()){
				Aluno aluno = new Aluno();
				aluno.setId(resultado.getInt("id"));
				aluno.setNome(resultado.getString("nome"));
				aluno.setSenha(resultado.getString("senha"));
				aluno.setMatricula(resultado.getString("aluno"));
				aluno.setRg(resultado.getString("rg"));
				aluno.setCpf(resultado.getString("cpf"));
				aluno.setEmail(resultado.getString("email"));
				aluno.setSexo(resultado.getString("sexo"));
				aluno.setPais(resultado.getString("pais"));
				aluno.setEstado(resultado.getString("estado"));
				aluno.setEscolaridade(resultado.getString("escolaridade"));
				aluno.setCurso(resultado.getString("curso"));
				aluno.setTurno(resultado.getString("turno"));
				
				lista.add(aluno);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return lista;

	}

	public Aluno autenticar(Aluno aluno){
		String sql="SELECT * FROM ALUNO WHERE MATRICULA = ? AND SENHA = ?";
		Aluno alunoRetorno = null;
		try {
			PreparedStatement preparador = con.prepareStatement(sql);
			preparador.setString(2, aluno.getSenha());
			
			ResultSet resultado = preparador.executeQuery();

			if(resultado.next()){
				alunoRetorno = new Aluno();
				alunoRetorno.setId(resultado.getInt("id"));
				alunoRetorno.setNome(resultado.getString("nome"));
				alunoRetorno.setSenha(resultado.getString("senha"));
				alunoRetorno.setMatricula(resultado.getString("matricula"));
				alunoRetorno.setRg(resultado.getString("rg"));
				alunoRetorno.setCpf(resultado.getString("cpf"));
				alunoRetorno.setEmail(resultado.getString("email"));
				alunoRetorno.setSexo(resultado.getString("sexo"));
				alunoRetorno.setPais(resultado.getString("pais"));
				alunoRetorno.setEstado(resultado.getString("estado"));
				alunoRetorno.setEscolaridade(resultado.getString("escolaridade"));
				alunoRetorno.setCurso(resultado.getString("curso"));
				alunoRetorno.setTurno(resultado.getString("turno"));
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return aluno;

	}
	
	public boolean existeUsuario(Aluno aluno){
		String sql="SELECT * FROM ALUNO WHERE MATRICULA = ? AND SENHA = ?";
		try {
			PreparedStatement preparador = con.prepareStatement(sql);
			preparador.setString(2, aluno.getSenha());
			
			ResultSet resultado = preparador.executeQuery();
			
			return resultado.next();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;

	}
	
//-------------------------------------------------------------------------

	public boolean verificarAluno(String matricula, String senha){
		
		try{
			// Consulta
			String sql = "SELECT COUNT(*) AS TOTAL FROM ALUNO WHERE MATRICULA=? AND SENHA=?";
			PreparedStatement stmt = con.prepareStatement(sql);
			
			// Inserção de Dados
			stmt.setString(1, matricula);
			stmt.setString(2, senha);
			
			// Executar Query
			ResultSet rs = stmt.executeQuery();
			rs.next();
			int total = rs.getInt("total");
			if( total == 1 ){
				return true;
			}else{
				return false;
			}
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return false;
		}
	}
	
	public ResultSet listaAlunos() throws SQLException{
		
		try{
			// Consulta
			String sql = "SELECT * FROM ALUNO";
			PreparedStatement stmt = con.prepareStatement(sql);
			
			// Executar Query
			ResultSet rs = stmt.executeQuery();
			return rs;
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}
	}
	
	public boolean removeAluno(String cpf) throws SQLException{

		try{
			// Deleta
			String sql = "DELETE a.* FROM aluno a WHERE cpf=?";
			PreparedStatement stmt = con.prepareStatement(sql);
			
			// Inserção de Dados
			stmt.setString(1, cpf);
			
			// Executar Query
		stmt.executeUpdate();
		return true;
			
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			
		}
		return false;

	}

	/*	
	public String totalAlunos() throws SQLException{
		// Cria a Conexão com Banco de Dados
		Connection conexao = criarConexao();
		
		try{
			// Consulta
			String sql = "SELECT count(*) as total FROM aluno a JOIN pessoa p, curso c WHERE a.cpf=p.cpf AND a.codigoCurso=c.codigo ORDER BY p.nome ASC";
			PreparedStatement stmt = conexao.prepareStatement(sql);
			
			// Executar Query
			ResultSet rs = stmt.executeQuery();
			rs.next();
			int total = rs.getInt("total");
			if( total == 0 ){
				return "Sem Registros";
			}else if( total == 1 ){
				return total+" registro";
			}else{
				return total+" registros";
			}
			
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}
	}
*/
	
	public boolean inserirAluno(String nome, String senha, String matricula, String rg, String cpf, String email, String sexo, String pais, String estado, String escolaridade, String curso, String turno){
		
		try{
			// Consulta
			String sql = "INSERT INTO ALUNO (nome, senha, matricula, rg, cpf, email, sexo, pais, estado, escolaridade, curso, turno) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";
			
			// Inserção de Dados
			PreparedStatement preparador = con.prepareStatement(sql);
			
			preparador.setString(1, nome);
			preparador.setString(2, senha);
			preparador.setString(3, matricula);
			preparador.setString(4, rg);
			preparador.setString(5, cpf);
			preparador.setString(6, email);
			preparador.setString(7, sexo);
			preparador.setString(8, pais);
			preparador.setString(9, estado);
			preparador.setString(10, escolaridade);
			preparador.setString(11, curso);
			preparador.setString(12, turno);
			
			// Executar Query
			preparador.execute();
			return true;
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return false;
		}
	}
	
}
