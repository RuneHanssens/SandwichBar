<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
        <a href="${pageContext.request.contextPath}/sandwich.htm">Broodjes</a>
        <a href="${pageContext.request.contextPath}/graph.htm">Geschiedenis</a>
    </nav>
</header>
<body>
<div class="container">
    <div id="graphMoist">
       <h3>Vochtigheid</h3>
        <canvas id="myChart1"></canvas>
    </div>
    <div id="graphTemp">
       <h3>Temperatuur</h3>
        <canvas id="myChart2"></canvas>
    </div>
    <div id="graphBread">
       <h3>Populare broodjes</h3>
        <canvas id="myChart3"></canvas>
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
</body>
<script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.7.2/Chart.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.4.4.min.js"></script>
<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.4.2/jquery.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/graph.js"></script>
</html>

