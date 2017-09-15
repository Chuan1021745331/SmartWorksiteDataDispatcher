$(document).ready(function() {

    var $o1st = $("#1st");
    var $o2nd = $("#2nd");
    var $o3rd = $("#3rd");
    var $o4th = $("#4th");
    var $o5th = $("#5th");

    $('#fullpage').fullpage({
        sectionsColor: ['#f2f2f2'],
        controlArrows: false
    });

    $o1st.on("click", function ()
    {
        $.fn.fullpage.moveTo(1, 0);
    });
    $o2nd.on("click", function ()
    {
        $.fn.fullpage.moveTo(1, 1);
    });
    $o3rd.on("click", function ()
    {
        $.fn.fullpage.moveTo(1, 2);
    });
    $o4th.on("click", function ()
    {
        $.fn.fullpage.moveTo(1, 3);
    });
    $o5th.on("click", function ()
    {
        $.fn.fullpage.moveTo(1, 4);
    });
});