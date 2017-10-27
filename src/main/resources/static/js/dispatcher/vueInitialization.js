function initEnvVue() {

    envVue = new Vue({
        el: '#envVue',
        data: {
            //------环境监测-------
            showStatus: false,
            temperature: 39.0,
            humidity: 23.0,
            pm2p5: 35.2,
            pm10: 27.9,
            noise: 63.5,
            windSpeed: 23.0,
            windDirection: 274
        }
    });
    eleVue = new Vue({
        el: '#eleVue',
        data: {
            //------环境监测-------
            showStatus: false,
            temperature: 39.0,
            humidity: 23.0,
            pm2p5: 35.2,
            pm10: 27.9,
            noise: 63.5,
            windSpeed: 23.0,
            windDirection: 274
        }
    });
    monVue = new Vue({
        el: '#monVue',
        data: {
            //------环境监测-------
            showStatus: false,
            temperature: 39.0,
            humidity: 23.0,
            pm2p5: 35.2,
            pm10: 27.9,
            noise: 63.5,
            windSpeed: 23.0,
            windDirection: 274
        }
    });
    pakVue = new Vue({
        el: '#pakVue',
        data: {
            //------环境监测-------
            showStatus: false,
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

