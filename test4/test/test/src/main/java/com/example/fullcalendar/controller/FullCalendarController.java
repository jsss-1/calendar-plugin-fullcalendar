package com.example.fullcalendar.controller;

import com.example.common.ResponseModel;
import com.example.fullcalendar.entity.CalendarEvent;
import com.example.fullcalendar.service.FullCalendarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/fullcalendar")
@CrossOrigin(origins = "${jsss.web.path}", allowedHeaders = "*", allowCredentials = "true")
public class FullCalendarController {


    @Autowired
    FullCalendarService fullCalendarService;


//    List<CalendarEvent> list=new ArrayList<>();


    @GetMapping("/list")
    @ResponseBody
    public ResponseModel list(){
        String key="calendarEvents";
        List<CalendarEvent> list=fullCalendarService.list(key);
        return new ResponseModel(list);
    }

    @PostMapping("/add")
    @ResponseBody
    public ResponseModel add(@RequestBody CalendarEvent calendarEvent){
//        list.add(calendarEvent);
        String key="calendarEvents";
        fullCalendarService.add(key,calendarEvent);
        return new ResponseModel("添加成功");

    }

    @PostMapping("/remove")
    @ResponseBody
    public ResponseModel remove(@RequestBody CalendarEvent calendarEvent){
//        list.remove(calendarEvent);
        String key="calendarEvents";
        fullCalendarService.remove(key,calendarEvent);
        return new ResponseModel("删除成功");

    }


}
