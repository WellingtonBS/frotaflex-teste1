package tests;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import core.Connections;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class TestSelect {

    private static Connections connec;
    private String sql;
/*


    @Test
    @Order(1)
    void select () {

        connec.sqlScript("SELECT nom_pessoa FROM tab_pessoa WHERE cod_pessoa = 1");

    }

    @Test
    @Order(2)
    void update () {

        connec.sqlScript("SELECT nom_pessoa FROM tab_pessoa WHERE cod_pessoa = 1");
        connec.execute("update tab_pessoa set nom_pessoa = nom_pessoa || ' 1' where cod_pessoa = 1");
        connec.sqlScript("SELECT nom_pessoa FROM tab_pessoa WHERE cod_pessoa = 1");

    }
 */

}
