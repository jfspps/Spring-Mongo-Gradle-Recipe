[![CircleCI](https://circleci.com/gh/jfspps/Spring-Mongo-Gradle-Recipe.svg?style=svg)](https://app.circleci.com/pipelines/github/jfspps/Spring-Mongo-Gradle-Recipe)

# Demo Recipe App with Spring, MongoDB and Gradle
This project was introduced by [Springframeworkguru](https://github.com/springframeworkguru/spring5-mongo-recipe-app) 
and worked through to demonstrate the use of MongoDB and Gradle (as opposed to MySQL and Maven) with Spring 5. 
This project will also form part of the Reactive programming part of the course.

Like other projects on the course, we use CircleCI to automate and signify the completion of building and testing 
of the project. Deployment to a cloud service is not part of the project at this stage.

The reader is directed to the unit and integration tests of the project to better appreciate the use of data streams and 
block() when retrieving data.

The refactoring from WebMVS to WebFlux starts with a new branch 'webflux'. At the time of course completion, many of the 
features of reactive programming with Spring were not completely understood and hence some of the blocking code remains 
blocking. This demonstration is really a work in progress.

When working with reactive controllers and services and non-reactive templates (such as WebMVC), one returns 
.toProcessor().block to enable subscriptions. When working with reactive controllers, services and templates,
one returns references to either the Mono or Flux publishers, WebFLux then handles the rest.