//组件初始化，是一些界面交互逻辑，跟数据处理逻辑没有太大关系
function initComponent() {
    initModal();
    initTooltip();
    initTabs();

    //实名制考勤组件初始化

}

function initTabs()
{
    var scrollWidth = getScrollbarWidth();
    var width = document.documentElement.clientWidth;
    var height = document.documentElement.clientHeight;
    var finalHeight = 0;
    // alert(height);
    if(height < 1000)
    {
        finalHeight = 1000;
    }
    else
    {
        finalHeight = height - 110;
    }

    $("#env").css({width:width, height: finalHeight});
    $("#ele").css({width:width, height: finalHeight});
    $("#mon").css({width:width, height: finalHeight});
    $("#pak").css({width:width, height: finalHeight});
    $('ul.tabs').tabs({swipeable: true});
}

function initTooltip()
{
    $('.tooltipped').tooltip({delay: 50});
}

function initModal()
{
    $('.modal').modal();
}

/*^_^*------辅助逻辑------*^_^*/
function getScrollbarWidth() {
    var oP = document.createElement('p'), styles = {
        width: '100px',
        height: '100px',
        overflowY: 'scroll',
    }, i, scrollbarWidth;

    for (i in styles){
        oP.style[i] = styles[i];
    }
    document.body.appendChild(oP);
    scrollbarWidth = oP.offsetWidth - oP.clientWidth;
    oP.remove();

    return scrollbarWidth;
}