package dao;

import gui.Login;
import gui.*;
import factory.ConnectionFactory;
import modelo.Usuario;
import java.sql.*;
import java.sql.PreparedStatement;
public class UsuarioDAO { 
    private Connection connection;
    Long id;
    String nome;
    String cpf;
    String email;
    String senha;
    public UsuarioDAO(){ 
        this.connection = new ConnectionFactory().getConnection();
    } 
    public void adiciona(Usuario usuario){ 
        String sql = "INSERT INTO usuarios(nome,cpf,email,senha) VALUES(?,?,?,?)";
        try { 
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, usuario.getNome());
            stmt.setString(2, usuario.getCpf());
            stmt.setString(3, usuario.getEmail());
            stmt.setString(4, usuario.getSenha());
            stmt.execute();
            stmt.close();
        } 
        
        catch (SQLException u) { 
            throw new RuntimeException(u);
        } 
        
    } 
  
    
}

