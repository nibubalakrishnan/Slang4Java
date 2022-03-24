package slang.compiler.Pace_One;
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
import slang.compiler.Pace_One.Expressions.Types.BinaryEvaluator;
import slang.compiler.Pace_One.Expressions.Types.NumeralStore;
import slang.compiler.Pace_One.Expressions.Types.UnaryEvaluator;


public class InvokeSlang {
    public static void main(String[] args) {


        RealtimeContext context = new RealtimeContext();

//        Creating an AST for adding two number (Binary Expression) say 1 and 1
        Expression binaryExpression = new BinaryEvaluator(new NumeralStore(1), new NumeralStore(1), OPERATORS.OPERATOR_PLUS);
        System.out.println(binaryExpression.Evaluate(context));

//        Creating an AST for unary (Unary Expression) say 1
        Expression unaryExpression = new UnaryEvaluator(new NumeralStore(1), OPERATORS.OPERATOR_PLUS);
        System.out.println(unaryExpression.Evaluate(context));

//        Creating an AST for a combined Expression - (1 + (2 * 3))
        Expression combinedExpression = new UnaryEvaluator(
                new BinaryEvaluator(
                        new NumeralStore(1),
                        new BinaryEvaluator(
                                new NumeralStore(2),
                                new NumeralStore(3),
                                OPERATORS.OPERATOR_MULTIPLICATION),
                        OPERATORS.OPERATOR_PLUS),
                OPERATORS.OPERATOR_MINUS);
        System.out.println(combinedExpression.Evaluate(context));

    }
}
