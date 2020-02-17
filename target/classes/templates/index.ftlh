<#import "parts/main.ftlh" as m>

<@m.main "Index">

<h1>Welcome to index page!</h1>

<p>Click <a href="/hello">here</a> to see hello!</p>
<p>Click <a href="/comments">here</a> to see/write comments!</p>
<p>Click <a href="/users">here</a> to see users!</p>
<p>Click <a href="/create">here</a> to create campaing!</p>
<p>Click <a href="/view">here</a> to view campaings!</p>

<hr>

<div class="card-deck mt-5">
    <button class="btn btn-outline-primary" type="button">PREV</button>

    <#include "parts/card.ftlh">
    <#include "parts/card.ftlh">
    <#include "parts/card.ftlh">
    <#include "parts/card.ftlh">

    <button class="btn btn-outline-primary" type="button">NEXT</button>
</div>

<hr>

<div class="card-deck mt-5 mb-5">
    <button class="btn btn-outline-primary" type="button">PREV</button>

    <#include "parts/card.ftlh">
    <#include "parts/card.ftlh">
    <#include "parts/card.ftlh">
    <#include "parts/card.ftlh">

    <button class="btn btn-outline-primary" type="button">NEXT</button>
</div>

<hr>

</@m.main>