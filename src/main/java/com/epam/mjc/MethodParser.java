package com.epam.mjc;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class MethodParser {

    /**
     * Parses string that represents a method signature and stores all it's members into a {@link MethodSignature} object.
     * signatureString is a java-like method signature with following parts:
     *      1. access modifier - optional, followed by space: ' '
     *      2. return type - followed by space: ' '
     *      3. method name
     *      4. arguments - surrounded with braces: '()' and separated by commas: ','
     * Each argument consists of argument type and argument name, separated by space: ' '.
     * Examples:
     *      accessModifier returnType methodName(argumentType1 argumentName1, argumentType2 argumentName2)
     *      private void log(String value)
     *      Vector3 distort(int x, int y, int z, float magnitude)
     *      public DateTime getCurrentDateTime()
     *
     * @param signatureString source string to parse
     * @return {@link MethodSignature} object filled with parsed values from source string
     */
    public MethodSignature parseFunction(String signatureString) {

        String fullArgs = signatureString.substring(signatureString.indexOf('(') + 1,signatureString.indexOf(')'));

        List<String> arguments = List.of(fullArgs.split(", | "));
        List <MethodSignature.Argument> parsedArgs = new ArrayList<MethodSignature.Argument>();
        for (int i = 0; i<arguments.size() && arguments.get(i) != ""; i = i+2){
            parsedArgs.add((MethodSignature.Argument) new MethodSignature.Argument(arguments.get(i), arguments.get(i+1)));
        }
        StringTokenizer str1 = new StringTokenizer(signatureString);
        String accessMod ="";
        String methodName;
        String returnType;
        if(signatureString.contains("public") || signatureString.contains("private")){
            accessMod = str1.nextToken();}
        else accessMod = null;
        returnType = str1.nextToken();
        methodName = str1.nextToken();
        methodName = methodName.substring(0, methodName.indexOf('('));
        MethodSignature parsedMethod = new MethodSignature(methodName, parsedArgs);
        System.out.println(arguments);
        System.out.println(methodName);

        System.out.println(returnType);
        if (accessMod != null) {
            System.out.println(accessMod);
        }
        if (methodName == null || returnType == null)
            throw new UnsupportedOperationException("You should implement this method.");
        parsedMethod.setAccessModifier(accessMod);
        parsedMethod.setReturnType(returnType);
        return parsedMethod;
    }
}
