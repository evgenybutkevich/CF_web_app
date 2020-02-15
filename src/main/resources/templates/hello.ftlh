<#import "parts/main.ftlh" as m>
<#import "parts/navbar.ftlh" as n>
<#import "parts/login.ftlh" as l>

<@m.main "Hello">
<@n.navbar/>

<div class="container mt-5">
    <@l.logout/>

    <h1>Welcome to hello page!</h1>
</div>

</@m.main>
