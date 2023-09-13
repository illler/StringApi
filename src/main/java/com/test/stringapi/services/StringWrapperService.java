package com.test.stringapi.services;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

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

        return result.entrySet().stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (e1, e2) -> e1,
                        LinkedHashMap::new
                ));
    }


}
