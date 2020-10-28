$(document).ready(function() {

    var altoinicio = $("#inicio").offset().top;
    console.log(altoinicio);

    var altocaracteristicas = $("#caracteristicas-beneficios").offset().top;
    console.log(altocaracteristicas);

    /* Animar menu =============================================== */

    $(window).scroll(function() {

        var posicionscroll = $(window).scrollTop();
        console.log(posicionscroll);

        if (posicionscroll > 100) {
            $("#menu").css({
                background: "rgba(0, 0, 0, 0.8)"
            }, 3000)

        } else {
            $("#menu").css({
                background: "none"
            }, 3000)
        }

    })

    /*============================================================== */

    /* Animar Scroll =============================================== */

    $(window).scroll(function() {
        var posicionscroll = $(window).scrollTop();
        console.log(posicionscroll);

        if (posicionscroll > altoinicio) {
            $(html).animate({
                scrollTop: "200px"
            });
        }



    })
});