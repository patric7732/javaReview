package com.example.springmvc.controller;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DateTimeController {
@GetMapping("/datetime")
public String showDateTime(Model model){
    LocalDate date = LocalDate.now();
    LocalDateTime dateTime = LocalDateTime.now();
    LocalTime time = LocalTime.now();
    ZonedDateTime zonedDateTime = ZonedDateTime.now(ZoneId.of("Asia/Seoul"));

    model.addAttribute("currentDate", date);
    model.addAttribute("currentDateTime", dateTime);
    model.addAttribute("currentTime", time);
    model.addAttribute("currentZonedDateTime", zonedDateTime);
    return "datetime";

}

}
