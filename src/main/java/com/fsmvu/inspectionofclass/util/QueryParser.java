package com.fsmvu.inspectionofclass.util;

import java.util.Map;
import java.util.Collections;
import java.util.HashMap;

public class QueryParser{

    public static Map<String, String> parse(String query) {
        /** If query is null, silently return */
        if(query == null) {
            return Collections.emptyMap();
        }
        Map<String, String> result = new HashMap<String, String>();
        for (String param : query.split("&")) {
            String pair[] = param.split("=");
            if (pair.length > 1) {
                result.put(pair[0], pair[1]);
            } else {
                result.put(pair[0], "");
            }
        }
        return result;
    }

}