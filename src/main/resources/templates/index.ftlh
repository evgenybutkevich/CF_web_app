<#import "parts/main.ftlh" as m>
<#import "parts/navbar.ftlh" as n>

<@m.main "Main">
<@n.navbar/>

<div class="container mt-5">
    <h1>Welcome to index page!</h1>

    <p>Click <a href="/hello">here</a> to see hello!</p>
    <p>Click <a href="/comment">here</a> to see/write comments!</p>
</div>

</@m.main>