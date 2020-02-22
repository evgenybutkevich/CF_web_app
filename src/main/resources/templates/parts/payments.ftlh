<#list payments as payments>
    <div class="media border border-primary m-1">

        <div class="media-body bg-white">
            <p class="m-1"><b>${payments.authorName}</b></p>
            <p class="text-break ml-3 m-1"><mark class="bg-warning">- ${payments.amount}</mark></p>
        </div>

        <p class="m-1"><b>${payments.stringDateOfCreation}</b></p>

    </div>
<#else>
    <p class="m-1"><b>No payments yet...</b></p>
</#list>