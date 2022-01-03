//package br.com.franca.tutorial.config.security;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.config.http.SessionCreationPolicy;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//
//@EnableWebSecurity
//public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
//
//    @Autowired
//    PasswordEncoder bCryptPasswordEncoder;
//
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//
//        System.out.println("Senha: " + bCryptPasswordEncoder.encode("123"));
//
//        auth.inMemoryAuthentication()
//                .withUser("rfrancacosta@gmail.com")
//                    .password(bCryptPasswordEncoder.encode("123456"))
//                    .roles("admin")
//                .and()
//                .withUser("bpaulalima@gmail.com")
//                .password(bCryptPasswordEncoder.encode("123456789"))
//                    .roles("operator");
//    }
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http.formLogin()
//                .and().httpBasic()
//            .and()
//                .authorizeRequests()
//                .antMatchers("/api/emitir").permitAll()
//                .anyRequest().authenticated()
//            .and()
//                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
//            .and()
//                .csrf().disable();
//
//
//    }
//
//
//}
