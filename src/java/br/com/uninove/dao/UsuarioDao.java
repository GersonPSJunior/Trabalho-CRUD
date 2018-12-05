/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.uninove.dao;

import br.com.uninove.model.Usuario;
import br.com.uninove.util.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author supercell
 */
public class UsuarioDao {
    
    public boolean gravar(Usuario usuario){
		
		String sql = "INSERT INTO tbl_usuario (nome, email, senha, fone) " +
				"VALUES (?, ?, ?, ?)";
		
		Connection con = Conexao.abrirConexao();
		PreparedStatement stm = null;
		boolean gravou = false;
		try {
			stm = con.prepareStatement(sql);
			stm.setString(1, usuario.getNome());
			stm.setString(2, usuario.getEmail());
			stm.setString(3, usuario.getSenha());
			stm.setString(4, usuario.getFone());
			stm.executeUpdate();
			gravou = true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			Conexao.FecharConexao(con);
		}
		return gravou;
	}
        
        public void delete(int idUsuario){
            
            String sql = "delete from tbl_usuario where id_usuario = ?";
            
            Connection con = Conexao.abrirConexao();
            PreparedStatement stm = null;
            
            try {
                stm = con.prepareStatement(sql);
                stm.setInt(1, idUsuario);
                stm.executeUpdate();
                System.out.println("Deletado!");
            } catch (SQLException ex) {
                Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
        
        public void update(Usuario usuario){
            
            String sql = "UPDATE `tbl_usuario` SET `nome` = ?, `email` = ?, `senha` = ?, `fone` = ? WHERE `tbl_usuario`.`id_usuario` = ?";
            Connection con = Conexao.abrirConexao();
            PreparedStatement stm = null;
            try {
                stm = con.prepareStatement(sql);
                stm.setString(1, usuario.getNome());
                stm.setString(2, usuario.getEmail());
                stm.setString(3, usuario.getSenha());
                stm.setString(4, usuario.getFone());
                stm.setInt(5, usuario.getIdUsuario());
                stm.executeUpdate();
                System.out.println("Atualizado!");
                
                } catch (SQLException ex) {
                Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
        
        public Usuario getUsuarioId(int idUsuario) {
        
        Usuario usuario = new Usuario();
        String sql = "select * from tbl_usuario where id_usuario=?";
        Connection con = Conexao.abrirConexao();
        PreparedStatement stm = null;
        try {
            stm = con.prepareStatement(sql);
            stm.setInt(1, idUsuario);
            ResultSet rs = stm.executeQuery();

            if (rs.next()) {
                usuario.setIdUsuario(rs.getInt("id_usuario"));
                usuario.setNome(rs.getString("nome"));
                usuario.setEmail(rs.getString("email"));
                usuario.setSenha(rs.getString("senha"));
                usuario.setFone(rs.getString("fone"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return usuario;
    }
        
        public List<Usuario> listaTodos(){
            
            List<Usuario> usuario = new ArrayList<Usuario>();
            Connection con = Conexao.abrirConexao();
            try {
                Statement stm = con.createStatement();
                ResultSet rs = stm.executeQuery("select * from tbl_usuario");
                while(rs.next()){
                    Usuario user = new Usuario();
                    user.setIdUsuario(rs.getInt("id_usuario"));
                    user.setNome(rs.getString("nome"));
                    user.setEmail(rs.getString("email"));
                    user.setSenha(rs.getString("senha"));
                    user.setFone(rs.getString("fone"));
                    usuario.add(user);
                }
            } catch (SQLException ex) {
                Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            return usuario;
        }
	
	public Usuario autenticar(String email, String senha){
		
		Usuario usuario = null;
		String sql = "SELECT * FROM tbl_usuario WHERE" +
				" email = ? and senha = ?";
		
		Connection con = Conexao.abrirConexao();
		PreparedStatement stm;
		
		try {
			stm = con.prepareStatement(sql);
			stm.setString(1, email);
			stm.setString(2, senha);
			ResultSet rs = stm.executeQuery();
			if(rs.next()){
				usuario = new Usuario();
				usuario.setIdUsuario(rs.getInt("idUsuario"));
				usuario.setNome(rs.getString("nome"));
				usuario.setEmail(rs.getString("email"));
				usuario.setSenha(rs.getString("senha"));
				usuario.setFone(rs.getString("fone"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return usuario;
		
	}
}
