var WS = window['MozWebSocket'] ? window['MozWebSocket'] : WebSocket;

console.log('<%= Session["email"] %>');

var email = '<%= Session["email"] %>';

var socket = new WS('@routes.MainController.webSocket().webSocketURL(request)');

if(null != socker) {
	console.log("##### socket connected #####");
}

socket.send("test von der viewsocket");

