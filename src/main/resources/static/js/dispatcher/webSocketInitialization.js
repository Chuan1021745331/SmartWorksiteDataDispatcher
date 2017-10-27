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
            elevatorDataHandler(data.value);
            break;
        case "MONITOR":
            break;
    }
}

function envDataHandler(data) {
    data = JSON.parse(data);
    var dataObj = JSON.parse(data);

    if(dataObj.temperature.toString().indexOf("err") != -1)
    {
        dataObj.temperature = dataObj.temperature.toString().replace("err", "");
        envVue.showStatus = true;
    }
    else
    {
        envVue.showStatus = false;
    }

    handleErrorMsg("temperature", dataObj.temperature);
    handleErrorMsg("humidity", dataObj.humidity);
    handleErrorMsg("pm2p5", dataObj.pm2p5);
    handleErrorMsg("pm10", dataObj.pm10);
    handleErrorMsg("noise", dataObj.noise);
    handleErrorMsg("windSpeed", dataObj.windSpeed);
    handleErrorMsg("windDirection", dataObj.windDirection);
}

function handleErrorMsg(type, obj)
{
    if(type.indexOf("temperature") != -1)
    {
        envVue.temperature = obj;
    }
    else if(type.indexOf("humidity") != -1)
    {
        envVue.humidity = obj;
    }
    else if(type.indexOf("pm2p5") != -1)
    {
        envVue.pm2p5 = obj;
    }
    else if(type.indexOf("pm10") != -1)
    {
        envVue.pm10 = obj;
    }
    else if(type.indexOf("noise") != -1)
    {
        envVue.noise = obj;
    }
    else if(type.indexOf("windSpeed") != -1)
    {
        envVue.windSpeed = obj;
    }
    else if(type.indexOf("windDirection") != -1)
    {
        envVue.windDirection = obj;
    }

}



function elevatorDataHandler(data)
{

}

function pingankaDataHandler()
{

}