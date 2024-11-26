package org.javaadvancedlevel.lab3.java17.textblocks;

/**
 * Demonstrates the use of text blocks for multi-line strings.
 */
public class Main {
    public static void main(String[] args) {
        String html = """
                <html>
                    <body>
                        <h1>Hello, World!</h1>
                    </body>
                </html>
                """;
        System.out.println(html);
    }
}

