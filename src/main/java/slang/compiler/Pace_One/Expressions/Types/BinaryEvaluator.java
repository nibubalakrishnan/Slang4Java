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

public class BinaryEvaluator extends Expression {

    private Expression expression_1, expression_2;
    private OPERATORS operators;

    public BinaryEvaluator(Expression expression_1, Expression expression_2, OPERATORS operators) {
        this.expression_1 = expression_1;
        this.expression_2 = expression_2;
        this.operators = operators;
    }

    @Override
    public double Evaluate(RealtimeContext realtimeContext) {
        switch (operators) {
            case ILLEGAL -> {
                return -1;
            }
            case OPERATOR_PLUS -> {
                return this.expression_1.Evaluate(realtimeContext) + this.expression_2.Evaluate(realtimeContext);
            }

            case OPERATOR_MINUS -> {
                return this.expression_1.Evaluate(realtimeContext) - this.expression_2.Evaluate(realtimeContext);
            }
            case OPERATOR_DIVISION -> {
                return this.expression_1.Evaluate(realtimeContext) / this.expression_2.Evaluate(realtimeContext);
            }
            case OPERATOR_MULTIPLICATION -> {
                return this.expression_1.Evaluate(realtimeContext) * this.expression_2.Evaluate(realtimeContext);
            }
            default -> {
                return Double.NaN;
            }
        }
    }


}
