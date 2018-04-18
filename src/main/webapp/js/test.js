$('#click').click(test);

function test() {
    var amount = $('#amount').val();
    var name = $('#name').val();
    var data = {"name":name,"amount":amount};
    //$.post("ajax.htm", data, "json");
    $.ajax({
        type: "POST",
        contentType: "application/json",
        dataType: 'json',
        url: "ajax.htm",
        data: JSON.stringify(data)
    });
}

function test2(){
    var amount = $('#amount').val();
    var name = $('#name').val();
    var data = {"name":name,"amount":amount};
    $.postJSON = function(url, data, callback) {
        return jQuery.ajax({
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            },
            'type': 'POST',
            'url': "ajax.htm",
            'data': data,
            'dataType': 'json',
            'success': callback
        });
    };
}