<#import "parts/main.ftlh" as m>

<@m.main "View campaing">

<h1>Welcome to campaing view page!</h1>

<#list campaings as campaings>
    <h4>${campaings.name}</h4>
    <p>${campaings.topic}</p>
    <p>${campaings.description}</p>
    <p>${campaings.amountTotal}</p>
    <img class="m-2" src="/icons/${campaings.logo}" width="64px" height="64px">
<#else>
    <p class="m-1"><b>No campaings yet...</b></p>
</#list>

</@m.main>