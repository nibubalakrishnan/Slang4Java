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

public class NumeralStore extends Expression {
    private double numeralValue;

    public NumeralStore(double numeralValue) {
        this.numeralValue = numeralValue;
    }

    @Override
    public double Evaluate(RealtimeContext realtimeContext) {
        return numeralValue;
    }
}
