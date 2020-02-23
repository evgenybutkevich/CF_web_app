<#list payments as payments>
    <div class="media border border-primary bg-primary m-1">
        <#if payments.authorAvatar??>
            <img class="m-2" src="/icons/${payments.authorAvatar}" width="64px">
        </#if>

        <div class="media-body bg-white">
            <p class="m-1"><b><a href="/users/view/${payments.authorId}">${payments.authorName}</a></b></p>
            <p class="text-break ml-3 m-1"><mark class="bg-warning">- ${payments.amount}</mark></p>

            <p class="m-1"><b>${payments.stringDateOfCreation}</b></p>
        </div>
    </div>
<#else>
    <p class="m-1"><b>No payments yet...</b></p>
</#list>