package slang.compiler.Pace_Three;
/*
 *
 * Copyright © 2021. #dltledgers Private Ltd. - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 * Written on behalf of #dltledgers ,  March  2022
 *
 */



import slang.compiler.Pace_One.Context.RealtimeContext;
import slang.compiler.Pace_Three.Statements.Statement;
import slang.compiler.Pace_Two.LexicalAnalyzer.RDParser;

import java.util.ArrayList;

public class InvokeSlang {
    public static void main(String[] args) throws Exception {
        RealtimeContext context = new RealtimeContext();
        String value = "PRINTLINE 2*20;";
        RDParser parser = new RDParser(value);
        ArrayList<Object> arrayList = parser.parse();
        for (Object object:arrayList) {
            Statement statement = (Statement) object;
            statement.Execute(context);
        }
    }
}
