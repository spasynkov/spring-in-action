<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec"%>
            <a id="logo" href="<s:url value="/" />">
                <img src="<s:url value="/resources/images/spittr_logo_50.png" />"
                     border="0" alt="logo" title="Back to main" />
            </a>

            <div id="loginLinks">
                <sec:authorize access="isAnonymous()">
                    <a href="<s:url value="/login"/>">Log in</a> |
                    <a href="<s:url value="/spitter/register" />">Register</a>
                </sec:authorize>

                <sec:authorize access="hasRole('ROLE_SPITTER')">
                    <a href="<s:url value="/logout"/>">Log out</a>
                </sec:authorize>
            </div>