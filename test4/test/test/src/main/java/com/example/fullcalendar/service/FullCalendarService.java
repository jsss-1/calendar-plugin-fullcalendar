package com.example.fullcalendar.service;

import com.example.fullcalendar.entity.CalendarEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FullCalendarService {
    @Autowired
    RedisTemplate redisTemplate;


    public List<CalendarEvent> list(String key) {
        List<CalendarEvent> calendarEvents = redisTemplate.opsForList().range(key, 0, -1);
        return calendarEvents;
    }

    public void add(String key,CalendarEvent calendarEvent) {
        redisTemplate.opsForList().rightPush(key, calendarEvent);
    }

    public void remove(String key,CalendarEvent calendarEvent) {
        redisTemplate.opsForList().remove(key, 0, calendarEvent);
    }

}
