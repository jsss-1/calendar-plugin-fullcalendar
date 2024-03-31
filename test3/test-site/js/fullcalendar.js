// 函数用于添加新事件对象到事件数组中
function addEvent(newEvent) {
    events.push(newEvent);
    // console.log(events);


}


// 函数用于删除新事件对象到事件数组中
function removeEvent(e) {
    events = events.filter(event => event == e);
    // console.log(events);

}