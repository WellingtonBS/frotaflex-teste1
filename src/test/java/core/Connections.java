package core;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Connections {

    static String host = "srv4.rddfconsultoria.com";
    static String port = "5432";
    static String base = "bkp_promoflex";
    static String user = "bkp_promoflex";
    static String pass = "d9i0804um3ythv8wo4890u";

    public static String sqlScript(String sql) {
        String valor = "";
        Connection c = connect(host, port, base, user, pass);
        try {
            valor = find(c, sql, null);
            System.out.println(valor);
        } catch(Exception e) {
            throw new RuntimeException(e.getMessage());
        } finally {
            Connections.close(c);
        }
        return valor;
    }

    public static Connection connect(String host, String port, String name, String user, String pass) {
        try {
            Class.forName("org.postgresql.Driver");
            return DriverManager.getConnection("jdbc:postgresql://" + host + ":" + port + "/" + name + "?ApplicationName=promoflex-api", user, pass);
        } catch(Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public static void close(Connection c) {
        if(c != null) {
            try {
                c.close();
            } catch(Exception e) {

            }
        }
    }

    @SuppressWarnings("unchecked")
    public static <T> T find(Connection c, String sql, T def, Object... params) {
        try {
            PreparedStatement stm = c.prepareStatement(sql);
            int index = 0;
            for(Object item : params) {
                index++;
                stm.setObject(index, item);
            }

            T result = null;
            ResultSet rs = stm.executeQuery();
            if(rs.next()) {
                result = (T)rs.getObject(1);
            }

            if(result == null) result = def;

            stm.close();
            return result;
        } catch(Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public static void execute(/*Connection c,*/ String sql, Object... params) {
        Connection c = connect(host, port, base, user, pass);
        try {
            PreparedStatement stm = c.prepareStatement(sql);
            int index = 0;
            for(Object item : params) {
                index++;
                stm.setObject(index, item);
            }

            stm.executeUpdate();
            stm.close();
        } catch(Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

}