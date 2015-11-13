# simple-file-parser

## Problem Description
This Excercise creates an application that reads data from a file, parses the data an inserts them into a database table.
The application logs its activities to file.
The application runs asyncronously i.e different threads run all the tasks simultaneously.

The file contains set of data  which was expoted from a Pathway/Geneome Database PGDB so that other programs and database management systems caan use them.
The data files generated from each PGDB fall into the following categories of formats. Note that in most cases the tabular files provide a subset of the information found in the attribute-value format files, but are typically easier to use.
To get more information on the format of the file, [visit] (http://bioinformatics.ai.sri.com/ptools/flatfile-format.html)


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

The first task creates a Fileparser class that has methods for reading and parsing the reactant file into different records.
The fileparser class consist of a `Filereader` inner class which has the following methods:

1.`createFile` creates a new bufferedfilereader
2.`readFile` reads a file
3.`isComment` ignores lines that are comments
*`invalid` ignores invalid lines
*`replace` adds double backslash to single quotes
*`remove` removes a space
*`delimeter` separates each line using a delimeter



