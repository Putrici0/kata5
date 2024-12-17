package software.ulpgc.control;

import software.ulpgc.control.pojo.RandomUserMe;
import software.ulpgc.control.pojo.RandomUserMeResponse;
import software.ulpgc.model.User;

import java.io.IOException;
import java.net.*;


public class RandomUserMeAdapter implements UserAdapter<RandomUserMeResponse> {


    @Override
    public User adapt(RandomUserMeResponse response) {

        RandomUserMe userMe = response.getResults().getFirst();
        User user = adapt(userMe);
        user.setPhoto(downloadPhoto(userMe.getPicture().medium()));
        return user;
    }


    private byte[] downloadPhoto(String url) {
        try {
            URLConnection conn = new URI(url).toURL().openConnection();
            return conn.getInputStream().readAllBytes();
        } catch (URISyntaxException | IOException e) {
            return new byte[0];
        }
    }

    private static User adapt(RandomUserMe userMe) {
        return new User(userMe.getName().first(), userMe.getName().last(), userMe.getEmail(),
                User.Gender.valueOf(firstUpperCase(userMe.getGender())));
    }

    private static String firstUpperCase(String value) {
        return value.substring(0, 1).toUpperCase() + value.substring(1);
    }




}
