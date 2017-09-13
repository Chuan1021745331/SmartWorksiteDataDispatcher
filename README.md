## SmartWorksiteDataDispatcher

***

>此项目为第三方硬件数据与重庆建委数据库中转服务 <br>
>需要中转的数据有

1. 实名制考勤；
2. 环境监测；
3. 视频监控；
4. 施工升降机；

下面为具体说明

环境监测
---

>环境监测数据的来源是要求在施工工地现场安装部署环境数据监测仪器，仪器能够实时采集工地现场的各项环境数据，并通过互联网将采集的数据及时上传至平台。
>环境监测落实到工地现场的硬件设备主要有环境监测主设备以及各类环境数据的传感器，目前市场中主流产品是将主机和各类传感器集成为一个设备，方便现场安装调试，因此本次标准将环境监测数据也进行集成化采集。环境监测设备需要满足以下功能性需求：

1.	环境监测设备能够准确感知气温、湿度、风速、风向、PM10、PM2.5、噪音。
2.	环境监测设备应带有网络通讯功能，能够将感知的环境数据上传至重庆市智慧工地信息管理平台。
3.	设备提供商需要满足重庆市智慧工地信息管理平台对数据上传的接口要求。

视频监控
---

>本次重庆市智慧工地视频监控方案采用分布式设计，施工工地现场安装视频监控系统，原始的视频数据不直接传输到市城乡建委数据中心存储，而是保存在各个项目现场的视频监控存储设备中。视频监控系统使用目前流行的云端直播方案，由供应商帮助建立视频直播系统，平台在需要查看视频时，向供应商的直播平台请求播放地址，直播平台再连接现场的视频监控设备抓取实时视频监控流返回给监管平台，通过浏览器能够实现播放即可。视频监控设备需要满足以下功能性需求：

1.	远程视频监控系统供应商应具备互联网视频直播能力，需要将工地现场的视频信号转换成能够通过互联网浏览器直接播放的视频数据，并提供安全的访问通道给重庆市智慧工地信息管理平台。
2.	设备提供商需要满足重庆市智慧工地信息管理平台对数据上传的接口要求。

施工升降机
---

>施工升降机运行数据的来源是要求在施工工地现场的施工升降机上安装部署设备黑匣子，黑匣子能够实时采集施工升降机运行的各项数据，并通过互联网将采集的数据及时上传至平台。施工升降机设备需要满足以下功能性需求：

1.	施工升降机感知设备能够准确感知载重、载重百分比、高度、楼层、人数等运行信息。
2.	施工升降机感知设备能够实时监控运行信息，及时发出异常提醒信息、异常报警信息、违章信息。
3.	施工升降机应带有网络通讯功能，能够将感知的数据上传至重庆市智慧工地信息管理平台。
4.	设备提供商需要满足重庆市智慧工地信息管理平台对数据上传的接口要求。

实名制考勤
---

>实名制考勤是对施工工地现场人员的基础信息和进出场信息进行管理，重庆市城乡建委的实名制考勤体系通过“平安卡”系统已在重庆市实施多年，实名制考勤的标准将继续沿用“平安卡”系统的标准。
>实名制考勤落实到工地现场的硬件设备主要有考勤机主机(包含平安卡读卡器、指纹采集器)。硬件设备需要满足以下功能性需求：

1.	实名制数据接入需要满足重庆市城乡建委平安卡系统数据通讯协议，能够正确采集通讯协议中需要上报的内容。
2.	考勤设备支持与工地现场的通道闸机进行互动，能够正确的控制通道闸机的开合。
3.	考勤设备具有GPS功能，能够准确采集设备当前的地理坐标信息。

##技术参数
###环境监测

>环境监测设备在满足功能性需求的同时需要遵守以下技术参数：

1. 噪声监测：
    - 测量范围：40～130dB(A)
    - 频率范围：20Hz～12.5kHz
    - 频率计权：A（计权）
    - 时间计权：F（快）
    - 最大误差：0.5dB
    - 工作温度：-20℃～70℃
    - 相对湿度：25% ～ 90%
    - 气压：65KPa ～ 108KPa
    - 稳定性：使用周期内小于2%
    - 反应时间：小于3s
    - 防护等级：IP23
2. 湿度湿度监测：
    - 检测范围：-20-60℃,0-100%RH
    - 稳定时间：约1分钟
    - 湿度检测精度：±3%RH（30%RH～85%RH），±5%RH(其他湿度范围)
    - 温度检测精度：±0.5℃(5℃～50℃)
    - 相对误差：≦2%
    - 工作温度：-20 ~ 80℃
    - 工作湿度：0-98%RH
    - 防护顶级：IP23
3. PM2.5监测：
    - 颗粒物检测范围：0~500μg/m3或0-6000ug/m3
    - 最小检出粒子直径：0.3μm以上
    - 分辨率：1ug/m3
    - 相对误差：≦5%
    - 稳定时间：小于3分钟
    - 工作温度：-10℃～60℃
    - 相对湿度：25% ～ 90%
    - 防护等级：IP23
4. PM10监测：
    - 颗粒物检测范围：0~500μg/m3或0-6000ug/m3
    - 最小检出粒子直径：0.3μm以上
    - 分辨率：1ug/m3
    - 相对误差：≦5%
    - 稳定时间：小于3分钟
    - 工作温度：-10℃～60℃
    - 相对湿度：25% ～ 90%
    - 防护等级：IP23
5. 风速监测：
    - 检测范围：0-70m/s
    - 检测精度：（0.3+0.03V）m/s （V:风速）
    - 启动风速：≦0.3m/s
    - 工作温度：-20 ~ 60℃
    - 工作湿度：0-98%RH
6. 风向精度
    - 检测范围：0-360 ° 
    - 检测精度：±1° 
    - 启动风速：≦0.3m/s
    - 工作温度：-20 ~ 60℃
    - 工作湿度：0-98%RH
7. 数据通讯：
    - 支持HTTP协议上传7项检测数据，数据格式为JSON
    - 可调整数据的上传频率

###视频监控

>视频监控设备及播放平台在满足功能性需求的同时需要遵守以下技术参数：

1.	视频设备输出的视频流采用.H264编码
2.	能够支持最大1080P分辨率的视频流稳定传输
3.	设备能够安全的保存监控视频数据至少30天以上
4.	视频设备支持多路视频输出
5.	播放平台能够输出兼容HTML5标准的HLS视频流，可直接用于浏览器和移动端
###施工升降机

>施工升降机设备在满足功能性需求的同时需要遵守以下技术参数：
（施工升降机未明确技术参数，待与设备供应商讨论后确定）

###实名制考勤

>实名制考勤设备在满足功能性需求的同时需要遵守以下技术参数：

1.	平安卡识别率：100%
2.	指纹识别算法：
3.	指纹识别率：99.5%以上
4.	指纹识别时间：少于1s
5.	数据通讯：3G/4G
6.	离线运行：支持

