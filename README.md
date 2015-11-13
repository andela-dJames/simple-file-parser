# simple-file-parser

## Problem Description
This Excercise creates an application that reads data from a file, parses the data an inserts them into a database table.
The application logs its activities to file.
The application runs asyncronously i.e different threads run all the tasks simultaneously.

The file to be read is not a normal text file. Firstly this is a reactant file  this is not a tabbed file, it is a key-value OR attribute-value file. Here are all the attributes that repeat in the file

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

## Task one

The first task creates a Fileparser class that has methods for reading and parsing the reactant file into different records

