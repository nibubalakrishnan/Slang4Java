package slang.compiler.Pace_Two.LexicalAnalyzer;
/*
 *
 * Copyright © 2021. #dltledgers Private Ltd. - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 * Written on behalf of #dltledgers ,  March  2022
 *
 */


import slang.compiler.Pace_One.Expressions.Expression;
import slang.compiler.Pace_One.Expressions.OPERATORS;
import slang.compiler.Pace_One.Expressions.Types.BinaryEvaluator;
import slang.compiler.Pace_One.Expressions.Types.NumeralStore;
import slang.compiler.Pace_One.Expressions.Types.UnaryEvaluator;
import slang.compiler.Pace_Three.Statements.PrintLineStatement;
import slang.compiler.Pace_Three.Statements.PrintStatement;
import slang.compiler.Pace_Three.Statements.Statement;

import java.util.ArrayList;

public class RDParser extends SlangLexer {
    TOKENS presentToken;
    TOKENS lastToken;


    public RDParser(String expression) {
        super(expression);
    }

    public RDParser(String expression, int index, double number, int length) {
        super(expression, index, number, length);
    }

    public Expression callExpression() {
        presentToken = getToken();
        return ExpressionFromParser();
    }

    private Expression ExpressionFromParser() {
        TOKENS token;
        Expression returnValue = Term();
        while (presentToken == TOKENS.TOKEN_PLUS || presentToken == TOKENS.TOKEN_SUB) {
            token = presentToken;
            presentToken = getToken();
            Expression expression = ExpressionFromParser();
            returnValue = new BinaryEvaluator(returnValue, expression, token == TOKENS.TOKEN_PLUS ? OPERATORS.OPERATOR_PLUS : OPERATORS.OPERATOR_MINUS);
        }
        return returnValue;
    }

    private Expression Term() {
        TOKENS token;
        try {
            Expression returnValue = Factor();
            while (presentToken == TOKENS.TOKEN_MUL || presentToken == TOKENS.TOKEN_DIV) {
                token = presentToken;
                presentToken = getToken();
                Expression expression = Term();
                returnValue = new BinaryEvaluator(returnValue, expression, token == TOKENS.TOKEN_MUL ? OPERATORS.OPERATOR_MULTIPLICATION : OPERATORS.OPERATOR_DIVISION);
            }
            return returnValue;
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return null;
    }

    private Expression Factor() {
        TOKENS token;
        try {
            Expression returnValue = null;
            if (presentToken == TOKENS.TOKEN_DOUBLE) {
                returnValue = new NumeralStore(getNumber());
                presentToken = getToken();
            } else if (presentToken == TOKENS.TOKEN_OPEN_PARENTHESIS) {
                presentToken = getToken();
                returnValue = ExpressionFromParser();
                if (presentToken != TOKENS.TOKEN_CLOSE_PARENTHESIS) {
                    System.out.println("Missing Closing Parenthesis");
                    throw new Exception();
                }
                presentToken = getToken();
            } else if (presentToken == TOKENS.TOKEN_PLUS || presentToken == TOKENS.TOKEN_SUB) {
                token = presentToken;
                presentToken = getToken();
                returnValue = Factor();
                returnValue = new UnaryEvaluator(returnValue, token == TOKENS.TOKEN_PLUS ? OPERATORS.OPERATOR_PLUS : OPERATORS.OPERATOR_MINUS);
            } else {
                System.out.println("Illegal Token Found");
                throw new Exception();
            }
            return returnValue;
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return null;
    }

    private TOKENS getNext() {
        lastToken = presentToken;
        presentToken = getToken();
        return presentToken;
    }

    public ArrayList<Object> parse() throws Exception {
        getNext();
        return statementList();
    }

    private ArrayList<Object> statementList() throws Exception {
        ArrayList<Object> arrayList = new ArrayList<>();
        while (presentToken != TOKENS.TOKEN_NULL) {
            Statement statement = Statement();
            if(statement != null) {
                arrayList.add(statement);
            }
        }
        return arrayList;
    }

    private Statement Statement() throws Exception {
        Statement returnValue = null;
        switch (presentToken) {
            case TOKEN_PRINT -> {
                returnValue = ParsePrintStatement();
                getNext();
                break;
            }
            case TOKEN_PRINTLN -> {
                returnValue = ParsePrintLnStatement();
                getNext();
                break;
            }

        }
        return returnValue;
    }

    private Statement ParsePrintLnStatement() throws Exception {
        getNext();
        Expression expression = ExpressionFromParser();
        if(presentToken != TOKENS.TOKEN_SEMICOLON) {
            throw new Exception("Expected ;");
        }
        return new PrintLineStatement(expression);
    }

    private Statement ParsePrintStatement() throws Exception {
        getNext();
        Expression expression = ExpressionFromParser();
        if(presentToken != TOKENS.TOKEN_SEMICOLON) {
            throw new Exception("Expected ;");
        }
        return new PrintStatement(expression);
    }

}
