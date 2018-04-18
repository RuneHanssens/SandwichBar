<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="nl">
<head>
   <link rel="stylesheet" href="/css/stylesheet.css">
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
    <div id="graphMoist">
        <canvas id ="myChart1"></canvas>
    </div>
    <div id="graphTemp">
        <canvas id ="myChart2"></canvas>
    </div>
    <div id="graphBread">
        <canvas id ="myChart3"></canvas>
    </div>
</div>

<script>
    let myChart = document.getElementById('myChart1').getContext('2d');

    let massPopChart = new Chart(myChart1, {
        type:'line',
        data:{
            labels:['tijd1', 'tijd2', 'tijd3', 'tijd4'],
            datasets:[{
                label: 'temp',
                data:[
                    24,
                    25,
                    15,
                    -4
                ],
                backgroundColor:'orange',
            }]
        },
        options:{

        }
    })
    //////////////////////////////////////
    let myChart2 = document.getElementById('myChart2').getContext('2d');

    let massPopChart2 = new Chart(myChart2, {
        type:'line',
        data:{
            labels:['tijd1', 'tijd2', 'tijd3', 'tijd4'],
            datasets:[{
                label: 'temp',
                data:[
                    24,
                    25,
                    15,
                    -4
                ],
                backgroundColor:'orange',
            }]
        },
        options:{

        }
    })
    /////////////////////////////////
    let myChart3 = document.getElementById('myChart3').getContext('2d');

    let massPopChart3 = new Chart(myChart3, {
        type:'bar',
        data:{
            labels:['tijd1', 'tijd2', 'tijd3', 'tijd4'],
            datasets:[{
                label: 'temp',
                data:[
                    24,
                    25,
                    15,
                    -4
                ],
                backgroundColor:'orange',
            }]
        },
        options:{

        }
    })
</script>
<footer><p>Gemaakt door Rune, Bjorn, Remi en Maarten</p></footer>
</body>
</html>

