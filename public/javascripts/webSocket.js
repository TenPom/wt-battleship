// get websocket class, firefox has a different way to get it
var WS = window['MozWebSocket'] ? window['MozWebSocket'] : WebSocket;

var socket = new WS('ws://localhost:9000/websocket');

var isPlayerOne;

//var polyList = [[]];

var matrix = [];

for(var i = 0; i < 10; i++) {
    matrix[i] = new Array(10);
}

$(document).ready(function () {
 
    socket.onmessage = handleMessage;
    socket.onclose = function () {console.log("socket schließt..")};
    var gamefield = document.getElementById('gamefield');
    for (var count = 0; count < 10; count++) {
        console.log("count: " + count);
        var row = document.createElement('div');
        row.setAttribute("class", "row");
        row.setAttribute("id", "row#" + count);
        
        var border1 = document.createElement('div');
        border1.setAttribute("class", "col-md-2 text-right");
        
        var border2 = document.createElement('div');
        border2.setAttribute("class", "col-md-2 text-right");
        
        var field = document.createElement('div');
        field.setAttribute("class", "col-md-8 text-center");
        
        for (var bCount = 0; bCount < 10; bCount++) {
            var button = document.createElement('gamefield-button');
            button.setAttribute("color", "O");
            matrix [count][bCount] = button;
            field.appendChild(button);
        }
        
        row.appendChild(border1);
        row.appendChild(field);
        row.appendChild(border2);
        gamefield.appendChild(row);
    }
    Polymer.updateStyles();
    console.log(matrix);
    
});

var messageType = {
        CHAT: "CHAT",
        PLAYERNAME: "PLAYERNAME",
        // HIT and MISS
        HIT: "HIT",
        MISS: "MISS",
        // INVALID
        WRONGINPUT: "WRONGINPUT",
        PLACEERR: "PLACEERR",
        WAIT: "WAIT",
        START: "START",
        // PLACE
        PLACE1: "PLACE1",
        PLACE2: "PLACE2",
        FINALPLACE1: "FINALPLACE1",
        FINALPLACE2: "FINALPLACE2",
        // SHOOT
        SHOOT1: "SHOOT1",
        SHOOT2: "SHOOT2",
        // WIN
        WIN1: "WIN1",
        WIN2: "WIN2",
    };

var handleMessage = function handleMessage(message) {
    var msg = JSON.parse(message.data);
        console.log("Message %o received", msg);
        switch (msg.type) {
            case messageType.CHAT: displayChatMessage(message); break;
            case messageType.PLAYERNAME: getPlayerName(); break;
            case messageType.PLACE1: fillField(message.boardmap); break;
            default: break;
        }
};

function chat() {
    var chatPrefix = "CHAT ";
    var text = document.getElementById('chatInput').value;
    document.getElementById('chatInput').value = "";
    console.log("sending message: " + text);
    socket.send(chatPrefix + text);
}

function displayChatMessage(message) {
    var msg = JSON.parse(message.data);
    var date = new Date();
    var charView = document.getElementById('chatView');
    chatView.append ("[" + date.getHours() + ":" + date.getMinutes() + "] " + msg.sender + ": " + msg.message + "\n");
}

function fillField(boardmap) {
    console.log("fillField called..");
    console.log("erstes Feld: " + boardmap[0][0]);
}

function getPlayerName() {
    var playername = prompt("Please enter your name", "");
    socket.send("PLAYERNAME " + playername);
}

