package com.example.tubes.data

data class UserVenueGraph(
    val userId: String,
    val edges: List<GraphEdge>
)

data class GraphEdge(
    val fromVenueId: String,
    val toVenueId: String
)

