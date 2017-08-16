# spring-boot-aspects-prototype

Run Projects
1. Install Java 8
2. Install Postgres 9.5
3. Create a database called spring-boot-aspects-prototype
4. Change HibernateConfig.java db-user and db-password to your postgres user and password.

After Spring bootRun
1. Create Team Juventus FC.
HTTP Post http://localhost:8080/Team/Juventus FC

2. Create Team Juventus FC again, will throw BusinessRuleException.
This rule CanNotCreateTeamWithDuplicateName.java is an aspect weaved to factory, a spring managed bean.

2. Change Team name to FIFA.
HTTP Post http://localhost:8080/Team/1/FIFA
This will throw another BusinessRuleException.
This rule TeamNameCanNotBeFIFA.java is an aspect weaved to Domain Entity, managed by Hibernate.

IntelliJ VM options
-ea
-javaagent:aspectjweaver-1.8.10.jar
-javaagent:spring-instrument-4.3.6.RELEASE.jar
