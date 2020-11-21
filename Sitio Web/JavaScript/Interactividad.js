$(document).ready(function() {


    /* Animar menu =============================================== */

    $(window).scroll(function() {

        var posicionscroll = $(window).scrollTop();
        console.log(posicionscroll);

        if (posicionscroll > 100) {
            $(".menu").css({
                background: "rgba(0, 0, 0, 0.8)"
            }, 3000)

        } else {
            $(".menu").css({
                background: "none"
            }, 3000)
        }

    })

    /* Animar con fondo =============================================== */

    $(window).scroll(function() {

        var posicionscroll = $(window).scrollTop();
        console.log(posicionscroll);

        if (posicionscroll > 100) {
            $(".menu-con-fondo").css({
                background: "rgba(0, 0, 0, 0.8)"
            }, 3000)

        } else {
            $(".menu-con-fondo").css({
                background: "rgba(0, 0, 0, 0.8)"
            }, 3000)
        }

    })

    /*============================================================== */

    /* Animar menu movil =============================================== */

    $(".icono-menu-movil").click(function() {
        $(".barra-menu-movil").animate({
                top: "-100%"
            }),

            $(".menu-movil-flotante").animate({
                right: "0%"
            })
    })

    $(".x-menu-movil, .menu-movil-flotante ul li a").click(function() {
        $(".menu-movil-flotante").animate({
                right: "-100%"
            }),

            $(".barra-menu-movil").animate({
                top: "0%"
            })


    })

    /*============================================================== */

    /* Filtro pagina Propositos de formacion =============================================== */

    $("table tr").show()

    /* Filtrar por todo */

    $(".bnt-filtro-todo").click(function() {
        $(".nivel1, .nivel2, .nivel3").fadeIn("slow");


        $(".bnt-filtro-nivel1, .bnt-filtro-nivel2, .bnt-filtro-nivel3,.bnt-filtro-nombre, .bnt-filtro-codigo").css({
            background: "none",
            color: "gray"
        })

        $(this).css({
            background: "blue",
            color: "white"
        })

        $(".buscadores").slideUp()

        $(".buscarxnombre").slideUp("slow")

        $(".buscarxcodigo").slideUp("slow")

    })

    /* Filtrar por nombre */

    $(".bnt-filtro-nombre").click(function() {

        $(".bnt-filtro-nivel1, .bnt-filtro-nivel2, .bnt-filtro-nivel3, .bnt-filtro-todo, .bnt-filtro-codigo").css({
            background: "none",
            color: "gray"
        })

        $(".buscadores").slideDown()

        $(".buscarxnombre").slideDown("slow")

        $(".buscarxcodigo").css({ "display": "none" })

        $(this).css({
            background: "blue",
            color: "white"
        })

    })

    /* Filtrar por codigo */

    $(".bnt-filtro-codigo").click(function() {

        $(".bnt-filtro-nivel1, .bnt-filtro-nivel2, .bnt-filtro-nivel3, .bnt-filtro-todo, .bnt-filtro-nombre").css({
            background: "none",
            color: "gray"
        })

        $(".buscadores").slideDown()

        $(".buscarxcodigo").slideDown("slow")

        $(".buscarxnombre").css({ "display": "none" })

        $(this).css({
            background: "blue",
            color: "white"
        })

    })

    /* Filtrar por nivel 1 */

    $(".bnt-filtro-nivel1").click(function() {

        $(".nivel1").fadeIn();

        $(".bnt-filtro-nivel2, .bnt-filtro-nivel3, .bnt-filtro-todo, .bnt-filtro-nombre, .bnt-filtro-codigo").css({
            background: "none",
            color: "gray"
        })

        $(".nivel2, .nivel3").hide();

        $(this).css({
            background: "yellow",
            color: "white"
        })

        $(".buscadores").slideUp()

        $(".buscarxnombre").slideUp("slow")

        $(".buscarxcodigo").slideUp("slow")

    })

    /* Filtrar por nivel 2 */

    $(".bnt-filtro-nivel2").click(function() {
        $(".nivel1, .nivel3").hide();


        $(".bnt-filtro-nivel1, .bnt-filtro-nivel3, .bnt-filtro-todo, .bnt-filtro-nombre, .bnt-filtro-codigo").css({
            background: "none",
            color: "gray"
        })

        $(this).css({
            background: "blue",
            color: "white"
        })

        $(".nivel2").delay().fadeIn("slow");

        $(".buscadores").slideUp()

        $(".buscarxnombre").slideUp("slow")

        $(".buscarxcodigo").slideUp("slow")

    })

    /* Filtrar por nivel 3 */

    $(".bnt-filtro-nivel3").click(function() {
        $(".nivel1, .nivel2").hide();


        $(".bnt-filtro-nivel1, .bnt-filtro-nivel2, .bnt-filtro-todo, .bnt-filtro-nombre, .bnt-filtro-codigo").css({
            background: "none",
            color: "gray"
        })

        $(this).css({
            background: "red",
            color: "white"
        })

        $(".nivel3").delay().fadeIn("slow");

        $(".buscadores").slideUp()

        $(".buscarxnombre").slideUp("slow")

        $(".buscarxcodigo").slideUp("slow")

    })



});