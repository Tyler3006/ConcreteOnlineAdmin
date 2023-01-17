
package nz.co.concreteOnlineA.users;

/**
 *
 * @author Tyler Costa
 */
public class User {
    
    private String userName;
    private String companyName;
    private String passWord;
    private int uniqueCode;
    private boolean isAdmin = false; 
    
    public User (String userName, String passWord, boolean isAdmin){
        this.userName = userName;
        this.passWord = passWord;
        this.isAdmin = isAdmin;
    }
    
}
 