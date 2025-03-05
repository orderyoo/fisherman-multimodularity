package com.example.fisherman.navigation

open class Routes(val route: String){

    data object MapScreen: Routes("map")
    data object MyMapScreen: Routes("my_map")
    data object PointScreen: Routes("point")
    data object TrackScreen: Routes("track")
    data object AdditionalOptionsScreen: Routes("additional_options")

}