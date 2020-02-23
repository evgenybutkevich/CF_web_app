<form class="p-3" method="post">
    <input name="_csrf" value="${_csrf.token}" type="hidden"/>

    <div class="form-group row">
        <div class="media border border-primary bg-primary m-1">
            <img class="m-2" src="/icons/${campaign.logo}" width="64px"">

            <div class="media-body bg-white">
                <p class="m-1"><b><a href="/campaigns/${campaign.id}">${campaign.campaignName}</a></b>

                </p>
                <p class="m-1">
                    <b>Author: <a href="/users/view/${campaign.authorId}">${campaign.authorName}</a></b>
                </p>
            </div>
        </div>
    </div>

    <div class="form-group row">
        <label class="col-form-label col-2 col-xl-2">Amount: </label>

        <div class="col-10 col-sm-6 col-xl-4">
            <input class="form-control" name="amount" type="text" placeholder="enter amount"/>
        </div>
    </div>

    <div class="form-group row">
        <label class="col-form-label col-2 col-xl-2">Name of card: </label>

        <div class="col-10 col-sm-6 col-xl-4">
            <input class="form-control" name="cardName" type="text" placeholder="enter card name"/>
        </div>
    </div>

    <div class="form-group row">
        <label class="col-form-label col-2 col-xl-2">Card Number: </label>

        <div class="col-10 col-sm-6 col-xl-4">
            <input class="form-control" name="cardNumber" type="text" placeholder="XXXX-XXXX-XXXX-XXXX"/>
        </div>
    </div>

    <div class="form-group row">
        <label class="col-form-label col-2 col-xl-2">Date of expiry / CVV: </label>

        <div class="col-5 col-sm-3 col-xl-2">
            <input class="form-control" name="dateOfExpiry" type="text" placeholder="MM/YY"/>
        </div>

        <div class="col-5 col-sm-3 col-xl-2">
            <input class="form-control" name="cvv" type="text" placeholder="CVV"/>
        </div>
    </div>

    <button class="btn btn-primary" type="submit">Send</button>
</form>

