import configparser

from flask import Flask, jsonify

from facebook.ad import create_ad, create_creative
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

@app.route("/campaigns")
def get_campaigns_api():
    campaigns = get_campaigns(**test_credential)
    return jsonify([campaign.get_id() for campaign in campaigns])

@app.route("/")
def index():
    return "a"

if __name__ == "__main__":
    app.run(debug=True)