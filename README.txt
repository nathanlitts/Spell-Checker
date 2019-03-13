# Spell-Checker

This is code I wrote a while ago for an assignment in my data structures class. 
StringSet is a hash-based set that can store strings and quickly look them up. 
SpellChecker is the driver application. It loads an entire dictionary into my StringSet. 
Next, the user is promted to type a word and I use the set do check if the word if spelled correctly. 
If it is not, then alternative words that are spelled differently by one letter are suggested.

To run this, I used:  
javac *.java
java SpellChecker

CTRL + C to stop.
