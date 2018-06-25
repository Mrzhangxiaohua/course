require.config({
    baseUrl: '/webjars/jquery/',
    paths: {
        jquery : '3.1.1/jquery',
    }
});

require(['jquery'],function ($) {
    console.log("here");

    $("#find").click(function(){
        console.log("here");
    });




});