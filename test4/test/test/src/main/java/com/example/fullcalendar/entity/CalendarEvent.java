package com.example.fullcalendar.entity;


import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.Date;

@Data
@ToString
@EqualsAndHashCode
public class CalendarEvent {


    //标题
    private String title;

    //是否全天
    private Boolean allDay;

    //开始时间
    private Date start;

    //结束时间
    private Date end;

}
