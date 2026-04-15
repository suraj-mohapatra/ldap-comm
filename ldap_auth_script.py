import ldap3
from ldap3.core.exceptions import LDAPBindError, LDAPException

LDAP_URL = "ldap://localhost:10389"
BASE_DN = "dc=example,dc=com"

# Admin credentials (used only for search)
ADMIN_DN = "uid=admin,ou=system"
ADMIN_PASSWORD = "secret"


def find_user_dn(username: str) -> str | None:
    """🔍 Step 1: Search user DN using admin bind."""
    server = ldap3.Server(LDAP_URL, get_info=ldap3.ALL)

    with ldap3.Connection(
        server,
        user=ADMIN_DN,
        password=ADMIN_PASSWORD,
        authentication=ldap3.SIMPLE,
        auto_bind=True
    ) as conn:
        conn.search(
            search_base=BASE_DN,
            search_filter=f"(uid={username})",
            search_scope=ldap3.SUBTREE,
            attributes=[]
        )

        if conn.entries:
            return conn.entries[0].entry_dn

    return None


def authenticate(user_dn: str, password: str) -> bool:
    """🔐 Step 2: Authenticate using user DN (bind attempt)."""
    server = ldap3.Server(LDAP_URL, get_info=ldap3.ALL)

    try:
        with ldap3.Connection(
            server,
            user=user_dn,
            password=password,
            authentication=ldap3.SIMPLE,
            auto_bind=True
        ):
            return True
    except (LDAPBindError, LDAPException):
        return False


def main():
    username = input("Enter username: ").strip()
    password = input("Enter password: ").strip()

    try:
        # Step 1: Find the user's DN
        user_dn = find_user_dn(username)

        if user_dn is None:
            print("❌ User not found")
            return

        print(f"Found DN: {user_dn}")

        # Step 2: Authenticate
        if authenticate(user_dn, password):
            print("✅ Login SUCCESS")
        else:
            print("❌ Invalid credentials")

    except Exception as e:
        print(f"Error: {e}")


if __name__ == "__main__":
    main()
