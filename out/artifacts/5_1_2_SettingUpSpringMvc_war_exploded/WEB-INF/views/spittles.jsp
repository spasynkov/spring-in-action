<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Spittles list</title>
    <link rel="stylesheet"
          type="text/css"
          href="<c:url value="/resources/style.css" />" >
</head>
<body>
    <h1>Spittles:</h1>

    <a href="/spittles/add">Add new spittle</a><br />
    <ul>
        <c:forEach items="${spittleList}" var="spittle" >
            <li id="spittle_<c:out value="${spittle.id}"/>">
                <a href="/spittles/<c:out value="${spittle.id}" />" class="spittleMessage">
                    <c:out value="${spittle.message}" />
                </a>
                <div>
                    <span class="spittleTime">
                        <c:out value="${spittle.time}" />
                    </span>
                    <span class="spittleLocation">
                        (<c:out value="${spittle.latitude}" />, <c:out value="${spittle.longitude}" />)
                    </span>
                </div>
            </li>
        </c:forEach>
    </ul>
</body>
</html>
