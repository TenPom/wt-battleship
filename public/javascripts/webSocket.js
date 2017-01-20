// get websocket class, firefox has a different way to get it
var WS = window['MozWebSocket'] ? window['MozWebSocket'] : WebSocket;

var socket = new WS('ws://localhost:9000/websocket');

$(document).ready(function () {
    
    console.log("### socket: " + socket + " ###");
    
    console.log(socket.send(' ## Ping ## '));
    
    socket.onmessage = function (message) {
        
        console.log(message);
        
    }; 
    
});


