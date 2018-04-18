<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="nl">
<head>
    <meta charset="utf-8">
    <%@include file="header.jspf"%>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="
    X-UA-Compatible" content="ie-edge">
    <script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.7.2/Chart.min.js"></script>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css">
    <title>statistieken</title>
</head>
<header>
    <nav>
        <img src="${pageContext.request.contextPath}/images/ucllLogo.png" class="logo">
        <a href="${pageContext.request.contextPath}/sandwich.htm">Live</a>
        <a href="${pageContext.request.contextPath}/graph.htm">Statistieken</a>
    </nav>
</header>
<body>
<div class="container">
    <canvas id ="myChart"></canvas>
</div>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.4.4.min.js"></script>
<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.4.2/jquery.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/graph.js"></script>

<footer><p>Gemaakt door Rune, Bjorn, Remi en Maarten</p></footer>
</body>
</html>

