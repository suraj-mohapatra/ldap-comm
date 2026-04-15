# LDAP Directory — Sample Users

Base DN: `dc=example,dc=com`

---

## 👨‍💻 Developers

> OU: `ou=developers,dc=example,dc=com` · Default Password: `dev123`

| UID | Common Name | Email |
|-----|-------------|-------|
| dev1 | Aarav Sharma | aarav.sharma@example.com |
| dev2 | Vivaan Patel | vivaan.patel@example.com |
| dev3 | Aditya Verma | aditya.verma@example.com |
| dev4 | Arjun Reddy | arjun.reddy@example.com |
| dev5 | Rohan Gupta | rohan.gupta@example.com |
| dev6 | Kunal Mehta | kunal.mehta@example.com |
| dev7 | Neha Singh | neha.singh@example.com |

<details>
<summary>View raw LDIF</summary>

```ldif
dn: uid=dev1,ou=developers,dc=example,dc=com
objectClass: inetOrgPerson
cn: Aarav Sharma
sn: Sharma
uid: dev1
mail: aarav.sharma@example.com
userPassword: dev123

dn: uid=dev2,ou=developers,dc=example,dc=com
objectClass: inetOrgPerson
cn: Vivaan Patel
sn: Patel
uid: dev2
mail: vivaan.patel@example.com
userPassword: dev123

dn: uid=dev3,ou=developers,dc=example,dc=com
objectClass: inetOrgPerson
cn: Aditya Verma
sn: Verma
uid: dev3
mail: aditya.verma@example.com
userPassword: dev123

dn: uid=dev4,ou=developers,dc=example,dc=com
objectClass: inetOrgPerson
cn: Arjun Reddy
sn: Reddy
uid: dev4
mail: arjun.reddy@example.com
userPassword: dev123

dn: uid=dev5,ou=developers,dc=example,dc=com
objectClass: inetOrgPerson
cn: Rohan Gupta
sn: Gupta
uid: dev5
mail: rohan.gupta@example.com
userPassword: dev123

dn: uid=dev6,ou=developers,dc=example,dc=com
objectClass: inetOrgPerson
cn: Kunal Mehta
sn: Mehta
uid: dev6
mail: kunal.mehta@example.com
userPassword: dev123

dn: uid=dev7,ou=developers,dc=example,dc=com
objectClass: inetOrgPerson
cn: Neha Singh
sn: Singh
uid: dev7
mail: neha.singh@example.com
userPassword: dev123
```

</details>

---

## 🧪 Testers

> OU: `ou=testers,dc=example,dc=com` · Default Password: `test123`

| UID | Common Name | Email |
|-----|-------------|-------|
| test1 | Priya Nair | priya.nair@example.com |
| test2 | Rahul Das | rahul.das@example.com |
| test3 | Sneha Iyer | sneha.iyer@example.com |
| test4 | Amit Yadav | amit.yadav@example.com |
| test5 | Pooja Kulkarni | pooja.kulkarni@example.com |
| test6 | Sandeep Mishra | sandeep.mishra@example.com |
| test7 | Kavya Menon | kavya.menon@example.com |
| test8 | Rohit Jain | rohit.jain@example.com |
| test9 | Ananya Chatterjee | ananya.chatterjee@example.com |
| test10 | Vikram Joshi | vikram.joshi@example.com |

<details>
<summary>View raw LDIF</summary>

```ldif
dn: uid=test1,ou=testers,dc=example,dc=com
objectClass: inetOrgPerson
cn: Priya Nair
sn: Nair
uid: test1
mail: priya.nair@example.com
userPassword: test123

dn: uid=test2,ou=testers,dc=example,dc=com
objectClass: inetOrgPerson
cn: Rahul Das
sn: Das
uid: test2
mail: rahul.das@example.com
userPassword: test123

dn: uid=test3,ou=testers,dc=example,dc=com
objectClass: inetOrgPerson
cn: Sneha Iyer
sn: Iyer
uid: test3
mail: sneha.iyer@example.com
userPassword: test123

dn: uid=test4,ou=testers,dc=example,dc=com
objectClass: inetOrgPerson
cn: Amit Yadav
sn: Yadav
uid: test4
mail: amit.yadav@example.com
userPassword: test123

dn: uid=test5,ou=testers,dc=example,dc=com
objectClass: inetOrgPerson
cn: Pooja Kulkarni
sn: Kulkarni
uid: test5
mail: pooja.kulkarni@example.com
userPassword: test123

dn: uid=test6,ou=testers,dc=example,dc=com
objectClass: inetOrgPerson
cn: Sandeep Mishra
sn: Mishra
uid: test6
mail: sandeep.mishra@example.com
userPassword: test123

dn: uid=test7,ou=testers,dc=example,dc=com
objectClass: inetOrgPerson
cn: Kavya Menon
sn: Menon
uid: test7
mail: kavya.menon@example.com
userPassword: test123

dn: uid=test8,ou=testers,dc=example,dc=com
objectClass: inetOrgPerson
cn: Rohit Jain
sn: Jain
uid: test8
mail: rohit.jain@example.com
userPassword: test123

dn: uid=test9,ou=testers,dc=example,dc=com
objectClass: inetOrgPerson
cn: Ananya Chatterjee
sn: Chatterjee
uid: test9
mail: ananya.chatterjee@example.com
userPassword: test123

dn: uid=test10,ou=testers,dc=example,dc=com
objectClass: inetOrgPerson
cn: Vikram Joshi
sn: Joshi
uid: test10
mail: vikram.joshi@example.com
userPassword: test123
```

</details>

---

## 🧑‍💼 HR

> OU: `ou=hr,dc=example,dc=com` · Default Password: `hr123`

| UID | Common Name | Email |
|-----|-------------|-------|
| hr1 | Meera Kapoor | meera.kapoor@example.com |
| hr2 | Rajesh Khanna | rajesh.khanna@example.com |
| hr3 | Sunita Verma | sunita.verma@example.com |

<details>
<summary>View raw LDIF</summary>

```ldif
dn: uid=hr1,ou=hr,dc=example,dc=com
objectClass: inetOrgPerson
cn: Meera Kapoor
sn: Kapoor
uid: hr1
mail: meera.kapoor@example.com
userPassword: hr123

dn: uid=hr2,ou=hr,dc=example,dc=com
objectClass: inetOrgPerson
cn: Rajesh Khanna
sn: Khanna
uid: hr2
mail: rajesh.khanna@example.com
userPassword: hr123

dn: uid=hr3,ou=hr,dc=example,dc=com
objectClass: inetOrgPerson
cn: Sunita Verma
sn: Verma
uid: hr3
mail: sunita.verma@example.com
userPassword: hr123
```

</details>

---

## Summary

| OU | Count | Password |
|----|-------|----------|
| developers | 7 | `dev123` |
| testers | 10 | `test123` |
| hr | 3 | `hr123` |
| **Total** | **20** | — |
