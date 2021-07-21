# toy-bot
A toy bot for code testing

The code is written in Java with gradlew for some simple dependency management.

Most of method are covered with unit test/integration test, but not 100% covered due to the time limit.

To run the file, just need to call
`java -jar .\toy-robot-1.0-SNAPSHOT.jar`
in the root folder.

Going through the class:
Robot - Class to store and update state
CommandHandler - Class to handle user input
PositionUtils - Util class to resolve position calculation
Runner - Main class to take in user input and pass to commandHandler

