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


### Peix(Fish) and Pescador(Fisherman) class.

The practice has been thought in such a way in which we deal with the relationship of a fish with its angler. The fish class is useful for storing data about fish.
  The fish data is found in the fishery files. The information is segmented into four parts through pads. This class is responsible for simplifying this data to be able to save it and later work with it in a simpler way.
First, the two constructor methods have been created. In one, the line of the fish that will be previously read from the fisheries file and transformed into a readable fish within the program is entered by parameter.
The second constructor is nothing more than a helper method in case you need to create fish with default values. Next, the initialize method has been created. This is complicated to explain since it is carried out through many mathematical operations and other auxiliary methods. But in a simplified way, it could be summarized in that in order to obtain the data that each fish has been divided into 4 segments, the name, the capture range, the maximum and minimum value of the weight and of each part in particular have been been making transformations to extract the information. In addition, to calculate the probability numbers and weights, two other auxiliary methods called calculateDecimalValue have been used.

The Fisher class is not that complex. In particular, this class has been created to show each user's best catches. 4 attributes have been declared: the name of the fisherman, an array of fish, the number of fish between both fishing grounds, and a constant that will be used to initialize the array of fish.
The constructor initializes the attributes.
The updateMillorPeix method compares the weight of the fish of the same species that arrive to save the largest. This uses an auxiliary method called afegeixNouPeix, which adds one more species of fish to the array.


### Fishing simulator class.

This class allows all menu options to work.

There are auxiliary files that will help when unsubscribing or registering users.

The first method found is to showPuntuacioGlobal, whose purpose is to allow you to see the global statistics of all users. You will go through the fishing file to find the biggest catches of each type of fish. We will look at who caught it so we can print it on the screen. An auxiliary private method called showPuntuacioGlobalPesqueres is used, to be able to use it for both fisheries files, Florida and Mediterránea.

Similar code is used for individual statistics, with the showScore method. What it does is similar, only this time the fish will be searched according to the user entered, and the comparison will be made to find out which ones have the greatest weight.

In order to execute the option of going fishing at a fishing station, two more methods have been created in this class. One is literally fishing, which depending on which fishery you decide to go to, you can catch different fish. When fishing, a random will be used, which will give a number between 0 and 1. Each fish has a number between those and depending on the number that comes out, one fish or another will be caught. The fish that will be caught will be the fish that is just above that number. In addition, the weight of the fish will also be a random between the two numbers that the list enables.

The escriurePesca method, what it does is write the fish in the format with the pads inside a file. All the catches are written next to the user. In addition, an auxiliary file will be created where the new catches will be transferred.

User registration method. What this method does is check if the users file exists, since if not, the file should be created and the first username recorded. If it already existed beforehand, you must check if the user you are trying to register had already registered previously, since in that case an error would occur since it is not possible to repeat the name. In the event that this username did not previously exist, the new user would be written to the file and therefore the registration would be successful.
To carry out this method, other private methods have been used to facilitate all operations. The first, writeFirstUser, opens the file, writes the user passed by parameter and closes the file. The second, existenixUsuari, scans the file to check whether or not that same user from before already existed. And the third submethod is the one that allows the first user to write a file. A new file is created and the first user is written, passed by parameter.

The last function is to unsubscribe users and for this purpose a submethod called deleteUsuari has also been developed. This plays with two files, an auxiliary one where it will copy all the users saved beforehand except the one you want to delete. Later all this information will return to the original file and the auxiliary will be deleted. Finally, the files are closed to avoid problems.
So what the baixUsuari method first does is check that the user file exists, since if not, it could not delete any user. If so, you must verify that the user already existed beforehand to be able to delete it now.




