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

public abstract class Statement {
    public abstract boolean Execute(RealtimeContext realtimeContext);
}
