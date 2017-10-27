$(document).ready(function () {

    initComponent();
});

/*^_^*------辅助逻辑------*^_^*/
//组件初始化，是一些界面交互逻辑，跟数据处理逻辑没有太大关系
function initComponent() {

    //materialize组件初始化
    $('.modal').modal();
    $('.collapsible').collapsible();
    $('.tooltipped').tooltip({delay: 50});
    var width = document.documentElement.clientWidth;
    var height = document.documentElement.clientHeight;
    // alert(height);
    $("#test1").css({width:width - 10, height: height - 115});
    $("#test2").css({width:width - 10, height: height - 115});
    $("#test3").css({width:width - 10, height: height - 115});
    $("#test4").css({width:width - 10, height: height - 115});
    $('ul.tabs').tabs({swipeable: true});
    //实名制考勤组件初始化

}