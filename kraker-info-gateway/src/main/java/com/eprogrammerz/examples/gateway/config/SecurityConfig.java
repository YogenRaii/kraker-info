package com.eprogrammerz.examples.gateway.config;

/**
 * Created by Yogen on 10/12/2017.
 */
//@Configuration
//@EnableWebSecurity
//@Order(-10)
public class SecurityConfig {//extends WebSecurityConfigurerAdapter {

//	@Autowired
//	private DataSource dataSource;
/*

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/swagger-ui.html", "/refresh", "/api/userSvc/v2/api-docs").permitAll()
                .and()
                .authorizeRequests().antMatchers("/api/userSvc/users*/
/**").authenticated()
 .and()
 .formLogin()
 .loginPage("/login")
 .permitAll()
 .and().httpBasic().disable();
 }

 @Override public void configure(AuthenticationManagerBuilder auth) throws Exception {
 //		auth.jdbcAuthentication().dataSource(dataSource);
 auth.inMemoryAuthentication().withUser("root").password("password").roles("USER");
 }
 */

}