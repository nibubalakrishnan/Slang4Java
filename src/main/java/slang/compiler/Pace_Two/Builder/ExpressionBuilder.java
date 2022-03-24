package slang.compiler.Pace_Two.Builder;
/*
 *
 * Copyright © 2021. #dltledgers Private Ltd. - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 * Written on behalf of #dltledgers ,  March  2022
 *
 */


import slang.compiler.Pace_One.Expressions.Expression;
import slang.compiler.Pace_Two.LexicalAnalyzer.RDParser;

public class ExpressionBuilder extends AbsctractBuilder {
    public String expressionString;

    public ExpressionBuilder(String expressionString) {
        this.expressionString = expressionString;
    }

    public Expression getExpression() {
        RDParser parser = new RDParser(expressionString);
        return parser.callExpression();
    }
}
