package slang.compiler.Pace_Two.LexicalAnalyzer;
/*
 *
 * Copyright © 2021. #dltledgers Private Ltd. - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 * Written on behalf of #dltledgers ,  March  2022
 *
 */


import java.util.Locale;

public class SlangLexer {
    String expression;
    int index;
    double number;
    int length;
    private ValueTable[] valueTables = null;
    private String lastString;

    public SlangLexer(String expression) {
        this.expression = expression;
        this.length = expression.length();
        this.index = index;

        valueTables = new ValueTable[2];
        valueTables[0] = new ValueTable(TOKENS.TOKEN_PRINT, "PRINT");
        valueTables[1] = new ValueTable(TOKENS.TOKEN_PRINTLN, "PRINTLN");
    }

    public SlangLexer(String expression, int index, double number, int length) {
        this.expression = expression;
        this.index = index;
        this.number = number;
        this.length = expression.length();
    }

    public TOKENS getToken() {
        TOKENS tokens = TOKENS.ILLEGAL_TOKEN;

        while (index < length && expression.toCharArray()[index] == ' ' || index < length && expression.toCharArray()[index] == '\t') {
            index++;
        }
        if (index == length) {
            return TOKENS.TOKEN_NULL;
        }

        switch (expression.toCharArray()[index]) {
            case '+' -> {
                tokens = TOKENS.TOKEN_PLUS;
                index++;
            }
            case '-' -> {
                tokens = TOKENS.TOKEN_SUB
                ;
                index++;
            }
            case '*' -> {
                tokens = TOKENS.TOKEN_MUL;
                index++;
            }
            case '/' -> {
                tokens = TOKENS.TOKEN_DIV;
                index++;
            }
            case '(' -> {
                tokens = TOKENS.TOKEN_OPEN_PARENTHESIS;
                index++;
            }
            case ')' -> {
                tokens = TOKENS.TOKEN_CLOSE_PARENTHESIS;
                index++;
            }
            case ';' -> {
                tokens = TOKENS.TOKEN_SEMICOLON;
                index++;
            }
            default -> {
                if (Character.isDigit(expression.toCharArray()[index])) {
                    String str = "";
                    while (index < length && (expression.toCharArray()[index] == '0'
                            || expression.toCharArray()[index] == '1'
                            || expression.toCharArray()[index] == '2'
                            || expression.toCharArray()[index] == '3'
                            || expression.toCharArray()[index] == '4'
                            || expression.toCharArray()[index] == '5'
                            || expression.toCharArray()[index] == '6'
                            || expression.toCharArray()[index] == '7'
                            || expression.toCharArray()[index] == '8'
                            || expression.toCharArray()[index] == '9')) {
                        str += (expression.toCharArray()[index]);
                        index++;
                    }
                    number = Double.parseDouble(str);
                    tokens = TOKENS.TOKEN_DOUBLE;
                } else if (Character.isLetter(expression.toCharArray()[index])) {
                    String temp = "";
                    while (index < length && Character.isLetterOrDigit(expression.toCharArray()[index]) ||
                            expression.toCharArray()[index] == '_') {
                        temp += String.valueOf(expression.toCharArray()[index]);
                        index++;
                    }
                    temp = temp.toUpperCase(Locale.ROOT);
                    for (ValueTable value : valueTables) {
                        if (value.value().compareTo(temp) == 0) {
                            return value.token();
                        }

                    }
                    this.lastString = temp;
                    return TOKENS.TOKEN_UNQUOTED_STRING;


                } else {
                    throw new IllegalStateException("Unexpected value: " + expression.toCharArray()[index]);
                }

            }
        }
        return tokens;

    }

    public Double getNumber() {
        return number;
    }
}
