package Dao;

import Util.Conexao;
import Util.Settings;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Class com operações para contagem!
 * @author SYNC
 */
public class Accountant {
    private Connection connection;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;

    public Accountant() {
        try {
            this.connection = Conexao.getConnection();
            if (this.connection != null) {
                System.out.println("Conectado com sucesso!");
            }
        } catch (Exception e) {
            System.out.println("Erro de conexão");
        }
    }


    /**
     * Contabilizar o total de contatos registrado.
     * @return Retornar 0 se não houver contatos registrados.
     * @author SYNC
     * @since 2025-01-14
     */
    public int acountTotalContato() throws Exception {
        System.out.println("Task - > Acounttotalcontato executada com sucesso!");
        if (connection.isClosed()) {
            connection = Conexao.getConnection();
        }
        try {
            int Totalcontato = 0;
            String sql = "SELECT * FROM " + Settings.Db + ".contato";
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Totalcontato++;
            }
            return Totalcontato;
        } catch (SQLException e) {
            System.out.println("Task - > acountTotalContato: Erro ao executar SQL: " + e.getMessage());
        } finally {
            Conexao.closeConnection(connection, preparedStatement, resultSet);
            System.out.println("Task - > Acounttotalcontato finalizado com sucesso!");
        }
        return 0;
    }

    /**
     * Faz contagem de todas postagem.
     * @return Retornar 0 se não houver postagem registrados.
     * @author SYNC
     * @since 2025-01-14
     */
    public int PostageAccount() throws Exception {
        System.out.println("Task - > PostageAccount executada com sucesso!");
        if (connection.isClosed()) {
            connection = Conexao.getConnection();
        }
        try {
            int total = 0;
            String sql = "SELECT * FROM " + Settings.Db + ".posts";
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                total++;
            }
            return total;
        } catch (SQLException e) {
            System.out.println("Task - > PostageAccount: Erro ao executar SQL: " + e.getMessage());
        } finally {
            Conexao.closeConnection(connection, preparedStatement, resultSet);
            System.out.println("Task - > Acounttotalcontato finalizado com sucesso!");

        }
        return 0;
    }
    /**
     * Faz contagem de todas email.
     * @return Retornar 0 se não houver email registrados.
     * @author SYNC
     * @since 2025-01-14
     */
    public int Acounttotalemail() throws Exception {
        System.out.println("Task - > Acounttotalemail executada com sucesso!");
        if (connection.isClosed()) {
            connection = Conexao.getConnection();
        }
        try {
            int totalEmail = 0;
            String sql = "SELECT * FROM " + Settings.Db + ".cadastroemail";
            connection = Conexao.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                totalEmail++;
            }
            return totalEmail;
        } catch (SQLException e) {
            System.out.println("Task - > Acounttotalemail: Erro ao executar SQL: " + e.getMessage());
        } finally {
            Conexao.closeConnection(connection, preparedStatement, resultSet);
            System.out.println("Task - > Acounttotalemail finalizado com sucesso!");
        }
        return 0;
    }
}
