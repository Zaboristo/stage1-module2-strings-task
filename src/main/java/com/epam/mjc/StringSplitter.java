package com.epam.mjc;

import java.util.*;

public class StringSplitter {

    /**
     * Splits given string applying all delimeters to it. Keeps order of result substrings as in source string.
     *
     * @param source source string
     * @param delimiters collection of delimiter strings
     * @return List of substrings
     */
    public List<String> splitByDelimiters(String source, Collection<String> delimiters) {
        List<String> result = new ArrayList<String>();
        result.add(source);
        String[] particles = (String[]) delimiters.toArray(new String[0]);
        for (int i = 0; i<particles.length; i++){
            result = splitterUnit(result, particles[i]);
        }
        while(result.indexOf("")!= -1)
        {
            result.remove(result.indexOf(""));
        }
        if( result != null)
        return result;
        else
        throw new UnsupportedOperationException("You should implement this method.");
    }

    public List<String> splitterUnit(List<String> before, String delim) {
        List<String> after = new ArrayList<>();
        for(int i = 0; i < before.size(); i++) {
            after.addAll(List.of(before.get(i).split(delim)));
        }
        return after;
    }

}
