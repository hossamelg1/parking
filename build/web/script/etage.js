$(document).ready(function () {
    $("#addition").hide();
    var rank;
    $.ajax({
        url: "EtageController",
        data: {op: "load"},
        type: 'POST',
        success: function (data, textStatus, jqXHR) {
            fill(data);
        },
        error: function (jqXHR, textStatus, errorThrown) {
            alert('failed');
        }
    });

    $("#content").on("click", ".delete", function () {
        var id = $(this).closest("tr").find("td").eq(0).text();
        console.log(id)
        $.ajax({
            url: "EtageController",
            data: {id: id, op: "delete"},
            type: 'POST',
            success: function (data, textStatus, jqXHR) {
                fill(data);
                nextEtage();
            },
            error: function (jqXHR, textStatus, errorThrown) {
                alert('failed');
            }
        });
    });


    $("#add").click(function () {
        var name = $('#options').find(":selected").text();
        var quartier = $("#quartier").val();
        $.ajax({
            url: "EtageController",
            data: {name: name},
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
    function fill(data) {
        var ligne = "";
        data.forEach(function (e) {
            ligne += "<tr><td>" + e.id + "</td><td>" + e.rank + "</td><td>" + e.nameParking + "</td><td><button class='btn btn-primary delete'>Supprimer</button></td><td><button class='btn btn-primary modify'>Modifier</button></td></tr>";
        });
        $("#content").html(ligne);
    }

    $("#toggle").click(function () {
        $("#addition").toggle(500);
    });
    function fillOptions(data) {
        var ligne = "";
        data.forEach(function (e) {
            ligne += "<option value=" + e.rank + ">" + e.rank + "</option>";
        });
        $("#options").html(ligne);
    }

    $("#options").change(function () {
        nextEtage();
    });
    function nextEtage(){
        var name = $('#options').find(":selected").text()
        $.ajax({
            url: "EtageController",
            data: {name: name, op: "nextetage"},
            type: 'POST',
            success: function (data, textStatus, jqXHR) {
                rank;
                var next;
                switch (data) {
                    case 0:
                        next = "Rez de chaussée";
                        $('#add').prop('disabled', false);
                        break
                    case 1:
                        next = "Premier Etage";
                        $('#add').prop('disabled', false)
                        break
                    case 2:
                        next = "Deuxiéme Etage";
                        $('#add').prop('disabled', false);
                        break
                    case 3:
                        next = "troisiéme Etage";
                        $('#add').prop('disabled', false);
                        break
                    default :
                        next = "full";
                        $('#add').prop('disabled', true);
                        break
                }
                $("#et").html("<p>" + next + "</p>")
            },
            error: function (jqXHR, textStatus, errorThrown) {
                conosle.log('failed');
            }
        });
    }
    load()
    function load() {

        setTimeout(function () {
            var name = $('#options').find(":selected").text();
            $.ajax({
                url: "EtageController",
                data: {name: name, op: "nextetage"},
                type: 'POST',
                success: function (data, textStatus, jqXHR) {
                    rank = data;
                    console.log(rank)
                    var next;
                    switch (data) {
                        case 0:
                            next = "Rez de chaussée";
                            $('#add').prop('disabled', false);
                            break
                        case 1:
                            next = "Premier Etage";
                            $('#add').prop('disabled', false)
                            break
                        case 2:
                            next = "Deuxiéme Etage";
                            $('#add').prop('disabled', false);
                            break
                        case 3:
                            next = "troisiéme Etage";
                            $('#add').prop('disabled', false);
                            break
                        default :
                            next = "full";
                            $('#add').prop('disabled', true);
                            break
                    }
                    $("#et").html("<p>" + next + "</p>")
                },
                error: function (jqXHR, textStatus, errorThrown) {
                    conosle.log('failed');
                }
            });
        }, 100);
    }
});

