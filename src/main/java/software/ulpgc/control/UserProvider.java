package software.ulpgc.control;

import software.ulpgc.model.User;

import java.io.IOException;

public interface UserProvider {

    User provideNew() throws IOException;
}
