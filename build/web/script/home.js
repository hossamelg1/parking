$(document).ready(function () {
    function generator() {
        var section = "<div class='col-xl-4 d-flex grid-margin stretch-card' ><div class='card'><div class=''><div style='float: left; width: 40px; height: 40px; background-color: red;margin: 2px'></div><div style='float: left; width: 40px; height: 40px; background-color: red;margin: 2px'></div></div><div><div style='float: left; width: 40px; height: 40px; background-color: red;margin: 2px'></div><div style='float: left; width: 40px; height: 40px; background-color: red;margin: 2px'></div></div></div></div>"
        $('#cont').html(section);
    }
    $.ajax({
            url: "EtageController",
            data: {op: 'generat'},
            type: 'POST',
            success: function (data, textStatus, jqXHR) {
                fill(data);
                nextEtage();
            },
            error: function (jqXHR, textStatus, errorThrown) {
                alert(textStatus);
            }
        });
});
