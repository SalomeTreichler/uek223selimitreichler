In this exercise the goal is to implement security to our entire application.
The focus of this exercise is to understand and use JWTs as a means of authorization and authentication. 
In this exercise the entire progress has already been implemented, so please have at a look at the provided examples.

As a next step you have to implement the security into your own application, be wary as a lot has been added and changed:
- New package called "security" in the "config" package
  - 3 new classes in this package, these are:
    - JWTAuthenticationFilter
    - JWTAuthorizationFilter
    - PasswordEncoder
- New package called "logging" in the "config" package with the class "LoggerConfig"
- The class "PropertyReader" in the "config" package
- New properties file under "resources" called "jwt.properties"
- The IDs for each class are now UUIDs
  - There are now multiple new annotations for the IDs in the business objects
  - The services must be updated, specifically the parameters which use the ID
  - The repositories must be updated, specifically the parameters sent in the extends part
  - The Controllers must be updated, specifically the parameters which use the ID
  - The DTOs must be updated, specifically the IDs
- We can no longer simply use every end point, we now have to login first and copy out the JWT and use it ourselves
  For more information on this specific topic check the included document "JWT_in_Postman.docx"

Now for implementing JWTs onto your own application follow these instructions:
1. Change the IDs from ints to Strings, this includes changing the business objects, the repositories, the services,
   the service implementations, the DTOs and the controllers
2. Create the files mentioned above, for comparisons check the provided example
3. Start postman and do a testrun, make sure you have a user already in your database

Beware that once the security measures are in place the passwords will be encrypted, 
this means simply creating the user in the database won't work. In the security config under the method "cofigure" you'll find 
ant-matchers with end points such as "/swagger-ui.html". Simply add ', "/**"' behind those ant-matchers to deactivate the
security.

Additional exercise:
How could we make changes like this easier to handle? Construct some ideas.