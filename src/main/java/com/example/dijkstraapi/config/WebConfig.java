package com.example.dijkstraapi.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        // Cấu hình CORS cho tất cả các API có đường dẫn bắt đầu bằng "/api"
        registry.addMapping("/api/**")  // Áp dụng cho tất cả các API có đường dẫn bắt đầu bằng "/api"
                .allowedOrigins("http://localhost:3000")  // Cho phép yêu cầu từ địa chỉ frontend (ở đây là localhost:3000)
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")  // Các phương thức HTTP cho phép
                .allowedHeaders("*");  // Cho phép tất cả các headers trong yêu cầu

        // Nếu cần cho phép cookie và credentials (JWT token chẳng hạn)
        // .allowCredentials(true);
    }
}
