import configparser

from facebook import get_campaigns, create_campaign, create_ad_set, get_add_sets, create_ad, create_creative

config = configparser.ConfigParser()
config.read("config.ini")

test_credential = {
    "app_id": config["facebook.app"]["APP_ID"],
    "app_secret": config["facebook.app"]["APP_SECRET"],
    "account_access_token": config["facebook.sandbox"]["ACCOUNT_ACCESS_TOKEN"],
    "account_id": config["facebook.sandbox"]["ACCOUNT_ID"]
}

campaigns = get_campaigns(**test_credential)
print(campaigns)
fields = []
params = {
    "name": "Super Campaña",
    "status": "PAUSED",
    "special_ad_category": "NONE",
    "objective": "CONVERSIONS"
}
campaing = create_campaign(**test_credential, fields=fields, params=params)
print(campaing)

fields = [
]
params = {
    'name': 'Promotion of webpage development Ad Set',
    'lifetime_budget': '500',
    'bid_amount': '2',
    'start_time': '2020-01-19',
    'end_time': '2020-01-21',
    'billing_event': 'IMPRESSIONS',
    'optimization_goal': 'OFFSITE_CONVERSIONS',
    'campaign_id': campaing.get_id(),
    'promoted_object': {'event_id': '782890378879795', 'custom_event_type': "OTHER"},
    'targeting': {'device_platforms': ['mobile'], 'facebook_positions': ['feed'], 'geo_locations': {'countries': ['MX']}, 'publisher_platforms': ['facebook', 'audience_network'], 'user_os': ['IOS']},
    'status': 'PAUSED',
}

ad_set = create_ad_set(**test_credential, fields=fields, params=params)

print(ad_set)

print(get_add_sets(**test_credential))


fields = [
]
params = {
    'name': 'Promotion of openning',
    'adset_id': ad_set.get_id(),
    'campaign_id': campaing.get_id(),
    'status': 'PAUSED',
    'billing_event': 'IMPRESSIONS',
    'targeting': {'device_platforms': ['mobile'], 'facebook_positions': ['feed'], 'geo_locations': {'countries': ['MX']}, 'publisher_platforms': ['facebook', 'audience_network'], 'user_os': ['IOS']},
    'creative': create_creative("Nueva página", "www.google.com", None)
}

ad = create_ad(**test_credential, fields=fields, params=params)

print(ad)
