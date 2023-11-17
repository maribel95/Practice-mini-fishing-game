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

The first class that has been created is called FEscriptura ("Fitxer Escriptura" in Catalan for short). In this you can find different methods that will facilitate the functions of opening and writing to files.
The constructor will prepare the output of the file whose name will have been passed as an argument.
A method that writes to the file has been programmed.
There is a variant where a line break is added at the end of the writing.
Finally, there is a method that closes the file.

The second class is called FLectura ("Fitxer Lectura", in Catalan).

The constructor opens the file, with the name indicated as a parameter.
There is a method that will read the file line by line.
And another method that closes the file.

### Paraula(Word) and LT(Lectura Teclat = Keyboard reading) class.

These are the classes that have been provided throughout the course by the teacher.

A constructor has been added to the Paraula class. A parameter is added that will contain the text as a char array. This serves to convert an entered user into an object of the paraula class.

Added a method that returns a boolean value that compares whether two words are equal. It is used to check that the registrations and cancellations are correct.


### Peix(Fish) and Pescador(Fisherman) Class.

The practice has been thought in such a way in which we deal with the relationship of a fish with its angler. The fish class is useful for storing data about fish.
  The fish data is found in the fishery files. The information is segmented into four parts through pads. This class is responsible for simplifying this data to be able to save it and later work with it in a simpler way.
First, the two constructor methods have been created. In one, the line of the fish that will be previously read from the fisheries file and transformed into a readable fish within the program is entered by parameter.
The second constructor is nothing more than a helper method in case you need to create fish with default values. Next, the initialize method has been created. This is complicated to explain since it is carried out through many mathematical operations and other auxiliary methods. But in a simplified way, it could be summarized in that in order to obtain the data that each fish has been divided into 4 segments, the name, the capture range, the maximum and minimum value of the weight and of each part in particular have been been making transformations to extract the information. In addition, to calculate the probability numbers and weights, two other auxiliary methods called calculateDecimalValue have been used.

The Fisher class is not that complex. In particular, this class has been created to show each user's best catches. 4 attributes have been declared: the name of the fisherman, an array of fish, the number of fish between both fishing grounds, and a constant that will be used to initialize the array of fish.
The constructor initializes the attributes.
The updateMillorPeix method compares the weight of the fish of the same species that arrive to save the largest. This uses an auxiliary method called afegeixNouPeix, which adds one more species of fish to the array.





