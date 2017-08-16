# EasyFly
EasyFly is a local travel search site of EasyFly airline that makes it easy for you to find the prices on flights and travel deals. 
With one click you find the best EasyFly airline flight prices. We show you the cheapest departure and arrival dates. 
And when you are ready to book, you can do this with one action. We provide the tickets and we are a free and independent service for all travellers.
## Table of Contents

- [Introduction](#EasyFly)
- [Table of Content](#table-of-contents)
- [Getting Started](#getting-started)
- [Installation](#installation)
- [Deployment](#deployment)
- [Running tests](#running-tests)
- [Built](#built-with)
- [Directory Structure](#directory-structure)
- [License](#license)

## Getting Started
These instructions will get you a copy of the project up and running on your local machine for development and testing purposes. See deployment for notes on how to deploy the project on a live system.
## Installation

- first install the server_library in your local maven repository: https://github.com/Antoooni/EasyFlyWebProject.git
- run the following commands:

```bash
# clone the repository
git clone https://github.com/Antoooni/EasyFlyWebProject.git
cd repository
# install the project's dependencies
mvn clean install
```

## Deployment

To deploy the newest version of the repository:

- first create the database on your deployment server. The sql file is in the "deployment/dumps" folder of the project. To install the database on your local machine, run the following commands with your database credentials:

```bash
cd repository/deployment/dumps
mysql -u username -p orchestrator < orchestrator.sql
```

- copy the war file to your tomcat WepApps directory on your deployment server. In linux systems, this is usually the directory "/usr/share/tomcat7/webapps". The war file is in the folder "repository/target" after the installation.

- start the tomcat server over the console

```bash
sudo service tomcat7 start
```

# Running tests

The tests are all executed during installation of the library. To execute the unit tests
without installation, do the following:

```bash
cd server_library
mvn test
```

## Built With

* [Maven](https://maven.apache.org/) - Dependency Management


## Directory Structure

```
.
├── src                        <- source code of the application
|   |                          <- servlet class and guice modules 
│   ├── bin                    <- entity classes
│   ├── cookie                 <- cookie classes
│   ├── dao                    <- data access object classes
│   ├── exception              <- exception classes
│   ├── filter                 <- filter classes
│   ├── service                <- service classes
│   ├── servlet                <- controller classes
│   ├── util                   <- util classes
│   └── resources              <- config and property files
│   
├── WebContent                 <- compiled classes and libs
├── deployment                 <- SQL dumps and war files for deployment
├── test                       <- API- and unit-tests
│   └── test                   <- API tests for all controllers
├── README.md                  <- this file
└── pom.xml                    <- maven project file containing all dependencies of the project
```

## License

This project is licensed under the MIT License - see the [LICENSE.md](LICENSE) file for details
