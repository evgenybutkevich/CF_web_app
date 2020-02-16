<#import "parts/main.ftlh" as m>
<#import "parts/navbar.ftlh" as n>

<@m.main "Index">
<@n.navbar/>

<div class="container mt-5">
    <h1>Welcome to index page!</h1>

    <p>Click <a href="/hello">here</a> to see hello!</p>
    <p>Click <a href="/comments">here</a> to see/write comments!</p>
    <p>Click <a href="/users">here</a> to see users!</p>
</div>

</@m.main>