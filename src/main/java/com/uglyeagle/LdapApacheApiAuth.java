package com.uglyeagle;

import org.apache.directory.ldap.client.api.LdapConnection;
import org.apache.directory.ldap.client.api.LdapNetworkConnection;
import org.apache.directory.api.ldap.model.cursor.EntryCursor;
import org.apache.directory.api.ldap.model.entry.Entry;

import java.util.Scanner;

public class LdapApacheApiAuth {

    private static final String HOST = "localhost";
    private static final int PORT = 10389;
    private static final String BASE_DN = "dc=example,dc=com";

    private static final String ADMIN_DN = "uid=admin,ou=system";
    private static final String ADMIN_PASSWORD = "secret";

    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter username: ");
        String username = sc.nextLine();

        System.out.print("Enter password: ");
        String password = sc.nextLine();

        // Step 1: search DN
        String userDN = findUserDN(username);

        if (userDN == null) {
            System.out.println("User not found");
            return;
        }

        System.out.println("Found DN: " + userDN);

        // Step 2: bind
        boolean success = authenticate(userDN, password);

        if (success) {
            System.out.println("Login SUCCESS");
        } else {
            System.out.println("Invalid credentials");
        }
    }

    private static String findUserDN(String username) throws Exception {

        LdapConnection connection = new LdapNetworkConnection(HOST, PORT);
        connection.bind(ADMIN_DN, ADMIN_PASSWORD);

        String filter = "(uid=" + username + ")";

        EntryCursor cursor = connection.search(BASE_DN, filter, org.apache.directory.api.ldap.model.message.SearchScope.SUBTREE);

        if (cursor.next()) {
            Entry entry = cursor.get();
            String dn = entry.getDn().toString();
            connection.unBind();
            return dn;
        }

        connection.unBind();
        return null;
    }

    private static boolean authenticate(String userDN, String password) {
        try {
            LdapConnection connection = new LdapNetworkConnection(HOST, PORT);
            connection.bind(userDN, password);
            connection.unBind();
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
