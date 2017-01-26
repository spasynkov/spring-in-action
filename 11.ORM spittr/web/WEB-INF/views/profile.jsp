<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>${spitter.username}'s profile</title>
        <link rel="stylesheet"
              type="text/css"
              href="<c:url value="/resources/style.css" />" >
    </head>

    <body>
        <h1>Your Profile</h1>
        <h3><c:out value="${spitter.username}" /></h3>
        <c:out value="${spitter.firstName}" />
        <c:out value="${spitter.lastName}" />
    </body>
</html>
