package fa20_bcs_060;


public class Login {
    private String loginId;
    private String password;

    public Login(String loginId, String password){
        this.loginId = loginId;
        this.password = password;
    }

    public boolean checkUserNamePass(){
        if (loginId.equals("admin") && password.equals("123")){
            return true;
        }
        else{
            return false;
        }
    }
}
