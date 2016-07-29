package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import DAO.IAluno;
import conexao.fabricaConexao;
import modelo.Aluno;

public class AlunoDAO implements IAluno {

	ResultSet rs = null;
	Connection con = null;
	PreparedStatement ps = null;
	private List<Aluno> listaAluno;

	public List<Aluno> listarAluno() throws SQLException {
		String query = "select codaluno, nomealuno from Aluno ";
		try{
			con = fabricaConexao.abrirConexao();
			ps = con.prepareStatement(query);
			rs = ps.executeQuery();
			while(rs.next()){
				Aluno aluno = new Aluno();
				aluno.setCodAluno(rs.getInt("codaluno"));
				aluno.setNomeAluno(rs.getString("nomealuno"));
				listaAluno.add(aluno);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			rs.close();
			ps.close();
			con.close();
		}
		return listaAluno;

	}

	public void inserirAluno(Aluno Aluno) throws SQLException {
		String query = "insert into Aluno values(?, ?)";
		try{
			con = fabricaConexao.abrirConexao();
			ps = con.prepareStatement(query);
			ps.setInt(0, Aluno.getCodAluno());
			ps.setString(1, Aluno.getNomeAluno());
			rs = ps.executeQuery();
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			try {
				rs.close();
				ps.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public void alterarAluno(Aluno Aluno) throws SQLException {
		String query = "update Aluno set nomealuno = ? " +
						" where codaluno = ?";
		try{
			con = fabricaConexao.abrirConexao();
			ps = con.prepareStatement(query);
			ps.setString(0, Aluno.getNomeAluno());
			ps.setInt(1, Aluno.getCodAluno());
			rs = ps.executeQuery();
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			try {
				rs.close();
				ps.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}	
	}

	public boolean excluirAluno(int codaluno) throws SQLException {
		String query = "delete from Aluno where codaluno = ?";
		try{
			con = fabricaConexao.abrirConexao();
			ps = con.prepareStatement(query);
			ps.setInt(1, codaluno);
			rs = ps.executeQuery();
			return true;
		}catch(SQLException e){
			e.printStackTrace();
			return false;
		}finally{
			try {
				rs.close();
				ps.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
				return false;
			}
		}
	}

	public Aluno carregarAluno(int codaluno) throws SQLException {
		String query = "select codaluno, nomealuno from Aluno where codaluno = ?";
		Aluno aluno = new Aluno();
		try{
			con = fabricaConexao.abrirConexao();
			ps = con.prepareStatement(query);
			ps.setInt(1, codaluno);
			rs = ps.executeQuery();
			if(rs.next()){
				aluno.setCodAluno(rs.getInt(codaluno));
				aluno.setNomeAluno(rs.getString("nomealuno"));
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			try {
				rs.close();
				ps.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return aluno;
	}
}
