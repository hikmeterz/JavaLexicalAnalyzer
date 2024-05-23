# JavaLexicalAnalyzer
## Project Description
This repository contains a Java program that performs lexical analysis on a given input file containing Java code. The program reads the input file, identifies tokens, and outputs the results of the lexical analysis to an output file. It also detects and reports lexical errors in the code.

## Files
- `Lexical.java`: Java program that performs lexical analysis.
- `input.txt`: Sample input file containing Java code for analysis.
- `output1.txt`, `output9.txt`, `output11.txt`, `output12.txt`: Sample output files showing the results of the lexical analysis.
- `sample.txt`: Example output file demonstrating the expected format of the analysis results.

## Java Program Description

### `Lexical.java`
This Java program reads a file containing Java code and performs lexical analysis to identify tokens such as keywords, identifiers, operators, and literals. The program also checks for lexical errors and reports them. The results of the analysis are written to an output file.

### Key Features:
- Identifies various tokens in the Java code, including keywords (e.g., `for`, `int`, `char`), operators (e.g., `=`, `+`, `<=`), and literals (e.g., `0`, `10`).
- Reports unknown identifiers and other lexical errors.
- Outputs the results in a specified format, showing each token and its corresponding lexeme.

### Example Input (input.txt)
```java
for (int i = 0; i <= 10; i=i+1)                     
{
a = f;
char c;
}
return 0;

Example Output (sample.txt)

Next token is FOR_STATEMENT Next lexeme is for
Next token is LPARANT Next lexeme is (
Next token is INT_TYPE Next lexeme is int
Next token is identifier Next lexeme is i
Next token is ASSIGNM Next lexeme is =
Next token is INT_LIT Next lexeme is 0
Next token is SEMICOLON Next lexeme is ;
Next token is identifier Next lexeme is i
Next token is LESS Next lexeme is <
Next token is INT_LIT Next lexeme is 10
Next token is SEMICOLON Next lexeme is ;
Next token is identifier Next lexeme is i
Next token is ASSIGNM Next lexeme is =
Next token is identifier Next lexeme is i
Next token is ADD Next lexeme is +
Next token is INT_LIT Next lexeme is 1
Next token is RPARANT Next lexeme is )
Next token is LCURLYB Next lexeme is {
Next token is identifier Next lexeme is a
Next token is ASSIGNM Next lexeme is =
Next token is identifier Next lexeme is f
Next token is SEMICOLON Next lexeme is ;
Next token is CHAR_TYPE Next lexeme is char
Next token is identifier Next lexeme is c
Next token is SEMICOLON Next lexeme is ;
Next token is RCURLYB Next lexeme is }
Next token is RETURN_STMT Next lexeme is return
Next token is INT_LIT Next lexeme is 0
Next token is SEMICOLON Next lexeme is ;
