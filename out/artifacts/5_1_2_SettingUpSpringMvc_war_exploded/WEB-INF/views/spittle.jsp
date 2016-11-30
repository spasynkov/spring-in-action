<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
</head>

<body>
    <h1>Spittle</h1>
    <div class="spittleView">
        <div id="map"></div>
        <div class="spittleMessage">
            <c:out value="${spittle.message}" />
        </div>
        <div>
            <span class="spittleTime">
                <c:out value="${spittle.time}" />
            </span>
        </div>

        <div id="coordinates">Coordinates: (<a href="#" id="latlng" title="Click here to show at map!"><c:out value="${spittle.latitude}" />; <c:out value="${spittle.longitude}" /></a>)</div>
    </div>

    <script async defer
            src="https://maps.googleapis.com/maps/api/js?key=AIzaSyAk_4MsZJZpcH35HZ7vMmRrbdMTBt7sqLc&callback=initMap">
    </script>
</body>
</html>
