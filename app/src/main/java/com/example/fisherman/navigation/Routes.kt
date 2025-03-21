package com.example.fisherman.navigation

open class Routes(val route: String){

    data object MapScreen: Routes("map")
    data object MyMapScreen: Routes("my_map")
    data object PointScreen: Routes("point")
    data object TrackScreen: Routes("track")
    data object AdditionalOptionsScreen: Routes("additional_options")

    data object AllNews: Routes("all_news")
    data object NewsDetails: Routes("news_details")

    data object About: Routes("about")
}