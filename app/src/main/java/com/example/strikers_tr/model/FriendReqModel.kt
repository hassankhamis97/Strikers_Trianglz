package com.example.strikers_tr.model

class FriendReqModel(
        var name: String,
        var image: Int,
        var date: String
)

class FriendRequests(
        var friendRequestsList: ArrayList<FriendReqModel>
): HomeData() {
    override fun getType(): Int {
        return TYPE_FRIEND_REQUEST
    }
}