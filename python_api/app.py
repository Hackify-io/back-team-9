import configparser

from flask import Flask, jsonify, request

from facebook.ad import create_ad, create_creative, get_ads
from facebook.ad_set import create_ad_set, get_add_sets
from facebook.campaigns import create_campaign, get_campaigns

app = Flask(__name__)

config = configparser.ConfigParser()
config.read("config.ini")

test_credential = {
    "app_id": config["facebook.app"]["APP_ID"],
    "app_secret": config["facebook.app"]["APP_SECRET"],
    "account_access_token": config["facebook.sandbox"]["ACCOUNT_ACCESS_TOKEN"],
    "account_id": config["facebook.sandbox"]["ACCOUNT_ID"]
}

@app.route("/campaigns", methods=["GET"])
def get_campaigns_api():
    campaigns = get_campaigns(**test_credential)
    return jsonify([campaign.get_id() for campaign in campaigns])

@app.route("/campaigns", methods=["POST"])
def create_campaigns_api():
    fields = []
    params = {
        "name": request.form["name"],
        "status": request.form["status"],
        "special_ad_category": request.form["special_ad_category"],
        "objective": request.form["objective"]
    }
    campaign = create_campaign(**test_credential, fields=fields, params=params)
    return jsonify({"campaign_id": campaign.get_id()})

@app.route("/ad-sets", methods=["GET"])
def get_ad_sets_api():
    ad_sets = get_add_sets(**test_credential)
    return jsonify([ad_set.get_id() for ad_set in ad_sets])

@app.route("/ads", methods=["GET"])
def get_ads_api():
    ads = get_ads(**test_credential)
    return jsonify([ad.get_id() for ad in ads])

@app.route("/")
def index():
    return "a"

if __name__ == "__main__":
    app.run(debug=True)
