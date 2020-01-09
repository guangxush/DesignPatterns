package template.example2;

import java.sql.*;

/**
 * @author: guangxush
 * @create: 2020/01/09
 */
public abstract class OperationDatabase {
    Connection con;
    Statement sql;
    ResultSet rs;
    String dataBase, tableName;

    OperationDatabase(String dataBase, String tableName) {
        this.dataBase = dataBase;
        this.tableName = tableName;
    }

    public final void lookResult() {
        loadDriver();
        createConnection();
        createStatement();
        handleResult();
    }

    public abstract void loadDriver();

    public abstract void createConnection();

    public final void createStatement() {
        try {
            sql = con.createStatement();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public final void handleResult() {
        try {
            DatabaseMetaData metadata = con.getMetaData();
            ResultSet rs1 = metadata.getColumns(null, null, tableName, null);
            int 字段个数 = 0;
            while (rs1.next()) {
                字段个数++;
                System.out.printf("%-15s", rs1.getString(4));
            }
            System.out.println();
            rs = sql.executeQuery("SELECT * FROM " + tableName);
            while (rs.next()) {
                for (int k = 1; k <= 字段个数; k++) {
                    System.out.printf("%-15s", rs.getString(k));
                }
                System.out.println();
            }
            con.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
}