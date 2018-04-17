window.onload = pollManager;

function pollManager(){
    pollAmount();
    setTimeout(pollManager, 5000);
}

function pollAmount() {
    $.ajax({
        type:"GET",
        url:"ajax.htm",
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
