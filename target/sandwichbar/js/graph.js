window.onload = graphPollManager();
let chart;
function graphPollManager() {
    pollBarGraph();
    setTimeout(graphPollManager, '10000');
}

function drawBarGraph(json) {
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

function pollBarGraph() {
    $.ajax({
        type: "GET",
        url: "ajax/barGraph.htm",
        dataType: "json",
        success: function (json) {
            console.log("success while retrieving the barGraph!");
            drawBarGraph(json);
        },
        error: function () {
            console.log("Something went wrong trying to retrieve barGraph!");
        },
    });
}

// let myChart = document.getElementById('myChart').getContext('2d');
// let massPopChart = new Chart(myChart, {
//     type:'bar',
//     data:{
//         labels:['tijd1', 'tijd2', 'tijd3', 'tijd4'],
//         datasets:[{
//             label: 'temp',
//             data:[
//                 24,
//                 25,
//                 15,
//                 -4
//             ],
//             backgroundColor:'orange',
//         }]
//     },
//     options:{
//     }
// })