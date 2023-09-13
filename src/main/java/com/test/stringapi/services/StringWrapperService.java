package com.test.stringapi.services;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class StringWrapperService {

    public Map<String, Integer> processString(String input, String toLowerCase, String containsSpaces) {
        Map<String, Integer> result = new HashMap<>();
        String processedString = input;

        toLowerCase = (toLowerCase == null)? "true": toLowerCase;
        containsSpaces = (containsSpaces == null)? "true": containsSpaces;


        if (toLowerCase.equals("true")) {
            processedString = processedString.toLowerCase();
        }

        if (containsSpaces.equals("true")) {
            processedString = processedString.replaceAll(" ", "");
        }

        for (int i = 0; i < processedString.length(); i++) {
            result.compute(String.valueOf(processedString.charAt(i)), (t, count) -> count == null ? 1 : ++count);
        }

        return result;
    }


}
