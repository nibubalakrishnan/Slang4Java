package slang.compiler.Pace_Three.Statements;
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

public class PrintStatement extends Statement {

    Expression expression;

    public PrintStatement(Expression expression) {
        this.expression = expression;
    }

    @Override
    public boolean Execute(RealtimeContext realtimeContext) {
        double value = expression.Evaluate(realtimeContext);
        System.out.print(value);
        return true;
    }
}
