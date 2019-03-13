# Spell-Checker

This is code I wrote a while ago for an assignment in my data structures class.
StringSet is a hash-based set that can store strings and quickly look them up. 
SpellChecker is the driver application. It loads an entire dictionary into my StringSet.
Next, the user is promted to type a word and I check to see if the word is in the set.
If the word is not found, words that are spelled differently by one letter are suggested.
