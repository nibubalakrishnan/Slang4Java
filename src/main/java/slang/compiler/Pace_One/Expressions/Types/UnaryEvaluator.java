package slang.compiler.Pace_One.Expressions.Types;
/*
 *
 * Copyright © 2021. #dltledgers Private Ltd. - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 * Written on behalf of #dltledgers ,  March  2022
 *
 */


import slang.compiler.Pace_One.Context.RealtimeContext;
import slang.compiler.Pace_One.Expressions.Expression;
import slang.compiler.Pace_One.Expressions.OPERATORS;

public class UnaryEvaluator extends Expression {
    private Expression expression;
    private OPERATORS operators;

    public UnaryEvaluator(Expression expression, OPERATORS operators) {
        this.expression = expression;
        this.operators = operators;
    }

    @Override
    public double Evaluate(RealtimeContext realtimeContext) {
        switch (operators) {
            case OPERATOR_MINUS -> {
                return -expression.Evaluate(realtimeContext);
            }
            case OPERATOR_PLUS -> {
                return +expression.Evaluate(realtimeContext);
            }
        }
        return Double.NaN;
    }
}
