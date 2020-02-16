<#import "parts/main.ftlh" as m>
<#import "parts/navbar.ftlh" as n>
<#include "parts/security.ftlh">

<@m.main "Comments">
<@n.navbar/>

<div class="container col-6 mt-5">
    <h4>List of comments</h4>

    <hr>

    <#list comments as comments>
        <div class="media border border-primary bg-primary m-1">
            <img class="m-2" src="https://img.icons8.com/pastel-glyph/2x/user-male.png" width="64px" height="64px">

            <div class="media-body bg-white">
                <p class="m-1"><b>${comments.authorName}</b></p>
                <p class="ml-3 m-1"><mark class="bg-warning">- ${comments.text}</mark></p>
                <p class="m-1"><b>${comments.date}</b></p>
            </div>
        </div>
    <#else>
        <p class="m-1"><b>No comments yet...</b></p>
    </#list>

    <hr>

    <#if isAdmin>
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
    </#if>
</div>

</@m.main>