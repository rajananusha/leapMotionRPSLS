# Rock Paper Scissors Lizard Spock

This is a a version of the Rock Paper Scissors Lizard Spock (RPSLS) game from the TV show; The Big Bang Theory. You, the player, play against the computer. The game uses a LeapMotion device for gesture recognition, so you can play against the computer using hand gestures like the actual game. 
This is a classic man vs machine game but the computer uses a KMP Learning algorithm to figure out a pattern in your gameplay and uses that knowledge to try and beat you. You play a round of Rock Paper Scissors Lizard Spock every 3 seconds and the computer records your move and if you won or lost. The computer saves your winning streak. The goal is to see how long you can last against the game.

## How to run this project

You will need the LeapMotion developer kit to run this project.

### Prerequisites

To run this project you will need to install:
* Java SE 7 installed
* [LeapMotion](https://www.leapmotion.com/) gesture recognition device

### Running the project

To run the project, clone this repository and run:
```
cd src
javac GestureListener.java
java GestureListener
```