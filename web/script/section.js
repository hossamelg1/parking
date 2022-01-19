$(document).ready(function () {
    $("#addition").hide();
    $.ajax({
        url: "SectionController",
        data: {op: "load"},
        type: 'POST',
        success: function (data, textStatus, jqXHR) {
            fill(data);
        },
        error: function (jqXHR, textStatus, errorThrown) {
            alert('failed');
        }
    });

    $("#toggle").click(function () {
        $("#addition").toggle(500);
    });

    $("#add").click(function () {
        var name = $('#options').find(":selected").text();
        var etage = $('#etageOption').find(":selected").text();
        var ref = $('#SectionOption').find(":selected").text();
        console.log(name);
        console.log(etage);
        console.log(ref);
        switch (etage) {
            case "Rez de chaussée":
                etage = 0;
                break;
            case "Premier Etage":
                etage = 1;
                break;
            case "Deuxiéme Etage":
                etage = 2;
                break;
            case "troisiéme Etage":
                etage = 3;
                break;
        }
        $.ajax({
            url: "SectionController",
            data: {name: name, etage: etage, ref: ref},
            type: 'POST',
            success: function (data, textStatus, jqXHR) {
                fill(data);
                availableSections();
            },
            error: function (jqXHR, textStatus, errorThrown) {
                alert('failed');
            }
        });

    });


    $("#options").change(function () {
        var name = $('#options').find(":selected").text();

        $.ajax({
            url: "SectionController",
            data: {name: name, op: "getOptions"},
            type: 'POST',
            success: function (data, textStatus, jqXHR) {
                fillOptions(data);
            },
            error: function (jqXHR, textStatus, errorThrown) {
                alert('failed');
            }
        });
    })
    $("#options").change(function () {
        setTimeout(function () {
            availableSections();
        }, 700);
    })
    $("#etageOption").change(function () {
        availableSections();
    })

$("#content").on("click", ".delete", function () {
        var id = $(this).closest("tr").find("td").eq(0).text();
        console.log(id)
        $.ajax({
            url: "SectionController",
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
    
    $("#content").on("click", ".generate", function () {
        var id = $(this).closest("tr").find("td").eq(0).text();
        console.log(id)
        $.ajax({
            url: "SectionController",
            data: {id: id, op: "generate"},
            type: 'POST',
            success: function (data, textStatus, jqXHR) {
                alert(data);
            },
            error: function (jqXHR, textStatus, errorThrown) {
                alert('failed');
            }
        });
    });
    
    

    // fill function
    function fill(data) {
        var ligne = "";
        data.forEach(function (e) {
            ligne += "<tr><td>" + e.id + "</td><td>" + e.ref + "</td><td>" + e.idEtage + "</td><td><button class='btn btn-primary delete'>Supprimer</button></td><td><button class='btn btn-primary generate'>Generer</button></td></tr>";
        });
        $("#content").html(ligne);
    }
    function fillOptions(data) {
        var line = "";
        data.forEach(function (e) {
            var choice;
            switch (e) {
                case 0:
                    choice = "Rez de chaussée";
                    break
                case 1:
                    choice = "Premier Etage";
                    break
                case 2:
                    choice = "Deuxiéme Etage";
                    break
                case 3:
                    choice = "troisiéme Etage";
                    break

            }
            line += "<option value =" + choice + ">" + choice + "</option>"
        });
        $("#etageOption").html(line);
    }
    ///


    function fillSecOption(data) {
        var line = "";
        data.forEach(function (e) {

            line += "<option value =" + e + ">" + e + "</option>"
        });
        $("#SectionOption").html(line);
    }


    function availableSections(){
        var name = $('#options').find(":selected").text();
        var etage = $('#etageOption').find(":selected").text();
        switch (etage) {
            case "Rez de chaussée":
                etage = 0;
                break;
            case "Premier Etage":
                etage = 1;
                break;
            case "Deuxiéme Etage":
                etage = 2;
                break;
            case "troisiéme Etage":
                etage = 3;
                break;
        }
        $.ajax({
            url: "SectionController",
            data: {name: name, etage: etage, op: "getNextSec"},
            type: 'POST',
            success: function (data, textStatus, jqXHR) {
                fillSecOption(data);
            },
            error: function (jqXHR, textStatus, errorThrown) {
                alert('failed');
            }
        });
    }
});