<#import "parts/main.ftlh" as m>
<#import "parts/login.ftlh" as l>

<@m.main "Registration">

<div class="container mt-5">
    <h1>Welcome to registration page!</h1>

    ${message?ifExists}

    <@l.login "/registration" "Sign up"/>
</div>

</@m.main>