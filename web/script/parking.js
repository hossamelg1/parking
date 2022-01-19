$(document).ready(function () {
    $('#hiddenButton').hide();
    $("#addition").hide();
    var id;
    $.ajax({
        url: "ParkingController",
        data: {op: "load"},
        type: 'POST',
        success: function (data, textStatus, jqXHR) {
            fill(data);
        },
        error: function (jqXHR, textStatus, errorThrown) {
            alert('failed');
        }
    });
    
    // delete requst
    $("#content").on("click", ".delete", function () {
        var id = $(this).closest("tr").find("td").eq(0).text();
        console.log(id)
        $.ajax({
            url: "ParkingController",
            data: {id: id, op: "delete"},
            type: 'POST',
            success: function (data, textStatus, jqXHR) {
                fill(data);
            },
            error: function (jqXHR, textStatus, errorThrown) {
                alert('failed');
            }
        });
    });
    
    $("#content").on("click", ".modify", function () {
        id = $(this).closest("tr").find("td").eq(0).text();
        var name = $(this).closest("tr").find("td").eq(1).text();
        var quartier = $(this).closest("tr").find("td").eq(2).text();
        $("#name").val(name);
        $("#quartier").val(quartier);
        $("#hiddenButton").show()
    });
    $("#hiddenButton").click(function() {
       var name = $("#name").val();
       var quartier = $("#quartier").val();
       $("#name").val();
       $("#quartier").val();
       $('#hiddenButton').hide();
        $.ajax({
            url: "ParkingController",
            data: {id: id, name: name, quartier: quartier, op : "update"},
            type: 'POST',
            success: function (data, textStatus, jqXHR) {
                fill(data);
            },
            error: function (jqXHR, textStatus, errorThrown) {
                alert(textStatus);
            }
        });
    });
    
    // add requset
    $("#add").click(function () {
        var name = $("#name").val();
        var quartier = $("#quartier").val();
        $.ajax({
            url: "ParkingController",
            data: {name: name, quartier: quartier},
            type: 'POST',
            success: function (data, textStatus, jqXHR) {
                fill(data);
            },
            error: function (jqXHR, textStatus, errorThrown) {
                alert(textStatus);
            }
        });
        $("#name").val(" ");
        $("#quartier").val(" ");
    });
    //
    function fill(data) {
        var ligne = "";
        data.forEach(function (e) {
            ligne += "<tr><td>" + e.id + "</td><td>" + e.name + "</td><td>" + e.quartier + "</td><td><button class='btn btn-primary delete'>Supprimer</button></td><td><button class='btn btn-primary modify'>Modifier</button></td></tr>";
        });
        $("#content").html(ligne);
    }
    $("#toggle").click(function () {
        $("#addition").toggle(500);
    });
    
    $('#name').focusout(function() {
        var name = $('#name').val();
        console.log(name)
        $.ajax({
            url: "ParkingController",
            data: {name: name, op: 'checkname'},
            type: 'POST',
            success: function (data, textStatus, jqXHR) {
                if (data) {
                   alert('this name is already exist'); 
                   $('#name').val(" ");
                }   
                
            },
            error: function (jqXHR, textStatus, errorThrown) {
                alert(textStatus);
            }
        });
    })
    
});