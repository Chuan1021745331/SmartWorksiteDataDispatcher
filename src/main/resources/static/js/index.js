$(document).ready(function ()
{
    onWindowResize();
    initComponent();
    initWebSocket();
    initEnvVue();
    initEnvCharts();
});

function showToast(msg)
{
    var $toastContent = $('<span>'+msg+'</span>').add($('<button class="btn-flat toast-action" onclick="removeToast()">我知道了</button>'));
    Materialize.toast($toastContent);
}

function removeToast()
{
    var toastElement = $('.toast').first()[0];
    var toastInstance = toastElement.M_Toast;
    toastInstance.remove();
}

function onWindowResize()
{
    $(window).resize(function () {          //当浏览器大小变化时
        alert($(window).height());          //浏览器时下窗口可视区域高度
        alert($(document).height());        //浏览器时下窗口文档的高度
        alert($(document.body).height());   //浏览器时下窗口文档body的高度
        alert($(document.body).outerHeight(true)); //浏览器时下窗口文档body的总高度 包括border padding margin
    });
}