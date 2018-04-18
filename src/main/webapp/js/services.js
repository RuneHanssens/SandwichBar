window.onload = sandwichPollManager;

function sandwichPollManager(){
    pollAmount();
    polltemp();
    setTimeout(sandwichPollManager, 5000);
}

function polltemp(){
    $.ajax({
        type:"GET",
        url:"ajax/temp.htm",
        dataType:"json",
        success: function (json) {
            console.log("Success while trying to retrieve the temperature!");
            writeTemp(json);
        },
        error:function () {
            console.log("Something went wrong while trying to retrieve the temperature!");
        },
    });
}

function writeTemp(json) {
    var temp = json.temp;
    var td = document.getElementById("temp");
    td.innerText = temp;
}


function pollAmount() {
    $.ajax({
        type:"GET",
        url:"ajax/sandwich.htm",
        dataType:"json",
        success: function (json) {
            console.log("success while retrieving the amount of available sandwiches!");
            writeAmount(json);
        },
        error: function () {
            console.log("Something went wrong trying to retrieve the amount of available sandwiches!");
        },
    });
}

function writeAmount(json){
    for (i in json){
        var sandwich = json[i];
        var td = document.getElementById(sandwich.name + "-amount");
        td.innerText = sandwich.amount;
    }
}