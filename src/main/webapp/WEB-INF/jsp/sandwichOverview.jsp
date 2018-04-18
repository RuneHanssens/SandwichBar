<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="nl">
<head>
    <meta charset="utf-8">
    <%@include file="header.jspf"%>
</head>
<body>
<header>
    <nav>
        <img src="${pageContext.request.contextPath}/images/ucllLogo.png" class="logo">
        <a href="">Live</a>
        <a href="">Statistieken</a>
    </nav>
</header>
<main>
    <div class="textDiv">
        <h1>Broodjes UCLL</h1>
        <p class="whiteP">Hieronder vind je de beschikbare broodjes op dit moment!</p>
    </div>
<div id="flex-container">
<c:forEach var="sandwich" items="${sandwiches}">
    <div class="sandwichDiv">
        <table id="${sandwich.name}">
            <tr>
                <th>${sandwich.name}</th>
            </tr>
            <tr>
                <td>${sandwich.description}</td>
            </tr>
            <tr>
                <td><img class="smallIcon" src="${pageContext.request.contextPath}/images/piggy-bank.png"></td>
                <td>${sandwich.price}</td>
            </tr>
            <tr>
                <td><img class="smallIcon" src="${pageContext.request.contextPath}/images/baguette.png"></td>
                <td id="${sandwich.name}-amount">${sandwich.amount}</td>
            </tr>
        </table>
    </div>
</c:forEach>
</div>
</main>
<footer><p>Gemaakt door Rune, Bjorn, Remi en Maarten</p></footer>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.4.4.min.js"></script>
<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.4.2/jquery.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/services.js"></script>
</body>
</html>