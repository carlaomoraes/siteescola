package DAO;

import java.sql.SQLException;
import java.util.List;

import modelo.Aluno;

public interface IAluno {
	 public List<Aluno> listarAluno() throws SQLException;

	 public void inserirAluno(Aluno Aluno) throws SQLException;

	 public void alterarAluno(Aluno Aluno) throws SQLException;
	    
	 public boolean excluirAluno(int codAluno) throws SQLException;
	    
	 public Aluno carregarAluno(int codAluno) throws SQLException;
}
