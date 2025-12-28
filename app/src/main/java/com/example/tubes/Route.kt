package com.example.tubes

object Route {
    const val login = "login"
    const val register = "register"


    const val sore =  "screen_Sore/{userId}/{username}"
    fun sore(userId: String, username: String): String {
        return "screen_Sore/$userId/$username"
    }

    const val papKops = "sore_Mark/{userId}/{username}"
    fun papKops(userId: String, username: String): String {
        return "sore_Mark/$userId/$username"
    }


    const val gangMatch = "gang_Match/{userId}/{username}"
    fun gangMatch(userId: String, username: String): String {
        return "gang_Match/$userId/$username"
    }
    const val me = "me"
    const val forYou = "for_You"
    const val invite = "invite"




    const val mainProfile = "mainProfile/{userId}/{username}"
    fun mainProfile(userId: String, username: String): String {
        return "mainProfile/$userId/$username"
    }
    const val feedProfile = "feed_Profile"
    const val statisticProfile = "statistic_Profile"
    const val journeyProfile = "journey_profile/{userId}/{username}"
    fun journeyProfile(userId: String, username: String): String {
        return "journey_profile/$userId/$username"
    }
    const val editProfile = "edit_Profile"
    const val shareProfile = "share_Profile"

    const val settingsActivity = "settings_Activity"




}