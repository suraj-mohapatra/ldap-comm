
import java.util.Hashtable;
import java.util.Scanner;
import javax.naming.Context;
import javax.naming.NamingEnumeration;
import javax.naming.directory.*;

public class LdapRealAuth {

    private static final String LDAP_URL = "ldap://localhost:10389";
    private static final String BASE_DN = "dc=example,dc=com";

    // Admin credentials (used only for search)
    private static final String ADMIN_DN = "uid=admin,ou=system";
    private static final String ADMIN_PASSWORD = "secret";

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter username: ");
        String username = sc.nextLine();

        System.out.print("Enter password: ");
        String password = sc.nextLine();

        try {
            // Step 1: Search user DN
            String userDN = findUserDN(username);

            if (userDN == null) {
                System.out.println("❌ User not found");
                return;
            }

            System.out.println("Found DN: " + userDN);

            // Step 2: Authenticate (bind)
            boolean isAuthenticated = authenticate(userDN, password);

            if (isAuthenticated) {
                System.out.println("✅ Login SUCCESS");
            } else {
                System.out.println("❌ Invalid credentials");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 🔍 Step 1: Search user DN using admin
    private static String findUserDN(String username) throws Exception {

        Hashtable<String, String> env = new Hashtable<>();

        env.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory");
        env.put(Context.PROVIDER_URL, LDAP_URL);
        env.put(Context.SECURITY_AUTHENTICATION, "simple");
        env.put(Context.SECURITY_PRINCIPAL, ADMIN_DN);
        env.put(Context.SECURITY_CREDENTIALS, ADMIN_PASSWORD);

        DirContext ctx = new InitialDirContext(env);

        String filter = "(uid=" + username + ")";

        SearchControls controls = new SearchControls();
        controls.setSearchScope(SearchControls.SUBTREE_SCOPE);

        NamingEnumeration<SearchResult> results
                = ctx.search(BASE_DN, filter, controls);

        if (results.hasMore()) {
            SearchResult result = results.next();
            String userDN = result.getNameInNamespace();
            ctx.close();
            return userDN;
        }

        ctx.close();
        return null;
    }

    // 🔐 Step 2: Authenticate using user DN
    private static boolean authenticate(String userDN, String password) {

        Hashtable<String, String> env = new Hashtable<>();

        env.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory");
        env.put(Context.PROVIDER_URL, LDAP_URL);
        env.put(Context.SECURITY_AUTHENTICATION, "simple");
        env.put(Context.SECURITY_PRINCIPAL, userDN);
        env.put(Context.SECURITY_CREDENTIALS, password);

        try {
            DirContext ctx = new InitialDirContext(env);
            ctx.close();
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
