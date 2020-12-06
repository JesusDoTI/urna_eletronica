package model.dao;

import com.mysql.jdbc.Statement;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import model.connection.ConnectionFactory;
import model.bean.Imagem;

/**
 *
 * @author User
 */
public class ImagemDAO {

    Connection connection = null;

    public int insert(Imagem img) {
        Integer cod = 0;
        try {
            connection = ConnectionFactory.getConnection();
            PreparedStatement pstmt = connection
                    .prepareStatement("INSERT INTO imagem (tamanho, tipo, imagem) values (?,?,?)", Statement.RETURN_GENERATED_KEYS);
            pstmt.setLong(1, img.getSize());
            pstmt.setString(2, img.getExtension());
            pstmt.setBlob(3, img.getImage());
            pstmt.execute();
            ResultSet rs = pstmt.getGeneratedKeys();
            if (rs.next()) {
                cod = rs.getInt(1);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Ocorreu um erro na inserção da imagem");
        } 
        return cod;
    }

    public Imagem select(int codigo) {
        Imagem img = new Imagem();
        try {
            connection = ConnectionFactory.getConnection();
            PreparedStatement pstmt = connection.prepareStatement("SELECT * FROM imagem "
                    + "WHERE cod = ?");
            pstmt.setInt(1, codigo);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                img.setCod(rs.getInt(1));
                img.setSize(rs.getLong(2));
                img.setExtension(rs.getString(3));
                img.setImage(rs.getBlob(4));
            }
            return img;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Ocorreu um erro na busca da imagem");
            return null;
        } 
    }

    public InputStream selectImage(int codigo) {
        InputStream is = null;
        try {
            connection = ConnectionFactory.getConnection();
            PreparedStatement pstmt = connection.prepareStatement("SELECT imagem FROM imagem "
                    + "WHERE cod = ?");
            pstmt.setInt(1, codigo);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                is = rs.getBinaryStream(1);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Ocorreu um erro na busca da imagem");
        } 
        return is;
    }
}
