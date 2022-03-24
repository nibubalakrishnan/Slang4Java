package slang.compiler.Pace_Two;
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
import slang.compiler.Pace_Two.Builder.ExpressionBuilder;

public class InvokeSlang {
    public static void main(String[] args) {
        RealtimeContext realtimeContext = new RealtimeContext();
        ExpressionBuilder builder = new ExpressionBuilder("-10*(15+15)");
        Expression expression = builder.getExpression();
        System.out.println(expression.Evaluate(realtimeContext));
    }
}
