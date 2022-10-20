window.addEventListener('DOMContentLoaded', function () {



    setTimeout(()=>{
        $('#intro').addClass('on');
    },2000)

    setTimeout(()=>{
        $('#section01').addClass('on');
    },3000)




    /* scroll event section */
    container.addListener((e) => {

        let scrollTop = container.scrollTop;
        $('.posNum').html(scrollTop)
    });

    /*  slide,click event section */



    $('.hambuger').click(function () {
        $('#full_menu').toggleClass('on');
        $('.hambuger .box').toggleClass('on');
    })




    $('#full_menu .menu_text > div').mouseenter(function () {
        let idx = $(this).index();
        $("#full_menu .menu_img > div").removeClass('on');
        $("#full_menu .menu_img > div").eq(idx).addClass('on');

    })


})
