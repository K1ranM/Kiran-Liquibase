# Kiran-Liquibase
Implementation for liquibase and integrate with CI/CD 


# Liquibase Project

Liquibase is an open-source database change management (DBCM) tool that helps you manage database schema changes in a version-controlled manner. It allows you to automate the deployment of database changes and manage different environments.

## Features

- Version control for database schema changes
- Supports various database types (MySQL, PostgreSQL, Oracle, SQL Server, etc.)
- Allows you to track, version, and deploy database changes easily
- Supports XML, YAML, JSON, and SQL changelog formats
- Provides rollback functionality to revert schema changes
- Integrates well with continuous integration (CI) tools

## Requirements

Before using Liquibase, make sure you have:

- Java 8 or later installed on your machine.
- A supported database management system (DBMS), such as MySQL, PostgreSQL, Oracle, SQL Server, etc.
- Liquibase CLI installed or you can use the Maven or Gradle plugins.

## Installation

### Using Homebrew (macOS)
You can install Liquibase via Homebrew:
```sh
brew install liquibase

