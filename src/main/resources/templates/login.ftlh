<#import "parts/main.ftlh" as m>
<#import "parts/login.ftlh" as l>

<@m.main "Login">

<h1>Welcome to login page!</h1>

<@l.login "/login" "Login"/>

<p>Click <a href="/registration">here</a> to sign up!</p>

</@m.main>