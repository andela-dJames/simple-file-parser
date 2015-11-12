# simple-file-parser

## Problem Description
In this exercise, you will be required to write a multithreaded application, which reads in data from a text document, parses the document and saves the data into a mysql database while generating an action log at the same time. 

A thread reads in the data into a buffer(temporary storage), another writes it into the database, and the third writes into a log file simultaneously. Each thread logs its action and records time it takes to complete its task.
