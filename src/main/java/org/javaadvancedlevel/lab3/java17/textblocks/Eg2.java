package org.javaadvancedlevel.lab3.java17.textblocks;

/**
 * Comparison of text blocks and regular string literals.
 */
public class Eg2 {
    public static void main(String[] args) {
        // Regular String Literal
        String json1 = "{\n" +
                "    \"key\": \"value\"\n" +
                "}";

        // Text Block
        String json2 = """
                {
                    "key": "value"
                }
                """;

        System.out.println(json1.equals(json2));
    }
}

