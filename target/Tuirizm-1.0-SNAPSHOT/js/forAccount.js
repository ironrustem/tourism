
var openOrder = 0;

function deleteFl(n) {
    delFly(n)
}


function delFly(n) {
    console.log("22222")
    var deleteFly = {
        "deleteFly": "" + n + ""
    };
    $.ajax({
        url: "/account",
        method: "post",
        data: deleteFly,
        error: function (message) {
        },
        success: function (responseJson) {
            console.log(responseJson)
            $('#flightTable').find('.flightsTable_res').html("")
            $.each(responseJson, function (index, flies) {
                console.log(flies.flight.id)
                load_data(flies.flight.id, flies.flight.date1, flies.flight.date2, flies.flight.city.name, flies.flight.terminal, flies.flight.status, flies.flight.number, flies.flight.company);
            });
        }
    });
}


function load_data(p_0, p_1, p_2, p_3, p_4, p_5, p_6, p_7) {
    $('#flightTable').find('.flightsTable_res').append(`
    <tr>
      <td>${p_6}</td>
      <td>${p_1}</td>
      <td>${p_2}</td>
      <td>${p_3}</td>
      <td>${p_7}</td>
      <td>${p_4}</td>
      <td>${p_5}</td>
      <td>
      <input type="submit" id="delFly" value="удалить" onclick="deleteFl(${p_0})"/>
     </td>
    </tr>
  `);
}

var serviceNumber = 0;
var editHotelNow = 0;

function saveHot(n) {
    editHotelNow = 0
    console.log(n)
    console.log("4444444")
    var forSaveHotel = "";
    for (var i = 0; i <= serviceNumber; i++) {
        var f1 = "#" + i
        var f = "#" + n;
        if ($('#hotelTable').find('.hotelTable_res').find(f).find(f).find(f1).is(':checked')) {
            console.log(i)
            forSaveHotel = forSaveHotel + "/" + i
        }
    }

    if(n < 0){
        forSaveHotel = "-1"
        var k = (n * -1)
        console.log(k)
        f = "#" + k
    }

    var saveHotel = {
        "saveHotel": "" + forSaveHotel
    };
    $.ajax({
        url: "/account",
        method: "post",
        data: saveHotel,
        error: function (message) {
        },
        success: function (responseJson) {
            console.log(responseJson)
            load_dataHotelSave(f,responseJson)
        }
    });
}

function load_dataHotelSave(f,hotel) {
    console.log(hotel)
    $('#hotelTable').find('.hotelTable_res').find(f).html(`
                                        <td>${hotel.id}</td>
                                        <td>${hotel.room.name}</td>
                                        <td>${hotel.price}</td>
                                        <td>${hotel.date}</td>
                                        <td>${hotel.date1}</td>
                                        <td id=${hotel.id}>
                                            <input type="submit" id="editHot" value="изменить"
                                                   onclick="editHot(${hotel.id})"/>
                                        </td>
                                        <td>
                                            <input type="submit" id="delHot" value="удалить"
                                                   onclick="deleteHot(${hotel.id})"/>
                                        </td>
  `);
}

function deleteHot(n) {
    delHotel(n)
}

function editHot(n) {
    editHotel(n)
}


function editHotel(n) {
    console.log("22222")
    if (editHotelNow != 0) {
        console.log(editHotelNow)
        saveHot(editHotelNow * -1);
        editHotelNow = 0;
    }
        editHotelNow = n
        var editHotel = {
            "editHotel": "" + n + ""
        };
        $.ajax({
            url: "/account",
            method: "post",
            data: editHotel,
            error: function (message) {
            },
            success: function (responseJson) {
                console.log(responseJson)
                var f = "#" + n;
                $('#hotelTable').find('.hotelTable_res').find(f).find(f).html("")
                $.each(responseJson, function (index, service) {
                    load_dataHotelEdit(f, service.service.name, service.service.price, service.service.id, service.checked, index);
                    serviceNumber = index
                });
                $('#hotelTable').find('.hotelTable_res').find(f).find(f).append(`
                 <input type="submit" id="serviceHotel" value="сохранить" onclick="saveHot(${n})"/>
            `);
            }
        });
}


function load_dataHotelEdit(f, p_0, p_1, p_4, p_2, p_3) {

    $('#hotelTable').find('.hotelTable_res').find(f).find(f).append (`
    <input type="checkbox" id=${p_3} value=${p_4} ${p_2}> ${p_0}(${p_1}р.) <Br>
  `);
}

function delHotel(n) {
    console.log("22222")
    var deleteHot = {
        "deleteHot": "" + n + ""
    };
    $.ajax({
        url: "/account",
        method: "post",
        data: deleteHot,
        error: function (message) {
        },
        success: function (responseJson) {
            console.log(responseJson)
            $('#hotelTable').find('.hotelTable_res').html("")
            $.each(responseJson, function (index, hotel) {
                load_dataHotel(hotel.id, hotel.room.name, hotel.price, hotel.date, hotel.date1, hotel.room.id);
            });
        }
    });
}


function load_dataHotel(p_0, p_1, p_2, p_3, p_4, p_5) {
    $('#hotelTable').find('.hotelTable_res').append(`
    <tr id="${p_0}" xmlns="http://www.w3.org/1999/html">
      <td>${p_1}</td>
      <td>${p_2}</td>
      <td>${p_3}</td>
      <td>${p_4}</td>
      <td>${p_5}</td>
      <td>
      <div class="service">
      <input type="submit" id="editHot" value="изменить"
             onclick="editHot(${p_0})"/>
      </td>
      </div>
      <td>
      <input type="submit" id="delFly" value="удалить" onclick="deleteHot(${p_0})"/>
     </td>
    </tr>
  `);
}



