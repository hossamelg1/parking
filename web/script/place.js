$(document).ready(function () {
    $.ajax({
        url: "PlaceController",
        data: {op: "load"},
        type: 'POST',
        success: function (data, textStatus, jqXHR) {
            fill(data);
        },
        error: function (jqXHR, textStatus, errorThrown) {
            alert('failed');
        }
    });

    $("#content").on("click", ".garer", function () {
        var id = $(this).closest("tr").find("td").eq(0).text();
        var idsection = $(this).closest("tr").find("td").eq(3).text();
        $.ajax({
            url: "PlaceController",
            data: {id: id,idsection: idsection, op: "garer"},
            type: 'POST',
            success: function (data, textStatus, jqXHR) {
                fill(data);
            },
            error: function (jqXHR, textStatus, errorThrown) {
                alert('failed');
            }
        });
    })
    $("#content").on("click", ".deparquer", function () {
        var id = $(this).closest("tr").find("td").eq(0).text();
        var idsection = $(this).closest("tr").find("td").eq(3).text();
        $.ajax({
            url: "PlaceController",
            data: {id: id,idsection: idsection, op: "deparquer"},
            type: 'POST',
            success: function (data, textStatus, jqXHR) {
                fill(data);
            },
            error: function (jqXHR, textStatus, errorThrown) {
                alert('failed');
            }
        });
    })


    function fill(data) {
        var ligne = "";
        data.forEach(function (e) {
            var etat
            if (!e.filled) {
                etat = "disponible"
            } else {
                etat = "indisponible";
            }
            ligne += "<tr><td>" + e.id + "</td><td>" + e.ref + "</td><td>" + etat + "</td> <td>" + e.idSection + "</td><td><button class='btn btn-primary garer'>Garer</button></td><td><button class='btn btn-primary deparquer'>Deparquer</button></td></tr>";
        });
        $("#content").html(ligne);
    }
});


