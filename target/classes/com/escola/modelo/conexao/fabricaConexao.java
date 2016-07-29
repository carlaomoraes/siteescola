package conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class fabricaConexao {
	
	private static String driver = "com.mysql.jdbc.Driver";
    private static String url = "jdbc:mysql://locahost/conexao_teste";
    private static String usuario = "root";
    private static String senha = "senha12345";
        

    public static Connection abrirConexao()
    {
		Connection conexao = null;
		try
        {
            Class.forName(driver);
            conexao = DriverManager.getConnection(url, usuario, senha);
        }
        catch(ClassNotFoundException Driver) {
        	System.out.println("Driver não localizado: " + Driver);
        }
        catch(SQLException Fonte) {
        	System.out.println("Erro na conexão com a fonte de dados: " + Fonte);
        }
        return conexao;
    }
}