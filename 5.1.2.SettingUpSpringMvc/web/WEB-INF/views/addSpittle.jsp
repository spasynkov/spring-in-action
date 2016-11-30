<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>

<sf:form action="/spittles" method="post" modelAttribute="spittle">
    <table>
        <tr>
            <td><sf:label path="message" cssErrorClass="error">Your message: </sf:label></td>
            <td><sf:textarea cols="40" rows="3" path="message" cssErrorClass="error"/></td>
            <td><sf:errors path="message" cssClass="error"/></td>
        </tr>
    </table>
    <input type="submit" value="Post it" />
</sf:form>