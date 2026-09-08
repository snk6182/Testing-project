package com.example.controller;
import org.springframework.web.bind.annotation.*; import java.util.*;
@RestController public class DashboardController {
 @GetMapping("/api/servers") public Map<String,Object> data(){return Map.of("servers",12,"healthy",10,"warning",1,"critical",1,"nodes",List.of(
 Map.of("name","app-server-01","cpu","32%","memory","48%","status","Healthy"),
 Map.of("name","app-server-02","cpu","67%","memory","72%","status","Healthy"),
 Map.of("name","db-server-01","cpu","84%","memory","89%","status","Warning"),
 Map.of("name","backup-server","cpu","96%","memory","93%","status","Critical")));}}
