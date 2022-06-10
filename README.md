# Spring Framework CRUD Application

A demo app that uses the Spring MVC Framework to demonstrate a basic CRUD application. The application allows user to register a team, register players into the various teams,edit and delete player and team data and check fixtures and results among other functionalities.


Deployed site link: https://koyiolouis-crud.herokuapp.com/
## Running Locally

Make sure you have Java and Maven installed.  Also, install the [Heroku CLI](https://cli.heroku.com/).

```sh
$ git clone https://github.com/Louiskoyio/SpringBootCRUD.git
$ cd SpringBootCRUD
$ mvn install
$ heroku local:start
```

Your app should now be running on [localhost:5000](http://localhost:5000/).

If you're going to use a database, ensure you have a local `.env` file that reads something like this:

```
JDBC_DATABASE_URL=jdbc:postgresql://localhost:5432/java_database_name
```


## Documentation

Technologies Used:
- Spring Boot
- HTML5
- CSS
- Java
- JavaScript
