from facebook_business.api import FacebookAdsApi
from facebook_business.adobjects.adaccount import AdAccount

def get_campaigns(app_id: str, app_secret: str, account_access_token: str, account_id: str):
    FacebookAdsApi.init(app_id, app_secret, account_access_token)
    account = AdAccount(account_id)
    return  account.get_campaigns()

def create_campaign(app_id: str, app_secret: str, account_access_token: str, account_id: str, fields, params):
    FacebookAdsApi.init(app_id, app_secret, account_access_token)
    account = AdAccount(account_id)
    return account.create_campaign(fields=fields, params=params)
