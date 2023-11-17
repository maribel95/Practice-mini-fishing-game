# Practice-mini-fishing-game
This is a fishing simulator. It is played through the terminal, where a menu with different options will be displayed.

- Choose fishing. In this case, the locations are Florida and the Mediterranean.
- Register user.
- Unsubscribe user.
- Start fishing.
- Game statistics. They can be reviewed by individual user, or globally for all players. Even if a user has lost their license, their statistics will still be recorded and will continue to contribute to the overall statistics report.

One of the fundamental requirements to go fishing is to have first registered our user. Registering would be the equivalent of granting a license to go fishing. So if we unsubscribed that same user, his license would be withdrawn and he would no longer be able to fish again until he recovered it.

When you choose the option to go fishing at a fishery, it will be necessary to enter the username to check if it has the license or not.

The licensing system has been controlled. You cannot unsubscribe a user that does not exist. Nor register a user who is already registered.

## Classes

In order to carry out this program, up to 8 different classes have been created, all within the same package. A better approach would have been to create several packages, where each grouped classes according to more specific functions. This way we can make a more conceptual classification of the classes.

### Reading and writing files:

The first class that has been created is called FEscriptura ("Fitxer scriptura" in Catalan for short). In this you can find different methods that will facilitate the functions of opening and writing to files.
  The constructor will prepare the output of the file whose name will have been passed as an argument.
A method that writes to the file has been programmed.
There is a variant where a line break is added at the end of the writing.
Finally, there is a method that closes the file.

The second class is called FLectura ("Fitxer Lectura", in Catalan).

The constructor opens the file, with the name indicated as a parameter.
There is a method that will read the file line by line.
And another method that closes the file.

### Paraula(Word) and LT class.

These are the classes that have been provided throughout the course by the teacher.

A constructor has been added to the Paraule class. A parameter is added that will contain the text as a char array. This serves to convert an entered user into an object of the paraula class.

Added a method that returns a boolean value that compares whether two words are equal. It is used to check that the registrations and cancellations are correct.

