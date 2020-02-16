<#import "parts/main.ftlh" as m>
<#import "parts/navbar.ftlh" as n>

<@m.main "Comments">
<@n.navbar/>

<div class="container mt-5">
    <h1>Welcome to comment page!</h1>

    <a class="btn btn-primary" data-toggle="collapse" href="#addComment" role="button" aria-expanded="false">
        Add comment
    </a>

    <div class="collapse mt-3" id="addComment">
        <form method="post">
            <input name="_csrf" value="${_csrf.token}" type="hidden"/>

            <div class="form-group row">
                <div class="col-sm-6">
                    <input name="text" class="form-control" type="text" placeholder="enter the comment...">
                </div>

                <button class="btn btn-primary" type="submit">Send</button>
            </div>


        </form>
    </div>

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