<#import "parts/main.ftlh" as m>
<#import "parts/navbar.ftlh" as n>
<#import "parts/login.ftlh" as l>

<@m.main "Comments">
<@n.navbar/>

<div class="container mt-5">
    <@l.logout/>

    <h1>Welcome to comment page!</h1>

    <div>
        <form method="post">
            <input name="_csrf" value="${_csrf.token}" type="hidden"/>
            <input name="text" type="text" placeholder="enter the comment...">
            <button type="submit">Send</button>
        </form>
    </div>

    <hr>

    <div>Comments list</div>
        <#list comments as comments>
            <div>
                <b>${comments.id}</b>
                <span>${comments.text}</span>
                <b>${comments.authorName}</b>
            </div>
        <#else>
            No comments
        </#list>
</div>

</@m.main>