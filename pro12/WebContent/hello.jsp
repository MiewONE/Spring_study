<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%!
        String name = "miewone";
        public String getName() { return name;}
    %>
    <!DOCTYPE html>
    <html>
        <head>
            <meta charset="UTF-8">
                <title>Insert title here</title>
            </head>
            <body>
                <h1>hi <%=name %>!</h1>
            </body>
        </html>