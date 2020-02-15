<#import "parts/main.ftlh" as m>
<#import "parts/login.ftlh" as l>

<@m.main "Login">

<div class="container mt-5">
    <h1>Welcome to login page!</h1>

    <@l.login "/login"/>

    <p>Click <a href="/registration">here</a> to sign up!</p>
</div>

</@m.main>