package com.example.handicappedcare.config;

import com.example.handicappedcare.service.MyUserDetailsService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    private final MyUserDetailsService myUserDetailsService;
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(myUserDetailsService).passwordEncoder(new BCryptPasswordEncoder());
    }
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .authorizeRequests()
                .antMatchers("/api/v1/Register/**").permitAll()
                .antMatchers("/api/v1/User/getUser","/api/v1/User/addUsers","/api/v1/User/deleteUsers/{Id}",
                        "/api/v1/User/update/{Id}","/api/v1/User/updateAdress/{Id}").hasAuthority("user")
                .antMatchers("/api/v1/User/getUsers").hasAuthority("admin")
                .antMatchers("/api/v1/Order/getOrders").hasAuthority("admin")
                .antMatchers("/api/v1/User/handicappeId/{handicappedId}").hasAuthority("admin")
                .antMatchers("/api/v1/Hospitals/addHospitals","/api/v1/Hospitals/deleteHospitals/{Id}",
                        "api/v1/Hospitals/update/{Id}").hasAuthority("admin")
                .antMatchers("/api/v1/ElectricMachine/addElectricMachine","/api/v1/ElectricMachine/deleteElectricMachine/{Id}",
                        "/api/v1/ElectricMachine/updateQuantity/{Id}",
                        "/api/v1/ElectricMachine/update/{Id}").hasAuthority("admin")
                .antMatchers("/api/v1/Order/addOrder","/api/v1/Order/requestMachine/{electricMachineId}").hasAuthority("user")
                .anyRequest().authenticated()
                .and()
                .httpBasic();



              //  .anyRequest().authenticated()
                //.and()
                //.httpBasic();
    }
    //     http.csrf().disable()
    //                .authorizeRequests()
    //                .antMatchers("/api/v1/auth/register").permitAll()
    //                .antMatchers(HttpMethod.POST,"/api/v1/blog").hasAuthority("ADMIN")
    //                .anyRequest().authenticated()
    //                .and()
    //                .logout().logoutUrl("/api/v1/auth/logout")
    //                .invalidateHttpSession(true).deleteCookies("JSESSIONID")
    //                .and()
    //                .httpBasic();
}
