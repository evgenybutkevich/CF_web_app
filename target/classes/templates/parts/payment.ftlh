<form class="p-3" method="post">
    <input name="_csrf" value="${_csrf.token}" type="hidden"/>

    <div class="media border border-primary bg-primary m-1">
        <img class="m-2" src="/icons/${campaign.logo}" width="64px"">

        <div class="media-body bg-white">
            <p class="m-1"><b><a href="/campaigns/${campaign.id}">${campaign.campaignName}</a></b>

            </p>
            <p class="m-1"><b>Author: ${user.firstName}</b></p>
        </div>

    </div>

    <div class="form-group row">
        <label class="col-form-label col-2 col-xl-2">Amount: </label>

        <div class="col-10 col-sm-6 col-xl-4">
            <input class="form-control" name="amount" type="text" placeholder="enter amount"/>
        </div>
    </div>

    <button class="btn btn-primary" type="submit">Send</button>
</form>

