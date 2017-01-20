var WS = window['MozWebSocket'] ? window['MozWebSocket'] : WebSocket;

var socket = new WS('@routes.MainController.webSocket("testname", "42").webSocketURL(request)');

