// get websocket class, firefox has a different way to get it
var WS = window['MozWebSocket'] ? window['MozWebSocket'] : WebSocket;

var socket = new WS('ws://localhost:9000/ws');

$(document).ready(function () {
    socket.onmessage = function (message) {
    
        
    });
});


