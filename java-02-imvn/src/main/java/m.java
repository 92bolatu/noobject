

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import org.jooq.DSLContext;
import org.jooq.SQLDialect;
import org.jooq.impl.DSL;
import org.jooq.*;

import static cn.generated.tables.Books.*;
import static java.lang.System.out;


/**
 * Created by cassandra on 15/7/24.
 */
public class m {
    public static void main(String[] args) {

        out.println("cass-boot");
        String username = "root";
        String password = "123456";
        String url = "jdbc:mysql://localhost:3306/lwt";

        out.println("cass-connect");
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        out.println("cass-dsl-create");
        DSLContext create = DSL.using(connection, SQLDialect.MYSQL);

        out.println("cass-select-gen-class");
        Result<Record> result = create.select().from(BOOKS).fetch();
        for (Record r : result) {
            out.println(r.getValue(BOOKS.AUTHOR));
            out.println(r);
        }

        out.println("cass-select-into-user-class");
        List<book> list = create.select().from(BOOKS).fetch().into(book.class);
        for (book b : list) {
            out.println("book : " + b.getName());
        }
    }
}
