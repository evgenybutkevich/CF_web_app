<#import "parts/main.ftlh" as m>

<@m.main "Index">

<h1>Main page!</h1>

<p>Click <a href="/users">here</a> to see users!</p>

<div class="card-deck mt-5 p-2">
    <button class="btn btn-outline-primary" type="button">PREV</button>

    <#include "parts/card.ftlh">
    <#include "parts/card.ftlh">
    <#include "parts/card.ftlh">

    <button class="btn btn-outline-primary" type="button">NEXT</button>
</div>

<div class="card-deck mt-5 mb-5 p-2">
    <button class="btn btn-outline-primary" type="button">PREV</button>

    <#include "parts/card.ftlh">
    <#include "parts/card.ftlh">
    <#include "parts/card.ftlh">

    <button class="btn btn-outline-primary" type="button">NEXT</button>
</div>

</@m.main>