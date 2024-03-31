$(document).ready(function () {


    $.ajax({
        type: "GET",
        url: SERVER_PATH + "/fullcalendar/list",
        xhrFields: {withCredentials: true},
        success: function (result) {
            if (result.status) {
                alertBox(result.data.message);
                return false;
            }

            result.data.forEach(function(e) {
                calendar.addEvent(e);//外部的全局变量
                events.push(e);
            });
            
            // console.log(events);
        }
    });

});


// 函数用于添加新事件对象到事件数组中
function addEvent(calendar,newEvent) {

    $.ajax({
        type: "POST",
        url: SERVER_PATH + "/fullcalendar/add",
        contentType: 'application/json',
        data: JSON.stringify(newEvent),
        xhrFields: {withCredentials: true},
        success: function (result) {
            if (result.status) {
                alertBox(result.data.message);
                return false;
            }
          
            calendar.addEvent(newEvent);
            events.push(newEvent);
            // console.log(events);

        }
    });


}



// 函数用于删除新事件对象到事件数组中
function removeEvent(arg,e) {

    let remove = {
        title: e.title,
        allDay: e.allDay,
        start: e.start,
        end: e.end
    };

    $.ajax({
        type: "POST",
        url: SERVER_PATH + "/fullcalendar/remove",
        contentType: 'application/json',
        data: JSON.stringify(remove),
        xhrFields: {withCredentials: true},
        success: function (result) {
            if (result.status) {
                alertBox(result.data.message);
                return false;
            }

            arg.event.remove();
            events = events.filter(event => event == e);
            // console.log(events);

        }
    });

    

}