package com.ghulam.parser.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.ghulam.parser.utils.Pair;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.*;

@Slf4j
@Service
public class AppService {

    List<Pair<String, Object>> data = new ArrayList<>();

    public List<Pair<String, Object>> parse(JsonNode json) {
        helper(json);
        return data;
    }

    private void helper(JsonNode node) {
        Iterator<Map.Entry<String, JsonNode>> fields = node.fields();

        while(fields.hasNext()) {
            Map.Entry<String, JsonNode> next = fields.next();

            String key = next.getKey();
            JsonNode value = next.getValue();

            /**
             "username" : "Tom Jerry"  // this is empty

             "address" : {  // this is not empty
                "more key" : "mor value"
             }
             */
            if(value.isEmpty()) {
                Pair<String, Object> pair = new Pair<>(key, value);
                data.add(pair);
            } else if(value.isObject()) {
                helper(value);
            } else if(value.isArray()) {
                for(var e : value) {
                    helper(e);
                }
            }
        }
    }
}
