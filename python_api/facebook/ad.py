from facebook_business.api import FacebookAdsApi
from facebook_business.adobjects.adaccount import AdAccount

from facebook_business.adobjects.adcreative import AdCreative
from facebook_business.adobjects.adcreativelinkdata import AdCreativeLinkData
from facebook_business.adobjects.adcreativeobjectstoryspec import AdCreativeObjectStorySpec

def create_creative(message, link, image_hash):
    link_data = AdCreativeLinkData()
    link_data[AdCreativeLinkData.Field.message] = message
    link_data[AdCreativeLinkData.Field.link] = link
    link_data[AdCreativeLinkData.Field.image_hash] = image_hash

    object_story_spec = AdCreativeObjectStorySpec()
    object_story_spec[AdCreativeObjectStorySpec.Field.page_id] = '102142938001931'
    object_story_spec[AdCreativeObjectStorySpec.Field.link_data] = link_data

    creative = AdCreative(parent_id='act_171349487548919')
    creative[AdCreative.Field.name] = 'AdCreative for Link Ad'
    creative[AdCreative.Field.object_story_spec] = object_story_spec
    creative.remote_create()
    return creative

def create_ad(app_id: str, app_secret: str, account_access_token: str, account_id: str, fields, params):
    FacebookAdsApi.init(app_id, app_secret, account_access_token)
    account = AdAccount(account_id)
    return account.create_ad(fields=fields, params=params)
