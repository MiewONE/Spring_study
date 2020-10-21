<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    isErrorPage="true"
    %>
    <!DOCTYPE html>
    <html>
        <head>
            <meta charset="UTF-8">
                <title>Error Page!</title>
        </head>
        <body>
            ==== toString() =====<br>
            <h1><%=exception.toString() %></h1>
            ==== getMessage() ======<br>
            <h1><%=exception.getMessage()%></h1>
            ==== printStatckTrace() ==== <br>
            <h1><% exception.printStackTrace();%></h1>

            <h3>
                숫자만 입력 가능, 다시 시도
                <a href="add.html">다시 하기</a>
            </h3>
        </body>
    </html>