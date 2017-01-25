<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<%@ page session="false" %>
<html>
    <head>
        <title>Spittr</title>
        <link rel="stylesheet"
              type="text/css"
              href="<c:url value="/resources/style.css" />" >
    </head>
    <body>
        <h1>Register</h1>
        <sf:form method="post" commandName="spitter" enctype="multipart/form-data">
            <table>
                <tr>
                    <td><sf:label path="firstName" cssErrorClass="error">First name: </sf:label></td>
                    <td><sf:input path="firstName" cssErrorClass="error" /></td>
                    <td><sf:errors path="firstName" cssClass="error"/></td>
                </tr>

                <tr>
                    <td><sf:label path="lastName" cssErrorClass="error">Last name: </sf:label></td>
                    <td><sf:input path="lastName" cssErrorClass="error" /></td>
                    <td><sf:errors path="lastName" cssClass="error" /></td>
                </tr>

                <tr>
                    <td><sf:label path="email" cssErrorClass="error">Email: </sf:label></td>
                    <td><sf:input path="email" type="email" cssErrorClass="error" /></td>
                    <td><sf:errors path="email" cssClass="error" /></td>
                </tr>

                <tr>
                    <td><sf:label path="username" cssErrorClass="error">Username: </sf:label></td>
                    <td><sf:input path="username" cssErrorClass="error" /></td>
                    <td><sf:errors path="username" cssClass="error" /></td>
                </tr>

                <tr>
                    <td><sf:label path="password" cssErrorClass="error">Password: </sf:label></td>
                    <td><sf:password path="password" cssErrorClass="error" /></td>
                    <td><sf:errors path="password" cssClass="error" /></td>
                </tr>

                <tr>
                    <td><label>Profile picture</label></td>
                    <td><input type="file" name="profilePicture"
                            accept="image/jpeg,image/png,image/gif" /></td>
                </tr>
            </table>
            <input type="submit" value="Register" />

            <c:if test="${spitter.id == null}" >
                <sf:errors path="*" element="div" cssClass="error" />
            </c:if>
        </sf:form>
    </body>
</html>