package RestAssuredProject1.testNG.june_27.postpayloadUsingPOJO;

public class AuthClass {
    //Using encapsulation create POJO class
    //1. Create public default constructor
    //2. Create private variables
    //3. Create getter and setter methods

    //1. Create public default constructor
    public AuthClass(){

    }
    //2. Create private variables
    private String username;
    private String password;

    //3. Create getter and setter methods
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

}
