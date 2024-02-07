//package es.cifpcm.SerafinAlejandroMiAli.Security;
//
//import es.cifpcm.SerafinAlejandroMiAli.data.services.PedidosService;
//import es.cifpcm.SerafinAlejandroMiAli.data.services.UsersService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.web.SecurityFilterChain;
//
//@Configuration
//@EnableWebSecurity
//@EnableMethodSecurity
//public class SecurityConfig {
//    @Autowired
//    private UsersService userService;
//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        http
//                .authorizeRequests(authorizeRequests ->
//                        authorizeRequests
//                                .requestMatchers("/public/**").permitAll() // Define endpoints accesibles para todos
//                                .anyRequest().authenticated() // Define endpoints accesibles solo para usuarios autenticados
//                )
//                .formLogin(formLogin ->
//                        formLogin
//                                .loginPage("/login") // Página personalizada de login
//                                .loginProcessingUrl("/login") // URL a la que se enviará la solicitud de inicio de sesión
//                                .defaultSuccessUrl("/") // URL de redirección después del inicio de sesión exitoso
//                                .permitAll()
//                )
//                .logout(logout ->
//                        logout
//                                .logoutUrl("/logout") // URL para el logout
//                                .logoutSuccessUrl("/") // URL de redirección después del logout exitoso
//                )
//                .userDetailsService((UserDetailsService) userService);
//        return http.build();
//    }
//}