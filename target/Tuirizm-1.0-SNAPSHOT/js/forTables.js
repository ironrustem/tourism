$(document).ready(function () {


    var select = document.querySelector('#hour');
    select.addEventListener("change", changeHour);
    select.value = document.querySelector('#hourTagAt').value;

    var dayIn = document.querySelector('#dayAt').value;

    hourTag(select.value)

    var search = document.querySelector('#search');
    search.addEventListener("change", changeSearch);




function changeSearch() {
    if (search.value != "") {
        $('.table').find('.t_res').html("")
        const searchText = {
            "search": "" + search.value + ""
        };
        $.ajax({
            url: "/arrival",
            method: "post",
            data: searchText,
            error: function (message) {
            },
            success: function (responseJson) {
                $.each(responseJson, function (index, flights) {
                    load_data(flights.id, flights.date1, flights.date2, flights.city.name, flights.terminal, flights.status, flights.number, flights.company);
                });
            }
        });
    } else {
        hourTag(select.value)
    }
}


function load_data(p_0, p_1, p_2, p_3, p_4, p_5, p_6, p_7) {
    $('.table').find('.t_res').insertAdjacentHTML('beforeend',`
    <tr>
      <td>${p_6}</td>
      <td>${p_1}</td>
      <td>${p_2}</td>
      <td><div class="poster">
        <p>{p_3}</p>
        <div class="descr">
        <p>Страна: Россия</p>
        </div>
        </div></td>
      <td>${p_7}</td>
      <td>${p_4}</td>
      <td>${p_5}</td>
      <td>
      <form method="post" action="departure">
           <input type="hidden" name="data" value=${p_0} />
           <input type="submit" value="лечу"/>
       </form>
     </td>
    </tr>
  `);
}

function threeDay(n) {
    if (!((dayIn == n) && (select.value == 0))) {
        $('.table').find('.t_res').html("")
        const day = {
            "day": "" + n + ""
        };
        $.ajax({
            method: "post",
            data: day,
            error: function (message) {
            },
            success: function (responseJson) {
                $.each(responseJson, function (index, flights) {
                    load_data(flights.id, flights.date1, flights.date2, flights.city.name, flights.terminal, flights.status, flights.number, flights.company);
                });
            }
        });
        dayIn = n;
    }
}

function hourTag(n) {
    console.log("222222")
    $('.table').find('.t_res').html("")
    const hourTag = {
        "hourTag": "" + n + ""
    };
    $.ajax({
        method: "post",
        data: hourTag,
        error: function (message) {
        },
        success: function (responseJson) {
            $.each(responseJson, function (index, flights) {
                load_data(flights.id, flights.date1, flights.date2, flights.city.name, flights.terminal, flights.status, flights.number, flights.company);
            });
        }
    });
}

$('#yesterday').click(function () {
    threeDay(-1)
    select.value = 0;
    hourIn = 0;
});

$('#today').click(function () {
    threeDay(0)
    select.value = 0;
    hourIn = 0;
});

$('#tomorrow').click(function () {
    threeDay(1)
    select.value = 0;
    hourIn = 0;
});


function changeHour() {
    hourTag(select.selectedIndex)
}

});
