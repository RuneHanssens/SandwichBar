window.onload = startUp();
let chart;

function startUp(){
    drawGraphs();
    pollManager();
}

function pollManager(){
    pollGraph1("update");
    setTimeout(pollManager, 2000);
}

function drawGraphs() {
    pollGraph1("load");
}

function pollGraph1(method) {
    $.ajax({
        type: "GET",
        url: "ajax/barGraph.htm",
        dataType: "json",
        success: function (json) {
            console.log("success while retrieving the barGraph!");
            if (method == "load"){
                drawGraph1(json);
            }else if(method == "update"){
                updateGraph1(json);
            }
        },
        error: function () {
            console.log("Something went wrong trying to retrieve barGraph!");
        },
    });
}

function updateGraph1(json) {
    var data = [];
    for (i in json) {
        var graphData = json[i];
        data.push(graphData.bought);
    }
    for (i in chart.data.datasets){
        var dataxd = chart.data.datasets[i];
        chart.data.datasets[i].data = data;
    }
    chart.update();
}

function drawGraph1(json){
    var labels = [];
    var data = [];

    for (i in json) {
        var graphData = json[i];
        labels.push(graphData.name);
        data.push(graphData.bought);
    }

    var maxValue = Math.max.apply(Math, data);

    while(!(maxValue % 5 == 0)){
        maxValue ++;
    }

    let myChart3 = document.getElementById('myChart3').getContext('2d');
    chart = new Chart(myChart3, {
        type: 'bar',
        data: {
            labels: labels,
            datasets: [{
                label: 'aantal verkocht',
                data: data,
                backgroundColor: 'orange',
            }]
        },
        options: {
            maintainAspectRatio: false,
            responsive: true,
            scales: {
                yAxes: [{
                    display: true,
                    ticks: {
                        beginAtZero: true,
                        padding: 100,
                        fixedStepSize: 5,
                        max:maxValue
                    }
                }]
            }
        }
    })
}