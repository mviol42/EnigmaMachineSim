# EnigmaMachineSim

Link to YouTube video: https://youtu.be/8zw7RAh-rro

Link to implementation docs: https://drive.google.com/drive/folders/1efcE5h0GWOXAlgVWJdeC05LQ7fcBfA_q?usp=sharing


User’s Guide Preface:
As a brief overview, Engima functions by taking an inputted character, passing it as an electrical signal forwards and backward through a set of rotors, and 
giving the output. The reason that Enigma doesn’t always encode each letter to the same character is that the user gets to define the order of rotors, each of 
which scrambles the characters differently. They also get to choose the rotor offsets. These rotor offsets literally offset the encryptions of characters. 
Moreover, the rotors move with each new character typed, meaning that the settings have to be identical for someone to decrypt and an encrypted message. 
For more information, see the following links (also found in the implementation doc at the EnigmaK_GUI section):
    https://en.wikipedia.org/wiki/Enigma_rotor_details
    https://www.cryptomuseum.com/crypto/enigma/wiring.htm 
    http://users.telenet.be/d.rijmenants/en/enigmatech.htm#wiringdiagram
    https://www.youtube.com/watch?v=G2_Q9FoD-oQ  


User's guide:
Run the main program (inside of EnigmaK_GUI) and, once prompted in the console, point the code to the .txt file you wish to encrypt. For the TA's, we recommend 
using a file inside of test/resources/. This .txt file should contain the phrase that you wish to encrypt. Alternatively, if you would like to use your own file,
we recommend placing it in the project folder, EnigmaMachineSim, so that you don’t have to specify a file path.

Next, you will be prompted to choose the position of the reflector, the order of the rotors, and each of the rotors’ positions. Set the rotors and positions 
within the acceptable values (acceptable values are printed in the console prompt). Please remember the settings you use here. If you do not keep them, you will 
not be able to decrypt your encrypted message.

Once all the rotors are set and you have your input file, it will automatically put the output in src/resources/output.txt. This file contains your encrypted 
message, also known as a ciphertext.

To decrypt the message, copy and paste that text into a new .txt file, point the program to it and enter the same rotor settings  you had before (this process 
should be the same as for when you originally encrypted), and watch as magical enigma things happen! 
These settings must be identical for Enigma to work.

Please note that if you do not specify a valid input file, the program will throw a FileNotFoundException.


A few other notes that may answer some questions:
1) The text in src/resources/output.txt will be your encrypted/decrypted file!
2) Each rotor does not understand where they are in the order of other rotors. That is handled by EnigmaK_GUI, which also has the predefined rotor maps for 
    the specific model of Enigma (Enigma K) that we are using. This handling is passed on to the Enigma class, which has no predefined aspects to it. The 
    theory behind this design is that rotors could be implemented in a different Enigma system and that Enigma could be used with different sets of rotors, or 
    even allow more rotors than are currently being used. The main method would need to be edited with new rotors, and, if this was with a different alphabet,    
    ALPHABET_SIZE would need to be changed throughout all of the classes. 
3) RotorList is functionally almost identical to a normal linked list, save for it also having a previous.
4) As previously stated, the ArrayLists which specify the wiring being used to scramble the letters here are from Enigma K. For this to work, there need to be 
the three rotors that the user chooses the order for and the reflector (known as the UKW) that, in this model, has a customizable position. It is important to 
note that, unlike the other rotors, the reflector’s position does not change as more letters are passed through the machine. There is also an entry wheel (known 
as ETW) that is sort of hidden. It adds one more layer of encryption. The user has no access to this wheel and it is not customizable. Moreover, like the 
reflector, this wheel does not rotate as letters are passed through.
