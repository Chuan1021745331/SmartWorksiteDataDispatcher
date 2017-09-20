var webSocketUrl = "ws://localhost:8080/dataRealTime";
var webSocket = null;
var envVue = null;

$(document).ready(function () {

    initComponent();
    initWebSocket();
    initEnvVue();
    initEnvCharts();

});

/*^_^*------主体逻辑------*^_^*/
function initEnvVue() {

    envVue = new Vue({
        el: '#env',
        data: {
            temperature: 39.0,
            humidity: 23.0,
            pm2p5: 35.2,
            pm10: 27.9,
            noise: 63.5,
            windSpeed: 23.0,
            windDirection: 274
        }
    });
}

function initWebSocket() {
    //check if your browser supports WebSocket
    if ('WebSocket' in window) {
        webSocket = new WebSocket(webSocketUrl);
    }
    else {
        alert('Sorry, webSocket not supported by your browser.')
    }

    //Error callback
    webSocket.onerror = function () {
    };

    //socket opened callback
    webSocket.onopen = function (event) {
    };

    //message received callback
    webSocket.onmessage = function (event) {
        dataHandler(event.data);
    };

    //socket closed callback
    webSocket.onclose = function () {
    };

    //when browser window closed, close the socket, to prevent server exception
    window.onbeforeunload = function () {
        webSocket.close();
    }
}

function initEnvCharts()
{
    // 基于准备好的dom，初始化echarts实例
    var valueChart = echarts.init(document.getElementById('envValueCharts'));
    var windDirectionChart = echarts.init(document.getElementById('envWindDirectionCharts'));

    // 指定图表的配置项和数据
    var valueOption = {
        title: {
            text: '量化数据统计图'
        },
        tooltip: {
            trigger: 'axis'
        },
        legend: {
            data:['温度','湿度','风速','风向','pm10','pm2.5','噪声']
        },
        grid: {
            left: '3%',
            right: '4%',
            bottom: '3%',
            containLabel: true
        },
        toolbox: {
            feature: {
                saveAsImage: {}
            }
        },
        xAxis: {
            type: 'category',
            boundaryGap: false,
            data: ['周一','周二','周三','周四','周五','周六','周日']
        },
        yAxis: {
            type: 'value'
        },
        series: [
            {
                name:'温度',
                type:'line',
                stack: '总量',
                data:[120, 132, 101, 134, 90, 230, 210]
            },
            {
                name:'湿度',
                type:'line',
                stack: '总量',
                data:[220, 182, 191, 234, 290, 330, 310]
            },
            {
                name:'风速',
                type:'line',
                stack: '总量',
                data:[150, 232, 201, 154, 190, 330, 410]
            },
            {
                name:'风向',
                type:'line',
                stack: '总量',
                data:[320, 332, 301, 334, 390, 330, 320]
            },
            {
                name:'pm10',
                type:'line',
                stack: '总量',
                data:[820, 932, 901, 934, 1290, 1330, 1320]
            },
            {
                name:'pm2.5',
                type:'line',
                stack: '总量',
                data:[820, 932, 901, 934, 1290, 1330, 1320]
            },
            {
                name:'噪声',
                type:'line',
                stack: '总量',
                data:[820, 932, 901, 934, 1290, 1330, 1320]
            }
        ]
    };

    function data(){
        var d = [];
        for (var i = 0; i < 24; i++) {
            d.push({name:i+'~'+(i+1),value:Math.random()*100});
        }
        return d;
    }

    var windDirectionOption = {
        title: {
            text: '风向玫瑰图'
        },
        tooltip: {
            trigger: 'axis',
            formatter: function (value) {
                return value[0]+",指标值："+value[1]+",环比："+value[2];
            }
        },
        radar: {
            // shape: 'circle',
            name: {
                textStyle: {
                    color: '#fff',
                    backgroundColor: '#999',
                    borderRadius: 3,
                    padding: [3, 5]
                }
            },
            indicator: [
                { name: 'N（0.9/1.3）', max: 12},
                { name: 'NNE', max: 12},
                { name: 'NE', max: 12},
                { name: 'ENE', max: 12},
                { name: 'E', max: 12},
                { name: 'ESE', max: 12},
                { name: 'SE', max: 12},
                { name: 'SSE', max: 12},
                { name: 'S', max: 12},
                { name: 'SSW', max: 12},
                { name: 'SW', max: 12},
                { name: 'WSW', max: 12},
                { name: 'W', max: 12},
                { name: 'WNW', max: 12},
                { name: 'NW', max: 12},
                { name: 'NNW', max: 12}
            ]
        },
        series: [{
            type: 'radar',
            data : [
                {
                    value : [3, 4, 2, 3,
                        1, 2, 4, 5,
                        12, 2, 5, 7,
                        8, 5, 6, 2]
                }
            ],
            itemStyle: {
                normal: {
                    color: '#2c87e5',
                    label: {
                        color: "#000000",
                        show: true,
                        formatter:function(params) {
                            return params.value;
                        }
                    },
                    areaStyle: {
                        color: 'rgba(44,135,229,0.3)'
                    }
                }
            }
        }]
    };

    // 使用刚指定的配置项和数据显示图表。
    valueChart.setOption(valueOption);
    windDirectionChart.setOption(windDirectionOption);
}

function dataHandler(data) {
    data = JSON.parse(data);
    console.log(data);
    switch (data.type) {
        case "AUTH":
            break;
        case "ENVIRONMENT":
            envDataHandler(data.value);
            break;
        case "ELEVATOR":
            elevator(data.value);
            break;
        case "MONITOR":
            break;
    }
}

function envDataHandler(data) {
    data = JSON.parse(data);
    var dataObj = JSON.parse(data);
    envVue.temperature = dataObj.temperature;
    envVue.humidity = dataObj.humidity;
    envVue.pm2p5 = dataObj.pm2p5;
    envVue.pm10 = dataObj.pm10;
    envVue.noise = dataObj.noise;
    envVue.windSpeed = dataObj.windSpeed;
    envVue.windDirection = dataObj.windDirection;
}

function elevator(data) {

}

function pinganka()
{

}

/*^_^*------辅助逻辑------*^_^*/
//组件初始化，是一些界面交互逻辑，跟数据处理逻辑没有太大关系
function initComponent() {
    //fullpage组件初始化
    var $o1st = $("#1st");
    var $o2nd = $("#2nd");
    var $o3rd = $("#3rd");
    var $o4th = $("#4th");
    var $o5th = $("#5th");

    $('#fullpage').fullpage({
        sectionsColor: ['#f2f2f2'],
        controlArrows: false
    });

    $o1st.on("click", function () {
        $.fn.fullpage.moveTo(1, 0);
    });
    $o2nd.on("click", function () {
        $.fn.fullpage.moveTo(1, 1);
    });
    $o3rd.on("click", function () {
        $.fn.fullpage.moveTo(1, 2);
    });
    $o4th.on("click", function () {
        $.fn.fullpage.moveTo(1, 3);
    });
    $o5th.on("click", function () {
        $.fn.fullpage.moveTo(1, 4);
    });

    //materialize组件初始化
    $('.modal').modal();
    $('.collapsible').collapsible();

    //实名制考勤组件初始化

}