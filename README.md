# simple-file-parser

## Problem Description
This Excercise creates an application that reads data from a file, parses the data an inserts them into a database table.
The application logs its activities to file.
The application runs asyncronously i.e different threads run all the tasks simultaneously.

The file contains set of data  which was expoted from a Pathway/Geneome Database PGDB so that other programs and database management systems caan use them.
The data files generated from each PGDB fall into the following categories of formats. Note that in most cases the tabular files provide a subset of the information found in the attribute-value format files, but are typically easier to use.
To get more information on the format of the file, [visit PATHWAY TOOLS DATA-FILE FORMATS] (http://bioinformatics.ai.sri.com/ptools/flatfile-format.html)


>    UNIQUE-ID
>    TYPES
>    COMMON-NAME
>    ATOM-MAPPINGS
>    CANNOT-BALANCE?
>  CITATIONS
>   COMMENT
>    COMMENT-INTERNAL
>   CREDITS
>    DATA-SOURCE
>    DBLINKS
>    DELTAG0
>    DOCUMENTATION
>    EC-NUMBER
>    ENZYMATIC-REACTION
>    ENZYMES-NOT-USED
>    EQUILIBRIUM-CONSTANT
>    HIDE-SLOT?
>    IN-PATHWAY
>    INSTANCE-NAME-TEMPLATE
>    LEFT
>    MEMBER-SORT-FN
>    ORPHAN?
>    PATHOLOGIC-NAME-MATCHER-EVIDENCE
>    PATHOLOGIC-PWY-EVIDENCE
>    PHYSIOLOGICALLY-RELEVANT?
>    PREDECESSORS
>    PRIMARIES
>    REACTION-DIRECTION
>    REACTION-LIST
>    REGULATED-BY
>    REQUIREMENTS
>    RIGHT
>    RXN-LOCATIONS
>    SIGNAL
>    SPECIES
>    SPONTANEOUS?
>    STD-REDUCTION-POTENTIAL
>    SYNONYMS
>    SYSTEMATIC-NAME
>    TEMPLATE-FILE

## Task 1

 The first task creates a `FileParser` class that has methods for reading and parsing the reactant file into different records.
1. The fileparser class consist of a `Filereader` inner class which has the following methods:

- `createFile` creates a new bufferedfilereader

- `readFile` reads a file

- `isComment` ignores lines that are comments

- `invalid` ignores invalid lines

- `replace` adds double backslash to single quotes

- `remove` removes a space

- `delimeter` separates each line using a delimeter

 2. The `FileParser` outer class consist of the following methods
 
- `parse` parses a record containing all the records into smaller records using `UNIQUE-ID`.
- `parseFile` reads a file and parse its content into `KeyValue` pairs.
- `createKeyValue` takes an array of strings and creates `KeyValue` object.

3. The `KeyValue` class is an object that defines key-value pair.

4. The `Record` class consist of the following method
- `addNewKeyValue` adds a new object into a set of Records.
- `getKeyValue` returns the objects in a set of records.
- `size` returns the size of a reccord
- `contains` returns true if a record contains an object
- `isEmpty` returns true if a record is empty.
- `fields` returns a all the colums and rows in a set of records.
- `getKeys` returns a string builder with all the field names.
- `getValues` returns a stringbuilder with all the row names.
- `UNIQUE-ID` returns an object in a set of record which is unique key.

##Task 2

1. This tasks sets up the MYSQL database.
- Create a new Database with name > reactiondb
- Create a new Table with name >reactions
- Adds all the column names to the table.

2. Intall the MySQL j/connector

##Task 3

This task creates the `TempBuffer` class. This is a buffer that will hold the data that has been parsed before they are inserted into the database.
It is a data structure that works like an `ArrayBlockingQueue`. It has the following methods:

- `insert` adds a new item into a `TempBuffer`.
- `remove` removes and returns the object at the top of the queue
- `contains` returns true if a buffer contains an object.
- `size` returns the size of the buffer

##Task 4
This task creates a `DBWriter` class that has the following methods

- `connectToDB` creates a connection to a database








