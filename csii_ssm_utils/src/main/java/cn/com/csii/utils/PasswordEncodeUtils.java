package cn.com.csii.utils;


import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordEncodeUtils {
    public static void main(String[] args) {
       // String password = "123";//$2a$10$S8/Lu1aubzZCYcVQpxkQqu0uYqZF4rKZ0W8pQZfvmiTfF73pk0Gu2
        String password = "456";//$2a$10$NyAj3hyrbxm1YFvK/ckHLeWtkGSYD7RrDXRt75DP9wfFIQaf6WrMK
        System.out.println(getEncodePassword(password));
    }
    public static  String getEncodePassword(String password){
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        return passwordEncoder.encode(password);
    }


}
