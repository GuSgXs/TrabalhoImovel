/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package imoveis;

import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

/**
 *
 * @author Aluno
 */
public class ImoveisBD {

    public static void main(String[] args) throws SQLException {
        Connection connection = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String serverName = "127.0.0.1:3306";
            String mydatabase = "imovel";
            String url = "jdbc:mysql://" + serverName + "/" + mydatabase + "?useTimezone=true&serverTimezone=UTC";
            String username = "root";
            String password = "";

            connection = DriverManager.getConnection(url, username, password);

            if (connection != null) {

                System.out.println("STATUS--->Conectado com sucesso!");
            } else {
                System.out.println("STATUS--->Não foi possivel realizar conexão");
            }
            String enter;
            int opc = 0;
            Scanner ler = new Scanner(System.in);

            while (opc != 9) {

                System.out.println("--------------------Aluguei de Imoveis--------------------");
                System.out.println("");
                System.out.println("Imoveis NOVO           (1)");
                System.out.println("Imoveis USADOS         (2)");
                System.out.println("MOSTRAR VALORES        (5)");
                System.out.println("SAIR                   (9)");
                System.out.println("Opcoes especiais       (10)");
                System.out.println("");
                System.out.println("Digite:");
                opc = ler.nextInt();

                if (opc == 1) {

                    ImovelNovo imoveln = new ImovelNovo();

                    imoveln.dados();
                    double imovelvalor = imoveln.valor();

                    String sql = "INSERT INTO imoveis (nome, endereco, preco, tipo) VALUES (?,?,?,?)";
                    PreparedStatement ps = connection.prepareStatement(sql);

                    ps.setString(1, imoveln.getNome());
                    ps.setString(2, imoveln.getEndereco());
                    ps.setDouble(3, imovelvalor);
                    ps.setInt(4, opc);
                    ps.execute();

                    System.out.println("");
                    System.out.println("");
                    System.out.println("Digite OK para continuar");
                    enter = ler.next();
                }

                if (opc == 2) {
                    ImovelUsado imovelu = new ImovelUsado();
                    imovelu.dados();
                    double imovelvalor = imovelu.valor();

                    String sql = "INSERT INTO imoveis (nome, endereco, preco, tipo) VALUES (?,?,?,?)";
                    PreparedStatement ps = connection.prepareStatement(sql);

                    ps.setString(1, imovelu.getNome());
                    ps.setString(2, imovelu.getEndereco());
                    ps.setDouble(3, imovelvalor);
                    ps.setInt(4, opc);
                    ps.execute();

                    System.out.println("");
                    System.out.println("");
                    System.out.println("Digite OK para continuar");
                    enter = ler.next();
                }

                if (opc == 5) {

                    String mostrarvalores = "SELECT id,nome,endereco,preco,tipo FROM imoveis";
                    PreparedStatement ps = connection.prepareStatement(mostrarvalores);
                    ps = connection.prepareStatement(mostrarvalores);
                    ResultSet rs = ps.executeQuery();
                    while (rs.next()) {

                        String nome = rs.getString("nome");
                        String endereco = rs.getString("endereco");
                        double preco = rs.getDouble("preco");
                        int tipo = rs.getInt("tipo");
                        System.out.println("Nome: " + nome);
                        System.out.println("Endereco: " + endereco);
                        System.out.println("Preco: " + preco);
                        System.out.println("Tipo: " + tipo);
                        System.out.println("");
                        System.out.println("");
                        System.out.println("Digite OK para continuar");
                        enter = ler.next();
                    }
                }

                if (opc == 10) {

                    String movelUpdate = "UPDATE imoveis SET preco=150000  WHERE id=1";
                    PreparedStatement ps = connection.prepareStatement(movelUpdate);

                    ps.executeUpdate();

                    String moveldel = "Delete from imoveis WHERE id = 3";
                    ps = connection.prepareStatement(moveldel);
                    ps.execute();

                    System.out.println("VALORES ALTERADOS!");
                    System.out.println("");
                    System.out.println("");
                    System.out.println("Digite OK para continuar");
                    enter = ler.next();
                }

            }

        } catch (ClassNotFoundException e) {
            System.out.println("O driver expecificado nao foi encontrado.");

        } catch (SQLException e) {

            System.out.println("não foi possivel conectar ao Banco de Dados." + e.getMessage());

        } finally {
            connection.close();

        }

    }
}
