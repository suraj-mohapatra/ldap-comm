
import java.util.Hashtable;
import javax.naming.Context;
import javax.naming.directory.DirContext;
import javax.naming.directory.InitialDirContext;

public class LdapAuthTest {

    public static void main(String[] args) {

        String username = "dev1";
        String password = "dev123";

        String ldapUrl = "ldap://localhost:10389";
        String baseDN = "dc=example,dc=com";

        // Step 1: construct user DN
        String userDN = "uid=" + username + ",ou=developers," + baseDN;

        Hashtable<String, String> env = new Hashtable<>();

        env.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory");
        env.put(Context.PROVIDER_URL, ldapUrl);
        env.put(Context.SECURITY_AUTHENTICATION, "simple");
        env.put(Context.SECURITY_PRINCIPAL, userDN);
        env.put(Context.SECURITY_CREDENTIALS, password);

        try {
            DirContext ctx = new InitialDirContext(env);
            System.out.println("Authentication SUCCESS");
            ctx.close();
        } catch (Exception e) {
            System.out.println("❌ Authentication FAILED");
            e.printStackTrace();
        }
    }
}
