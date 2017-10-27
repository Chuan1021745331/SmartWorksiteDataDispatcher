function  initEnvCharts()
{
    var temperatureChart = echarts.init(document.getElementById('temperatureChart'));
    var humidityChart = echarts.init(document.getElementById('humidityChart'));
    var windSpeedChart = echarts.init(document.getElementById('windSpeedChart'));
    var windDirectionChart = echarts.init(document.getElementById('windDirectionChart'));
    var pm10Chart = echarts.init(document.getElementById('pm10Chart'));
    var pm2p5Chart = echarts.init(document.getElementById('pm2p5Chart'));
    var noiseChart = echarts.init(document.getElementById('noiseChart'));

    // 指定图表的配置项和数据
    var temperatureOption = {
        title: {
            text: '温度'
        },
        tooltip: {
            trigger: 'axis'
        },
        xAxis: {
            data: ['2017-10-19 16:33:59', '2017-10-19 16:34:59', '2017-10-19 16:35:59', '2017-10-19 16:36:59', '2017-10-19 16:37:59', '2017-10-19 16:38:59', '2017-10-19 16:39:59', '2017-10-19 16:34:59', '2017-10-19 16:35:59', '2017-10-19 16:36:59', '2017-10-19 16:37:59', '2017-10-19 16:38:59', '2017-10-19 16:39:59']
        },
        yAxis: {
            splitLine: {
                show: false
            }
        },
        toolbox: {
            left: 'center',
            feature: {
                dataZoom: {
                    yAxisIndex: 'none'
                },
                restore: {},
                saveAsImage: {}
            }
        },
        visualMap: {
            top: 10,
            right: 10,
            pieces: [{
                gt: -10,
                lte: 0,
                color: '#096'
            }, {
                gt: 0,
                lte: 10,
                color: '#ffde33'
            }, {
                gt: 10,
                lte: 30,
                color: '#ff9933'
            }, {
                gt: 30,
                lte: 35,
                color: '#cc0033'
            }, {
                gt: 35,
                lte: 40,
                color: '#660099'
            }, {
                gt: 40,
                color: '#7e0023'
            }],
            outOfRange: {
                color: '#999'
            }
        },
        series: {
            name: '温度',
            type: 'line',
            data: [25, 13, 23, -1, 28, 35, 17, 13, 23, -1, 28, 35, 17],
            markLine: {
                silent: true,
                data: [{
                    yAxis: 40
                }, {
                    yAxis: 35
                }, {
                    yAxis: 30
                }, {
                    yAxis: 10
                }, {
                    yAxis: 0
                }]
            }
        }
    };

    var windDirectionOption = {
        title: {
            text: '风向玫瑰图'
        },
        tooltip: {
            position: ['25%', '25%'],
            extraCssText: 'width: 50%; height: 50%; box-shadow: 0 0 3px rgba(0, 0, 0, 0.3);',
            formatter: function (params)
            {
                // console.log(params)
                return '<div style="width: 100%; height: 20px; display: flex; flex-direction: row; justify-content: space-around; align-items: center">N :' + params.value[0] + '&emsp;&emsp;&emsp;&emsp;NNW:' + params.value[0] + '</div>' +
                    '<div style="width: 100%; height: 20px; display: flex; flex-direction: row; justify-content: space-around; align-items: center">NW:' + params.value[0] + '&emsp;&emsp;&emsp;&emsp;WNW:' + params.value[0] + '</div>' +
                    '<div style="width: 100%; height: 20px; display: flex; flex-direction: row; justify-content: space-around; align-items: center">W :' + params.value[0] + '&emsp;&emsp;&emsp;&emsp;WSW:' + params.value[0] + '</div>' +
                    '<div style="width: 100%; height: 20px; display: flex; flex-direction: row; justify-content: space-around; align-items: center">SW:' + params.value[0] + '&emsp;&emsp;&emsp;&emsp;SSW:' + params.value[0] + '</div>' +
                    '<div style="width: 100%; height: 20px; display: flex; flex-direction: row; justify-content: space-around; align-items: center">S :' + params.value[0] + '&emsp;&emsp;&emsp;&emsp;SSE:' + params.value[0] + '</div>' +
                    '<div style="width: 100%; height: 20px; display: flex; flex-direction: row; justify-content: space-around; align-items: center">SE:' + params.value[0] + '&emsp;&emsp;&emsp;&emsp;ESE:' + params.value[0] + '</div>' +
                    '<div style="width: 100%; height: 20px; display: flex; flex-direction: row; justify-content: space-around; align-items: center">E :' + params.value[0] + '&emsp;&emsp;&emsp;&emsp;ENE:' + params.value[0] + '</div>' +
                    '<div style="width: 100%; height: 20px; display: flex; flex-direction: row; justify-content: space-around; align-items: center">NE:' + params.value[0] + '&emsp;&emsp;&emsp;&emsp;NNE:' + params.value[0] + '</div>'
            }
        },
        toolbox: {
            feature: {
                saveAsImage: {}
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
                { name: 'N', max: 12},
                { name: 'NNW', max: 12},
                { name: 'NW', max: 12},
                { name: 'WNW', max: 12},
                { name: 'W', max: 12},
                { name: 'WSW', max: 12},
                { name: 'SW', max: 12},
                { name: 'SSW', max: 12},
                { name: 'S', max: 12},
                { name: 'SSE', max: 12},
                { name: 'SE', max: 12},
                { name: 'ESE', max: 12},
                { name: 'E', max: 12},
                { name: 'ENE', max: 12},
                { name: 'NE', max: 12},
                { name: 'NNE', max: 12}
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

    var humidityOption = {
        title: {
            text: '湿度'
        },
        tooltip: {
            trigger: 'axis'
        },
        xAxis: {
            data: ['2017-10-19 16:33:59', '2017-10-19 16:34:59', '2017-10-19 16:35:59', '2017-10-19 16:36:59', '2017-10-19 16:37:59', '2017-10-19 16:38:59', '2017-10-19 16:39:59', '2017-10-19 16:34:59', '2017-10-19 16:35:59', '2017-10-19 16:36:59', '2017-10-19 16:37:59', '2017-10-19 16:38:59', '2017-10-19 16:39:59']
        },
        yAxis: {
            splitLine: {
                show: false
            }
        },
        toolbox: {
            left: 'center',
            feature: {
                dataZoom: {
                    yAxisIndex: 'none'
                },
                restore: {},
                saveAsImage: {}
            }
        },
        visualMap: {
            top: 10,
            right: 10,
            pieces: [{
                gt: -10,
                lte: 0,
                color: '#096'
            }, {
                gt: 0,
                lte: 10,
                color: '#ffde33'
            }, {
                gt: 10,
                lte: 30,
                color: '#ff9933'
            }, {
                gt: 30,
                lte: 35,
                color: '#cc0033'
            }, {
                gt: 35,
                lte: 40,
                color: '#660099'
            }, {
                gt: 40,
                color: '#7e0023'
            }],
            outOfRange: {
                color: '#999'
            }
        },
        series: {
            name: '温度',
            type: 'line',
            data: [25, 13, 23, -1, 28, 35, 17, 13, 23, -1, 28, 35, 17],
            markLine: {
                silent: true,
                data: [{
                    yAxis: 40
                }, {
                    yAxis: 35
                }, {
                    yAxis: 30
                }, {
                    yAxis: 10
                }, {
                    yAxis: 0
                }]
            }
        }
    };

    var windSpeedOption = {
        title: {
            text: '风速'
        },
        tooltip: {
            trigger: 'axis'
        },
        xAxis: {
            data: ['2017-10-19 16:33:59', '2017-10-19 16:34:59', '2017-10-19 16:35:59', '2017-10-19 16:36:59', '2017-10-19 16:37:59', '2017-10-19 16:38:59', '2017-10-19 16:39:59', '2017-10-19 16:34:59', '2017-10-19 16:35:59', '2017-10-19 16:36:59', '2017-10-19 16:37:59', '2017-10-19 16:38:59', '2017-10-19 16:39:59']
        },
        yAxis: {
            splitLine: {
                show: false
            }
        },
        toolbox: {
            left: 'center',
            feature: {
                dataZoom: {
                    yAxisIndex: 'none'
                },
                restore: {},
                saveAsImage: {}
            }
        },
        visualMap: {
            top: 10,
            right: 10,
            pieces: [{
                gt: -10,
                lte: 0,
                color: '#096'
            }, {
                gt: 0,
                lte: 10,
                color: '#ffde33'
            }, {
                gt: 10,
                lte: 30,
                color: '#ff9933'
            }, {
                gt: 30,
                lte: 35,
                color: '#cc0033'
            }, {
                gt: 35,
                lte: 40,
                color: '#660099'
            }, {
                gt: 40,
                color: '#7e0023'
            }],
            outOfRange: {
                color: '#999'
            }
        },
        series: {
            name: '温度',
            type: 'line',
            data: [25, 13, 23, -1, 28, 35, 17, 13, 23, -1, 28, 35, 17],
            markLine: {
                silent: true,
                data: [{
                    yAxis: 40
                }, {
                    yAxis: 35
                }, {
                    yAxis: 30
                }, {
                    yAxis: 10
                }, {
                    yAxis: 0
                }]
            }
        }
    };

    var pm10Option = {
        title: {
            text: 'pm10'
        },
        tooltip: {
            trigger: 'axis'
        },
        xAxis: {
            data: ['2017-10-19 16:33:59', '2017-10-19 16:34:59', '2017-10-19 16:35:59', '2017-10-19 16:36:59', '2017-10-19 16:37:59', '2017-10-19 16:38:59', '2017-10-19 16:39:59', '2017-10-19 16:34:59', '2017-10-19 16:35:59', '2017-10-19 16:36:59', '2017-10-19 16:37:59', '2017-10-19 16:38:59', '2017-10-19 16:39:59']
        },
        yAxis: {
            splitLine: {
                show: false
            }
        },
        toolbox: {
            left: 'center',
            feature: {
                dataZoom: {
                    yAxisIndex: 'none'
                },
                restore: {},
                saveAsImage: {}
            }
        },
        visualMap: {
            top: 10,
            right: 10,
            pieces: [{
                gt: -10,
                lte: 0,
                color: '#096'
            }, {
                gt: 0,
                lte: 10,
                color: '#ffde33'
            }, {
                gt: 10,
                lte: 30,
                color: '#ff9933'
            }, {
                gt: 30,
                lte: 35,
                color: '#cc0033'
            }, {
                gt: 35,
                lte: 40,
                color: '#660099'
            }, {
                gt: 40,
                color: '#7e0023'
            }],
            outOfRange: {
                color: '#999'
            }
        },
        series: {
            name: '温度',
            type: 'line',
            data: [25, 13, 23, -1, 28, 35, 17, 13, 23, -1, 28, 35, 17],
            markLine: {
                silent: true,
                data: [{
                    yAxis: 40
                }, {
                    yAxis: 35
                }, {
                    yAxis: 30
                }, {
                    yAxis: 10
                }, {
                    yAxis: 0
                }]
            }
        }
    };

    var pm2p5Option = {
        title: {
            text: 'pm2.5'
        },
        tooltip: {
            trigger: 'axis'
        },
        xAxis: {
            data: ['2017-10-19 16:33:59', '2017-10-19 16:34:59', '2017-10-19 16:35:59', '2017-10-19 16:36:59', '2017-10-19 16:37:59', '2017-10-19 16:38:59', '2017-10-19 16:39:59', '2017-10-19 16:34:59', '2017-10-19 16:35:59', '2017-10-19 16:36:59', '2017-10-19 16:37:59', '2017-10-19 16:38:59', '2017-10-19 16:39:59']
        },
        yAxis: {
            splitLine: {
                show: false
            }
        },
        toolbox: {
            left: 'center',
            feature: {
                dataZoom: {
                    yAxisIndex: 'none'
                },
                restore: {},
                saveAsImage: {}
            }
        },
        visualMap: {
            top: 10,
            right: 10,
            pieces: [{
                gt: -10,
                lte: 0,
                color: '#096'
            }, {
                gt: 0,
                lte: 10,
                color: '#ffde33'
            }, {
                gt: 10,
                lte: 30,
                color: '#ff9933'
            }, {
                gt: 30,
                lte: 35,
                color: '#cc0033'
            }, {
                gt: 35,
                lte: 40,
                color: '#660099'
            }, {
                gt: 40,
                color: '#7e0023'
            }],
            outOfRange: {
                color: '#999'
            }
        },
        series: {
            name: '温度',
            type: 'line',
            data: [25, 13, 23, -1, 28, 35, 17, 13, 23, -1, 28, 35, 17],
            markLine: {
                silent: true,
                data: [{
                    yAxis: 40
                }, {
                    yAxis: 35
                }, {
                    yAxis: 30
                }, {
                    yAxis: 10
                }, {
                    yAxis: 0
                }]
            }
        }
    };

    var noiseOption = {
        title: {
            text: '噪声'
        },
        tooltip: {
            trigger: 'axis'
        },
        xAxis: {
            data: ['2017-10-19 16:33:59', '2017-10-19 16:34:59', '2017-10-19 16:35:59', '2017-10-19 16:36:59', '2017-10-19 16:37:59', '2017-10-19 16:38:59', '2017-10-19 16:39:59', '2017-10-19 16:34:59', '2017-10-19 16:35:59', '2017-10-19 16:36:59', '2017-10-19 16:37:59', '2017-10-19 16:38:59', '2017-10-19 16:39:59']
        },
        yAxis: {
            splitLine: {
                show: false
            }
        },
        toolbox: {
            left: 'center',
            feature: {
                dataZoom: {
                    yAxisIndex: 'none'
                },
                restore: {},
                saveAsImage: {}
            }
        },
        visualMap: {
            top: 10,
            right: 10,
            pieces: [{
                gt: -10,
                lte: 0,
                color: '#096'
            }, {
                gt: 0,
                lte: 10,
                color: '#ffde33'
            }, {
                gt: 10,
                lte: 30,
                color: '#ff9933'
            }, {
                gt: 30,
                lte: 35,
                color: '#cc0033'
            }, {
                gt: 35,
                lte: 40,
                color: '#660099'
            }, {
                gt: 40,
                color: '#7e0023'
            }],
            outOfRange: {
                color: '#999'
            }
        },
        series: {
            name: '温度',
            type: 'line',
            data: [25, 13, 23, -1, 28, 35, 17, 13, 23, -1, 28, 35, 17],
            markLine: {
                silent: true,
                data: [{
                    yAxis: 40
                }, {
                    yAxis: 35
                }, {
                    yAxis: 30
                }, {
                    yAxis: 10
                }, {
                    yAxis: 0
                }]
            }
        }
    };

    // 使用刚指定的配置项和数据显示图表。
    temperatureChart.setOption(temperatureOption);
    humidityChart.setOption(humidityOption);
    windSpeedChart.setOption(windSpeedOption);
    windDirectionChart.setOption(windDirectionOption);
    pm10Chart.setOption(pm10Option);
    pm2p5Chart.setOption(pm2p5Option);
    noiseChart.setOption(noiseOption);
}