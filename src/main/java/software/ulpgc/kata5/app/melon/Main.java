package software.ulpgc.kata5.app.melon;

import software.ulpgc.kata5.app.*;

import java.sql.SQLException;

public class Main {

    public static void main(String[] args) throws SQLException {
        Desktop.with(new RemoteStore(MovieDeserializer::fromTsv))
                .display()
                .setVisible(true);
    }

}
