<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="t" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
    <head>
        <title>Spittr</title>
        <meta http-equiv="content-type" content="text/html; charset=UTF-8">
        <link rel="stylesheet"
              type="text/css"
              href="<s:url value="/resources/style.css" />" >
        <script type="text/javascript" src="<s:url value="/resources/scripts.js" />"></script>
    </head>

    <body>
        <div id="header">
            <t:insertAttribute name="header" />
        </div>

        <div id="content">
            <t:insertAttribute name="body" />
        </div>

        <div id="footer">
            <t:insertAttribute name="footer" />
        </div>
    </body>
</html>