window.onload = startUp();
let chart1;
let chart2;

function startUp(){
    drawGraphs();
    pollManager();
}

function pollManager(){
    pollGraph("update","ajax/barGraph.htm",1);
    pollGraph("update","ajax/hum.htm",2);
    setTimeout(pollManager, 5000);
}

function drawGraphs() {
    pollGraph("load", "ajax/barGraph.htm", 1);
    pollGraph("load", "ajax/hum.htm",2);
}

function pollGraph(method,url,graph) {
    $.ajax({
        type: "GET",
        url: url,
        dataType: "json",
        success: function (json) {
            console.log("success while retrieving the data!");
            if (method == "load"){
                if(graph ==1){
                    drawGraph1(json);
                }else if(graph == 2){
                    drawGraph2(json);
                }

            }else if(method == "update"){
                if(graph == 1){
                    updateGraph1(json);
                }else if (graph == 2){
                    updateGraph2(json);
                }
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

function drawGraph2(json){
    var data = [];
    data.push(json.humidity);
    data.push(100 - json.humidity);
    let myChart1 = document.getElementById('myChart1').getContext('2d');

    chart2 = new Chart(myChart1, {
        type:'doughnut',
        data:{
            labels:['Vochtigheid %'],
            datasets:[{
                label: 'Vochtigheid',
                data: data,
                backgroundColor:['orange','lightgrey'],
            }]
        },
        options:{

        }
    })
}

function updateGraph2(json){
    var data = [];
    data.push(json.humidity);
    data.push(100 - json.humidity)
    for (i in chart2.data.datasets){
        chart2.data.datasets[i].data = data;
    }
    chart2.update();
}
