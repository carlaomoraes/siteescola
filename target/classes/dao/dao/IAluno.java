package dao;

import java.util.List;

import modelo.Aluno;

public interface IAluno {
	 public List<Aluno> listarAluno();

	 public void inserirAluno(Aluno Aluno);

	 public void alterarAluno(Aluno Aluno);
	    
	 public boolean excluirAluno(int codDisc);
	    
	 public Aluno carregarAluno(int codDisc);

}
