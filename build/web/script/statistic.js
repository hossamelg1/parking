$(document).ready(function () {
    $('#chart').hide();
    $('#for_etage').hide();
    $('#pStats').click(function () {
        var parkings;
        var counters;
        $.ajax({
            url: "StatisticController",
            data: {chart: 'parkingName'},
            type: 'POST',
            success: function (data, textStatus, jqXHR) {
                parkings = data;
            },
            error: function (jqXHR, textStatus, errorThrown) {
                alert('failed');
            }
        });
        setTimeout(function () {
            $.ajax({
                url: "StatisticController",
                data: {chart: 'parkingCount'},
                type: 'POST',
                success: function (data, textStatus, jqXHR) {
                    counters = data;
                },
                error: function (jqXHR, textStatus, errorThrown) {
                    alert('failed');
                }
            });
        }, 500)
        
        
        setTimeout(function () {
            var myChart = document.getElementById("myChart").getContext('2d');
            console.log(counters);
            var myJSON = JSON.stringify(parkings);
            console.log(parkings);
            var chart = new Chart(myChart, {
                type: 'bar',
                data: {
                    labels: parkings,
                    datasets: [{
                            label: 'Nombre des stationement',
                            data: counters,
                            backgroundColor: '#ff006e',
                            borderWidth: 2,
                            borderColor: 'black'
                        }]
                }
            });
            $('#chart').show();
            
        }, 800)


    });
    $('#eStats').click(function () {
        $('#chart').hide();
        $('#for_etage').show();
    });

    $('#options').change(function () {
        var etages;
        var counters;
        var name = $('#options').find(":selected").text();
        $.ajax({
            url: "StatisticController",
            data: {chart: 'etageRank', name: name},
            type: 'POST',
            success: function (data, textStatus, jqXHR) {
                etages = data;
            },
            error: function (jqXHR, textStatus, errorThrown) {
                alert('failed');
            }
        });
        setTimeout(function () {
            $.ajax({
                url: "StatisticController",
                data: {chart: 'etageCount', name: name},
                type: 'POST',
                success: function (data, textStatus, jqXHR) {
                    counters = data;
                },
                error: function (jqXHR, textStatus, errorThrown) {
                    alert('failed');
                }
            });
        }, 500)
        setTimeout(function () {

            if (chart === undefined) {
                var myChart = document.getElementById("myChart").getContext('2d');
                console.log(counters);
                console.log(etages);

                var chart = new Chart(myChart, {
                    type: 'doughnut',
                    data: {
                        labels: etages,
                        datasets: [{
                                label: 'Nombre des stationement',
                                data: counters,
                                backgroundColor: ['#ff006e', '#e9c46a', '#4361ee'],
                                borderWidth: 2,
                                borderColor: 'black'
                            }]
                    }
                });
                $('#chart').show();
             
            }


        }, 800)


    })


});


