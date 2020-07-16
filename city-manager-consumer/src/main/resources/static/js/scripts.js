(function ($) {
	"use strict";

    jQuery(document).ready(function($){


        $('.panel-heading a').click(function() {
            $('.panel-heading').removeClass('active');
            $(this).parents('.panel-heading').addClass('active');
         });
        
        $(".single-service").hover(
            function(e){
                $('.why-us .col-md-4:first-child .single-service').removeClass('active');
            }, // over
            function(e){
                $('.why-us .col-md-4:first-child .single-service').addClass('active');
            }  // out
        );

        $(".single-price-block").hover(
            function(e){
                $('.pricing-box .col-md-4:last-child .single-price-block').removeClass('active');
            }, // over
            function(e){
                $('.pricing-box .col-md-4:last-child .single-price-block').addClass('active');
            }  // out
        );


    });


    jQuery(window).load(function(){

        
    });


}(jQuery));	