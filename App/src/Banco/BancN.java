
package Banco;

import java.sql.*;
import javax.swing.JOptionPane;

public class BancN {

  private String driver = "com.mysql.jdbc.Driver";
  private String url = "jdbc:mysql://localhost:3306/mysql";
  private String usuario = "root";
  private String senha = "";
  private Connection Conexao;
  public Statement statement;
  public ResultSet resultset;

  
  
public boolean conecta()
{
    boolean result = true;
    try{
        Class.forName(driver);
        Conexao = DriverManager.getConnection(url,DadosAcesso.usuario(),DadosAcesso.senha());
        //JOptionPane.showMessageDialog(null,"Conectou");
    }
    catch(ClassNotFoundException Driver)
    {
     JOptionPane.showMessageDialog(null,"Driver Nao Encontrado:"+Driver);
     result = false;
    }
    catch(SQLException Fonte)
    {
     JOptionPane.showMessageDialog(null,"Deu erro na Conexao com a fonte de dados: "+Fonte);
   result = false;
    }
     return result;
}
public void desconecta(){

    boolean result = true;
    try{
        Conexao.close();
        JOptionPane.showMessageDialog(null,"Banco fechado");
    }
    catch(SQLException erroSQL){
        JOptionPane.showMessageDialog(null,"Nao foi possivel"+ "fechar o banco de dados:"+erroSQL.getMessage());
  result = false;
    }

}

public void executeSQL(String sql){

    try{
        statement = Conexao.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
        resultset = statement.executeQuery(sql);
    }
    catch(SQLException sqlex){
     JOptionPane.showMessageDialog(null,"Nao foi possivel"+"executar o comando sql,"+sqlex+", "
             + "o sql passado foi "+sql+" \n original" + sqlex.getMessage());
    }

}

public int executeUpdateL(String sql){
int re=0;
    try{
        statement = Conexao.createStatement();
        statement.executeUpdate(sql);
    re=1;
    }
    catch(SQLException sqlex){
     JOptionPane.showMessageDialog(null,"Nao foi possivel"+"executar o comando sql,"+sqlex+", "
             + "o sql passado foi "+sql+" \n original" + sqlex.getMessage());
    }
return re;
}
}
