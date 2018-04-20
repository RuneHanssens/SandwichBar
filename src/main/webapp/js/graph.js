window.onload = startUp();
let chart1;

function startUp(){
    drawGraphs();
    pollManager();
}

function pollManager(){
    pollGraph("update");
    setTimeout(pollManager, 5000);
}

function drawGraphs() {
    pollGraph("load");
}

function pollGraph(method) {
    $.ajax({
        type: "GET",
        url: "ajax/barGraph.htm",
        dataType: "json",
        success: function (json) {
            console.log("success while retrieving the data!");
            if (method == "load"){
                drawGraph1(json);
            }else if(method == "update"){
                updateGraph1(json);
            }
        },
        error: function () {
            console.log("Something went wrong trying to retrieve data!");
        },
    });
}

function updateGraph1(json) {
    var data = [];
    for (i in json) {
        var graphData = json[i];
        data.push(graphData.bought);
    }
    for (i in chart1.data.datasets){
        chart1.data.datasets[i].data = data;
    }
    var maxValue = Math.max.apply(Math, data);

    while(!(maxValue % 5 == 0)){
        maxValue ++;
    }
    chart1.config.options.scales.yAxes[0].ticks.max = maxValue;
    chart1.update();
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
    chart1 = new Chart(myChart3, {
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
