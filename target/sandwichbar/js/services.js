window.onload = pollManager;

function pollManager(){
    pollAmount();
    setTimeout(pollManager, 1000);
}

function pollAmount() {
    $.ajax({
        type:"GET",
        url:"ajax.htm",
        dataType:"json",
        success: function (json) {
            console.log("success while retrieving the amount of available sandwiches!");
            console.log(json);
        },
        error: function () {
            console.log("Something went wrong trying to retrieve the amount of available sandwiches!");
        },
    });
}