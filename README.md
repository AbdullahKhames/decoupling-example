decoupling example with java
here we implement a decoupling example from laur spilca's book spring start here
but with real interfaces and classes
using jdbc to store and retrieve data from a database
and using java mail to send emails to the user
with org.eclipse.angus angus mail implementation of the java mail specification
here we define some properties for connecting to the database and the mail server
the database propertiees are set in config package's class connection provider
we define the driver class with driver manager or class.forname for my sql driver in a static block inside thhe configuration class
then we use the driver manager to instantiate a connection object and return it to the caller

and for mail server connection we use a test mail server called Mailtrap and its configuratiojn inside the resources folder
we use the java mail api to send emails to the user
the connection properties is then called within the mailtrap configuration class
with classloader.getResourceAsStream method to load the properties file
then we use the properties to instantiate a java mail session object with authentication
and then we use the session object to instantiate a java mail message object
and then we use the message object to set the message content and the recipient
and then we use the transport object to send the message to the recipient
and then we close the transport object
and then we close the session object

so in conclusion
we have a decoupled application
with a database layer
and a mail layer
and a service layer
the service layer is the one that does the business logic
here the business logic is to send an email to the user with the comment content
but first it must be saved to the database
so we depend on the database layer to save the comment
and then we depend on the mail layer to send the email
and we call both of them from the service layer
but decoupling here means that whenever we want to change the database layer we can just provide a diffrennct implementation to the repository interface in our service
and will still work the same
and same for the proxy if we want to change the implementation of the sending notification to client 
we can use a different implementation of the  comment proxy interface and it will still work the same
