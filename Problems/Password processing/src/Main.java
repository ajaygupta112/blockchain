import java.io.Serializable;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;

class UserProfile implements Serializable {
    private static final long serialVersionUID = 26292552485L;

    private String login;
    private String email;
    private transient String password;

    public UserProfile(String login, String email, String password) {
        this.login = login;
        this.password = password;
        this.email = email;
    }

    // implement readObject and writeObject properly

    private void writeObject(ObjectOutputStream oos) throws IOException
    {
        oos.defaultWriteObject();
        String str = "";
        for(int i = 0 ; i < password.length(); i++)
        {
            int j = password.charAt(i)+1;
            str = str + "" + (char)j;
        }
        oos.writeObject(str);
    }

    private void readObject(ObjectInputStream ooi) throws IOException, ClassNotFoundException
    {
        ooi.defaultReadObject();
        String str = (String)ooi.readObject();
        password = "";
        for(int i = 0 ; i < str.length(); i++)
        {
            int j = str.charAt(i)-1;
            password = password + "" + (char)j;
        }

    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }
}