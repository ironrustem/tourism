
var htmlCode = ""

var nubmerM = 0;

function load_dataGet(s,t) {
    document.getElementById("messages").insertAdjacentHTML('beforeend',   `
   <li class="left clearfix">
                     <span class="chat-img1 pull-left">
                     <img src="https://lh6.googleusercontent.com/-y-MY2satK-E/AAAAAAAAAAI/AAAAAAAAAJU/ER_hFddBheQ/photo.jpg"
                          alt="User Avatar" class="img-circle">
                     </span>
                                <div class="chat-body1 clearfix">
                                    <p>${s}</p>
                                    <div class="chat_time pull-right">${t}</div>
                                </div>
                            </li>
  `)
}

function load_dataSend(s,t) {
    document.getElementById("messages").insertAdjacentHTML('beforeend',  `
     <li class="left clearfix admin_chat">
                     <span class="chat-img1 pull-right">
                     <img src="https://lh6.googleusercontent.com/-y-MY2satK-E/AAAAAAAAAAI/AAAAAAAAAJU/ER_hFddBheQ/photo.jpg"
                          alt="User Avatar" class="img-circle">
                     </span>
                                <div class="chat-body1 clearfix">
                                    <p>${s}</p>
                                    <div class="chat_time pull-left">${t}</div>
                                </div>
                            </li>
  `)
}

function setJson(responseJson) {
    console.log(responseJson)

    document.getElementById("messages").innerHTML = ""


    for (var i = 0; i < responseJson.length; i++) {
        if (responseJson[i].type == "send") {
            console.log(responseJson[i].text)
            load_dataSend(responseJson[i].text, responseJson[i].date)

        } else {
            console.log(responseJson[i].text)
            load_dataGet(responseJson[i].text, responseJson[i].date)
        }
    }
}

function sendMes() {
    var s = document.getElementById("textera").value

    if (s != '') {
        const text = {
            "text": s
        };
        $.ajax({
            url: "/chat",
            method: "post",
            data: text,
            error: function (message) {
            },
            success: function (responseJson) {
                document.getElementById("textera").value = ""
                setJson(responseJson)
            }
        });
    }
}

setInterval(check, 1000);

function refresh() {

        const text = {
            "refresh": "1"
        };
        $.ajax({
            url: "/chat",
            method: "post",
            data: text,
            error: function (message) {
            },
            success: function (responseJson) {
                setJson(responseJson)
            }
        });
}

function check() {
    const text = {
        "check": "1"
    };
    $.ajax({
        url: "/chat",
        method: "post",
        data: text,
        error: function (message) {
        },
        success: function (data) {
            if(nubmerM != data) {
                refresh()
                nubmerM = data
                console.log(data)
            }
            console.log(data)


        }
    });
}